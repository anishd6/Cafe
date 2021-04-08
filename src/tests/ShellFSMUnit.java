package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import application.ShellController;

public class ShellFSMUnit {
	
	ShellController shellController = new ShellController();

	@Test
	@Category(WhiteBoxTest.class)
	public void testNavToMenu() {
		shellController.menuBtnListener();

		assertEquals(true, shellController.getCurrentPage() == 1);
	}

	@Test
	@Category(WhiteBoxTest.class)
	public void testNavToNutrition() {
		shellController.nutritionBtnListener();

		assertEquals(true, shellController.getCurrentPage() == 2);
	}

	@Test
	@Category(WhiteBoxTest.class)
	public void testNavToCoupon() {
		shellController.couponBtnListener();

		assertEquals(true, shellController.getCurrentPage() == 3);
	}

	@Test
	@Category(WhiteBoxTest.class)
	public void testNavToOrderNow() {
		shellController.orderNowBtnListener();

		assertEquals(true, shellController.getCurrentPage() == 4);
	}

}
