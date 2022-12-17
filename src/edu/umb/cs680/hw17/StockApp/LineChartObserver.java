package edu.umb.cs680.hw17.StockApp;

import java.util.Observable;
import java.util.Observer;

public class LineChartObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("[Line Chart Observer] - Ticker("+((StockEvent) arg).getTicker()+") - Quote("+((StockEvent) arg).getQuote()+")");
    }
}