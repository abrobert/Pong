package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Player;

public class GUI {
	
	private JFrame frame;
	private JPanel panel;
	private Player user;
	private Player computer;
	
	private final int HEIGHT = 500;
	private final int WIDTH = 500;
	
	public GUI () {
	    JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        PPanel panel = new PPanel();
        
        
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.getDefaultCloseOperation());
	

		
	}
	
}
