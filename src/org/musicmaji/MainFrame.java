package org.musicmaji;

import java.awt.Color;
import java.awt.FlowLayout;
 
import javax.swing.*;
	 
	public class MainFrame extends JFrame{
	 
	    public  MainFrame() {     
	        		
	        		
	        JFrame frame = new JFrame("MusicMaji");

	        JPanel panel = new JPanel();
	        panel.setLayout(new FlowLayout());
	        panel.setBackground(Color.BLACK);
	 
	        JLabel label = new JLabel("Choose your music");
	 
	        JButton playBut = new JButton();
	        playBut.setText("Play");
	        panel.add(playBut);

	        JButton pauseBut = new JButton();
	        pauseBut.setText("Pause");
	        panel.add(pauseBut);
	        
	        JButton stopBut = new JButton();
	        stopBut.setText("Stop");
	        panel.add(stopBut);
	        
	        panel.add(label);

        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
 
    }
	 
}