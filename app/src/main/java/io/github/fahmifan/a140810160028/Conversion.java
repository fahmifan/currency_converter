package io.github.fahmifan.a140810160028;

public class Conversi {
    Keys keys;

    /**
     * The equivalent to 1 USD
     */
    private final double RP = 14000.0;
    private final double USD = 1.0;
    private final double EURO = 0.8;
    private final double YEN = 107.0;

    private double inputCurrency;
    private double currencyInUSD;

    /**
     * The current currency passed to the constructor.
     * Maybe the inputted from the user
     */
    private String baseCurrency;

    public Conversi(String baseCurrency, double inputCurrency) {
        this.baseCurrency = baseCurrency;
        this.inputCurrency = inputCurrency;
        convertToUSD();
    }

    /**
     * Conver the @inputCurrency to USD
     */
    private void convertToUSD() {
        if (this.baseCurrency == keys.RUPIAH) {
            this.currencyInUSD = inputCurrency / this.RP;
        } else if (this.baseCurrency == keys.USD) {
            this.currencyInUSD = inputCurrency / this.USD;
        } else if (this.baseCurrency == keys.YEN) {
            this.currencyInUSD = inputCurrency / this.YEN;
        } else if (this.baseCurrency == keys.EURO) {
            this.currencyInUSD = inputCurrency / this.EURO;
        }
    }

    public double getRupiah() {
        return this.currencyInUSD * this.RP;
    }

    public double getUsd() {
        return this.currencyInUSD * this.USD;
    }

    public double getYen() {
        return this.currencyInUSD * this.YEN;
    }

    public double getEuro() {
        return this.currencyInUSD * this.EURO;
    }
}
