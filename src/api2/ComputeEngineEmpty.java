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
		//find the prime under the given
		for(int i = 0; i < input.size(); i++) {
			if ((input.get(i) % 2) != 0) {
				b.add(input.get(i));
			}
			i++;
		}
		return b;
    }
    
}
