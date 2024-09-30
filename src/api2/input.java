package api2;
import java.util.List;

public class input implements InputConfig {
    // Variable to store the input list
    private List<String> inputList;
    
    // Constructor to accept a list
    public input(List<String> inputList) {
        this.inputList = inputList;
    }

    // Getter method to retrieve the list
    public List<String> getInputList() {
        return inputList;
    }

    // Setter method to set a new list
    public void setInputList(List<String> inputList) {
        this.inputList = inputList;
    }

    // Method to add an item to the list
    public void addItem(String item) {
        this.inputList.add(item);
    }

    // Method to display the list
    public void displayList() {
        for (String item : inputList) {
            System.out.println(item);
        }
    }
}