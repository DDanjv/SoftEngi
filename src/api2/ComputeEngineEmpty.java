package api2;

import java.util.ArrayList;
import java.util.List;

public class ComputeEngineEmpty implements ComputeEngine {
    private input input ;
    public ComputeEngineEmpty (input input){
        this.input = input;
    }
    @Override
    public List<Integer> compute(List<Integer> input) {
        List<Integer> b = new ArrayList<Integer>();

	    //As it stands, this will return ANY number non divisble by 2. 5 and 7 are prime, but 9 and 15 get through and are not.
	    //I've tried to implement something that may work better if a little late, but what works works.
	    //I have been racking my brain as to how to get this to work, and using nested loops MAY be the solution, but how is lost on me.
	    //I've been looking over this the whole night and frankly staying up any longer is a detriment to my health.
	    //I'm leaving the old code as a comment for reference and readability. -Ivan
	
		//find the prime under the given
		/*for(int i = 0; i < input.size(); i++) {
			if ((input.get(i) % 2) != 0) {
				b.add(input.get(i));*/

	    for (int i = 0; i < input.size(); i++) { //
		    for (int j = 0; j < i; j++) {
			    if (input.get(i) % j != 0) {
				    b.add(input.get(i));
			}
			i++;
		}
		return b;
    }
    
}
