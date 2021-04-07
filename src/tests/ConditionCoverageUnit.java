package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import application.ShellController;
import models.Order;

public class ConditionCoverageUnit {

	@Test
	public void validCoupon() {
		Order order = new Order(1, 2, 3, 4, 5, 6, 7, 8, 9);
		double grossTotal = order.getOrderTotal();

		order.addCoupon("123");
		double netTotal = order.getOrderTotal();
		assertEquals(true, netTotal < grossTotal);
	}

	@Test
	public void invalidCoupon() {
		Order order = new Order(1, 2, 3, 4, 5, 6, 7, 8, 9);
		double grossTotal = order.getOrderTotal();

		order.addCoupon("1234");
		double netTotal = order.getOrderTotal();

		assertEquals(true, netTotal == grossTotal);
	}

}