package api;

import java.util.ArrayList;

//Empty implementation for PNF
public class EmptyPNF implements PNF {
 // Instance variables for future API usage
 private EmptyPNF dataStoreApi;

 public EmptyPNF(EmptyPNF dataStoreApi) {
     this.dataStoreApi = dataStoreApi;
 }

 @Override
 public ArrayList<Double> prototype() {
     return new ArrayList<Double>(); // Default value
 }
}

