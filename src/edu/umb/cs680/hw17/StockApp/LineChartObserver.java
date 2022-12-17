package edu.umb.cs680.hw17.StockApp;

import edu.umb.cs680.hw17.Observable;
import edu.umb.cs680.hw17.Observer;

public class LineChartObserver implements Observer<StockEvent> {

    @Override
    public void update(Observable<StockEvent> o, StockEvent arg) {
        System.out.println("[Line Chart Observer] - Ticker("+arg.getTicker()+") - Quote("+arg.getQuote()+")");
    }
}