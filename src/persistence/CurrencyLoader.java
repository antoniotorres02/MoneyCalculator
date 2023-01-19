package persistence;

import java.util.List;
import model.Currency;

public interface CurrencyLoader {
    public static CurrencyLoader initialize() {
        return new CurrencyLoaderFromFile();
    }
    
    public List<Currency> getCurrencyList();
}
