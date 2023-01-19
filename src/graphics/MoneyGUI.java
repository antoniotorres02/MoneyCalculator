package graphics;

import command.Command;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JFrame;
import model.Currency;
import model.Money;

public class MoneyGUI extends JFrame implements GUI{
    
    static int SIZEX = 500;
    static int SIZEY = 300;
    static MoneyGUI moneyGUI;
    DialogPanel dialogPanel;
    ResultPanel resultPanel;
    
    
    public static MoneyGUI start(List<Currency> currencies) {
        if (moneyGUI != null) return moneyGUI;
        moneyGUI = new MoneyGUI("Money Calculator");
        moneyGUI.setLayout(new GridLayout(0, 1));
        moneyGUI.dialogPanel = new DialogPanel(currencies);
        moneyGUI.resultPanel = new ResultPanel();
        moneyGUI.getContentPane().add(moneyGUI.dialogPanel);
        moneyGUI.getContentPane().add(moneyGUI.resultPanel);
        moneyGUI.setResizable(false);
        return moneyGUI;
    }
    
    private MoneyGUI(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SIZEX,SIZEY);
    }

    @Override
    public GUI showGUI() {
        this.setVisible(true);
        return this;
    }

    @Override
    public List<Currency> getCurrencies() {
        return this.dialogPanel.getCurrencies();
    }

    @Override
    public void addCommand(Command command) {
        this.dialogPanel.setButtonCommand(command);
    }

    @Override
    public void showMoney(Money money) {
        this.resultPanel.showMoney(money);
    }

    @Override
    public Double getAmount() {
        return this.dialogPanel.getAmount();
    }
    


}
