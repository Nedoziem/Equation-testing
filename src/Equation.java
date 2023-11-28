
public class Equation {
	private int lefthandside; 
	private char operation;
	private char unknown;
	private double valueOfUnknown;
	private int righthandside; 
	// Equation format:
	// <lefthandside> _ <operation> _ <unknown> _ = _ <righthandside>
	/** no-args constructor **/
	public Equation() {
		// default values
		this.lefthandside = 0;
		this.operation = ' ';
		this.unknown = ' ';
		this.valueOfUnknown = 0.0;
		this.righthandside = 0;
	}
	
	/** constructor that takes the whole equation as a String **/
	public Equation(String eq) {
		// parse equation
		String[] parsedEquation = eq.split("\\s+");
		// set the values of each data member 
		// (except for valueOfUnknown, which is still unknown)
		this.lefthandside = Integer.parseInt(parsedEquation[0]); // convert String to int
		this.operation = parsedEquation[1].charAt(0); // convert String to char
		this.unknown = parsedEquation[2].charAt(0); // convert String to char
		this.righthandside = Integer.parseInt(parsedEquation[4]); // convert String to int
	}
	
	/** getters and setters for all of the data members **/
	public int getLefthandside() {
		return lefthandside;
	}
	public void setLefthandside(int lefthandside) {
		this.lefthandside = lefthandside;
	}
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}
	public char getUnknown() {
		return unknown;
	}
	public void setUnknown(char unknown) {
		this.unknown = unknown;
	}
	public double getValueOfUnknown() {
		return valueOfUnknown;
	}
	public void setValueOfUnknown(double valueOfUnknown) {
		this.valueOfUnknown = valueOfUnknown;
	}
	public int getRighthandside() {
		return righthandside;
	}
	public void setRighthandside(int righthandside) {
		this.righthandside = righthandside;
	}
	/** a void method, solves the equation to find the value of the unknown **/
	public void solve() {
		if (operation == '+') {
			this.valueOfUnknown = (this.righthandside - this.lefthandside);
		} else if (operation == '-' ) {
			this.valueOfUnknown = (this.lefthandside - this.righthandside);
		} else if (operation == '*') {
			this.valueOfUnknown = (this.righthandside / this.lefthandside);
		} else if (operation == '/') {
			this.valueOfUnknown = (this.lefthandside / this.righthandside);
		} 
	}
}

//tests constructors
//one test for each getter and setter with the first constructors
//left handside - positive tests, negative, and zero
