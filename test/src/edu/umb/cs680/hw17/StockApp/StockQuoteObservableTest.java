package edu.umb.cs680.hw17.StockApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Observable;
import java.util.Observer;

public class StockQuoteObservableTest {
    
    @Test
	public void verifyStockQuotePeriodicalUpdate() {
		StockQuoteObservable observable = new StockQuoteObservable();
        TableObserver obs1 = new TableObserver();
        LineChartObserver obs2 = new LineChartObserver();
        ThreeDObserver obs3 = new ThreeDObserver();
        observable.addObserver(obs1);
        observable.addObserver(obs2);
        observable.addObserver(obs3);

        observable.changeQuote("Stock1", 12.00);
        observable.changeQuote("Stock1", 15.00);
        observable.changeQuote("Stock2", 11.00);
        observable.changeQuote("Stock1", 15.20);
        observable.changeQuote("Stock2", 12.10);
        observable.changeQuote("Stock2", 11.20);
        observable.changeQuote("Stock1", 12.00);

        assertEquals(12.00, observable.getHashmap().get("Stock1"));
        assertEquals(11.20, observable.getHashmap().get("Stock2"));

        observable.deleteObserver(obs1);
        observable.deleteObserver(obs2);
        observable.deleteObserver(obs3);
	}

    @Test
	public void verifyLEObserverCount() {
		StockQuoteObservable observable = new StockQuoteObservable();

        Observer obs1 = (Observable sender, Object arg)->{System.out.println("[LE Observer] - Ticker("+((StockEvent) arg).getTicker()+") - Quote("+((StockEvent) arg).getQuote()+")");};

        observable.addObserver(obs1);

        observable.changeQuote("Stock331", 32.00);
        observable.changeQuote("Stock331", 25.00);
        observable.changeQuote("Stock42", 56.00);
        observable.changeQuote("Stock331", 65.20);
        observable.changeQuote("Stock42", 17.10);
        observable.changeQuote("Stock42", 19.20);

        assertEquals(19.20, observable.getHashmap().get("Stock42"));
        assertEquals(65.20, observable.getHashmap().get("Stock331"));

        observable.deleteObserver(obs1);
	}


}
