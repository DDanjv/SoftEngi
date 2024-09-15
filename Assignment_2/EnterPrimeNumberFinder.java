package api;
import java.util.ArrayList;
import java.util.Scanner;
public class EnterPrimeNumberFinder {
	public void prototype(PrimeNumbers number) {
		Scanner sc=new Scanner(System.in);
        ArrayList<String> numbers = new ArrayList<String>();
        System.out.println("enter in mult numbers:");
        boolean scan = true;
        while (scan){
           String hold = sc.nextLine();
            if (hold.equals("n")) {
                System.out.println("Calculating");
                break;
            }
            else{
                break;
            }
        }
        scanner.close();
		//User would enter number
		//load prime numbers less then but above 0
		//list in an array?
	}

}
