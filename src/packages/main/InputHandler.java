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
import java.util.Stack;

/*
 * LiSp engine
 * 
 * Keep track of changes in a stack, until the main class pulls from it
 * TODO
 * not sure if the main stack can pop from this stack or not
 * it should be able to
 * 
 */

public class InputHandler implements FocusListener, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener{

	private Stack<UserInputChange> inputChangeStack;
	
	public InputHandler(){
		this.inputChangeStack = new Stack<UserInputChange>();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.MOUSE_MOVE, e.getX(), e.getY()));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.MOUSE_MOVE, e.getX(), e.getY()));
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
			inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.MOUSE_BUTTON, 0, 1));
		} else if (e.getButton() == MouseEvent.BUTTON2){
			inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.MOUSE_BUTTON, 1, 1));
		} else if (e.getButton() == MouseEvent.BUTTON3){
			inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.MOUSE_BUTTON, 2, 1));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
			inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.MOUSE_BUTTON, 0, 0));
		} else if (e.getButton() == MouseEvent.BUTTON2){
			inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.MOUSE_BUTTON, 1, 0));
		} else if (e.getButton() == MouseEvent.BUTTON3){
			inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.MOUSE_BUTTON, 2, 0));
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.MOUSE_FOCUS, 1, Integer.MAX_VALUE));
	}

	@Override
	public void focusLost(FocusEvent e) {
		inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.MOUSE_FOCUS, 0, Integer.MAX_VALUE));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.KEY, e.getKeyCode(), 1));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.KEY, e.getKeyCode(), 0));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// NOTE
		// this probably won't be used
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// scroll wheel moves + or - 1
		inputChangeStack.add(new UserInputChange(UserInputChange.ChangeType.MOUSE_WHEEL, e.getWheelRotation(), Integer.MAX_VALUE));
	}
	
	public Stack<UserInputChange> getInputStack(){ return inputChangeStack; }
}
