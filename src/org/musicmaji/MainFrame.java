package org.musicmaji;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
	 
	public class MainFrame extends JFrame implements ActionListener {

		JButton playBut = new JButton();
		File f = new File()

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

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == playBut) {
				System.out.println("Play");
			}
			
		}
	 
}