package persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Currency;

public class CurrencyLoaderFromFile implements CurrencyLoader{
    private static String file = "currencies";
    
    public List<Currency> getCurrencyList() {
        List<Currency> list = new ArrayList<>();
        Iterator<String> iterator = IteratorFromFile(file);
        while (iterator.hasNext()) {
            list.add(CurrencyFromLine(iterator.next()));
        }
        return list;
    }
    
    private Iterator<String> IteratorFromFile(String file) {
    
        return new Iterator<String>() {
            private String nextLine;
            private BufferedReader reader;
            
            {
                reader = getReader(file);
                nextLine = readLine();
            }
            
            @Override
            public boolean hasNext() {
                return nextLine != null;
            }

            @Override
            public String next() {
                String line = nextLine;
                nextLine = readLine();
                return line;
            }

            private BufferedReader getReader(String file) {
                try {
                    return new BufferedReader(new FileReader(file));
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return null;
            }

            private String readLine() {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                return null;
            }
        };
    
    }

    private Currency CurrencyFromLine(String line) {
        String[] params = line.split(",");
        return new Currency(params[0].trim(),params[1].trim(),params[2].trim());
    }
}
