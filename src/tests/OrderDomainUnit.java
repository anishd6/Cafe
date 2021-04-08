package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import models.Order;

public class OrderDomainUnit {

	private Order order;

	@Test
	@Category(BlackBoxTest.class)
	public void testCase1() {
		order = new Order();
		order.setOrderTotal(0.01);
		double grossTotal = order.getOrderTotal();
		
		order = new Order(0, 0, 0, 0, 0, 0, 1, 0, 0);
		order.addCoupon("123");
		double netTotal = order.getOrderTotal();
		
		assertEquals(false, grossTotalWithinRange(grossTotal) && netTotalWithinRange(netTotal));
	}

	@Test
	@Category(BlackBoxTest.class)
	public void testCase2() {
		order = new Order(0, 0, 0, 0, 0, 1, 1, 1, 0);
		double grossTotal = order.getOrderTotal();

		order.addCoupon("123");
		double netTotal = order.getOrderTotal();
		
		assertEquals(true, grossTotalWithinRange(grossTotal) && netTotalWithinRange(netTotal));
	}
	
	@Test
	@Category(BlackBoxTest.class)
	public void testCase3() {
		order = new Order(0, 0, 0, 0, 0, 1, 0, 0, 0);
		double grossTotal = order.getOrderTotal();
		
		order = new Order(20, 0, 0, 20, 0, 20, 20, 20, 0);
		order.addCoupon("123");
		double netTotal = order.getOrderTotal();
				
		assertEquals(true, grossTotalWithinRange(grossTotal) && netTotalWithinRange(netTotal));
	}

	@Test
	@Category(BlackBoxTest.class)
	public void testCase4() {
		order = new Order(0, 0, 0, 1, 1, 2, 3, 2, 0);
		double grossTotal = order.getOrderTotal();
		
		order = new Order(100, 100, 100, 100, 100, 100, 100, 100, 100);
		order.setOrderTotal(order.getOrderTotal() + 5);
		order.addCoupon("123");
		double netTotal = order.getOrderTotal();
		
		assertEquals(false, grossTotalWithinRange(grossTotal) && netTotalWithinRange(netTotal));
	}

	private boolean grossTotalWithinRange(double grossTotal) {
		return grossTotal > 0.74 && grossTotal < 3000;
	}

	private boolean netTotalWithinRange(double netTotal) {
		return netTotal > 0.32 && netTotal < 1500;
	}

}
