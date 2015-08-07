package cooperjd.simon;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
*	@author Jamal D. Cooper
*	Class that checks for key presses
*/
public class KeyPadListener implements KeyListener{
	public boolean upPressed;
	public boolean downPressed;
	public boolean leftPressed;
	public boolean rightPressed;
	
	public static void main(String[] a) {

	  }

	@Override
	public void keyPressed(KeyEvent e) {
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
	int keyCode = e.getKeyCode();
		
		//Pressed the up button
		if(keyCode == KeyEvent.VK_W){
			System.out.println("Pressed Up");
			upPressed = true;
			downPressed = false;
			leftPressed = false;
			rightPressed = false;
		}
		else
			e.consume();
		
		//Pressed the down button
		if(keyCode == KeyEvent.VK_S){
			System.out.println("Pressed Down");
			upPressed = false;
			downPressed = true;
			leftPressed = false;
			rightPressed = false;
		}
		else
			e.consume();
		
		//Pressed the left button
		if(keyCode == KeyEvent.VK_A){
			System.out.println("Pressed Left");
			upPressed = false;
			downPressed = false;
			leftPressed = true;
			rightPressed = false;
		}
		else
			e.consume();
		
		//Pressed the right button
		if(keyCode == KeyEvent.VK_D){
			System.out.println("Pressed Right");
			upPressed = false;
			downPressed = false;
			leftPressed = false;
			rightPressed = true;
		}
		else
			e.consume();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
	}
}
