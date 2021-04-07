package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Order;

public class OrderEquivalenceUnit {

	@Test
	public void testOrder1() {
		Order order = new Order(1, 2, 3, 4, 5, 6, 7, 8, 9);
		order.calculateOrderTotal();

		assertEquals(true, order.getOrderTotal() == 152.25);
	}

	@Test
	public void testOrder2() {
		Order order = new Order(1, 2, 3, 4, 5, 6, 7, 8, 9);
		order.calculateOrderTotal();
		order.addCoupon("123");
		
		assertEquals(true, order.getOrderTotal() == 76.13);
	}

	@Test
	public void testOrder3() {
		Order order = new Order(1, 2, 3, 4, 5, 6, 7, 8, 9);
		order.calculateOrderTotal();
		order.addCoupon("1234");

		assertEquals(true, order.getOrderTotal() == 152.25);
	}

}
