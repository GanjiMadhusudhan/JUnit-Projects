package com.bharath.maven.calculator.calculator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorImplTest {

	private int num1;
	private int num2;
	private int expectedResult;
	private int expectedSubResult;

	public CalculatorImplTest(int num1, int num2, int result, int expectedSubResult) {

		this.num1 = num1;
		this.num2 = num2;
		this.expectedResult = result;
		this.expectedSubResult = expectedSubResult;

	}

	@Parameters
	public static Collection<Integer[]> data() {
		return Arrays.asList(new Integer[][] { { -1, 2, 1, -3 }, { 1, 2, 3, -1}, { 6, 7, 13, -1 } });
	}
		
	@Test
	public void addShouldReturnAResult() {
		Calculator c = new CalculatorImpl();
		int result = c.add(num1, num2);
		assertEquals(expectedResult, result);
	}
	
	
	@Test public void subShouldReturnAResult() { 
		Calculator c = new
		CalculatorImpl(); 
		int result = c.sub(num1, num2);
		assertEquals(expectedSubResult, result); 
	}
	 
}
