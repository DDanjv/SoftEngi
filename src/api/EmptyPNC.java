package api;

import java.util.ArrayList;

//Empty implementation for PNC
public class EmptyPNC implements PNC {
 // Instance variables for future API usage
 private CalculateAPI calculateApi;

 public EmptyPNC(CalculateAPI calculateApi) {
     this.calculateApi = calculateApi;
 }

 @Override
 public ArrayList<Double> prototype(ArrayList<Double> a) {
     return new ArrayList<Double>(); // Default value
 }
}

