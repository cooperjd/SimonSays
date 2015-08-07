package cooperjd.simon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/*
 *  1) Read if each keypress matches the order
 *  2) move add to guess order to right after e.getkeycode line
 *  3) 
 */

/**
 * 
 * @author cooperjd
 * The Simon Game
 */
public class SimonShapeTester{
	public static boolean upPressed;
	public static boolean downPressed;
	public static boolean leftPressed;
	public static boolean rightPressed;
	
	public static boolean up;
	public static boolean down;
	public static boolean left;
	public static boolean right;
	
	private static JFrame window = new JFrame("Simon Says");
	private static JLabel level;
	private static JLabel highScore;
    private static final int SHORT_DELAY = Integer.MAX_VALUE;
    
    private static SimonShape ss = new SimonShape(window);
    private static int numberCount = 1;
	private static int[] order;
	private static ArrayList<Integer> guessOrder = new ArrayList<Integer>();
    
	  public void init(){

	  }
	  
	  public static void main(String args[])
	  {
		    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		    window.setBounds(screenSize.width / 2 - 164, screenSize.height / 2 - 193, 328, 385);
		    window.setResizable(false);
		    
		    level = new JLabel("Level:  x" + numberCount, SwingConstants.CENTER);
		    try {
				highScore = new JLabel("High Score:  x" + Scores.getHighScore(), SwingConstants.CENTER);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		    window.add(level, BorderLayout.NORTH);
		    window.add(ss, BorderLayout.CENTER);
		    window.add(highScore, BorderLayout.SOUTH);
		    window.setVisible(true);
		    Highlight();
			  window.addKeyListener(new KeyPadListener() {
				  @Override
					public void keyPressed(KeyEvent e) {
					  
						//Pressed the up button
						if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
							System.out.println("Pressed Up");
							ss.highlightTop(SHORT_DELAY, false);
							guessOrder.add(0);
							if(guessOrder.size() == order.length){
								try {
									checkAnswers();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						}
						
						//Pressed the down button
						if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
							System.out.println("Pressed Down");
							ss.highlightBottom(SHORT_DELAY, false);
							guessOrder.add(2);
							if(guessOrder.size() == order.length){
								try {
									checkAnswers();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						}
						
						//Pressed the left button
						if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
							System.out.println("Pressed Left");
							ss.highlightLeft(SHORT_DELAY, false);
							guessOrder.add(1);
							if(guessOrder.size() == order.length){
								try {
									checkAnswers();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						}
						
						//Pressed the right button
						if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
							System.out.println("Pressed Right");
							ss.highlightRight(SHORT_DELAY, false);
							guessOrder.add(3);
							if(guessOrder.size() == order.length){
								try {
									checkAnswers();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						}	
				  	}	
				  
				  @Override
					public void keyReleased(KeyEvent e) {
						e.consume();
					}
					
					/**
					 * Checks if a key is pressed
					 */
					@Override
					public void keyTyped(KeyEvent e) {
						e.consume();
					}
				  });
	  }
	  
	  /**
	   * Randomly highlights one of the colors
	   */
	  public static void Highlight(){
		  boolean restart = false;
		  System.out.println(numberCount);
		  order = new int[numberCount];
		  for(int i = 0; i<numberCount; i++){
			  if(i == 0){
				  restart = true;
			  }
			  Random r = new Random();
			  int random = r.nextInt(4);
			  if(random == 0){
			    	ss.highlightTop(i, restart);
			    	order[i] = 0;
			    	//up = true;
			    }
			    else if(random == 1){
			    	ss.highlightLeft(i, restart);
			    	order[i] = 1;
			    	//left = true;
			    }
			    else if(random == 2){
			    	ss.highlightBottom(i, restart);
			    	order[i] = 2;
			    	//down = true;
			    }
			    else if(random == 3){
			    	ss.highlightRight(i, restart);
			    	order[i] = 3;
			    	//right = true;
			    }
		  }  
		  numberCount += 1;
	  }
	  
	  /**
	   * Checks the users input once the user has matched the number of 
	   * key presses with the number of highlights
	 * @throws IOException 
	 * @throws FileNotFoundException 
	   * 
	   */
	  private static void checkAnswers() throws FileNotFoundException, IOException{
		  boolean correct = true;
		  for(int i = 0; i < guessOrder.size(); i++){
			  if(guessOrder.get(i) != order[i]){
				  correct = false;
				  break;
			  }
		  }
		  
		  if(correct){
			  System.out.println("Correct");
			  updateLabels();
		  }else{
			  System.out.println("Incorrect");
			  int currentLevel = numberCount - 1;
		  	  JOptionPane.showMessageDialog(window, "Incorrect. You made it to the x" + currentLevel + " Level.\n\t\tStarting New Game.");
		  	  numberCount = 1;
			  updateLabels();
		  }
	
		  guessOrder.clear();
		  Highlight();
	  }
	  
	  private static void updateLabels() throws FileNotFoundException, IOException{
		  level.setText("Level:  x" + numberCount);
		  
		  if(numberCount > Scores.getHighScore()){
			  try {
				  Scores.setHighScore(numberCount);
				  highScore.setText("High Score: x" + Scores.getHighScore());
				  //window.repaint();
			  } catch (IOException e2) {
				  e2.printStackTrace();
			  }
		  }
		  
		  ss.update(ss.getGraphics());
		  window.update(window.getGraphics());
	  }
}
