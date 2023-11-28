/*
 * Nicole Edoziem & Sophie Hasara
 * Professor Elva 
 * CMS 270: Object Oriented Programming
 * 
 * This code is a JUnit Test for the 
 * Equation class, which was coded by a Rollins student.
 * The code tests every method in the Equation class using 
 * multiple different cases for each method test.
 * 
 */


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EquationTest {
	@Test
	public void testEquationOne() {
		Equation e = new Equation();
		assertEquals(0, e.getLefthandside());
		assertEquals(' ', e.getOperation());
		assertEquals(' ', e.getUnknown());
		assertEquals(0, e.getRighthandside());
		assertEquals(0.0, e.getValueOfUnknown());
	}
	
	@Test
	public void testEquationOneFalse() {
		Equation e = new Equation();
		assertFalse(e.getLefthandside() == 2);
		assertFalse(e.getOperation() == '*');
		assertFalse(e.getUnknown() == 'u');
		assertFalse(e.getRighthandside() == 5);
		assertFalse(e.getValueOfUnknown() == 4.8);
	}
	@Test
	public void testEquationTwo() {
		String eq = "2 - y = 8";
		Equation e = new Equation(eq);
		assertEquals(2, e.getLefthandside());
		assertEquals('-', e.getOperation());
		assertEquals('y', e.getUnknown());
		assertEquals(8, e.getRighthandside());
	}
	
	@Test
	public void testEquationNegative() {
		String eq = "-10 + x = -20";
		Equation e = new Equation(eq);
		assertEquals(-10, e.getLefthandside());
		assertEquals('+', e.getOperation());
		assertEquals('x', e.getUnknown());
		assertEquals(-20, e.getRighthandside());
	}
	
	@Test
	public void testEquationNegPosMultiplication() {
		String eq = "-100 * a = 500";
		Equation e = new Equation(eq);
		assertEquals(-100, e.getLefthandside());
		assertEquals('*', e.getOperation());
		assertEquals('a', e.getUnknown());
		assertEquals(500, e.getRighthandside());
	}
	
	@Test
	public void testEquationPosNegDivision() {
		String eq = "35 / x = -80";
		Equation e = new Equation(eq);
		assertEquals(35, e.getLefthandside());
		assertEquals('/', e.getOperation());
		assertEquals('x', e.getUnknown());
		assertEquals(-80, e.getRighthandside());
	}
	
	@Test
	public void testGetLefthandsidePositive() {
		String eq = "50 / x = 70";
		Equation e = new Equation(eq);
		assertEquals(50, e.getLefthandside());
	}
	
	@Test
	public void testGetLefthandsideNegative() {
		String eq = "-250 * x = 1000";
		Equation e = new Equation(eq);
		assertEquals(-250, e.getLefthandside());
	}
	
	@Test
	public void testSetLefthandsidePositive() {
		Equation e = new Equation();
		e.setLefthandside(60);
		assertTrue(e.getLefthandside() == 60);
	}
	
	@Test
	public void testSetLefthandsideNegative() {
		Equation e = new Equation();
		e.setLefthandside(-40000);
		assertEquals(-40000, e.getLefthandside());
	}
	
	@Test
	public void testGetOperationAddition() {
		String eq = "45 + x = 600";
		Equation e = new Equation(eq);
		assertEquals('+', e.getOperation());
	}
	
	@Test
	public void testGetOperationSubtraction() {
		String eq = "18 - h = 0";
		Equation e = new Equation(eq);
		assertEquals('-', e.getOperation());
	}
	
	@Test
	public void testGetOperationDivision() {
		String eq = "98 / l = 67";
		Equation e = new Equation(eq);
		assertEquals('/', e.getOperation());
	}
	
	@Test
	public void testGetOperationMultiplication() {
		String eq = "560 * c = 85593";
		Equation e = new Equation(eq);
		assertEquals('*', e.getOperation());
	}
	
	@Test
	public void testSetOperationAddition() {
		Equation e = new Equation();
		e.setOperation('+');
		assertEquals('+', e.getOperation());
	}
	
	@Test
	public void testSetOperationSubtraction() {
		Equation e = new Equation();
		e.setOperation('-');
		assertEquals('-', e.getOperation());
	}
	
	@Test
	public void testSetOperationMultiplication() {
		Equation e = new Equation();
		e.setOperation('*');
		assertEquals('*', e.getOperation());
	}
	
	@Test
	public void testSetOperationDivision() {
		Equation e = new Equation();
		e.setOperation('/');
		assertEquals('/', e.getOperation());
	}
	
	@Test
	public void testGetUnknownOne() {
		String eq = "9 / m = 105";
		Equation e = new Equation(eq);
		assertTrue(e.getUnknown() == 'm');
	}
	
	@Test
	public void testGetUnknownTwo() {
		String eq = "67 * p = 6067";
		Equation e = new Equation(eq);
		assertTrue(e.getUnknown() == 'p');
	}
	
	@Test
	public void testGetUnknownThree() {
		String eq = "67 * t = 6067";
		Equation e = new Equation(eq);
		assertTrue(e.getUnknown() == 't');
	}
	//observation, it allows you to set a number as unknown as long as it is in between apostrophes
	
	@Test
	public void testSetUnknownOne() {
		Equation e = new Equation();
		e.setUnknown('p');
		assertTrue(e.getUnknown() == 'p');
	}
	
	@Test
	public void testSetUnknownTwo() {
		Equation e = new Equation();
		e.setUnknown('x');
		assertTrue(e.getUnknown() == 'x');
	}
	
	@Test
	public void testSetUnknownThree() {
		Equation e = new Equation();
		e.setUnknown('q');
		assertTrue(e.getUnknown() == 'q');
	}
	@Test
	void getValueOfUnknownTestNoSolveNoArgsCon() {
		//no args constructor 
		//data members initiated and not changed
		Equation a = new Equation();
		double n = a.getValueOfUnknown();
		assertEquals(n, 0.0);
	}
	@Test
	void getValueOfUnknownTestNoSolve() {
		//Not solved but still initiated with args constructor
		Equation a = new Equation("5 + y = 7");
		double n = a.getValueOfUnknown();
		assertEquals(n,0.0);
	}
	@Test
	void getValueOfUnknownPlusPosSolveS() {
		//Positive answer and input 
		//single digits 
		//solved method runs
		Equation a = new Equation("5 + y = 7");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n, 2);
	}
	@Test
	void getValueOfUnknownMinusNegSolveD() {
		Equation a = new Equation("16 - y = 20");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n, -4);
	}
	@Test
	void getValueOfUnknownTimesZeroSolveS() {
		Equation a = new Equation("5 * y = 0");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n, 0);
	}
	@Test
	void getValueOfUnknownDividePosSolveD() {
		Equation a = new Equation("200 / y = 5");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n, 40);
	}
	@Test
	void setValueOfUnknownNotSolvedDividePosS() {
		//unsolved equation 
		//set value to single digit number after equation created
		//Equasion has division
		Equation a = new Equation("2 / y = 5");
		double n = 5;
		a.setValueOfUnknown(n);
		assertEquals(n, 5);
	}
	@Test
	void setValueOfUnknownSolvedAddNegD() {
		//solved equation 
		//set value to double digit number after equation created and solved
		//equation has addition
		Equation a = new Equation("8 + y = -1");
		double n = 27;
		a.solve();
		a.setValueOfUnknown(n);
		assertEquals(n, 27);
	}
	@Test
	void setValueOfUnknownSolvedMultiPosS() {
		//solved equation 
		//set value to double digit number after equation created but before it is solved
		//equation has multiplication
		Equation a = new Equation("2 * y = 6");
		a.setValueOfUnknown(77);
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n, 3);
		
	}
	void setValueOfUnknownSolvedSubNegD() {
		//solved equation 
		//set value to double digit number after equation created but before it is solved
		//equation has multiplication
		Equation a = new Equation("20 - y = 21");
		a.setValueOfUnknown(-8);
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n, -1);
		
	}
	void getRighthandsideTestNoArgs() {
		Equation a = new Equation();
		int n = a.getRighthandside();
		assertEquals(n,0);
	}
	@Test
	void getRighthandsideTestPositive() {
		Equation a = new Equation("93 + y = 3");
		int n = a.getRighthandside();
		assertEquals(n,3);
	}
	@Test
	void getRighthandsideTestNegative() {
		Equation a = new Equation("5 - y = -10");
		int n = a.getRighthandside();
		assertEquals(n,-10);
	}
	
	@Test
	void getRighthandsideTestZero() {
		Equation a = new Equation("6 * y = 0");
		int n = a.getRighthandside();
		assertEquals(n, 0);
	}
	@Test
	void getRighthandsideTestTriple() {
		Equation a = new Equation("1000 / y = 500");
		int n = a.getRighthandside();
		assertEquals(n,500);
	}
	@Test
	void setRighthandsideTestNoArgsS() {
		Equation a = new Equation();
		a.setRighthandside(5);
		int n = a.getRighthandside();
		assertEquals(n,5);
	}
	@Test
	void setRighthandsideTestPosD() {
		Equation a = new Equation("12 + y = 90");
		a.setRighthandside(22);
		int n = a.getRighthandside();
		assertEquals(n,22);
	}
	@Test
	void setRighthandsideTestNegS() {
		Equation a = new Equation("5 * y = -20");
		a.setRighthandside(-35);
		int n = a.getRighthandside();
		assertEquals(n,-35);
	}
	@Test
	void setRighthandsideTestZero() {
		Equation a = new Equation("97 / y = 13");
		a.setRighthandside(0);
		int n = a.getRighthandside();
		assertEquals(n,0);
	}
	
	///////////////////////////////////////////////
	
	//put in different values of operation
	//do we also need different values of left & right & unknown, or
	//should we keep those consistent? We could have two tests for each function
	//with different inside values but the same function char
	@Test
	void solveTestNoArgs() {
		Equation a = new Equation();
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n,0.0);
	}
	@Test
	void solveTestPlusPos() {
		Equation a = new Equation("12 + y = 17");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n,5);
	}
	@Test
	void solveTestPlusPosNeg() {
		Equation a = new Equation("12 + y = -30");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n,-42);
	}
	@Test
	void solveTestPlusNeg() {
		Equation a = new Equation("-6 + y = -8");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n,-2);
	}
	@Test
	void solveTestMinusPos() {
		Equation a = new Equation("18 - y = 10");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n,8);
	}
	@Test
	void solveTestMinusPosNeg() {
		Equation a = new Equation("90 - y + -12");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n,102);
	}
	@Test
	void solveTestMinusNeg() {
		Equation a = new Equation("-9 - y = -5");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n,-4);
	}
	@Test
	void solveTestTimesPosNeg() {
		Equation a = new Equation("3 * y = -12");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n,-4);
	}
	@Test
	void solveTestTimesNeg() {
		Equation a = new Equation("-5 * y = -20");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n,4);
	}
	@Test
	void solveTestDividePosNeg() {
		Equation a = new Equation("900 / y = -3");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n,-300);
	}
	@Test
	void solveTestDivideNeg() {
		Equation a = new Equation("-30 / y = -3");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n,10);
	}
	
	@Test
	void solveTestDivideZero() {
		Equation a = new Equation("-30 / y = 0");
		a.solve();
		double n = a.getValueOfUnknown();
		assertEquals(n,0);
	}
	
}
