package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

public class NumSysByMV implements ActionListener {
	
	public static JLabel userlabel;
	public static JTextField userText;
	public static JLabel passlabel;
	public static JPasswordField passText;
	public static JButton button;
    public static JTextField useranswer;
    public static JLabel answer;
    public static JLabel usersolution;
    public static JLabel solution;
    public static JTextField usersol;
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("NumSys Converters By Group 6");
		JPanel panel = new JPanel();
		
		frame.setSize(340, 260);
		panel.setBackground(Color.BLACK);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLUE);
	
		frame.add(panel);
		
		panel.setLayout(null);
		
		// change color of string
		userlabel = new JLabel("<html>Enter Decimal<br>Number</html>");
		userlabel.setForeground(Color.WHITE);
		userlabel.setBounds(10, 12, 80, 40);
		
		panel.add(userlabel);
		
		
		userText = new JTextField();
		userText.setBounds(95, 20, 165, 25);
		panel.add(userText);
		
		
		
		
	    button = new JButton("Binary");
	    button.setForeground(Color.WHITE); 
        button.setBackground(Color.BLACK);
	    button.setBounds(120, 60, 100, 25);
	    button.addActionListener(new NumSysByMV());
	    panel.add(button);
	    
	    button = new JButton("Hexa");
	    button.setForeground(Color.WHITE);
	    button.setBackground(Color.BLACK);
	    button.setBounds(120, 90, 100, 25);
	    button.addActionListener(new NumSysByMV());
	    panel.add(button);
	    
	    button = new JButton("Octal");
	    button.setForeground(Color.WHITE);
	    button.setBackground(Color.BLACK);
	    button.setBounds(120, 120, 100, 25);
	    button.addActionListener(new NumSysByMV());
	    panel.add(button);
	    
	    
	    frame.setLocation(535, 300);
		
		frame.setVisible(true);
		 
		/* *  Window Timer
		Timer timer = new Timer(10000, e -> {
            frame.dispose();
        });
        timer.start();
		**/
		
		useranswer = new JTextField();
		useranswer.setBounds(95, 160, 165, 25);
		panel.add(useranswer);
		
		answer = new JLabel("Answer =");
		answer.setForeground(Color.WHITE);
		answer.setBounds(10, 160, 165, 25);
		panel.add(answer);
		
		//Creat a solution output, kung gusto mo
		
		
		
		
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String number = userText.getText();
        int decimal = Integer.parseInt(number);
        
        
        
    
        
        if(e.getActionCommand() == "Binary") {
            
        	useranswer.setText(Integer.toBinaryString(decimal));
        	
            
        }
        
        if(e.getActionCommand() == "Hexa") {
            
        	useranswer.setText(Integer.toHexString(decimal));
            
        }
        
        if(e.getActionCommand() == "Octal") { 
            String octal = Integer.toOctalString(decimal);
            
            while (octal.length() < 3) {
                octal = "0" + octal;
            }
            useranswer.setText(octal);            
            
            

        }
	}
}
           
     
//Test pull
	          
	        
	    
	        
	        
	
		
		
		
		
		
		
		
	


