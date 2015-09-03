package org.musicmaji;

import java.io.File;

import javazoom.jl.player.advanced.*;

	public class JLayerTest
	{
		static SoundJLayer soundToPlay = new SoundJLayer("Test.mp3");
	    public static void lecture()
	    {

	        soundToPlay.play();
	    }
	    
	    public static void stop()
	    {
	    	soundToPlay.stop();
	    	
	    }
	       
	    
	  
	}

	class SoundJLayer extends PlaybackListener implements Runnable
	{
	    private String filePath;
	    private AdvancedPlayer player;
	    private Thread playerThread;    

	    public SoundJLayer(String filePath)
	    {
	        this.filePath = filePath;
	    }
	    public void stop()
	    {
	    	player.stop();
	    }

	    public void play()
	    {
	        try
	        {
	            String urlAsString = "file:///"
	            		+ new java.io.File(".").getCanonicalPath() + "/Ressources/Musics/" 
	            		+ this.filePath ;

	            this.player = new AdvancedPlayer
	            (
	                new java.net.URL(urlAsString).openStream(),
	                javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice()
	            );

	            this.player.setPlayBackListener(this);

	            this.playerThread = new Thread(this, "AudioPlayerThread");

	            this.playerThread.start();
	        }
	        catch (Exception ex)
	        {
	            ex.printStackTrace();
	        }
	    }

	    // PlaybackListener members

	    public void playbackStarted(PlaybackEvent playbackEvent)
	    {
	        System.out.println("playbackStarted");
	    }

	    public void playbackFinished(PlaybackEvent playbackEvent)
	    {
	        System.out.println("playbackEnded");
	    }    

	    // Runnable members

	    public void run()
	    {
	        try
	        {
	            this.player.play();
	        }
	        catch (javazoom.jl.decoder.JavaLayerException ex)
	        {
	            ex.printStackTrace();
	        }

	    }
	}


