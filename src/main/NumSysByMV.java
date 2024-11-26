package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumSysByMV implements ActionListener {

    public static JLabel userLabel;
    public static JTextField userText;
    public static JComboBox<String> conversionBox;
    public static JButton convertButton;
    public static JTextField userAnswer;
    public static JLabel answer;
    private static int usageCount = 0; // Counter for session usage

    public static void main(String[] args) {
        // main frame
        JFrame frame = new JFrame("Unit Converter - Group 6");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

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

        // Dropdown menu for conversion options
        String[] conversionOptions = {
            "Decimal to Binary",
            "Decimal to Hexadecimal",
            "Decimal to Octal",
            "Binary to Decimal",
            "Binary to Octal",
            "Binary to Hexadecimal",
            "Hexadecimal to Decimal",
            "Hexadecimal to Binary",
            "Octal to Decimal",
            "Octal to Binary",
            "Kg to Lb",
            "Lb to Kg"
        };
        conversionBox = new JComboBox<>(conversionOptions);
        conversionBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(conversionBox, gbc);

        // Convert button
        convertButton = new JButton("Convert");
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));
        convertButton.setBackground(new Color(43, 43, 43));
        convertButton.setForeground(Color.WHITE);
        convertButton.setBorder(BorderFactory.createLineBorder(new Color(99, 99, 99)));
        convertButton.addActionListener(new NumSysByMV());
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(convertButton, gbc);

        // Answer field and label
        answer = new JLabel("Answer:");
        answer.setForeground(Color.WHITE);
        answer.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 4;
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
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(usageLabel, gbc);

        // usage count updating
        Timer timer = new Timer(500, e -> usageLabel.setText("Program Used: " + usageCount + " times"));
        timer.start();

        // para ma center yung frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String input = userText.getText();
            String selectedConversion = (String) conversionBox.getSelectedItem();

            switch (selectedConversion) {
                case "Decimal to Binary":
                    int decimal = Integer.parseInt(input);
                    userAnswer.setText(Integer.toBinaryString(decimal));
                    break;
                case "Decimal to Hexadecimal":
                    decimal = Integer.parseInt(input);
                    userAnswer.setText(Integer.toHexString(decimal).toUpperCase());
                    break;
                case "Decimal to Octal":
                    decimal = Integer.parseInt(input);
                    userAnswer.setText(Integer.toOctalString(decimal));
                    break;
                case "Binary to Decimal":
                    int binary = Integer.parseInt(input, 2);
                    userAnswer.setText(String.valueOf(binary));
                    break;
                case "Binary to Octal":
                    binary = Integer.parseInt(input, 2);
                    userAnswer.setText(Integer.toOctalString(binary));
                    break;
                case "Binary to Hexadecimal":
                    binary = Integer.parseInt(input, 2);
                    userAnswer.setText(Integer.toHexString(binary).toUpperCase());
                    break;
                case "Hexadecimal to Decimal":
                    int hex = Integer.parseInt(input, 16);
                    userAnswer.setText(String.valueOf(hex));
                    break;
                case "Hexadecimal to Binary":
                    hex = Integer.parseInt(input, 16);
                    userAnswer.setText(Integer.toBinaryString(hex));
                    break;
                case "Octal to Decimal":
                    int octal = Integer.parseInt(input, 8);
                    userAnswer.setText(String.valueOf(octal));
                    break;
                case "Octal to Binary":
                    octal = Integer.parseInt(input, 8);
                    userAnswer.setText(Integer.toBinaryString(octal));
                    break;
                case "Kg to Lb":
                    double kilograms = Double.parseDouble(input);
                    double pounds = kilograms * 2.20462;
                    userAnswer.setText(String.format("%.2f pounds", pounds));
                    break;
                case "Lb to Kg":
                    double lbs = Double.parseDouble(input);
                    double kgs = lbs / 2.20462;
                    userAnswer.setText(String.format("%.2f kilograms", kgs));
                    break;
                default:
                    userAnswer.setText("Error");
            }

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
        }
    }
}
