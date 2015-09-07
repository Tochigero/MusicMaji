package org.musicmaji;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

	 
	public class MainFrame extends JFrame implements ActionListener {

		JButton playBut = new JButton();
		JButton pauseBut = new JButton();
		JButton stopBut = new JButton();
		JButton rembBut = new JButton();
		JButton deboBut = new JButton();
		JButton BiblioBut = new JButton();
		
        static JLabel BandeauCurrentMusic = new JLabel("");
		
		public static boolean biblioOpen = false;		
		public static boolean alreadyBeenOpen = false;
		
		public static String imagesPath = "Ressources"+File.separator+"Images"+File.separator;
		public static String musicsPath = "Ressources"+File.separator+"Musics"+File.separator;
		public static String policesPath = "Ressources"+File.separator+"Polices"+File.separator;
		public static String musiqueCourante = "";

        static JPanel panel = new JPanel();
		
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
	        
	        try {
				panel = setBackgroundImage(new File(imagesPath+"Fond.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(imagesPath+"Icone.png"));

	        panel.setLayout(null);
	        
	        ImageIcon playIc = new ImageIcon(imagesPath+"Play.png");
	        JLabel playIcon = new JLabel(playIc);
	        playIcon.setBounds(350, 225, 100, 100);
	        panel.add(playIcon);

	        playBut.setBounds(355, 230, 90, 90);
	        playBut.setBorderPainted(false);
	        playBut.setContentAreaFilled(false);
	        playBut.addActionListener(this);
	        panel.add(playBut);

	        ImageIcon pauseIc = new ImageIcon(imagesPath+"Pause.png");
	        JLabel pauseIcon = new JLabel(pauseIc);
	        pauseIcon.setBounds(280, 240, 70, 70);
	        panel.add(pauseIcon);
	        
	        pauseBut.setBounds(280, 240, 70, 70);
	        pauseBut.setBorderPainted(false);
	        pauseBut.setContentAreaFilled(false);
	        pauseBut.addActionListener(this);
	        panel.add(pauseBut);
	        
	        ImageIcon stopIc = new ImageIcon(imagesPath+"Stop.png");
	        JLabel stopIcon = new JLabel(stopIc);
	        stopIcon.setBounds(450, 240, 70, 70);
	        panel.add(stopIcon);
	 	   
	        stopBut.setBounds(450, 240, 70, 70);
	        stopBut.setBorderPainted(false);
	        stopBut.setContentAreaFilled(false);
	        stopBut.addActionListener(this);
	        panel.add(stopBut);
	        
/*	        ImageIcon rembIc = new ImageIcon(imagesPath+"Rembobiner.png");
	        JLabel rembIcon = new JLabel(rembIc);
	        rembIcon.setBounds(220, 245, 60, 60);
	        panel.add(rembIcon);

	        rembBut.setBounds(220, 245, 60, 60);
	        rembBut.setBorderPainted(false);
	        rembBut.setContentAreaFilled(false);
	        rembBut.addActionListener(this);
	        panel.add(rembBut);

	        ImageIcon deboIc = new ImageIcon(imagesPath+"Debobiner.png");
	        JLabel deboIcon = new JLabel(deboIc);
	        deboIcon.setBounds(520, 245, 60, 60);
	        panel.add(deboIcon);
*/
	        deboBut.setBounds(520, 245, 60, 60);
	        deboBut.setBorderPainted(false);
	        deboBut.setContentAreaFilled(false);
	        deboBut.addActionListener(this);
	        panel.add(deboBut);

	        ImageIcon BiblioIc = new ImageIcon(imagesPath+"Biblio.png");
	        JLabel BiblioIcon = new JLabel(BiblioIc);
	        BiblioIcon.setBounds(15, 10, 70, 70);
	        panel.add(BiblioIcon);

	        BiblioBut.setBounds(10, 5, 80, 80);
	        BiblioBut.setContentAreaFilled(false);
	        BiblioBut.setBorderPainted(false);
	        BiblioBut.addActionListener(this);
	        panel.add(BiblioBut);
	          
	        ImageIcon BandeauIc = new ImageIcon(imagesPath+"Bandeau.png");
	        JLabel BandeauIcon = new JLabel(BandeauIc);
	        BandeauIcon.setBounds(100, 450, 600, 100);
	        panel.add(BandeauIcon);
	        
	        Font font = new Font("", Font.PLAIN, 20);
	        
	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        try {
				font = Font.createFont(Font.TRUETYPE_FONT,new File(policesPath+"ATOMICCLOCKRADIO.ttf"));
		        ge.registerFont(font);
		        font = font.deriveFont(Font.TRUETYPE_FONT, 30);
		        
	        } catch (FontFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        //get musiqueCourante
	        BandeauCurrentMusic.setFont(font);
	        BandeauCurrentMusic.setForeground(new Color(0, 255, 0));
	        BandeauCurrentMusic.setBounds(125, 450, 571, 100);
	        panel.add(BandeauCurrentMusic);    	

	        frame.add(panel);
	        frame.setSize(800, 600);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        frame.setResizable(false);
        
    }

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("bob");
			try{
				if (musiqueCourante.length()>0) {
					FileInputStream input = new FileInputStream(musicsPath+musiqueCourante); 
					JLayerTest player = new JLayerTest(input); 
					if (e.getSource() == playBut) {
						System.out.println("Play");
						if(JLayerTest.playerStatus == 0)
							player.play();
						else if (JLayerTest.playerStatus == 3 )
							JLayerTest.playerStatus=0;
							player.play();
					} else if(e.getSource() == stopBut){
						System.out.println("stop");
						player.stop();
					} else if(e.getSource() == pauseBut){
						System.out.println("pause");
						player.pause();
					} /* else if(e.getSource() == rembBut) {
						System.out.println("Rembobiner");
						//action rembob
					} else if(e.getSource() == deboBut) {
						System.out.println("Debobiner");
						//action debob
					} */
					
				} 
				if(e.getSource() == BiblioBut) {
						System.out.println("Bibliotheque");
						if(!biblioOpen) {
							new Bibliotheque();
							biblioOpen = true;
							alreadyBeenOpen = true;
						} else
							System.out.println("boolean");
				}
				
			} catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
	    
	 
}