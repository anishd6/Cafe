package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import models.Order;

public class OrderBoundaryUnit {

	@Test
	@Category(BlackBoxTest.class)
	public void testValidItems() {
		Order order = new Order(1, 0, 0, 1, 0, 0, 1, 0, 0);

		assertEquals(true, order.getOrderQtty().length > 0);
	}

	@Test
	@Category(BlackBoxTest.class)
	public void testTooLittleItems() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Order(1, 0, 0, -1, 0, 0, 1, 0, 0);
		});

	}

	@Test
	@Category(BlackBoxTest.class)
	public void testTooManyItems() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Order(1, 0, 0, 101, 0, 0, 1, 0, 0);
		});

	}

}