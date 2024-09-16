import java.util.ArrayList;
public class PrimeNumberStore implements PNS {
	public String prototype(ArrayList<Double> primes) {
		String result = "Prime numbers less than ";
		if(primes.isEmpty()) {
			result = "None";
		}
		else {
		result += (primes.get(primes.size()-1)+1) + ", ";
			for (int i = 0; i < primes.size(); i++){
				result += primes.get(i) + ", ";
			}
		}
		return result;
		//store the prime numbers
		//retrieve
	}

}
