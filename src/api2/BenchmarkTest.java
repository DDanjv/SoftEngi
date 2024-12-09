package api2;
import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import com.google.common.base.Stopwatch;
import api2.ComputeEngineEmpty;
import java.util.Arrays;
import java.util.List;


public class BenchmarkTest {
	
	private static final int NUM_RUNS = 10;
	private static final double IMPROVEMENT_PERCENT = 0.2;

	@Test
	public void testBenchmark() throws Exception {
		//Shared input list
		List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 1009, 1013, 1021, 100000);
		
		ComputeEngineEmpty computeEngine = new ComputeEngineEmpty();
		long elapsedTimeNaive = timeComputeVersion(() -> computeEngine.computeNaive(input));
		long elapsedTimeSieve = timeComputeVersion(() -> computeEngine.compute(input));
		
		double threshold = elapsedTimeNaive * (1 - IMPROVEMENT_PERCENT);
		
		System.out.println("Old: " + elapsedTimeNaive + "ms");
		System.out.println("New: " + elapsedTimeSieve + "ms");
		
		if (elapsedTimeSieve >= threshold){
			fail("The version did not improve");
		}
	}

	private long timeComputeVersion(Runnable task) {
		Stopwatch timer = Stopwatch.createStarted();
		for (int i = 0; i < NUM_RUNS; i++) {
			task.run();
		}
		timer.stop();
		
		return timer.elapsed(TimeUnit.MILLISECONDS) / NUM_RUNS;
	}
}
