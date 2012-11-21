package edu.gatech.CS2340.GrandTheftPoke.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gatech.CS2340.GrandTheftPoke.backend.Backpack;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
/**
 *@author R. Tyler Lucas
 *@version 1.0
 */
public class BackpackTest {

	/**
	 * tests placing item in backpack with no capacity or range
	 */
	@Test
	public void testPlace() {
		Backpack bp = new Backpack(0,0);
		GlobalItemReference ref = new GlobalItemReference();
		//assertFalse(bp.place(ref.getCharizard(),1));
	}
	/**
	 * tests placing items in backpack to fill max capacity
	 */
	@Test
	public void testPlace0() {
		Backpack bp = new Backpack(30,30);
		GlobalItemReference ref = new GlobalItemReference();
		//assertTrue(bp.place(ref.getCharizard(),30));
	}
	
	/**
	 * tests placing items in backpack when backpack is full
	 */
	@Test
	public void testPlace1() {
		Backpack bp = new Backpack(30,30);
		GlobalItemReference ref = new GlobalItemReference();
		//assertFalse(bp.place(ref.getCharizard(),31));
	}
	
	/**
	 * tests placing item of zero quantity in backpack of 0 capacity
	 */
	@Test
	public void testPlace2() {
		Backpack bp = new Backpack(0,0);
		GlobalItemReference ref = new GlobalItemReference();
		//assertFalse(bp.place(ref.getCharizard(),0));
	}
	/**
	 * tests null pointer to item
	 */
	@Test
	public void testPlace3() {
		Backpack bp = new Backpack(0,0);
		assertFalse(bp.place(null,1));
	}
	/**
	 * tests negative quantities of items
	 */
	@Test
	public void testPlace4() {
		Backpack bp = new Backpack(10,10);
		GlobalItemReference ref = new GlobalItemReference();
		assertFalse(bp.place(ref.getSquirtle(),-1));
	}


}
