package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumSysByMV implements ActionListener {

    public static JLabel userLabel;
    public static JTextField userText;
    public static JComboBox<String> fromBox;
    public static JComboBox<String> toBox;
    public static JButton convertButton;
    public static JTextField userAnswer;
    public static JLabel answer;
    private static int usageCount = 0; // Counter for session usage

    public static void main(String[] args) {
        // Main frame
        JFrame frame = new JFrame("Unit Converter - Group 6");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        // Main panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(60, 63, 65));
        panel.setLayout(new GridBagLayout());
        frame.add(panel);

        // GridBagLayout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input Label
        userLabel = new JLabel("Enter a Value:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(userLabel, gbc);

        // Input TextField
        userText = new JTextField();
        userText.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(userText, gbc);

        // Dropdown menus for conversion options
        String[] units = {
            "Decimal", "Binary", "Hexadecimal", "Octal", "Kg", "Lb"
        };

        // From label
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setForeground(Color.WHITE); // Set font color to white
        fromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(fromLabel, gbc);

        // From dropdown
        fromBox = new JComboBox<>(units);
        fromBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        panel.add(fromBox, gbc);

        // To label
        JLabel toLabel = new JLabel("To:");
        toLabel.setForeground(Color.WHITE); // Set font color to white
        toLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(toLabel, gbc);

        // To dropdown
        toBox = new JComboBox<>(units);
        toBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        panel.add(toBox, gbc);


        // Convert button
        convertButton = new JButton("Convert");
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));
        convertButton.setBackground(new Color(43, 43, 43));
        convertButton.setForeground(Color.WHITE);
        convertButton.setBorder(BorderFactory.createLineBorder(new Color(99, 99, 99)));
        convertButton.addActionListener(new NumSysByMV());
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(convertButton, gbc);

        // Answer field and label
        answer = new JLabel("Answer:");
        answer.setForeground(Color.WHITE);
        answer.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        panel.add(answer, gbc);

        userAnswer = new JTextField();
        userAnswer.setFont(new Font("Arial", Font.PLAIN, 14));
        userAnswer.setEditable(false);
        gbc.gridx = 1;
        panel.add(userAnswer, gbc);

        // Usage label
        JLabel usageLabel = new JLabel("Program Used: 0 times");
        usageLabel.setForeground(Color.WHITE);
        usageLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(usageLabel, gbc);

        // usage count updating
        Timer timer = new Timer(500, e -> usageLabel.setText("Program Used: " + usageCount + " times"));
        timer.start();

        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    try {
        String input = userText.getText();
        String fromUnit = (String) fromBox.getSelectedItem();
        String toUnit = (String) toBox.getSelectedItem();

        // Check for incompatible categories
        boolean isNumberSystem = fromUnit.equals("Decimal") || fromUnit.equals("Binary") ||
                                 fromUnit.equals("Hexadecimal") || fromUnit.equals("Octal");

        boolean isWeightClass = fromUnit.equals("Kg") || fromUnit.equals("Lb");

        if ((isNumberSystem && toUnit.equals("Kg")) || 
            (isNumberSystem && toUnit.equals("Lb")) || 
            (isWeightClass && toUnit.equals("Decimal")) || 
            (isWeightClass && toUnit.equals("Binary")) || 
            (isWeightClass && toUnit.equals("Hexadecimal")) || 
            (isWeightClass && toUnit.equals("Octal"))) {
            userAnswer.setText("Invalid Conversion");
            JOptionPane.showMessageDialog(null, 
                "Invalid Conversion", 
                "Invalid Conversion", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        String result = "";

        // Conversion logic
        if (fromUnit.equals("Decimal")) {
            int decimal = Integer.parseInt(input);
            if (toUnit.equals("Binary")) {
                result = Integer.toBinaryString(decimal);
            } else if (toUnit.equals("Hexadecimal")) {
                result = Integer.toHexString(decimal).toUpperCase();
            } else if (toUnit.equals("Octal")) {
                result = Integer.toOctalString(decimal);
            } else if (toUnit.equals("Decimal")) {
                result = input; // No conversion
            }
        } else if (fromUnit.equals("Binary")) {
            int binary = Integer.parseInt(input, 2);
            if (toUnit.equals("Decimal")) {
                result = String.valueOf(binary);
            } else if (toUnit.equals("Octal")) {
                result = Integer.toOctalString(binary);
            } else if (toUnit.equals("Hexadecimal")) {
                result = Integer.toHexString(binary).toUpperCase();
            } else if (toUnit.equals("Binary")) {
                result = input; // No conversion
            }
        } else if (fromUnit.equals("Kg")) {
            double kilograms = Double.parseDouble(input);
            if (toUnit.equals("Lb")) {
                result = String.format("%.2f", kilograms * 2.20462) + " pounds";
            } else if (toUnit.equals("Kg")) {
                result = input + " kilograms"; // No conversion
            }
        } else if (fromUnit.equals("Lb")) {
            double pounds = Double.parseDouble(input);
            if (toUnit.equals("Kg")) {
                result = String.format("%.2f", pounds / 2.20462) + " kilograms";
            } else if (toUnit.equals("Lb")) {
                result = input + " pounds"; // No conversion
            }
        }

        userAnswer.setText(result);

        // usage count
        usageCount++;
        if (usageCount == 100) {
            JOptionPane.showMessageDialog(null,
                    "Congratulations! You've used the program 100 times!",
                    "Milestone Achieved",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (NumberFormatException ex) {
        userAnswer.setText("Invalid Input");
        JOptionPane.showMessageDialog(null, 
            "Please enter a valid numeric value.", 
            "Invalid Input", 
            JOptionPane.ERROR_MESSAGE);
        }
    }
}