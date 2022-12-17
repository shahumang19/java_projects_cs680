package edu.umb.cs680.hw17.StockApp;

public class StockEvent {
    private String ticker;
    private double quote;

    public StockEvent(String ticker, double quote) {
        this.ticker = ticker;
        this.quote = quote;
    }

    public String getTicker() {
        return this.ticker;
    }

    public double getQuote() {
        return this.quote;
    }
}
