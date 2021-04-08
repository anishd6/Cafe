package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import models.Order;

@RunWith(Parameterized.class)
public class NutritionPWUnit {

	public int[] orderQtty;
	private int americano;
	private int cappuccino;
	private int espresso;
	private int hotChocolate;
	private int whiteChocolate;
	private int matchaLatte;
	private int doughnut;
	private int croissant;
	private int cheesecake;

	@Parameters
	public static Collection<Object[]> getParameters() {
		return Arrays.asList(new Object[][] {
			{1, 0, 0, 1, 0, 0, 1, 0, 0},
			{0, 1, 0, 0, 1, 0, 1, 0, 0},
			{0, 0, 1, 0, 0, 1, 1, 0, 0},
			{0, 0, 1, 0, 1, 0, 0, 1, 0},
			{0, 1, 0, 1, 0, 0, 0, 1, 0},
			{1, 0, 0, 0, 0, 1, 0, 1, 0},
			{1, 0, 0, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 0, 0, 1, 0, 0, 1},
			{0, 0, 1, 1, 0, 0, 0, 0, 1},		
		});
	}

	public NutritionPWUnit(int americano, int cappuccino, int espresso, int hotChocolate, int whiteChocolate,
			int matchaLatte, int doughnut, int croissant, int cheesecake) {
		this.americano = americano;
		this.cappuccino = cappuccino;
		this.espresso = espresso;
		this.hotChocolate = hotChocolate;
		this.whiteChocolate = whiteChocolate;
		this.matchaLatte = matchaLatte;
		this.doughnut = doughnut;
		this.croissant = croissant;
		this.cheesecake = cheesecake;
	}

	@Test
	@Category(BlackBoxTest.class)
	public void testNutritionBalance() {
		Order order = new Order(americano, cappuccino, espresso, hotChocolate, whiteChocolate, matchaLatte, doughnut,
				croissant, cheesecake);
		
		int[] nutComparison = order.compareNutrition();
		boolean overNutrition = false;
		
		for (int i : nutComparison)
			if (i == 1)
				overNutrition = true;
		
		assertEquals(false, overNutrition);
	}

}
