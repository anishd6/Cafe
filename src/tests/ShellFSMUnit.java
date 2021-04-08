package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import application.ShellController;

public class ShellFSMUnit {
	
	ShellController shellController = new ShellController();

	@Test
	public void testNavToMenu() {
		shellController.menuBtnListener();

		assertEquals(true, shellController.getCurrentPage() == 1);
	}

	@Test
	public void testNavToNutrition() {
		shellController.nutritionBtnListener();

		assertEquals(true, shellController.getCurrentPage() == 2);
	}

	@Test
	public void testNavToCoupon() {
		shellController.couponBtnListener();

		assertEquals(true, shellController.getCurrentPage() == 3);
	}

	@Test
	public void testNavToOrderNow() {
		shellController.orderNowBtnListener();

		assertEquals(true, shellController.getCurrentPage() == 4);
	}

}
