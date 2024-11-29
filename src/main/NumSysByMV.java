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

    // Components for Length Tab
    private JTextField lengthUserText;
    private JComboBox<String> lengthFromBox, lengthToBox;
    private JTextField lengthUserAnswer;

    // Components for Time Tab
    private JTextField timeUserText;
    private JComboBox<String> timeFromBox, timeToBox;
    private JTextField timeUserAnswer;

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
        tabbedPane.addTab("Length", converter.createLengthPanel());
        tabbedPane.addTab("Time", converter.createTimePanel());

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

        String[] weightUnits = {"Kilogram", "Pound", "Gram", "Milligram"};
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

    // Length conversion panel
    private JPanel createLengthPanel() {
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
        lengthUserText = new JTextField();
        lengthUserText.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        panel.add(lengthUserText, gbc);
    
        // From Label
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setForeground(Color.WHITE);
        fromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(fromLabel, gbc);
    
        // From ComboBox
        lengthFromBox = new JComboBox<>(new String[]{"Meter", "Kilometer", "Centimeter", "Mile", "Yard", "Foot", "Inch"});
        lengthFromBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        panel.add(lengthFromBox, gbc);
    
        // To Label
        JLabel toLabel = new JLabel("To:");
        toLabel.setForeground(Color.WHITE);
        toLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(toLabel, gbc);
    
        // To ComboBox
        lengthToBox = new JComboBox<>(new String[]{"Meter", "Kilometer", "Centimeter", "Mile", "Yard", "Foot", "Inch"});
        lengthToBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        panel.add(lengthToBox, gbc);
    
        // Convert Button
        JButton convertButton = new JButton("Convert");
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));
        convertButton.setBackground(new Color(43, 43, 43));
        convertButton.setForeground(Color.WHITE);
        convertButton.setBorder(BorderFactory.createLineBorder(new Color(99, 99, 99)));
        convertButton.setActionCommand("Length");
        convertButton.addActionListener(this);
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
        lengthUserAnswer = new JTextField();
        lengthUserAnswer.setFont(new Font("Arial", Font.PLAIN, 14));
        lengthUserAnswer.setEditable(false);
        gbc.gridx = 1;
        panel.add(lengthUserAnswer, gbc);
    
        return panel;
    }
    
    // Time conversion panel
    private JPanel createTimePanel() {
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
        timeUserText = new JTextField();
        timeUserText.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        panel.add(timeUserText, gbc);
    
        // From Label
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setForeground(Color.WHITE);
        fromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(fromLabel, gbc);
    
        // From ComboBox
        timeFromBox = new JComboBox<>(new String[]{"Second", "Millisecond", "Minute", "Hour", "Day", "Week", "Month", "Year"});
        timeFromBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        panel.add(timeFromBox, gbc);
    
        // To Label
        JLabel toLabel = new JLabel("To:");
        toLabel.setForeground(Color.WHITE);
        toLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(toLabel, gbc);
    
        // To ComboBox
        timeToBox = new JComboBox<>(new String[]{"Second", "Millisecond", "Minute", "Hour", "Day", "Week", "Month", "Year"});
        timeToBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        panel.add(timeToBox, gbc);
    
        // Convert Button
        JButton convertButton = new JButton("Convert");
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));
        convertButton.setBackground(new Color(43, 43, 43));
        convertButton.setForeground(Color.WHITE);
        convertButton.setBorder(BorderFactory.createLineBorder(new Color(99, 99, 99)));
        convertButton.setActionCommand("Time");
        convertButton.addActionListener(this);
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
        timeUserAnswer = new JTextField();
        timeUserAnswer.setFont(new Font("Arial", Font.PLAIN, 14));
        timeUserAnswer.setEditable(false);
        gbc.gridx = 1;
        panel.add(timeUserAnswer, gbc);
    
        return panel;
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
            }
            case "Weight" -> {
            // Get values from the Weight tab
            input = weightUserText.getText().trim();
            fromUnit = (String) weightFromBox.getSelectedItem();
            toUnit = (String) weightToBox.getSelectedItem();
        
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Input cannot be empty.");
            }
        
            double weight = Double.parseDouble(input); // Parse as a double
        
            if (fromUnit.equals("Kilogram")) {
                if (toUnit.equals("Pound")) {
                    result = String.format("%.2f", weight * 2.20462) + " pounds";
                } else if (toUnit.equals("Gram")) {
                    result = String.format("%.2f", weight * 1000) + " grams";
                } else if (toUnit.equals("Milligram")) {
                    result = String.format("%.2f", weight * 1_000_000) + " milligrams";
                } else if (toUnit.equals("Kilogram")) {
                    result = input + " kilograms";
                }
            } else if (fromUnit.equals("Pound")) {
                if (toUnit.equals("Kilogram")) {
                    result = String.format("%.2f", weight / 2.20462) + " kilograms";
                } else if (toUnit.equals("Gram")) {
                    result = String.format("%.2f", (weight / 2.20462) * 1000) + " grams";
                } else if (toUnit.equals("Milligram")) {
                    result = String.format("%.2f", (weight / 2.20462) * 1_000_000) + " milligrams";
                } else if (toUnit.equals("Pound")) {
                    result = input + " pounds";
                }
            } else if (fromUnit.equals("Gram")) {
                if (toUnit.equals("Kilogram")) {
                    result = String.format("%.2f", weight / 1000) + " kilograms";
                } else if (toUnit.equals("Milligram")) {
                    result = String.format("%.2f", weight * 1000) + " milligrams";
                } else if (toUnit.equals("Pound")) {
                    result = String.format("%.2f", (weight / 1000) * 2.20462) + " pounds";
                } else if (toUnit.equals("Gram")) {
                    result = input + " grams";
                }
            } else if (fromUnit.equals("Milligram")) {
                if (toUnit.equals("Kilogram")) {
                    result = String.format("%.2f", weight / 1_000_000) + " kilograms";
                } else if (toUnit.equals("Gram")) {
                    result = String.format("%.2f", weight / 1000) + " grams";
                } else if (toUnit.equals("Pound")) {
                    result = String.format("%.2f", (weight / 1_000_000) * 2.20462) + " pounds";
                } else if (toUnit.equals("Milligram")) {
                    result = input + " milligrams";
                }
            } else {
                throw new IllegalArgumentException("Invalid Weight Conversion.");
            }
        
            weightUserAnswer.setText(result);
            }            
            case "Temperature" -> {
            // Get values from the Temperature tab
            input = tempUserText.getText().trim();
            fromUnit = (String) tempFromBox.getSelectedItem();
            toUnit = (String) tempToBox.getSelectedItem();

            // Check if input is empty or invalid
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Input cannot be empty.");
            }

            try {
                // Parse input as a double
                double temp = Double.parseDouble(input);

                // Perform the conversion
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

            } catch (NumberFormatException ex) {
                // Handle non-numeric input
                throw new IllegalArgumentException("Please enter a valid numeric value.");
            }
        }
            case "Length" -> {
            // Get values from the Length tab
            input = lengthUserText.getText().trim();
            fromUnit = (String) lengthFromBox.getSelectedItem();
            toUnit = (String) lengthToBox.getSelectedItem();

            if (input.isEmpty()) {
                throw new IllegalArgumentException("Input cannot be empty.");
            }

            try {
                double length = Double.parseDouble(input); // Parse input as double

                // Conversion rates to meters
                double toMeters = switch (fromUnit) {
                    case "Meter" -> 1.0;
                    case "Kilometer" -> 1000.0;
                    case "Centimeter" -> 0.01;
                    case "Mile" -> 1609.34;
                    case "Yard" -> 0.9144;
                    case "Foot" -> 0.3048;
                    case "Inch" -> 0.0254;
                    default -> throw new IllegalArgumentException("Invalid Length Unit.");
                };

                // Conversion rates from meters
                double fromMeters = switch (toUnit) {
                    case "Meter" -> 1.0;
                    case "Kilometer" -> 0.001;
                    case "Centimeter" -> 100.0;
                    case "Mile" -> 0.000621371;
                    case "Yard" -> 1.09361;
                    case "Foot" -> 3.28084;
                    case "Inch" -> 39.3701;
                    default -> throw new IllegalArgumentException("Invalid Length Unit.");
                };

                // Perform the conversion
                double convertedLength = length * toMeters * fromMeters;
                result = String.format("%.4f", convertedLength) + " " + toUnit;

                // Display the result
                lengthUserAnswer.setText(result);

            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Please enter a valid numeric value.");
            }
        }
            default -> throw new IllegalArgumentException("Unknown action command.");
       case "Time" -> {
        // Get values from the Time tab
        input = timeUserText.getText().trim();
        fromUnit = (String) timeFromBox.getSelectedItem();
        toUnit = (String) timeToBox.getSelectedItem();
    
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty.");
        }
    
        try {
            double time = Double.parseDouble(input); // Parse input as double
    
            // Conversion rates to seconds
            double toSeconds = switch (fromUnit) {
                case "Millisecond" -> 0.001;
                case "Second" -> 1.0;
                case "Minute" -> 60.0;
                case "Hour" -> 3600.0;
                case "Day" -> 86400.0;
                case "Week" -> 604800.0;
                case "Month" -> 2592000.0; // Approximation (30 days)
                case "Year" -> 31536000.0; // Approximation (365 days)
                default -> throw new IllegalArgumentException("Invalid Time Unit.");
            };
    
            // Conversion rates from seconds
            double fromSeconds = switch (toUnit) {
                case "Millisecond" -> 1000.0;
                case "Second" -> 1.0;
                case "Minute" -> 1.0 / 60.0;
                case "Hour" -> 1.0 / 3600.0;
                case "Day" -> 1.0 / 86400.0;
                case "Week" -> 1.0 / 604800.0;
                case "Month" -> 1.0 / 2592000.0; // Approximation (30 days)
                case "Year" -> 1.0 / 31536000.0; // Approximation (365 days)
                default -> throw new IllegalArgumentException("Invalid Time Unit.");
            };
    
            // Perform the conversion
            double convertedTime = time * toSeconds * fromSeconds;
            result = String.format("%.4f", convertedTime) + " " + toUnit;
    
            // Display the result
            timeUserAnswer.setText(result);
    
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Please enter a valid numeric value.");
        }
    }    
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
