package org.musicmaji;

import java.awt.FlowLayout;
 
import javax.swing.*;
	 
	public class MainFrame extends JFrame{
	 
	    public  MainFrame() {     
	        		
	        		
	        JFrame frame = new JFrame("MusicMaji");

	        JPanel panel = new JPanel();
	        panel.setLayout(new FlowLayout());
	 
	        JLabel label = new JLabel("Choose your music");
	 
	        JButton button = new JButton();
	        button.setText("Play");
	 
	        panel.add(label);
	        panel.add(button);

        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
 
    }
	 
}