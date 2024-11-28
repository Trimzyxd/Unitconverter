package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumSysByMV implements ActionListener {

    // Components for Number System Tab
    private JTextField nsUserText;
    private JComboBox<String> nsFromBox, nsToBox;
    private JTextField nsUserAnswer;

    // Components for Weight Tab
    private JTextField weightUserText;
    private JComboBox<String> weightFromBox, weightToBox;
    private JTextField weightUserAnswer;

    // Components for Temperature Tab
    private JTextField tempUserText;
    private JComboBox<String> tempFromBox, tempToBox;
    private JTextField tempUserAnswer;

    private static int usageCount = 0; // Counter for session usage

    public static void main(String[] args) {
        // Main frame
        JFrame frame = new JFrame("Unit Converter - Group 6");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Instance of this class for handling actions
        NumSysByMV converter = new NumSysByMV();

        // Add panels for each tab
        tabbedPane.addTab("Number System", converter.createNumberSystemPanel());
        tabbedPane.addTab("Weight", converter.createWeightPanel());
        tabbedPane.addTab("Temperature", converter.createTemperaturePanel());

        // Add tabbed pane to the frame
        frame.add(tabbedPane);

        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Number System conversion panel
    private JPanel createNumberSystemPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(60, 63, 65));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input Label
        JLabel userLabel = new JLabel("Enter a Value:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        // Input TextField
        nsUserText = new JTextField();
        nsUserText.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        panel.add(nsUserText, gbc);

        // From label and dropdown
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setForeground(Color.WHITE);
        fromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(fromLabel, gbc);

        String[] numUnits = {"Decimal", "Binary", "Hexadecimal", "Octal"};
        nsFromBox = new JComboBox<>(numUnits);
        nsFromBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        panel.add(nsFromBox, gbc);

        // To label and dropdown
        JLabel toLabel = new JLabel("To:");
        toLabel.setForeground(Color.WHITE);
        toLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(toLabel, gbc);

        nsToBox = new JComboBox<>(numUnits);
        nsToBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        panel.add(nsToBox, gbc);

        // Convert button
        JButton convertButton = new JButton("Convert");
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));
        convertButton.setBackground(new Color(43, 43, 43));
        convertButton.setForeground(Color.WHITE);
        convertButton.setBorder(BorderFactory.createLineBorder(new Color(99, 99, 99)));
        convertButton.setActionCommand("NumberSystem");
        convertButton.addActionListener(this);
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(convertButton, gbc);

        // Answer field and label
        JLabel answer = new JLabel("Answer:");
        answer.setForeground(Color.WHITE);
        answer.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        panel.add(answer, gbc);

        nsUserAnswer = new JTextField();
        nsUserAnswer.setFont(new Font("Arial", Font.PLAIN, 14));
        nsUserAnswer.setEditable(false);
        gbc.gridx = 1;
        panel.add(nsUserAnswer, gbc);

        return panel;
    }

    // Weight conversion panel
    private JPanel createWeightPanel() {
        // Similar to Number System Panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(60, 63, 65));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        // Input Label
        JLabel userLabel = new JLabel("Enter a Value:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        // Input TextField
        weightUserText = new JTextField();
        weightUserText.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        panel.add(weightUserText, gbc);


        // From label and dropdown
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setForeground(Color.WHITE);
        fromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(fromLabel, gbc);

        String[] weightUnits = {"Kg", "Lb"};
        weightFromBox = new JComboBox<>(weightUnits);
        weightFromBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        panel.add(weightFromBox, gbc);


        // To label and dropdown
        JLabel toLabel = new JLabel("To:");
        toLabel.setForeground(Color.WHITE);
        toLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(toLabel, gbc);

        weightToBox = new JComboBox<>(weightUnits);
        weightToBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        panel.add(weightToBox, gbc);

        // Convert button
        JButton convertButton = new JButton("Convert");
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));
        convertButton.setBackground(new Color(43, 43, 43));
        convertButton.setForeground(Color.WHITE);
        convertButton.setBorder(BorderFactory.createLineBorder(new Color(99, 99, 99)));
        convertButton.setActionCommand("Weight");
        convertButton.addActionListener(this);
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(convertButton, gbc);

        // Answer field and label
        JLabel answer = new JLabel("Answer:");
        answer.setForeground(Color.WHITE);
        answer.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        panel.add(answer, gbc);

        weightUserAnswer = new JTextField();
        weightUserAnswer.setFont(new Font("Arial", Font.PLAIN, 14));
        weightUserAnswer.setEditable(false);
        gbc.gridx = 1;
        panel.add(weightUserAnswer, gbc);

        return panel;
    }

