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

// ***** NOTES *****
//
// TODO
// calls to update should probably incorporate the boolean they return
// though this shouldn't be a huge deal
//
// ***** NOTES *****

public class InputHandler implements FocusListener, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener{
	
	// variables
	UserInputState currentState, prevState;

	public InputHandler(){
		this.currentState = new UserInputState();
		this.prevState = new UserInputState();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		currentState.adjustInputState(prevState);
		currentState.updateMouseLocation(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		currentState.adjustInputState(prevState);
		currentState.updateMouseLocation(e.getX(), e.getY());
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
		currentState.adjustInputState(prevState);
		if (e.getButton() == MouseEvent.BUTTON1){
			currentState.updateMouseButton(0, true);
		} else if (e.getButton() == MouseEvent.BUTTON2){
			currentState.updateMouseButton(1, true);
		} else if (e.getButton() == MouseEvent.BUTTON3){
			currentState.updateMouseButton(2, true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		currentState.adjustInputState(prevState);
		if (e.getButton() == MouseEvent.BUTTON1){
			currentState.updateMouseButton(0, false);
		} else if (e.getButton() == MouseEvent.BUTTON2){
			currentState.updateMouseButton(1, false);
		} else if (e.getButton() == MouseEvent.BUTTON3){
			currentState.updateMouseButton(2, false);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		currentState.adjustInputState(prevState);
		currentState.updateIsFocused(true);
	}

	@Override
	public void focusLost(FocusEvent e) {
		currentState.adjustInputState(prevState);
		currentState.updateIsFocused(false);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		currentState.adjustInputState(prevState);
		currentState.updateKey(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		currentState.adjustInputState(prevState);
		currentState.updateKey(e.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// NOTE
		// this probably won't be used
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println("Scroll wheel something: " +e.getWheelRotation());
	}
}
