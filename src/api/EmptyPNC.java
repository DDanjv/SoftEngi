package api;

import java.util.ArrayList;

public class EmptyPNC implements PNC {

    private EmptyPNC calculateApi ;

    public EmptyPNC(EmptyPNC calculateApi) {
        this.calculateApi = calculateApi;
    }

    @Override
    public ArrayList<Double> prototype(ArrayList<Double> a) {
        return new ArrayList<Double>(); 
    }
}
