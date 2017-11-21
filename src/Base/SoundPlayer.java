package Base;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {

	private URL soundURL;
    private Clip clip = null;
	
	public SoundPlayer(String path) {

		this.soundURL = getClass().getClassLoader().getResource(path);
		System.out.println(soundURL);
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.soundURL);
	        AudioFormat audioFormat = audioInputStream.getFormat();
	        DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
	        this.clip = (Clip)AudioSystem.getLine(info);
	        this.clip.open(audioInputStream);
	    } 
		catch (UnsupportedAudioFileException e) { e.printStackTrace(); }
	    catch (IOException e) { e.printStackTrace(); }
	    catch (LineUnavailableException e) { e.printStackTrace(); }
	}
	
	public void play() {
		this.clip.start();
	}

	public void init() {
		this.clip.setFramePosition(0);
	}
}
