package graphics;

import command.Command;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import model.Currency;

public class DialogPanel extends JPanel {
   
    JComboBox<Currency> fromComboBox;
    JComboBox<Currency> toComboBox;
    JTextField moneyField;
    JButton calculateButton;
    JLabel moneyLabel;
    JLabel fromLabel;
    JLabel toLabel;
    
    public DialogPanel(List<Currency> currencies){
        createComponents(currencies);
        addComponents();
    }

    private void createComponents(List<Currency> currencies) {
        fromComboBox = new JComboBox<>();
        toComboBox = new JComboBox<>();
        moneyField = new JTextField("0");
        calculateButton = new JButton("Calculate");
        moneyLabel = new JLabel("Money");
        fromLabel = new JLabel("From");
        toLabel = new JLabel("To");
        for (Currency currency : currencies) {
            fromComboBox.addItem(currency);
            toComboBox.addItem(currency);
        }
    }

    private void addComponents() {
        JPanel dialogPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(10, 30, 0, 20);
        dialogPanel.setBorder(padding);
        dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.X_AXIS));

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(0, 1));
        labelPanel.add(this.moneyLabel);
        labelPanel.add(this.fromLabel);
        labelPanel.add(this.toLabel);

        dialogPanel.add(labelPanel);

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(0, 1));

        fieldPanel.add(this.moneyField);
        fieldPanel.add(this.fromComboBox);
        fieldPanel.add(this.toComboBox);

        dialogPanel.add(fieldPanel);

        JPanel controlPanel = new JPanel();
        controlPanel.add(this.calculateButton);

        setLayout(new BorderLayout());
        add(dialogPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);   
    }
    
    public void setButtonCommand(Command command) {
        this.calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command.execute();
            }
        });
    }
    
    public List<Currency> getCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        currencies.add((Currency) this.fromComboBox.getSelectedItem());
        currencies.add((Currency) this.toComboBox.getSelectedItem());
        return currencies;
    }

    public Double getAmount() {
        return Double.valueOf(this.moneyField.getText());
    }
    
}
