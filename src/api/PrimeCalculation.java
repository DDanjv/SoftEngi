package api;

import java.util.ArrayList;
public class PrimeCalculation implements PNC{

	private ArrayList list;

	public PrimeCalculation(ArrayList list) {
		this.list = list;
    }
	public ArrayList<Double> prototype (ArrayList<Double> a) {
		ArrayList<Double> b = new ArrayList<Double>();
		//find the prime under the given
		for(int i = 0; i < a.size(); i++) {
			if ((a.get(i) % 2) != 0) {
				b.add(a.get(i));
			}
			i++;
		}
		return b;
	}

}