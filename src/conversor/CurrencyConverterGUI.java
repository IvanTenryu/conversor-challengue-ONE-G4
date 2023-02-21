package conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CurrencyConverterGUI {
    private CurrencyConverter converter;
    private JLabel amountLabel;
    private JTextField amountField;
    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;
    private JLabel resultLabel;

    public CurrencyConverterGUI() {
        this.converter = new CurrencyConverter();

        // Agregar las monedas y tasas de cambio
        converter.addCurrency("USD", 1.0);
        converter.addCurrency("EUR", 0.83);
        converter.addCurrency("GBP", 0.72);
        converter.addCurrency("JPY", 105.23);
        converter.addCurrency("KRW", 1137.69);

        // Crear la interfaz de usuario
        JFrame frame = new JFrame("Conversor de Divisas");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setVisible(true);
        
        // Etiqueta de "Cantidad"
        amountLabel = new JLabel("Cantidad:");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        frame.add(amountLabel, c);

        // Campo de texto para la cantidad
        amountField = new JTextField(10);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        frame.add(amountField, c);

        // Etiqueta de "De"
        JLabel fromLabel = new JLabel("De:");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        frame.add(fromLabel, c);

        // Cuadro combinado para seleccionar la moneda de origen
        fromComboBox = new JComboBox<>();
        List<String> codes = converter.getCurrencyCodes();
        for (String code : codes) {
            fromComboBox.addItem(code);
        }
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        frame.add(fromComboBox, c);

        // Etiqueta de "A"
        JLabel toLabel = new JLabel("A:");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        frame.add(toLabel, c);

        // Cuadro combinado para seleccionar la moneda de destino
        toComboBox = new JComboBox<>();
        for (String code : codes) {
            toComboBox.addItem(code);
        }
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        frame.add(toComboBox, c);

        // Botón para realizar la conversión
        JButton convertButton = new JButton("Convertir");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                String fromCode = (String) fromComboBox.getSelectedItem();
                String toCode = (String) toComboBox.getSelectedItem();
                double result = converter.convert(amount, fromCode, toCode);
                resultLabel.setText(String.format("%.2f", result));
            }
        });
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        frame.add(convertButton, c);

        // Etiqueta para mostrar el resultado de la conversión
        resultLabel = new JLabel(" ");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        frame.add(resultLabel, c);

        // Mostrar la ventana
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    	CurrencyConverterGUI gui = new CurrencyConverterGUI();
        }
}

