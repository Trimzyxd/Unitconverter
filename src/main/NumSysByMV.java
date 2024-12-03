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
    
    private JLabel usageCounterLabel; // Label to display the usage counter
    private static int usageCount = 0; // Counter for session usage
    
    private JPanel createMatchUnitsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(60, 63, 65));
    
        JLabel instructions = new JLabel("Match the units with their correct categories:");
        instructions.setForeground(Color.WHITE);
        instructions.setFont(new Font("Arial", Font.PLAIN, 16));
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(instructions, BorderLayout.NORTH);
    
        // Units and categories
        String[] units = {"Kilogram", "Fahrenheit", "Binary", "Meter", "Hour"};
        String[] categories = {"Weight", "Temperature", "Number System", "Length", "Time"};
    
        // Shuffle units for randomness
        java.util.List<String> shuffledUnits = new java.util.ArrayList<>(java.util.Arrays.asList(units));
        java.util.Collections.shuffle(shuffledUnits);
    
        // Game panel to hold the labels and dropdowns
        JPanel gamePanel = new JPanel(new GridLayout(units.length, 2, 10, 10));
        gamePanel.setBackground(new Color(43, 43, 43));
        panel.add(gamePanel, BorderLayout.CENTER);
    
        // Array to hold the dropdowns
        JComboBox<String>[] dropdowns = new JComboBox[units.length];
    
        // Populate the game panel
        for (int i = 0; i < units.length; i++) {
            JLabel unitLabel = new JLabel(shuffledUnits.get(i));
            unitLabel.setForeground(Color.WHITE);
            unitLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            gamePanel.add(unitLabel);
    
            dropdowns[i] = new JComboBox<>(categories);
            dropdowns[i].setFont(new Font("Arial", Font.PLAIN, 14));
            gamePanel.add(dropdowns[i]);
        }
    
        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(43, 43, 43));
        submitButton.setForeground(Color.WHITE);
    
        // Submit ActionListener
        submitButton.addActionListener(e -> {
            int score = 0;
            for (int i = 0; i < units.length; i++) {
                if (categories[java.util.Arrays.asList(units).indexOf(shuffledUnits.get(i))]
                    .equals(dropdowns[i].getSelectedItem())) {
                    score++;
                }
            }
    
            // Show the score
            JOptionPane.showMessageDialog(panel, "Your score: " + score + "/" + units.length,
                    "Game Result", JOptionPane.INFORMATION_MESSAGE);
    
            // Shuffle the units again and update the panel
            java.util.Collections.shuffle(shuffledUnits);
            gamePanel.removeAll(); // Clear the existing components
    
            // Recreate the labels and dropdowns with the shuffled units
            for (int i = 0; i < units.length; i++) {
                JLabel unitLabel = new JLabel(shuffledUnits.get(i));
                unitLabel.setForeground(Color.WHITE);
                unitLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                gamePanel.add(unitLabel);
    
                dropdowns[i] = new JComboBox<>(categories);
                dropdowns[i].setFont(new Font("Arial", Font.PLAIN, 14));
                gamePanel.add(dropdowns[i]);
            }
    
            // Refresh the panel to reflect the changes
            gamePanel.revalidate();
            gamePanel.repaint();
        });
    
        panel.add(submitButton, BorderLayout.SOUTH);
    
        return panel;
    }
    
    private JPanel createGuessLargerPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(60, 63, 65));
    
        JLabel instructions = new JLabel("Guess which unit is larger:");
        instructions.setForeground(Color.WHITE);
        instructions.setFont(new Font("Arial", Font.PLAIN, 16));
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(instructions, BorderLayout.NORTH);
    
        // Units and conversion values for comparison
        String[] units = {"Kilogram", "Pound", "Meter", "Centimeter", "Hour", "Minute"};
        double[] values = {1000.0, 453.592, 1.0, 0.01, 3600.0, 60.0}; // Base conversion values
    
        // Center panel for the question
        JPanel gamePanel = new JPanel(new GridLayout(3, 1, 10, 10));
        gamePanel.setBackground(new Color(43, 43, 43));
        panel.add(gamePanel, BorderLayout.CENTER);
    
        // Labels for displaying units
        JLabel unit1Label = new JLabel();
        unit1Label.setForeground(Color.WHITE);
        unit1Label.setFont(new Font("Arial", Font.PLAIN, 14));
        unit1Label.setHorizontalAlignment(SwingConstants.CENTER);
    
        JLabel unit2Label = new JLabel();
        unit2Label.setForeground(Color.WHITE);
        unit2Label.setFont(new Font("Arial", Font.PLAIN, 14));
        unit2Label.setHorizontalAlignment(SwingConstants.CENTER);
    
        // Button group for guessing
        ButtonGroup choices = new ButtonGroup();
        JRadioButton guessUnit1 = new JRadioButton("Unit 1");
        guessUnit1.setForeground(Color.WHITE);
        guessUnit1.setBackground(new Color(43, 43, 43));
        guessUnit1.setFont(new Font("Arial", Font.PLAIN, 14));
    
        JRadioButton guessUnit2 = new JRadioButton("Unit 2");
        guessUnit2.setForeground(Color.WHITE);
        guessUnit2.setBackground(new Color(43, 43, 43));
        guessUnit2.setFont(new Font("Arial", Font.PLAIN, 14));
    
        choices.add(guessUnit1);
        choices.add(guessUnit2);
    
        JPanel choicePanel = new JPanel();
        choicePanel.setBackground(new Color(43, 43, 43));
        choicePanel.add(guessUnit1);
        choicePanel.add(guessUnit2);
    
        gamePanel.add(unit1Label);
        gamePanel.add(unit2Label);
        gamePanel.add(choicePanel);
    
        // Function to randomize units
        Runnable randomizeUnits = () -> {
            int index1 = (int) (Math.random() * units.length);
            int index2;
            do {
                index2 = (int) (Math.random() * units.length);
            } while (index1 == index2);
    
            unit1Label.setText("Unit 1: " + units[index1]);
            unit2Label.setText("Unit 2: " + units[index2]);
    
            // Store the indices in the ActionListener for later validation
            unit1Label.putClientProperty("index1", index1);
            unit2Label.putClientProperty("index2", index2);
        };
    
        // Initialize the first question
        randomizeUnits.run();
    
        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(43, 43, 43));
        submitButton.setForeground(Color.WHITE);
    
        // Logic to check the answer and randomize for the next question
        submitButton.addActionListener(e -> {
            int index1 = (int) unit1Label.getClientProperty("index1");
            int index2 = (int) unit2Label.getClientProperty("index2");
    
            if (guessUnit1.isSelected()) {
                if (values[index1] > values[index2]) {
                    JOptionPane.showMessageDialog(panel, "Correct! " + units[index1] + " is larger.",
                            "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Incorrect. " + units[index2] + " is larger.",
                            "Result", JOptionPane.ERROR_MESSAGE);
                }
            } else if (guessUnit2.isSelected()) {
                if (values[index2] > values[index1]) {
                    JOptionPane.showMessageDialog(panel, "Correct! " + units[index2] + " is larger.",
                            "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Incorrect. " + units[index1] + " is larger.",
                            "Result", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(panel, "Please select a unit before submitting.",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
    
            // Randomize for the next question
            randomizeUnits.run();
            choices.clearSelection(); // Reset the radio buttons
        });
    
        panel.add(submitButton, BorderLayout.SOUTH);
    
        return panel;
    }
    


    public static void main(String[] args) {
        // Main frame
        JFrame frame = new JFrame("Unit Converter - Group 6");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout()); // Use BorderLayout
    
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
        tabbedPane.addTab("Match Units Game", converter.createMatchUnitsPanel());
        tabbedPane.addTab("Guess Larger Game", converter.createGuessLargerPanel());


    
        // Add tabbed pane to the frame
        frame.add(tabbedPane, BorderLayout.CENTER);
    
        // Initialize and add the usage counter label
        converter.usageCounterLabel = new JLabel("Usage Count: 0");
        converter.usageCounterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(converter.usageCounterLabel, BorderLayout.SOUTH); // Place it at the bottom
    
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

        switch (actionCommand) {
            case "NumberSystem" -> {
                // Get values from the Number System tab
                input = nsUserText.getText().trim();
                fromUnit = (String) nsFromBox.getSelectedItem();
                toUnit = (String) nsToBox.getSelectedItem();
            
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty.");
                }
            
                int intermediateDecimal = 0;
                StringBuilder conversionSteps = new StringBuilder("Step-by-Step Conversion:\n\n");
            
                // Step 1: Convert the input to decimal (base-10)
                conversionSteps.append("1. Convert ").append(fromUnit).append(" to Decimal (Base-10):\n");
            
                switch (fromUnit) {
                    case "Decimal" -> {
                        intermediateDecimal = Integer.parseInt(input);
                        conversionSteps.append("   Input is already in Decimal:\n")
                                       .append("   Result = ").append(intermediateDecimal).append(" (Base-10)\n\n");
                    }
                    case "Binary" -> {
                        intermediateDecimal = Integer.parseInt(input, 2);
                        conversionSteps.append("   Formula: Σ(bit × 2^position)\n")
                                       .append("   Calculation: ");
                        for (int i = 0; i < input.length(); i++) {
                            char bit = input.charAt(input.length() - 1 - i);
                            conversionSteps.append(bit).append(" × 2^").append(i);
                            if (i != input.length() - 1) conversionSteps.append(" + ");
                        }
                        conversionSteps.append(" = ").append(intermediateDecimal).append(" (Base-10)\n\n");
                    }
                    case "Hexadecimal" -> {
                        intermediateDecimal = Integer.parseInt(input, 16);
                        conversionSteps.append("   Formula: Σ(digit × 16^position)\n")
                                       .append("   Calculation: ");
                        for (int i = 0; i < input.length(); i++) {
                            char digit = input.charAt(input.length() - 1 - i);
                            conversionSteps.append(digit).append(" × 16^").append(i);
                            if (i != input.length() - 1) conversionSteps.append(" + ");
                        }
                        conversionSteps.append(" = ").append(intermediateDecimal).append(" (Base-10)\n\n");
                    }
                    case "Octal" -> {
                        intermediateDecimal = Integer.parseInt(input, 8);
                        conversionSteps.append("   Formula: Σ(digit × 8^position)\n")
                                       .append("   Calculation: ");
                        for (int i = 0; i < input.length(); i++) {
                            char digit = input.charAt(input.length() - 1 - i);
                            conversionSteps.append(digit).append(" × 8^").append(i);
                            if (i != input.length() - 1) conversionSteps.append(" + ");
                        }
                        conversionSteps.append(" = ").append(intermediateDecimal).append(" (Base-10)\n\n");
                    }
                    default -> throw new IllegalArgumentException("Invalid Number System.");
                }
            
                // Step 2: Convert the intermediate decimal to the target system
                String finalResult = "";
                conversionSteps.append("2. Convert Decimal (Base-10) to ").append(toUnit).append(":\n");
            
            switch (toUnit) {
                case "Decimal" -> {
                    finalResult = String.valueOf(intermediateDecimal);
                    conversionSteps.append("   No conversion needed. Result = ").append(finalResult).append(" (Base-10)\n");
                }
                case "Binary" -> {
                    finalResult = Integer.toBinaryString(intermediateDecimal);
                    conversionSteps.append("   Formula: Repeated Division by 2 (Remainder forms the bits):\n")
                                    .append("   Calculation: \n");
                    int temp = intermediateDecimal;
                    StringBuilder binarySteps = new StringBuilder();
                    while (temp > 0) {
                        int remainder = temp % 2;
                        binarySteps.append(temp).append(" ÷ 2 = ").append(temp / 2).append(", Remainder = ").append(remainder).append("\n");
                        temp /= 2;
                    }
                    conversionSteps.append(binarySteps).append("   Result (read remainders bottom-up) = ").append(finalResult).append(" (Base-2)\n");
                }
                case "Hexadecimal" -> {
                    finalResult = Integer.toHexString(intermediateDecimal).toUpperCase();
                    conversionSteps.append("   Formula: Repeated Division by 16 (Remainder forms the digits):\n")
                                    .append("   Calculation: \n");
                    int temp = intermediateDecimal;
                    StringBuilder hexSteps = new StringBuilder();
                    while (temp > 0) {
                        int remainder = temp % 16;
                        hexSteps.append(temp).append(" ÷ 16 = ").append(temp / 16).append(", Remainder = ").append(remainder).append("\n");
                        temp /= 16;
                    }
                    conversionSteps.append(hexSteps).append("   Result (read remainders bottom-up) = ").append(finalResult).append(" (Base-16)\n");
                }
                case "Octal" -> {
                    finalResult = Integer.toOctalString(intermediateDecimal);
                    conversionSteps.append("   Formula: Repeated Division by 8 (Remainder forms the digits):\n")
                                    .append("   Calculation: \n");
                    int temp = intermediateDecimal;
                    StringBuilder octalSteps = new StringBuilder();
                    while (temp > 0) {
                        int remainder = temp % 8;
                        octalSteps.append(temp).append(" ÷ 8 = ").append(temp / 8).append(", Remainder = ").append(remainder).append("\n");
                        temp /= 8;
                    }
                    conversionSteps.append(octalSteps).append("   Result (read remainders bottom-up) = ").append(finalResult).append(" (Base-8)\n");
                }
                default -> throw new IllegalArgumentException("Invalid Number System.");
            }
        
            // Display the result
            nsUserAnswer.setText(finalResult);
        
            // Show the detailed explanation in a pop-up
            JOptionPane.showMessageDialog(null, conversionSteps.toString(), 
                                            "Detailed Conversion Steps", JOptionPane.INFORMATION_MESSAGE);
        }
            

            case "Weight" -> {
                input = weightUserText.getText().trim();
                fromUnit = (String) weightFromBox.getSelectedItem();
                toUnit = (String) weightToBox.getSelectedItem();
            
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty.");
                }
            
                double weight = Double.parseDouble(input);
                double intermediateKilograms = 0;
                StringBuilder conversionSteps = new StringBuilder("Step-by-Step Conversion:\n\n");
            
            // Convert to kilograms (intermediate step)
            switch (fromUnit) {
                case "Kilogram" -> {
                    intermediateKilograms = weight;
                    conversionSteps.append("1. Input is already in Kilograms (kg):\n")
                                    .append("   Intermediate Value = ").append(intermediateKilograms).append(" kg\n\n");
                }
                case "Pound" -> {
                    intermediateKilograms = weight / 2.20462;
                    conversionSteps.append("1. Convert Pounds (lb) to Kilograms (kg):\n")
                                    .append("   Pounds ").append(weight).append(" ÷ 2.20462 = ")
                                    .append(intermediateKilograms).append(" kg\n\n");
                }
                case "Gram" -> {
                    intermediateKilograms = weight / 1000.0;
                    conversionSteps.append("1. Convert Grams (g) to Kilograms (kg):\n")
                                    .append("   Grams ").append(weight).append(" ÷ 1000 = ")
                                    .append(intermediateKilograms).append(" kg\n\n");
                }
                case "Milligram" -> {
                    intermediateKilograms = weight / 1_000_000.0;
                    conversionSteps.append("1. Convert Milligrams (mg) to Kilograms (kg):\n")
                                    .append("   Milligrams ").append(weight).append(" ÷ 1,000,000 = ")
                                    .append(intermediateKilograms).append(" kg\n\n");
                }
                default -> throw new IllegalArgumentException("Invalid Weight Unit.");
            }
        
            double finalResult = 0;
            // Convert from kilograms to the target unit
            switch (toUnit) {
                case "Kilogram" -> {
                    finalResult = intermediateKilograms;
                    conversionSteps.append("2. No further conversion needed (already in Kilograms):\n")
                                    .append("   Result = ").append(finalResult).append(" kg\n");
                }
                case "Pound" -> {
                    finalResult = intermediateKilograms * 2.20462;
                    conversionSteps.append("2. Convert Kilograms (kg) to Pounds (lb):\n")
                                    .append("   Kilograms ").append(intermediateKilograms).append(" × 2.20462 = ")
                                    .append(finalResult).append(" lb\n");
                }
                case "Gram" -> {
                    finalResult = intermediateKilograms * 1000.0;
                    conversionSteps.append("2. Convert Kilograms (kg) to Grams (g):\n")
                                    .append("   Kilograms ").append(intermediateKilograms).append(" × 1000 = ")
                                    .append(finalResult).append(" g\n");
                }
                case "Milligram" -> {
                    finalResult = intermediateKilograms * 1_000_000.0;
                    conversionSteps.append("2. Convert Kilograms (kg) to Milligrams (mg):\n")
                                    .append("   Kilograms ").append(intermediateKilograms).append(" × 1,000,000 = ")
                                    .append(finalResult).append(" mg\n");
                }
                default -> throw new IllegalArgumentException("Invalid Weight Unit.");
            }
            
                // Display result
                weightUserAnswer.setText(String.format("%.2f", finalResult) + " " + toUnit);
                JOptionPane.showMessageDialog(null, conversionSteps.toString(), 
                                              "Detailed Conversion Steps", JOptionPane.INFORMATION_MESSAGE);
            }
  
            case "Temperature" -> {
                input = tempUserText.getText().trim();
                fromUnit = (String) tempFromBox.getSelectedItem();
                toUnit = (String) tempToBox.getSelectedItem();
            
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty.");
                }
            
                double temperature = Double.parseDouble(input);
                StringBuilder conversionSteps = new StringBuilder("Step-by-Step Conversion:\n\n");
            
                if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) {
                    double intermediate = temperature * 9 / 5;
                    double finalResult = intermediate + 32;
                    conversionSteps.append("1. Multiply Celsius by 9/5:\n")
                                   .append("   ").append(temperature).append(" × 9/5 = ").append(intermediate).append("\n\n")
                                   .append("2. Add 32 to convert to Fahrenheit:\n")
                                   .append("   ").append(intermediate).append(" + 32 = ").append(finalResult).append(" °F\n");
                    tempUserAnswer.setText(String.format("%.2f", finalResult) + " °F");
                } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius")) {
                    double intermediate = temperature - 32;
                    double finalResult = intermediate * 5 / 9;
                    conversionSteps.append("1. Subtract 32 from Fahrenheit:\n")
                                   .append("   ").append(temperature).append(" - 32 = ").append(intermediate).append("\n\n")
                                   .append("2. Multiply by 5/9 to convert to Celsius:\n")
                                   .append("   ").append(intermediate).append(" × 5/9 = ").append(finalResult).append(" °C\n");
                    tempUserAnswer.setText(String.format("%.2f", finalResult) + " °C");
                } else if (fromUnit.equals(toUnit)) {
                    conversionSteps.append("No conversion needed. Input and output units are the same:\n")
                                   .append("   Result = ").append(temperature).append(" ").append(fromUnit).append("\n");
                    tempUserAnswer.setText(String.format("%.2f", temperature) + " " + fromUnit);
                } else {
                    throw new IllegalArgumentException("Invalid Temperature Conversion.");
                }
            
                // Show detailed conversion steps
                JOptionPane.showMessageDialog(null, conversionSteps.toString(), 
                                              "Detailed Conversion Steps", JOptionPane.INFORMATION_MESSAGE);
            }
             
            case "Length" -> {
                input = lengthUserText.getText().trim();
                fromUnit = (String) lengthFromBox.getSelectedItem();
                toUnit = (String) lengthToBox.getSelectedItem();
            
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty.");
                }
            
                double length = Double.parseDouble(input);
                StringBuilder conversionSteps = new StringBuilder("Step-by-Step Conversion:\n\n");
            
                // Convert input to meters as an intermediate step
                double meters = switch (fromUnit) {
                    case "Meter" -> length;
                    case "Kilometer" -> length * 1000.0; // 1 km = 1000 m
                    case "Centimeter" -> length / 100.0; // 1 cm = 0.01 m
                    case "Mile" -> length * 1609.34; // 1 mile = 1609.34 m
                    case "Yard" -> length * 0.9144; // 1 yard = 0.9144 m
                    case "Foot" -> length * 0.3048; // 1 foot = 0.3048 m
                    case "Inch" -> length * 0.0254; // 1 inch = 0.0254 m
                    default -> throw new IllegalArgumentException("Invalid Length Unit.");
                };
            
                // Show how the conversion to meters is calculated
                conversionSteps.append("1. Convert ").append(fromUnit).append(" to Meters:\n");
                switch (fromUnit) {
                    case "Kilometer" -> conversionSteps.append("   Formula: ").append(length).append(" × 1000 = ").append(meters).append(" m\n");
                    case "Centimeter" -> conversionSteps.append("   Formula: ").append(length).append(" ÷ 100 = ").append(meters).append(" m\n");
                    case "Mile" -> conversionSteps.append("   Formula: ").append(length).append(" × 1609.34 = ").append(meters).append(" m\n");
                    case "Yard" -> conversionSteps.append("   Formula: ").append(length).append(" × 0.9144 = ").append(meters).append(" m\n");
                    case "Foot" -> conversionSteps.append("   Formula: ").append(length).append(" × 0.3048 = ").append(meters).append(" m\n");
                    case "Inch" -> conversionSteps.append("   Formula: ").append(length).append(" × 0.0254 = ").append(meters).append(" m\n");
                    case "Meter" -> conversionSteps.append("   No conversion needed: ").append(meters).append(" m\n");
                }
                conversionSteps.append("\n");
            
                // Convert from meters to the target unit
                double convertedLength = switch (toUnit) {
                    case "Meter" -> meters;
                    case "Kilometer" -> meters / 1000.0;
                    case "Centimeter" -> meters * 100.0;
                    case "Mile" -> meters / 1609.34;
                    case "Yard" -> meters / 0.9144;
                    case "Foot" -> meters / 0.3048;
                    case "Inch" -> meters / 0.0254;
                    default -> throw new IllegalArgumentException("Invalid Length Unit.");
                };
            
                // Show how the conversion from meters is calculated
                conversionSteps.append("2. Convert Meters to ").append(toUnit).append(":\n");
                switch (toUnit) {
                    case "Kilometer" -> conversionSteps.append("   Formula: ").append(meters).append(" ÷ 1000 = ").append(convertedLength).append(" ").append(toUnit).append("\n");
                    case "Centimeter" -> conversionSteps.append("   Formula: ").append(meters).append(" × 100 = ").append(convertedLength).append(" ").append(toUnit).append("\n");
                    case "Mile" -> conversionSteps.append("   Formula: ").append(meters).append(" ÷ 1609.34 = ").append(convertedLength).append(" ").append(toUnit).append("\n");
                    case "Yard" -> conversionSteps.append("   Formula: ").append(meters).append(" ÷ 0.9144 = ").append(convertedLength).append(" ").append(toUnit).append("\n");
                    case "Foot" -> conversionSteps.append("   Formula: ").append(meters).append(" ÷ 0.3048 = ").append(convertedLength).append(" ").append(toUnit).append("\n");
                    case "Inch" -> conversionSteps.append("   Formula: ").append(meters).append(" ÷ 0.0254 = ").append(convertedLength).append(" ").append(toUnit).append("\n");
                    case "Meter" -> conversionSteps.append("   No conversion needed: ").append(meters).append(" ").append(toUnit).append("\n");
                }
                conversionSteps.append("\n");
            
                // Display the result
                lengthUserAnswer.setText(String.format("%.4f", convertedLength) + " " + toUnit);
            
                // Show the detailed explanation in a pop-up
                JOptionPane.showMessageDialog(null, conversionSteps.toString(), 
                                              "Detailed Conversion Steps", JOptionPane.INFORMATION_MESSAGE);
            }
            
            case "Time" -> {
                input = timeUserText.getText().trim();
                fromUnit = (String) timeFromBox.getSelectedItem();
                toUnit = (String) timeToBox.getSelectedItem();
            
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty.");
                }
            
                double time = Double.parseDouble(input);
                StringBuilder conversionSteps = new StringBuilder("Step-by-Step Conversion:\n\n");
            
                // Convert input to seconds as an intermediate step
                double seconds = switch (fromUnit) {
                    case "Millisecond" -> time / 1000.0; // 1 ms = 0.001 s
                    case "Second" -> time; // already in seconds
                    case "Minute" -> time * 60.0; // 1 min = 60 s
                    case "Hour" -> time * 3600.0; // 1 hr = 3600 s
                    case "Day" -> time * 86400.0; // 1 day = 86400 s
                    case "Week" -> time * 604800.0; // 1 week = 604800 s
                    case "Month" -> time * 2592000.0; // 1 month (approx) = 2592000 s
                    case "Year" -> time * 31536000.0; // 1 year = 31536000 s
                    default -> throw new IllegalArgumentException("Invalid Time Unit.");
                };
            
                // Show how the conversion to seconds is calculated
                conversionSteps.append("1. Convert ").append(fromUnit).append(" to Seconds:\n");
                switch (fromUnit) {
                    case "Millisecond" -> conversionSteps.append("   Formula: ").append(time).append(" ÷ 1000 = ").append(seconds).append(" s\n");
                    case "Minute" -> conversionSteps.append("   Formula: ").append(time).append(" × 60 = ").append(seconds).append(" s\n");
                    case "Hour" -> conversionSteps.append("   Formula: ").append(time).append(" × 3600 = ").append(seconds).append(" s\n");
                    case "Day" -> conversionSteps.append("   Formula: ").append(time).append(" × 86400 = ").append(seconds).append(" s\n");
                    case "Week" -> conversionSteps.append("   Formula: ").append(time).append(" × 604800 = ").append(seconds).append(" s\n");
                    case "Month" -> conversionSteps.append("   Formula: ").append(time).append(" × 2592000 = ").append(seconds).append(" s\n");
                    case "Year" -> conversionSteps.append("   Formula: ").append(time).append(" × 31536000 = ").append(seconds).append(" s\n");
                    case "Second" -> conversionSteps.append("   No conversion needed: ").append(seconds).append(" s\n");
                }
                conversionSteps.append("\n");
            
                // Convert from seconds to the target unit
                double convertedTime = switch (toUnit) {
                    case "Millisecond" -> seconds * 1000.0;
                    case "Second" -> seconds;
                    case "Minute" -> seconds / 60.0;
                    case "Hour" -> seconds / 3600.0;
                    case "Day" -> seconds / 86400.0;
                    case "Week" -> seconds / 604800.0;
                    case "Month" -> seconds / 2592000.0;
                    case "Year" -> seconds / 31536000.0;
                    default -> throw new IllegalArgumentException("Invalid Time Unit.");
                };
            
                // Show how the conversion from seconds is calculated
                conversionSteps.append("2. Convert Seconds to ").append(toUnit).append(":\n");
                switch (toUnit) {
                    case "Millisecond" -> conversionSteps.append("   Formula: ").append(seconds).append(" × 1000 = ").append(convertedTime).append(" ").append(toUnit).append("\n");
                    case "Minute" -> conversionSteps.append("   Formula: ").append(seconds).append(" ÷ 60 = ").append(convertedTime).append(" ").append(toUnit).append("\n");
                    case "Hour" -> conversionSteps.append("   Formula: ").append(seconds).append(" ÷ 3600 = ").append(convertedTime).append(" ").append(toUnit).append("\n");
                    case "Day" -> conversionSteps.append("   Formula: ").append(seconds).append(" ÷ 86400 = ").append(convertedTime).append(" ").append(toUnit).append("\n");
                    case "Week" -> conversionSteps.append("   Formula: ").append(seconds).append(" ÷ 604800 = ").append(convertedTime).append(" ").append(toUnit).append("\n");
                    case "Month" -> conversionSteps.append("   Formula: ").append(seconds).append(" ÷ 2592000 = ").append(convertedTime).append(" ").append(toUnit).append("\n");
                    case "Year" -> conversionSteps.append("   Formula: ").append(seconds).append(" ÷ 31536000 = ").append(convertedTime).append(" ").append(toUnit).append("\n");
                    case "Second" -> conversionSteps.append("   No conversion needed: ").append(seconds).append(" ").append(toUnit).append("\n");
                }
                conversionSteps.append("\n");
            
                // Display the result
                timeUserAnswer.setText(String.format("%.4f", convertedTime) + " " + toUnit);
            
                // Show the detailed explanation in a pop-up
                JOptionPane.showMessageDialog(null, conversionSteps.toString(), 
                                              "Detailed Conversion Steps", JOptionPane.INFORMATION_MESSAGE);
            }             
    }

    // Increment usage count and update the label
    usageCount++;
    usageCounterLabel.setText("Usage Count: " + usageCount);
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

