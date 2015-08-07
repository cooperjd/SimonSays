package cooperjd.simon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * 
 * @author cooperjd
 * This class draws the Simon shape
 *
 */
class SimonShape extends JComponent{
	private static final long serialVersionUID = 1L;
	
	public Graphics2D ga;
	ColorManager c = new ColorManager();
	public Color color1 = c.getColor(0);
	public Color color2 = c.getColor(1);
	public Color color3 = c.getColor(2);
	public Color color4 = c.getColor(3);
	
	public Color color5 = c.getHighlight(0);
	public Color color6 = c.getHighlight(1);
	public Color color7 = c.getHighlight(2);
	public Color color8 = c.getHighlight(3);
	
	private final int size = 10;
	private final long highlightDelay = 3000;
	private final long highlightDelayShort = 200;
	private final long highlightDuration = 300;
	private JFrame j;
	private SimonShape ss;
	
	
	public SimonShape(JFrame j){
		this.j = j;
		this.ss = this;
	}
	/**
	 * Paints the original Simon shape
	 * @param g2 The graphics object that will draw the Simon shape
	 */
	@Override
	public void paint(Graphics g2) {
	    ga = (Graphics2D)g2;
	    
	    //Top Right
	    ga.setPaint(color1);
		ga.fillArc(size, size, 300, 300, 45, 90);
		//c.removeColor(r1);
		
		//Top Left
		ga.setPaint(color2);
		ga.fillArc(size, size, 300, 300, 135, 90);
		//c.removeColor(r2);

		//Bottom Left
		ga.setPaint(color3);
		ga.fillArc(size, size, 300, 300, 225, 90);
		//c.removeColor(r3);
		
		//Bottom Right
		ga.setPaint(color4);
		ga.fillArc(size, size, 300, 300, 315, 90);
		//c.removeColor(r4);
	}
	
	/**
	 * Highlights the top arc in the Simon shape for .3 seconds
	 * @param j the Window that the Simon shape is in
	 */
	//highlights the corresponding arc
	public void highlightTop(int index, boolean restart){
		try { 
			if(index == 0 && restart)
				Thread.sleep(highlightDelay); 
			else if(index == Integer.MAX_VALUE){
				Thread.sleep(0);
			}else
				Thread.sleep(highlightDelayShort);
		} 
		catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
		color1 = color5;
		try {
			SoundManager.playSound(1);
		} catch (LineUnavailableException
				| UnsupportedAudioFileException | IOException e1) {
			e1.printStackTrace();
		}
		updateGraphics();
		try { 
			Thread.sleep(highlightDuration); 
		} 
		catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
		returnTop();
		System.out.println("Highlighted Top");
	}
	
	/**
	 * Highlights the left arc in the Simon shape for .3 seconds
	 * @param j the Window that the Simon shape is in
	 */
	public void highlightLeft(int index, boolean restart){
		try { 
			if(index == 0 && restart)
				Thread.sleep(highlightDelay); 
			else if(index == Integer.MAX_VALUE){
				Thread.sleep(0);
			}else
				Thread.sleep(highlightDelayShort); 
		} 
		catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
		color2 = color6;
		try {
			SoundManager.playSound(2);
		} catch (LineUnavailableException
				| UnsupportedAudioFileException | IOException e1) {
			e1.printStackTrace();
		}
		updateGraphics();
		try { 
			Thread.sleep(highlightDuration); 
		} 
		catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
		returnLeft();
		System.out.println("Highlighted Left");
	}
	
	/**
	 * Highlights the bottom arc in the Simon shape for .3 seconds
	 * @param j the Window that the Simon shape is in
	 */
	public void highlightBottom(int index, boolean restart){
		try { 
			if(index == 0 && restart)
				Thread.sleep(highlightDelay); 
			else if(index == Integer.MAX_VALUE){
				Thread.sleep(0);
			}else
				Thread.sleep(highlightDelayShort);  
		} 
		catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
		color3 = color7;
		try {
			SoundManager.playSound(3);
		} catch (LineUnavailableException
				| UnsupportedAudioFileException | IOException e1) {
			e1.printStackTrace();
		}
		updateGraphics();
		try { 
			Thread.sleep(highlightDuration); 
		} 
		catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
		returnBottom();
		System.out.println("Highlighted Bottom");
	}
	
	/**
	 * Highlights the right arc in the Simon shape for .3 seconds
	 * @param j the Window that the Simon shape is in
	 */
	public void highlightRight(int index, boolean restart){
		try { 
			if(index == 0 && restart)
				Thread.sleep(highlightDelay); 
			else if(index == Integer.MAX_VALUE){
				Thread.sleep(0);
			}else
				Thread.sleep(highlightDelayShort);  
		} 
		catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
		color4 = color8;
		try {
			SoundManager.playSound(4);
		} catch ( LineUnavailableException
				| UnsupportedAudioFileException | IOException e1) {
			e1.printStackTrace();
		}
		updateGraphics();
		try { 
			Thread.sleep(highlightDuration); 
		} 
		catch (InterruptedException e) { 
			e.printStackTrace(); 
		}
		returnRight();
		System.out.println("Highlighted Right");
	}
	
	
	//returns the corresponding arc to its original color 
	/**
	 * returns the top arc to its original color
	 * @param j the Window that the Simon shape is in
	 */
	public void returnTop(){
		color1 = c.getColor(0);
		updateGraphics();
	}
	
	/**
	 * returns the left arc to its original color
	 * @param j the Window that the Simon shape is in
	 */
	public void returnLeft(){
		color2 = c.getColor(1);
		updateGraphics();
	}
	
	/**
	 * returns the bottom arc to its original color
	 * @param j the Window that the Simon shape is in
	 */
	public void returnBottom(){
		color3 = c.getColor(2);
		updateGraphics();
	}
	
	/**
	 * returns the right arc to its original color
	 * @param j the Window that the Simon shape is in
	 */
	public void returnRight(){
		color4 = c.getColor(3);	
		updateGraphics();
	}
	
	private void updateGraphics(){
		j.getContentPane().remove(ss);
		j.getContentPane().add(ss, BorderLayout.CENTER);
		j.getContentPane().doLayout();
		j.update(j.getGraphics());
	}
}
