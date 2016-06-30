package packages.main;

import java.awt.Point;

public class UserInputState {

	// array of the keyboard keys
	// indices are the KeyEvent.VK_* integer value
	private boolean keys[];
	// mouse buttons
	// indices go from 0-2 [mouse1, mouse2, mouse3]
	// mouse1 is left button, mouse2 is scroll wheel press, mouse3 is right mouse button
	private boolean mouseButtons[];
	private Point mouseLocation;
	private boolean isMouseFocused;
	private boolean canBeUpdated;
	
	// default constructor, just initialize everything to 0
	public UserInputState(){
		this.keys = new boolean[68836];
		this.mouseButtons = new boolean[3];
		this.mouseLocation = new Point(0, 0);
		this.isMouseFocused = true;
		this.canBeUpdated = true;
	}
	
	// update a key in the array with code and bool
	public boolean updateKey(int code, boolean isDown){
		// make sure code is valid
		if (code < 0 || code > 68835){
			System.err.println("Key code for update is out of range");
			return false;
		}
		if (canBeUpdated){
			keys[code] = isDown;
			return true;
		}
		return false;
	}
	
	// update mouse button
	public boolean updateMouseButton(int code, boolean isDown){
		// make sure code is valid
		if (code < 0 || code > 2){
			System.err.println("Mouse code for update is out of range");
			return false;
		}
		if (canBeUpdated){
			mouseButtons[code] = isDown;
			return true;
		}
		return false;
	}
	
	// update the mouse location
	public boolean updateMouseLocation(Point p){
		if (p == null){
			System.err.println("Point for mouse location is invalid");
			return false;
		}
		if (canBeUpdated){
			mouseLocation.move(p.x, p.y);
			return true;
		}
		return false;
	}
	
	// update if the mouse is focused
	public boolean updateIsFocused(boolean b){
		if (canBeUpdated){
			isMouseFocused = b;
			return true;
		}
		return false;
	}
	
	// change a given input state to the current one
	public void adjustInputState(UserInputState yourState){
		for (int i = 0; i < keys.length; i++){
			yourState.keys[i] = this.keys[i];
		}
		yourState.mouseButtons[0] = this.keys[0];
		yourState.mouseButtons[1] = this.keys[1];
		yourState.mouseButtons[2] = this.keys[2];
		yourState.mouseLocation = this.mouseLocation;
		yourState.isMouseFocused = this.isMouseFocused;
		yourState.canBeUpdated = this.canBeUpdated;
	}	
}
