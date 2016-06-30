package packages.main;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/*
 * LiSp engine
 * 
 * This class handles input from the user and send it to the main class,
 * which sends it to everything in the stage
 * 
 */

public class InputHandler implements FocusListener, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener{

	public InputHandler(){
		// do nothing
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.MOUSE_MOVE, e.getX(), e.getY()));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.MOUSE_MOVE, e.getX(), e.getY()));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// NOTE
		// this probably won't be used
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// NOTE
		// not sure about this method
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// NOTE
		// not sure about this method
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
			Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.MOUSE_BUTTON, 0, 1));
		} else if (e.getButton() == MouseEvent.BUTTON2){
			Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.MOUSE_BUTTON, 1, 1));
		} else if (e.getButton() == MouseEvent.BUTTON3){
			Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.MOUSE_BUTTON, 2, 1));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
			Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.MOUSE_BUTTON, 0, 0));
		} else if (e.getButton() == MouseEvent.BUTTON2){
			Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.MOUSE_BUTTON, 1, 0));
		} else if (e.getButton() == MouseEvent.BUTTON3){
			Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.MOUSE_BUTTON, 2, 0));
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.MOUSE_FOCUS, 1, Integer.MAX_VALUE));
	}

	@Override
	public void focusLost(FocusEvent e) {
		Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.MOUSE_FOCUS, 0, Integer.MAX_VALUE));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.KEY, e.getKeyCode(), 1));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.KEY, e.getKeyCode(), 0));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// NOTE
		// this probably won't be used
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// scroll wheel moves + or - 1
		Main.addInputChange(new UserInputChange(UserInputChange.ChangeType.KEY, e.getScrollAmount(), Integer.MAX_VALUE));		
	}
}
