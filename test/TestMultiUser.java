import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import api.ComputationCoordinator;
import api.ComputationCoordinatorEmpty;
import api.ComputeEngineEmpty;
import api.ComputeRequest;
import api.DataStoreEmpty;
import api.Input;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMultiUser<T> {
	
	// change the type of this variable to the name you're using for your
	// User <-> ComputeEngine API
	private ComputationCoordinatorEmpty coordinator;
	
	@BeforeEach
	//
	public void initializeComputeEngine() {
		//create an instance of your coordinator component; this is the component
		// that the user will make requests to
		// Store it in the 'coordinator' instance variable

		//engine 
		List<Integer> list = new ArrayList<>();
		
		Input listl = new Input(list);
		ComputeEngineEmpty engine = new ComputeEngineEmpty(null);
		//store
		DataStoreEmpty store = new DataStoreEmpty(listl);
		//coord
		coordinator = new ComputationCoordinatorEmpty(store, engine);
		coordinator.compute(new ComputeRequest(listl, null));
	}

	@Test
	public void compareMultiAndSingleThreaded() throws Exception {
		int numThreads = 4;
		List<TestUser> testUsers = new ArrayList<>();
		for (int i = 0; i < numThreads; i++) {
			testUsers.add(new TestUser(coordinator));
		}
		
		// Run single threaded
		String singleThreadFilePrefix = "testMultiUser.compareMultiAndSingleThreaded.test.singleThreadOut.tmp";
		for (int i = 0; i < numThreads; i++) {
			File singleThreadedOut = 
					new File(singleThreadFilePrefix + i);
			singleThreadedOut.deleteOnExit();
			testUsers.get(i).run(singleThreadedOut.getCanonicalPath());
		}
		
		// Run multi threaded
		ExecutorService threadPool = Executors.newCachedThreadPool();
		List<Future<?>> results = new ArrayList<>();
		String multiThreadFilePrefix = "testMultiUser.compareMultiAndSingleThreaded.test.multiThreadOut.tmp";
		for (int i = 0; i < numThreads; i++) {
			File multiThreadedOut = 
					new File(multiThreadFilePrefix + i);
			multiThreadedOut.deleteOnExit();
			String multiThreadOutputPath = multiThreadedOut.getCanonicalPath();
			TestUser testUser = testUsers.get(i);
			results.add(threadPool.submit(() -> testUser.run(multiThreadOutputPath)));
		}
		
		results.forEach(future -> {
			try {
				future.get();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
		
		
		// Check that the output is the same for multi-threaded and single-threaded
		List<String> singleThreaded = loadAllOutput(singleThreadFilePrefix, numThreads);
		List<String> multiThreaded = loadAllOutput(multiThreadFilePrefix, numThreads);
		Assert.assertEquals(singleThreaded, multiThreaded);
	}

	private List<String> loadAllOutput(String prefix, int numThreads) throws IOException {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < numThreads; i++) {
			File multiThreadedOut = 
					new File(prefix + i);
			result.addAll(Files.readAllLines(multiThreadedOut.toPath()));
		}
		return result;
	}
}
