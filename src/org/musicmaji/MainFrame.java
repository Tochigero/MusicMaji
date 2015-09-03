package org.musicmaji;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
	 
	public class MainFrame extends JFrame implements ActionListener {

		JButton playBut = new JButton();
		JButton stopBut = new JButton();
		JLayerTest mus = new JLayerTest(); 
		//File f = new File()
		
	    public  MainFrame() {     
	        		    	
	        JFrame frame = new JFrame("MusicMaji");

	        JPanel panel = new JPanel();
	        panel.setLayout(new FlowLayout());
	        panel.setBackground(Color.BLACK);
	        
	        JLabel label = new JLabel("Choose your music");
	 
	        playBut.setText("Play");
	        playBut.addActionListener(this);
	        panel.add(playBut);

	        JButton pauseBut = new JButton();
	        pauseBut.setText("Pause");
	        panel.add(pauseBut);
	        
	   
	        stopBut.setText("Stop");
	        stopBut.addActionListener(this);
	        panel.add(stopBut);
	        
	        panel.add(label);

        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.repaint();
        frame.revalidate();
        
    }

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == playBut) {
				System.out.println("Play");
				mus.lecture();
				
			}else if(e.getSource() == stopBut){
				System.out.println("stop");
				mus.stop();
			}
			
		}
	 
}