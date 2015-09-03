package org.musicmaji;

import java.io.File;

import javazoom.jl.player.advanced.*;

public class JLayerTest {
	static SoundJLayer soundToPlay = new SoundJLayer("Test.mp3");

	public static void lecture() {
		try{
			soundToPlay.create();
			soundToPlay.play();
		}catch(Exception e){
			soundToPlay.play();
		}
		
	}

	public static void stop() {
		soundToPlay.stop();

	}

	public void pause() {
		soundToPlay.pause();

	}

}

class SoundJLayer extends PlaybackListener implements Runnable {
	private String filePath;
	private AdvancedPlayer player;
	private Thread playerThread;

	public SoundJLayer(String filePath) {
		this.filePath = filePath;
	}

	public void create(){
		try {
			String urlAsString = "file:///"
					+ new java.io.File(".").getCanonicalPath()
					+ "/Ressources/Musics/" + this.filePath;

			this.player = new AdvancedPlayer(
					new java.net.URL(urlAsString).openStream(),
					javazoom.jl.player.FactoryRegistry.systemRegistry()
							.createAudioDevice());

			this.player.setPlayBackListener(this);

			this.playerThread = new Thread(this, "AudioPlayerThread");

			this.playerThread.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void stop() {
		player.stop();
	}
	
	public void pause() {
		System.out.println("waiting");
		try {
			playerThread.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void play() {
		System.out.println("playing");
		this.playerThread.resume();
	}

	// PlaybackListener members

	public void playbackStarted(PlaybackEvent playbackEvent) {
		System.out.println("playbackStarted");
	}

	public void playbackFinished(PlaybackEvent playbackEvent) {
		System.out.println("playbackEnded");
	}

	// Runnable members

	public void run() {
		try {
			this.player.play();
		} catch (javazoom.jl.decoder.JavaLayerException ex) {
			ex.printStackTrace();
		}

	}
	
}
