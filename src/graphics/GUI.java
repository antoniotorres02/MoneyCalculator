package graphics;

import command.Command;
import java.util.List;
import model.Currency;
import model.Money;

public interface GUI {

    /*Factory Method*/
    public static GUI start(List<Currency> currencies) {
        return MoneyGUI.start(currencies);
    };
    
    public GUI showGUI();
    public List<Currency> getCurrencies();
    public void addCommand(Command command);
    public void showMoney(Money money);
    public Double getAmount();
}
