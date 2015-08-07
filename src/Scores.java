package cooperjd.simon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
*	@author Jamal D. Cooper
*	Class writes and reads the score from a file
*/
public class Scores {
	//The location of the file where the score will be stored
	private final static String SCORE_FILE = "res\\scores\\highscores.txt";
	
	//The highest score reached
	private static int highScore;
	
	//Sets the high score and writes it into the file
	public static void setHighScore(int score) throws FileNotFoundException, IOException{
		highScore = score;
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SCORE_FILE));
		oos.write(highScore);
		System.out.println("Saved High Score: " + highScore);
		oos.flush();
		oos.close();
	}
	
	//Resads the high score from the file and returns that value 
	public static int getHighScore() throws FileNotFoundException, IOException{
		File scoreFile = new File(SCORE_FILE);
		if(scoreFile.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SCORE_FILE));
			int highScore = (int) ois.read();
			System.out.println("Retrieved High Score: " + highScore);
			ois.close();
			return highScore;
		}else{
			setHighScore(1);
			return highScore;
		}
	}
}
