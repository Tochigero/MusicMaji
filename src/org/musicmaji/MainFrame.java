package org.musicmaji;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

	 
	public class MainFrame extends JFrame implements ActionListener {

		JButton playBut = new JButton();
		JButton pauseBut = new JButton();
		JButton stopBut = new JButton();
		JLayerTest mus = new JLayerTest(); 
		//File f = new File()
		
		public static JPanel setBackgroundImage(final File img) throws IOException
		{
			JPanel panel = new JPanel()
			{
				private static final long serialVersionUID = 1;
				
				private BufferedImage buf = ImageIO.read(img);
				
				@Override
				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					g.drawImage(buf, 0,0, null);
				}
			};
			
			return panel;
		}

	    public  MainFrame() {     
	        		    	
	        JFrame frame = new JFrame("MusicMaji");
	        
	        JPanel panel = new JPanel();
	        try {
				panel = setBackgroundImage(new File("Ressources"+File.separator+"Images"+File.separator+"Fond.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        panel.setLayout(null);
	        /*
	        ImageIcon fond = new ImageIcon("Ressources"+File.separator+"Images"+File.separator+"Fond.png");
	        JLabel wallpaper = new JLabel(fond);
	        wallpaper.setBounds(0, 0, 800, 600);
	        panel.add(wallpaper);*/
	        
	        ImageIcon playIc = new ImageIcon("Ressources"+File.separator+"Images"+File.separator+"Play.png");
	        JLabel playIcon = new JLabel(playIc);
	        playIcon.setBounds(350, 225, 100, 100);
	        panel.add(playIcon);

	        ImageIcon pauseIc = new ImageIcon("Ressources"+File.separator+"Images"+File.separator+"Pause.png");
	        JLabel pauseIcon = new JLabel(pauseIc);
	        pauseIcon.setBounds(280, 240, 70, 70);
	        panel.add(pauseIcon);

	        ImageIcon stopIc = new ImageIcon("Ressources"+File.separator+"Images"+File.separator+"Stop.png");
	        JLabel stopIcon = new JLabel(stopIc);
	        stopIcon.setBounds(450, 240, 70, 70);
	        panel.add(stopIcon);

	        playBut.setBounds(355, 230, 90, 90);
	        playBut.setBorderPainted(false);
	        playBut.setContentAreaFilled(false);
	        playBut.addActionListener(this);
	        panel.add(playBut);

	        pauseBut.setBounds(280, 240, 70, 70);
	        pauseBut.setBorderPainted(false);
	        pauseBut.setContentAreaFilled(false);
	        pauseBut.addActionListener(this);
	        panel.add(pauseBut);
	        
	   
	        stopBut.setText("Stop");
	        stopBut.addActionListener(this);
	        stopBut.setBounds(450, 240, 70, 70);
	        stopBut.setBorderPainted(false);
	        stopBut.setContentAreaFilled(false);
	        panel.add(stopBut);
	        

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        
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
			else if(e.getSource() == pauseBut){
				System.out.println("pause");
				mus.pause();
			}
			
		}
	 
}