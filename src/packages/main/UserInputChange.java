package packages.main;

import java.awt.Point;

public class UserInputChange {

	// each change should be one of these types
	public enum ChangeType{
		NO_TYPE, MOUSE_BUTTON, KEY, MOUSE_WHEEL, MOUSE_MOVE, MOUSE_FOCUS
	};
	// holds which change it was
	private ChangeType currentType;
	// so this will be tricky..
	// valueOne will be key code, mouse button code, scroll wheel amount,
	// or mouse mouse X coord -- all depending on the change type
	// valueTwo will be 0 or 1 if the type is a button,
	// or the Y coord for a mouse move
	// pretty convoluted... but saves space
	private int valueOne, valueTwo;
	// NOTE -- default values for these will be MAX_INT value
	
	// default constructor for empty change
	public UserInputChange(){
		this.currentType = ChangeType.NO_TYPE;
		this.valueOne = Integer.MAX_VALUE;
		this.valueTwo = Integer.MAX_VALUE;
	}
	
	// constructor for any event
	// NOTE -- we need to assure the change was valid later
	public UserInputChange(ChangeType type, int valOne, int valTwo){
		this.currentType = type;
		this.valueOne = valOne;
		this.valueTwo = valTwo;
	}
	
	public ChangeType getType(){ return currentType; }
	
	// return the key code, only if it is a key
	public int getKeyCode(){
		// make sure the key is valid
		if (currentType == ChangeType.KEY){
			return valueOne;
		}
		System.err.println("Asked for key code, but wasn't a key change");
		// if it is invalid, return the max integer value
		return Integer.MAX_VALUE;
	}

	// return the mouse button code, only if it was a mouse button
	public int getMouseButtonCode(){
		// make sure the key is valid
		if (currentType == ChangeType.MOUSE_BUTTON){
			return valueOne;
		}
		System.err.println("Asked for mouseButton code, but wasn't a mouseButton change");
		// if it is invalid, return the max integer value
		return Integer.MAX_VALUE;
	}
	
	// return if the key or button is down, only if it was valid
	public boolean getIsDown(){
		// make sure the type
		if (currentType == ChangeType.MOUSE_BUTTON || currentType == ChangeType.KEY){
			// return a boolean
			return (valueTwo == 0x01);
		}
		System.err.println("Asked for isDown, but wasn't a button change");
		// if it is invalid, return false
		return false;
	}
	
	// return if the mouse gained or lost focus
	public boolean getHasFocus(){
		if (currentType == ChangeType.MOUSE_FOCUS){
			return (valueOne == 0x01);
		}
		System.err.println("Asked for mouse focus, but wasn't correct type");
		// if invalid, return false
		return false;
	}
	
	// if it was a mouse move
	public Point getMouseLocation(){
		if (currentType == ChangeType.MOUSE_MOVE){
			return new Point(valueOne, valueTwo);
		}
		System.err.println("Asked for location, but wasn't a mouse move");
		// if invalid, return null point
		return new Point();
	}
	
	// if it was a mouse scroll
	public int getMouseScrollAmount(){
		if (currentType == ChangeType.MOUSE_WHEEL){
			return valueOne;
		}
		System.err.println("Asked for mouse scroll, but wasn't");
		// if invalid, return max value
		return Integer.MAX_VALUE;
	}
	
}
