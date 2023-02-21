package conversor;

public class Currency {
    private String code;
    private double exchangeRate;

    public Currency(String code, double exchangeRate) {
        this.code = code;
        this.exchangeRate = exchangeRate;
    }

    public String getCode() {
        return code;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double convert(double amount, Currency toCurrency) {
        double exchangeRate = toCurrency.getExchangeRate() / this.exchangeRate;
        return amount * exchangeRate;
    }
}
