package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumSysByMV implements ActionListener {

    public static JLabel userLabel;
    public static JTextField userText;
    public static JButton binaryButton, hexaButton, octalButton, kgToLbButton, lbToKgButton;
    public static JTextField userAnswer;
    public static JLabel answer;
    private static int usageCount = 0; // Counter for session usage

    public static void main(String[] args) {
        // Create main frame
        JFrame frame = new JFrame("Unit Converter - Group 6");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Main panel with a modern look
        JPanel panel = new JPanel();
        panel.setBackground(new Color(60, 63, 65));
        panel.setLayout(new GridBagLayout());
        frame.add(panel);

        // GridBagLayout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input Label
        userLabel = new JLabel("Enter Decimal or Weight:");
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

        // Buttons for conversions
        binaryButton = createButton("Binary");
        hexaButton = createButton("Hexa");
        octalButton = createButton("Octal");
        kgToLbButton = createButton("Kg to Lb");
        lbToKgButton = createButton("Lb to Kg");

        gbc.gridwidth = 1;
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(binaryButton, gbc);
        gbc.gridx = 1;
        panel.add(kgToLbButton, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(hexaButton, gbc);
        gbc.gridx = 1;
        panel.add(lbToKgButton, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        panel.add(octalButton, gbc);

        // Answer field and label
        answer = new JLabel("Answer:");
        answer.setForeground(Color.WHITE);
        answer.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
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

        // Update usage count dynamically
        Timer timer = new Timer(500, e -> usageLabel.setText("Program Used: " + usageCount + " times"));
        timer.start();

        // Center the frame and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Helper method to create buttons
    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(new Color(43, 43, 43));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(new Color(99, 99, 99)));
        button.addActionListener(new NumSysByMV());
        button.setActionCommand(text);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String input = userText.getText();

            switch (e.getActionCommand()) {
                case "Binary":
                    int decimal = Integer.parseInt(input);
                    userAnswer.setText(Integer.toBinaryString(decimal));
                    break;
                case "Hexa":
                    decimal = Integer.parseInt(input);
                    userAnswer.setText(Integer.toHexString(decimal).toUpperCase());
                    break;
                case "Octal":
                    decimal = Integer.parseInt(input);
                    userAnswer.setText(Integer.toOctalString(decimal));
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

            // Increment usage count
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
