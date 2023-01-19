package graphics;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Money;

public class ResultPanel extends JPanel {

    JLabel exchangeLabel;
    JLabel exchangeAmount;
    
    public ResultPanel() {
        createComponents();
        addComponents();
    }
    


    private void createComponents() {
        exchangeLabel = new JLabel("EXCHANGE:");
        exchangeAmount = new JLabel("");
        exchangeLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        exchangeAmount.setFont(new Font("Arial", Font.PLAIN, 25));
    }

    private void addComponents() {
        JPanel resultPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(0, 20, 20, 20);
        resultPanel.setBorder(padding);
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.X_AXIS));
        
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(0,1));
        labelPanel.add(exchangeLabel);
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(0,1));
        textPanel.add(exchangeAmount);
        
        resultPanel.add(labelPanel);
        resultPanel.add(textPanel);
        
        
        setLayout(new BorderLayout());
        add(resultPanel, BorderLayout.CENTER);
    }
    
    public void showMoney(Money money) {
        exchangeAmount.setText(money.toString());
    }
}