// Temperature conversion panel
private JPanel createTemperaturePanel() {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.setBackground(new Color(60, 63, 65));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    // Input Label
    JLabel userLabel = new JLabel("Enter a Value:");
    userLabel.setForeground(Color.WHITE);
    userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    gbc.gridx = 0;
    gbc.gridy = 0;
    panel.add(userLabel, gbc);

    // Input TextField
    tempUserText = new JTextField();
    tempUserText.setFont(new Font("Arial", Font.PLAIN, 14));
    gbc.gridy = 1;
    panel.add(tempUserText, gbc);

    // From Label
    JLabel fromLabel = new JLabel("From:");
    fromLabel.setForeground(Color.WHITE);
    fromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    gbc.gridy = 2;
    gbc.gridx = 0;
    panel.add(fromLabel, gbc);

    // From ComboBox
    String[] temperatureUnits = {"Celsius", "Fahrenheit"};
    tempFromBox = new JComboBox<>(temperatureUnits);
    tempFromBox.setFont(new Font("Arial", Font.PLAIN, 14));
    gbc.gridx = 1;
    panel.add(tempFromBox, gbc);

    // To Label
    JLabel toLabel = new JLabel("To:");
    toLabel.setForeground(Color.WHITE);
    toLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    gbc.gridy = 3;
    gbc.gridx = 0;
    panel.add(toLabel, gbc);

    // To ComboBox
    tempToBox = new JComboBox<>(temperatureUnits);
    tempToBox.setFont(new Font("Arial", Font.PLAIN, 14));
    gbc.gridx = 1;
    panel.add(tempToBox, gbc);

    // Convert Button
    JButton convertButton = new JButton("Convert");
    convertButton.setFont(new Font("Arial", Font.BOLD, 14));
    convertButton.setBackground(new Color(43, 43, 43));
    convertButton.setForeground(Color.WHITE);
    convertButton.setBorder(BorderFactory.createLineBorder(new Color(99, 99, 99)));
    convertButton.setActionCommand("Temperature"); // Identifies this button's action
    convertButton.addActionListener(this); // Links to actionPerformed
    gbc.gridy = 4;
    gbc.gridwidth = 2;
    panel.add(convertButton, gbc);

    // Answer Label
    JLabel answer = new JLabel("Answer:");
    answer.setForeground(Color.WHITE);
    answer.setFont(new Font("Arial", Font.PLAIN, 14));
    gbc.gridy = 5;
    gbc.gridwidth = 1;
    gbc.gridx = 0;
    panel.add(answer, gbc);

    // Answer TextField
    tempUserAnswer = new JTextField();
    tempUserAnswer.setFont(new Font("Arial", Font.PLAIN, 14));
    tempUserAnswer.setEditable(false); // Output field should not be editable
    gbc.gridx = 1;
    panel.add(tempUserAnswer, gbc);

    return panel; // Return the fully constructed panel
}

@Override
    public void actionPerformed(ActionEvent e) {
    try {
        String actionCommand = e.getActionCommand(); // Identify the source tab
        String input;
        String fromUnit;
        String toUnit;
        String result = "";
        
        switch (actionCommand) {
        case "NumberSystem" -> {
        // Get values from the Number System tab
        input = nsUserText.getText().trim();
        fromUnit = (String) nsFromBox.getSelectedItem();
        toUnit = (String) nsToBox.getSelectedItem();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty.");
        }

        // Parse input and perform the conversion
        int value = switch (fromUnit) {
            case "Decimal" -> Integer.parseInt(input);
            case "Binary" -> Integer.parseInt(input, 2);
            case "Hexadecimal" -> Integer.parseInt(input, 16);
            case "Octal" -> Integer.parseInt(input, 8);
            default -> throw new IllegalArgumentException("Invalid Number System.");
        };

        result = switch (toUnit) {
            case "Decimal" -> String.valueOf(value);
            case "Binary" -> Integer.toBinaryString(value);
            case "Hexadecimal" -> Integer.toHexString(value).toUpperCase();
            case "Octal" -> Integer.toOctalString(value);
            default -> throw new IllegalArgumentException("Invalid Number System.");
        };

        nsUserAnswer.setText(result);
    }case "Weight" -> {
        // Get values from the Weight tab
        input = weightUserText.getText().trim();
        fromUnit = (String) weightFromBox.getSelectedItem();
        toUnit = (String) weightToBox.getSelectedItem();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty.");
        }

        double weight = Double.parseDouble(input); // Parse as a double
        if (fromUnit.equals("Kg") && toUnit.equals("Lb")) {
            result = String.format("%.2f", weight * 2.20462) + " pounds";
        } else if (fromUnit.equals("Lb") && toUnit.equals("Kg")) {
            result = String.format("%.2f", weight / 2.20462) + " kilograms";
        } else if (fromUnit.equals(toUnit)) {
            result = input + (fromUnit.equals("Kg") ? " kilograms" : " pounds");
        } else {
            throw new IllegalArgumentException("Invalid Weight Conversion.");
        }

        weightUserAnswer.setText(result);
    }case "Temperature" -> {
        // Get values from the Temperature tab
        input = tempUserText.getText().trim();
        fromUnit = (String) tempFromBox.getSelectedItem();
        toUnit = (String) tempToBox.getSelectedItem();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty.");
        }

        double temp = Double.parseDouble(input); // Parse as a double
        if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) {
            result = String.format("%.2f", (temp * 9 / 5) + 32) + " °F";
        } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius")) {
            result = String.format("%.2f", (temp - 32) * 5 / 9) + " °C";
        } else if (fromUnit.equals(toUnit)) {
            result = input + (fromUnit.equals("Celsius") ? " °C" : " °F");
        } else {
            throw new IllegalArgumentException("Invalid Temperature Conversion.");
        }

        tempUserAnswer.setText(result);
    }default -> throw new IllegalArgumentException("Unknown action command.");
}
        
            // Increment usage count
            usageCount++;
        if (usageCount == 100) {
            JOptionPane.showMessageDialog(null,
                        "Congratulations! You've used the program 100 times!",
                        "Milestone Achieved",
                    JOptionPane.INFORMATION_MESSAGE);
    }

        } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null,
                    "Please enter a valid numeric value.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(null,
                    ex.getMessage(),
                    "Conversion Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,
                    "An unexpected error occurred.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}