import java.util.ArrayList;
import java.util.Scanner;

public class EnterPrimeNumberFinder implements PNF {

public ArrayList<Double> prototype() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<Double>();
        System.out.println("enter in numbers: to end hit enter any letter");
        boolean scan = true;
        while (scan){ 
            Double hold = sc.nextDouble();
            if (sc.hasNextDouble()) {
                numbers.add(hold);
            }
            else{
                numbers.add(hold);
                System.out.println("Calculating");
                scan = false ;
                sc.close();
                return numbers;
            }
        }
        return numbers;
    }
}

