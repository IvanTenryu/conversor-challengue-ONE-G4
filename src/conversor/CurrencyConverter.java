package conversor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyConverter {
    private Map<String, Currency> currencies;

    public CurrencyConverter() {
        this.currencies = new HashMap<>();
    }

    public void addCurrency(String code, double exchangeRate) {
        Currency currency = new Currency(code, exchangeRate);
        currencies.put(code, currency);
    }

    public Currency getCurrency(String code) {
        return currencies.get(code);
    }

    public List<String> getCurrencyCodes() {
        return new ArrayList<>(currencies.keySet());
    }

    public double convert(double amount, String fromCode, String toCode) {
        Currency fromCurrency = currencies.get(fromCode);
        Currency toCurrency = currencies.get(toCode);
        return fromCurrency.convert(amount, toCurrency);
    }
}
