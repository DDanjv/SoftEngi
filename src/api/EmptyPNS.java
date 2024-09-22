package api;

import java.util.ArrayList;

//Empty implementation for PNS
public class EmptyPNS implements PNS {
 // Instance variables for future API usage
 private ListAPI listApi;

 public EmptyPNS(ListAPI listApi) {
     this.listApi = listApi;
 }

 @Override
 public String prototype(ArrayList<Double> primes) {
     return "No prime numbers available."; // Default message
 }
}

