package persistence;

import model.Currency;
import model.ExchangeRate;

public interface ExRateLoader {
    public static ExRateLoader initialize() {
        return new ExRateLoaderFromWeb();
    }
    public ExchangeRate getExRateFromTo(Currency from, Currency to);
}
