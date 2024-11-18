package tuning;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.google.common.base.Stopwatch;

public class BenchmarkTest {
	
	private static final int NUM_RUNS = 10;

	@Test
	public void testBenchmark() throws Exception {
		TaskInterface v1 = new SlowVersion();
		TaskInterface v2 = new FasterVersion();
		
		long elapsedTimeV1 = timeAVersion(v1);
		long elapsedTimeV2 = timeAVersion(v2);
		
		double percentImprovement = elapsedTimeV1 * .2;
		
		System.out.println("Old: " + elapsedTimeV1);
		System.out.println("New: " + elapsedTimeV2);
		
		if (Math.abs(elapsedTimeV1 - elapsedTimeV2) < percentImprovement
				|| elapsedTimeV2 > elapsedTimeV1) {
			fail();
		}
	}

	private long timeAVersion(TaskInterface v1) {
		Stopwatch timer = Stopwatch.createStarted();
		for (int i = 0; i < NUM_RUNS; i++) {
			v1.doTask();
		}
		timer.stop();
		
		return timer.elapsed(TimeUnit.MILLISECONDS) / NUM_RUNS;
	}
}
