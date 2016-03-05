package com.prabhash.interview.seatfinder;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RandomUnitTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void TestExection() {
		
		List<String> list = new ArrayList<String>();
		
		list.get(0); // should throw exception as there is no String in List
	}
	
	@Test
	public void TestExcetionWithRule() {
		
		List<String> list = new ArrayList<String>();
		
		expectedException.expect(IndexOutOfBoundsException.class);
		list.get(0); // should throw exception as there is no String in List
	}

}
