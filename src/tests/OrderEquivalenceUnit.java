package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Order;

public class OrderEquivalenceUnit {

	@Test
	public void testWithinItemRange() {
		Order order = new Order(1, 0, 0, 0, 0, 0, 0, 0, 0);
		double orderTotalCost = order.calculateOrderTotal();
		
		assertEquals(true, orderTotalCost == 3.25);
	}
	
	@Test
	public void testBelowItemRange() {
		Order order = new Order(-1, 0, 0, 0, 0, 0, 0, 0, 0);
		double orderTotalCost = order.calculateOrderTotal();
		
		assertEquals(true, orderTotalCost == 0);
	}
	
	@Test
	public void testAboveItemRange() {
		Order order = new Order(101, 0, 0, 0, 0, 0, 0, 0, 0);
		double orderTotalCost = order.calculateOrderTotal();
		
		assertEquals(true, orderTotalCost == 0);
	}

}
