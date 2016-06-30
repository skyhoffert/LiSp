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
		this.mouseDownX = e.getX();
		this.mouseDownY = e.getY();
		if (e.getButton() == MouseEvent.BUTTON1){
			isMouseDownLeft = true;
			Main.LMBDown(mouseDownX, mouseDownY);
		} else if (e.getButton() == MouseEvent.BUTTON3){
			isMouseDownRight = true;
			Main.RMBDown(mouseDownX, mouseDownY);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.mouseUpX = e.getX();
		this.mouseUpY = e.getY();
		if (e.getButton() == MouseEvent.BUTTON1){
			isMouseDownLeft = false;
			Main.LMBUp(mouseDownX, mouseDownY);
		} else if (e.getButton() == MouseEvent.BUTTON3){
			isMouseDownRight = false;
			Main.RMBUp(mouseDownX, mouseDownY);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		 this.isFocused = true;
	}

	@Override
	public void focusLost(FocusEvent e) {
		 this.isFocused = false;
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		Main.keyDown(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		Main.keyUp(e.getKeyCode());
	}

	public void keyTyped(KeyEvent e) {
	}

	public int getMouseDownX() {
		return mouseDownX;
	}

	public int getMouseDownY() {
		return mouseDownY;
	}

	public int getMouseUpX() {
		return mouseUpX;
	}

	public int getMouseUpY() {
		return mouseUpY;
	}
	
	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}
	
	public boolean getIsFocused(){
		return isFocused;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
	}
}
