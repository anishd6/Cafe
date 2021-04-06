package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Order;

public class OrderBoundaryUnit {

	@Test
	public void testValidItems() {
		Order order = new Order(1, 0, 0, 1, 0, 0, 1, 0, 0);
		
		assertEquals(true, validOrder(order));
	}
	
	@Test
	public void testTooLittleItems() {
		Order order = new Order(1, 0, 0, -1, 0, 0, 1, 0, 0);
		
		assertEquals(false, validOrder(order));
	}
	
	@Test
	public void testTooManyItems() {
		Order order = new Order(1, 0, 0, 101, 0, 0, 1, 0, 0);
		
		assertEquals(false, validOrder(order));
	}
	
	public boolean validOrder(Order order) {

		for (int i : order.getOrderQtty())
			if (i < 0 || i > 100)
				return false;

		return true;
	}

}
