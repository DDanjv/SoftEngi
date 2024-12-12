import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import api2.ComputeEngineEmpty;
import api2.input;

import java.util.Arrays;
import java.util.List;

class ComputeEngineEmptyTest {
    @Mock
    private input mockInput;

    private ComputeEngineEmpty computeEngine;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        computeEngine = new ComputeEngineEmpty(mockInput);
    }

    @Test
    void testCompute_WithPrimes() {
        // Arrange
        List<Integer> inputNumbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Act
        String result = computeEngine.compute(inputNumbers);

        // Assert
        assertEquals("2, 3, 5, 7", result);
    }

    @Test
    void testCompute_WithoutPrimes() {
        // Arrange
        List<Integer> inputNumbers = Arrays.asList(4, 6, 8, 9, 10, 12);

        // Act
        String result = computeEngine.compute(inputNumbers);

        // Assert
        assertEquals("", result); // No primes in the input
    }

    @Test
    void testCompute_EmptyList() {
        // Arrange
        List<Integer> inputNumbers = Arrays.asList();

        // Act
        String result = computeEngine.compute(inputNumbers);

        assertEquals("", result);
    }

    @Test
    void testCompute_SinglePrime() {
        List<Integer> inputNumbers = Arrays.asList(11);
        String result = computeEngine.compute(inputNumbers);
        assertEquals("11", result); 
    }

    @Test
    void testCompute_SingleNonPrime() {
        List<Integer> inputNumbers = Arrays.asList(12);
        String result = computeEngine.compute(inputNumbers);
        assertEquals("", result);
    }
}
