package edu.umb.cs680.hw17.DJIAApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import edu.umb.cs680.hw17.Observable;
import edu.umb.cs680.hw17.Observer;

public class DJIAQuoteObservableTest {
    
    @Test
	public void verifyDJIAQuotePeriodicalUpdate() {
		DJIAQuoteObservable observable = new DJIAQuoteObservable();
        TableObserver obs1 = new TableObserver();
        LineChartObserver obs2 = new LineChartObserver();
        ThreeDObserver obs3 = new ThreeDObserver();
        observable.addObserver(obs1);
        observable.addObserver(obs2);
        observable.addObserver(obs3);

        observable.changeQuote(12.00);
        observable.changeQuote(15.00);
        observable.changeQuote(11.00);
        observable.changeQuote(15.20);
        observable.changeQuote(12.10);
        observable.changeQuote(11.20);
        observable.changeQuote(12.00);

        assertEquals(12.00, observable.getQuote());

        observable.removeObserver(obs1);
        observable.removeObserver(obs2);
        observable.removeObserver(obs3);
	}

    @Test
	public void verifyLEObserver() {
		DJIAQuoteObservable observable = new DJIAQuoteObservable();

        Observer<Double> obs1 = (Observable<Double> sender, Double arg)->{System.out.println("[LE Observer] - Quote("+arg+")");};

        observable.addObserver(obs1);

        observable.changeQuote(32.00);
        observable.changeQuote(25.00);
        observable.changeQuote(56.00);
        observable.changeQuote(65.20);
        observable.changeQuote(17.10);
        observable.changeQuote(19.20);

        assertEquals(19.20, observable.getQuote());

        observable.removeObserver(obs1);
	}


}
