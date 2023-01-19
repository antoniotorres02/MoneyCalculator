package command;

import graphics.GUI;
import java.util.List;
import model.Currency;
import model.ExchangeRate;
import model.Money;
import persistence.ExRateLoader;

public class CalculateCommand implements Command {
    GUI gui;
    ExRateLoader exRateLoader;

    public CalculateCommand(GUI gui, ExRateLoader exRateLoader) {
        this.gui = gui;
        this.exRateLoader = exRateLoader;
    }

    @Override
    public void execute() {
        List<Currency> currencies = gui.getCurrencies();
        Currency from = currencies.get(0);
        Double amount = gui.getAmount();
        Money fromMoney = new Money(amount, from);
        Currency to = currencies.get(1);
        Money exchange = calculateExchange(fromMoney, to);
        gui.showMoney(exchange);
    }
    
    private Money calculateExchange(Money money, Currency to) {
        Currency from = money.currency();
        ExchangeRate exRate = exRateLoader.getExRateFromTo(from, to);
        return new Money(money.amount()* exRate.rate(), to);
    }
    
}
