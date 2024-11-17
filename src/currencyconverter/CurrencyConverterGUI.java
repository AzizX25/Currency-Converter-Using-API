// The commented code in the snippet above delivers a GUI that allows users to enter a base currency, target currency, and amount to convert.
/*
package currencyconverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CurrencyConverterGUI extends JFrame {

    private JTextField fromCurrencyField;
    private JTextField toCurrencyField;
    private JTextField amountField;
    private JLabel resultLabel;
    private JTextField resultField;


    public CurrencyConverterGUI() {
        setTitle("Currency Converter 1.0");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        //Labels
        JLabel fromLabel = new JLabel("From Currency: ");
        fromLabel.setBounds(30, 20, 90, 25);
        add(fromLabel);

        JLabel toLabel = new JLabel("To Currency: ");
        toLabel.setBounds(270, 20, 90, 25);
        add(toLabel);

        JLabel amountLabel = new JLabel("Amount: ");
        amountLabel.setBounds(30, 60, 60, 25);
        add(amountLabel);

        //Text Fields
        fromCurrencyField = new JTextField("USD");
        fromCurrencyField.setBounds(130, 20, 100, 25);
        add(fromCurrencyField);

        toCurrencyField = new JTextField("EUR");
        toCurrencyField.setBounds(360, 20, 100, 25);
        add(toCurrencyField);

        amountField = new JTextField("100");
        amountField.setBounds(130, 60, 100, 25);
        add(amountField);

        resultField = new JTextField();
        resultField.setBounds(160, 100, 100, 25);
        add(resultField);

        //Convert Button
        JButton convertButton = new JButton("CONVERT");
        convertButton.setBounds(270, 60, 100, 25);
        add(convertButton);

        //Result Label
        resultLabel = new JLabel("Result =");
        resultLabel.setBounds(30, 100, 300, 25);
        add(resultLabel);

        //Action Listener for the covert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        String fromCurrency = fromCurrencyField.getText().toUpperCase();
        String toCurrency = toCurrencyField.getText().toUpperCase();
        double amount = Double.parseDouble(amountField.getText());
        try {
            double rate = CurrencyService.getExchangeRate(fromCurrency, toCurrency);
            double convertedamount = amount * rate;
            resultField.setText(String.valueOf(convertedamount));
        } catch (IOException | InterruptedException e) {
            resultLabel.setText("ERROR : Unable to fetch exchange rate");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyConverterGUI converterGUI = new CurrencyConverterGUI();
            converterGUI.setVisible(true);
        });

    }
}
*/

// This GUI allows users to choose the base and target currencies from drop-down lists, enter the amount to convert, and click a "CONVERT" button to display the converted amount.
package currencyconverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CurrencyConverterGUI extends JFrame {

    // Components
    // JComboBox is a component that allows users to select an item from a list.
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JTextField amountField;
    private JLabel resultLabel;
    private JTextField resultField;

    private static final String[] currencyCodes = {
            "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN",
            "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL",
            "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY",
            "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP",
            "ERN", "ETB", "EUR", "FJD", "FKP", "FOK", "GBP", "GEL", "GGP", "GHS",
            "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF",
            "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD",
            "JPY", "KES", "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT",
            "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD",
            "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN",
            "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK",
            "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR",
            "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SOS", "SRD", "SSP",
            "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD",
            "TVD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND",
            "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL"
    };

    public CurrencyConverterGUI() {
        setTitle("Currency Converter 1.0");
        setSize(570, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Labels
        JLabel fromLabel = new JLabel("From Currency:");
        fromLabel.setBounds(30, 20, 90, 25);
        add(fromLabel);

        JLabel toLabel = new JLabel("To Currency:");
        toLabel.setBounds(270, 20, 90, 25);
        add(toLabel);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(30, 60, 60, 25);
        add(amountLabel);

        // Combo Boxes
        fromCurrencyComboBox = new JComboBox<>(currencyCodes);
        fromCurrencyComboBox.setBounds(130, 20, 100, 25);
        add(fromCurrencyComboBox);

        toCurrencyComboBox = new JComboBox<>(currencyCodes);
        toCurrencyComboBox.setBounds(360, 20, 100, 25);
        add(toCurrencyComboBox);

        // Text Fields
        amountField = new JTextField("100");
        amountField.setBounds(130, 60, 100, 25);
        add(amountField);

        resultField = new JTextField();
        resultField.setBounds(160, 100, 100, 25);
        add(resultField);

        // Convert Button
        JButton convertButton = new JButton("CONVERT");
        convertButton.setBounds(270, 60, 100, 25);
        add(convertButton);

        // Result Label
        resultLabel = new JLabel("Result =");
        resultLabel.setBounds(30, 100, 300, 25);
        add(resultLabel);

        // Action Listener for the convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        // Get the selected currencies and amount from the GUI components
        String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
        String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
        double amount = Double.parseDouble(amountField.getText());
        try {
            double rate = CurrencyService.getExchangeRate(fromCurrency, toCurrency);
            double convertedAmount = amount * rate;
            resultField.setText(String.valueOf(convertedAmount));
        } catch (IOException | InterruptedException e) {
            resultLabel.setText("ERROR: Unable to fetch exchange rate");
            e.printStackTrace();
        }
    }

    // Main method to create and display the GUI
    // The GUI is created and displayed on the Event Dispatch Thread (EDT) using SwingUtilities.invokeLater().
    // This ensures that the GUI components are created and updated on the EDT, which is the dedicated thread for handling Swing components.
    // This is important to ensure that the GUI remains responsive and avoids potential concurrency issues.
    // The CurrencyConverterGUI instance is created and made visible by calling setVisible(true).
    public static void main(String[] args) {
        // Create and display the CurrencyConverterGUI
        // SwingUtilities.invokeLater() is used to run the GUI creation code on the Event Dispatch Thread (EDT).
        // This is necessary for Swing applications to ensure proper handling of GUI components.
        // invokeLater() takes a Runnable as an argument, which defines the code to be executed on the EDT.
        // SwingUtilities.invokeLater(() -> { ... }) is a common pattern for creating Swing GUIs. The lambda expression (() -> { ... }) defines the code to be executed on the EDT.
        // Inside the lambda expression, the CurrencyConverterGUI instance is created and made visible by calling setVisible(true).
        // This ensures that the GUI components are created and displayed on the EDT, avoiding potential concurrency issues.
        SwingUtilities.invokeLater(() -> {
            CurrencyConverterGUI converterGUI = new CurrencyConverterGUI();
            converterGUI.setVisible(true);
        });
    }
}