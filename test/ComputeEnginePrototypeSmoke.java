import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import api2.ComputeEngineEmpty;
import api2.input;

import java.util.Arrays;
import java.util.List;

class ComputeEnginePrototypeSmoke {

    @Mock
    private input mockInput;

    private ComputeEngineEmpty computeEngine;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        computeEngine = new ComputeEngineEmpty(mockInput);
    }

    @Test
    boolean testCompute_WithPrimes(){
        List<Integer> inputNumbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        String result = computeEngine.compute(inputNumbers);
        assertEquals("2, 3, 5, 7", result);
        return true;
    }
}
