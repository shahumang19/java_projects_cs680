package edu.umb.cs680.hw17.DJIAApp;

import edu.umb.cs680.hw17.Observable;
import edu.umb.cs680.hw17.Observer;

public class TableObserver implements Observer<Double> {

    @Override
    public void update(Observable<Double> o, Double arg) {
        System.out.println("[Table Observer] - Quote("+arg+")");
    }
}