package org.musicmaji;

import javax.swing.SwingUtilities;

public class Thread1 extends Thread {

	public void run() {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MainFrame frame = new MainFrame();
				
			}
		});
		}
	
}
