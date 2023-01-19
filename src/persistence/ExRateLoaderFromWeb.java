package persistence;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import model.Currency;
import model.ExchangeRate;

public class ExRateLoaderFromWeb implements ExRateLoader{
    
    public ExchangeRate getExRateFromTo(Currency from, Currency to) {
        Double rate = load(from, to);
        ExchangeRate exRate = new ExchangeRate(from , to, rate);
        return exRate;
    }

    private Double load(Currency from, Currency to) {
        String json = getJson(from,to);
        return getRateFromJson(json);
    }

    private String getJson(Currency from, Currency to) {
        try {
            URL url = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + from.code() + "/" + to.code() + ".json");
            InputStream inputStream = url.openStream();
            byte[] buffer = new byte[1024];
            int lenght = inputStream.read(buffer);
            return new String(buffer, 0, lenght);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Double getRateFromJson(String json) {
        String[] split = json.split(",");
        String rate = split[1].substring(split[1].indexOf(":") + 1, split[1].indexOf("}") - 1);
        return Double.parseDouble(rate);
    }
    
    
}
