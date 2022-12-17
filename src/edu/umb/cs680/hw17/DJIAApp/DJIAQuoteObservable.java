package edu.umb.cs680.hw17.DJIAApp;

import edu.umb.cs680.hw17.Observable;

public class DJIAQuoteObservable extends Observable<Double> {
    private double quote;

    public void changeQuote(Double q){
        quote = q;
        notifyObservers(q);
    }


    public double getQuote() {
        return this.quote;
    }
    
    public static void main(String[] args) {
        System.out.println("DJIA Quote Observable");
    }
}
