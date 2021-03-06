package com.app;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Window extends JFrame {
	public static int gold = 0;
	
	public static Font font = null;
	
	private static List<Integer> codes = new ArrayList<Integer>();
	
	public Window() {
		//Window
		super("Trash Dash");
		setLookAndFeel();
		setSize(360, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		//[Window]
		
		
		//font
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/com/images/PRESSSTART2P.ttf"));
		} catch (FontFormatException | IOException e1) {
		}
		
		//Components
		JLabel enterPin = new JLabel("Enter Pin: ", JLabel.RIGHT);
		JTextField pin = new JTextField();
		JLabel background = new JLabel(new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/images/Widescreen-Space.jpg")))));
		JButton backField = new JButton();
		
		backField.setEnabled(false);
		
		codes.add(4012); 
		codes.add(5716);
		codes.add(1234);
		codes.add(7412);
		codes.add(6123);
		codes.add(8125);
		codes.add(5237);
		codes.add(1823);
		codes.add(1241);
		
		JButton Submit = new JButton();
		Submit.setText("Submit");
		
		Submit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) { 
		    	for (int i = 0; i < codes.size(); i++) {
			    	try {
			    		if (Integer.parseInt(pin.getText()) == codes.get(i)) {
				    		gold += 5;
				    		System.out.println(gold);
				    		codes.remove(i);
				    	} else {
				    		//System.out.println("Invalid Code");
				    	}
			    	} catch(Exception ex) {
			    		//System.out.println("Invalid Code");
			    	}
		    	}
		    }
		 });
		//[Components]
		
		//Set Fonts
		enterPin.setFont(font.deriveFont(Font.PLAIN, 25f));
		//enterPin.setForeground(Color.WHITE);
		Submit.setFont(font.deriveFont(Font.PLAIN, 15f));
		pin.setFont(font.deriveFont(Font.PLAIN, 20f));
		//[Set Fonts]
		
		int yOffset = 150;
		int xOffset = 13;
		
		//Set Boundaries
		backField.setBounds(25 + xOffset, 55 + yOffset, 275, 110);
		enterPin.setBounds(20 + xOffset, 70 + yOffset, 300, 25);
		pin.setBounds(40 + xOffset, 100 + yOffset, 100, 50);
		Submit.setBounds(160 + xOffset, 100 + yOffset, 125, 50);
		background.setBounds(0, 0, 360, 640);
		//[Set Boundaries]
		
		//Adding components
		add(enterPin);
		add(pin);
		add(Submit);
		add(backField);
		add(background);
		//[Adding components]
		
		setVisible(true);
	}
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.palf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			//If it fails
		}
	}
}
