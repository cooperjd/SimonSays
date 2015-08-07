package cooperjd.simon;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class SoundManager {
	public static final String SOUND_FOLDER	= "res\\sounds" + File.separator;
	public static final String SOUND_1 = SOUND_FOLDER + "\\sound1.wav";
	public static final String SOUND_2 = SOUND_FOLDER + "\\sound2.wav";
	public static final String SOUND_3 = SOUND_FOLDER + "\\sound3.wav";
	public static final String SOUND_4 = SOUND_FOLDER + "\\sound4.aiff";
	
	
	public static void playSound(int soundNumber) throws FileNotFoundException, LineUnavailableException, UnsupportedAudioFileException, IOException{
		if(soundNumber == 1){
			play(SOUND_1);
		}else if(soundNumber == 2){
			play(SOUND_2);
		}else if(soundNumber == 3){
			play(SOUND_3);
		}else{
			play(SOUND_4);
		}
	}
	
	private static void play(String soundFileName) throws LineUnavailableException, FileNotFoundException, UnsupportedAudioFileException, IOException{	
		Clip clip = AudioSystem.getClip();
		AudioInputStream inputStream;
		inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(soundFileName)));
		clip.open(inputStream);
        clip.start();
        //clip.loop(Clip.LOOP_CONTINUOUSLY);
		System.out.println("Playing: " + soundFileName);
	}
}
