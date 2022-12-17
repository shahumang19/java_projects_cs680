package edu.umb.cs680.hw17.StockApp;

import java.util.HashMap;
import java.util.Map;
import edu.umb.cs680.hw17.Observable;

public class StockQuoteObservable extends Observable<StockEvent> {
    private Map<String, Double> hashmap = new HashMap<String,Double>();

    public void changeQuote(String t, Double q){
        hashmap.put(t, q);
        notifyObservers(new StockEvent(t, q));
    }


    public Map<String,Double> getHashmap() {
        return this.hashmap;
    }
    
    public static void main(String[] args) {
        System.out.println("Stock Quote Observable");
    }
}
