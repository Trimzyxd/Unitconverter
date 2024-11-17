package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumSysByMV implements ActionListener {

    public static JLabel userlabel;
    public static JTextField userText;
    public static JButton binaryButton, hexaButton, octalButton;
    public static JTextField useranswer;
    public static JLabel answer;
    private static int usageCount = 0; // Counter for session usage

    public static void main(String[] args) {
        JFrame frame = new JFrame("NumSys Converters By Group 6");
        JPanel panel = new JPanel();

        frame.setSize(340, 260);
        panel.setBackground(Color.BLACK);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLUE);

        frame.add(panel);

        panel.setLayout(null);

        // Change color of labels
        userlabel = new JLabel("<html>Enter Decimal<br>Number</html>");
        userlabel.setForeground(Color.WHITE);
        userlabel.setBounds(10, 12, 80, 40);
        panel.add(userlabel);

        userText = new JTextField();
        userText.setBounds(95, 20, 165, 25);
        panel.add(userText);

        // Buttons for conversions
        binaryButton = new JButton("Binary");
        binaryButton.setForeground(Color.WHITE);
        binaryButton.setBackground(Color.BLACK);
        binaryButton.setBounds(120, 60, 100, 25);
        binaryButton.setActionCommand("Binary");
        binaryButton.addActionListener(new NumSysByMV());
        panel.add(binaryButton);

        hexaButton = new JButton("Hexa");
        hexaButton.setForeground(Color.WHITE);
        hexaButton.setBackground(Color.BLACK);
        hexaButton.setBounds(120, 90, 100, 25);
        hexaButton.setActionCommand("Hexa");
        hexaButton.addActionListener(new NumSysByMV());
        panel.add(hexaButton);

        octalButton = new JButton("Octal");
        octalButton.setForeground(Color.WHITE);
        octalButton.setBackground(Color.BLACK);
        octalButton.setBounds(120, 120, 100, 25);
        octalButton.setActionCommand("Octal");
        octalButton.addActionListener(new NumSysByMV());
        panel.add(octalButton);

        useranswer = new JTextField();
        useranswer.setBounds(95, 160, 165, 25);
        useranswer.setEditable(false);
        panel.add(useranswer);

        answer = new JLabel("Answer =");
        answer.setForeground(Color.WHITE);
        answer.setBounds(10, 160, 80, 25);
        panel.add(answer);

        // Display usage count
        JLabel usageLabel = new JLabel("Program Used: " + usageCount + " times");
        usageLabel.setForeground(Color.WHITE);
        usageLabel.setBounds(10, 200, 200, 25);
        panel.add(usageLabel);

        // Update the usage count in real-time
        Timer timer = new Timer(500, e -> usageLabel.setText("Program Used: " + usageCount + " times"));
        timer.start();

        frame.setLocation(535, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String number = userText.getText();
            int decimal = Integer.parseInt(number);

            switch (e.getActionCommand()) {
                case "Binary":
                    useranswer.setText(Integer.toBinaryString(decimal));
                    break;
                case "Hexa":
                    useranswer.setText(Integer.toHexString(decimal).toUpperCase());
                    break;
                case "Octal":
                    String octal = Integer.toOctalString(decimal);
                    while (octal.length() < 3) {
                        octal = "0" + octal;
                    }
                    useranswer.setText(octal);
                    break;
                default:
                    useranswer.setText("Error");
            }

            // Increment usage count
            usageCount++;

        } catch (NumberFormatException ex) {
            useranswer.setText("Invalid Input");
        }
    }
}
