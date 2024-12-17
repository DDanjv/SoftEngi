import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import api.ComputeEngineEmpty;
import api.Input;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import api.WriteResult;
import api.ComputationServiceOuterClass.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputeEnginePrototypeSmoke {

    @Mock
    private Input mockInput;

    private ComputeEngineEmpty computeEngine;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); //Needed for any Mockito mocks initialization
        Input mockInput =  new Input(null);
       this.computeEngine = new ComputeEngineEmpty(mockInput);
    }
    @Test
    String testCompute_noPrime() {
        when(mockInput.getInputList()).thenReturn(Arrays.asList(1, 4, 6, 8, 9, 10));
        String result = computeEngine.compute(mockInput.getInputList());
        assertEquals("", result);
        return result;
    }

    @Test
    String testCompute_multiplePrime() {
        when(mockInput.getInputList()).thenReturn(Arrays.asList(2, 3, 4, 5, 6, 7, 10, 11, 13));
        String result = computeEngine.compute(mockInput.getInputList());
        assertEquals("2, 3, 5, 7, 11, 13", result);
        return result;
    }

   @Test
    String testCompute_Zero() {
        when(mockInput.getInputList()).thenReturn(Arrays.asList(0,2));
        String result = computeEngine.compute(mockInput.getInputList());
        assertEquals("2", result);
        return result;
    }

     @Test
    String testCompute_Null() {
        when(mockInput.getInputList()).thenReturn(Arrays.asList());
        String result = computeEngine.compute(mockInput.getInputList());
        assertEquals("", result);
        return result;
    }
    
}
