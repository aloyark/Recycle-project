package com.app;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Window extends JFrame {
	public Window() {
		super("Trash Dash");
		setLookAndFeel();
		setSize(360, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		setVisible(true);
	}
	
	public void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.palf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			//If it fails
		}
	}
}