package model;

public class Money {
    private final double amount;
    private final Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double amount() {
        return amount;
    }

    public Currency currency() {
        return currency;
    }
    
    @Override
    public String toString() {
        return String.format("%.2f", this.amount)+this.currency.symbol();
    }
    
    
}
