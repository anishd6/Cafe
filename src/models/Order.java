package models;

public class Order {

	public int[] orderQtty;
	public double orderTotal;
	public String orderReceipt;

	public int orderCalories;
	public int orderCarbohydrates;
	public int orderProtein;
	public int orderFat;

	public int dailyCalories = 1800;
	public int dailyProtein = 150;
	public int dailyCarbohydrates = 210;
	public int dailyFat = 55;

	public Order() {
		orderQtty = new int[9];

		for (int i = 0; i < 9; i++)
			orderQtty[i] = 0;
	}

	public Order(int americano, int cappuccino, int espresso, int hotChocolate, int whiteChocolate, int matchaLatte,
			int doughnut, int croissant, int cheesecake) {

		int[] order = new int[9];

		order[0] = americano;
		order[1] = cappuccino;
		order[2] = espresso;
		order[3] = hotChocolate;
		order[4] = whiteChocolate;
		order[5] = matchaLatte;
		order[6] = doughnut;
		order[7] = croissant;
		order[8] = cheesecake;

		for (int i : order)
			if (i < 0 || i > 100)
				throw new IllegalArgumentException();

		orderQtty = order;
		calculateOrderTotal();

	}

	public void calculateOrderTotal() {

		double total = 0;

		for (int i = 0; i < orderQtty.length; i++) {

			if (orderQtty[i] > 0 && orderQtty[i] <= 100) {
				int itemCount = orderQtty[i];

				switch (i) {
				case 0:
					total += itemCount * 3.25;
					break;
				case 1:
					total += itemCount * 3.75;
					break;
				case 2:
					total += itemCount * 3.50;
					break;
				case 3:
					total += itemCount * 3.75;
					break;
				case 4:
					total += itemCount * 3.75;
					break;
				case 5:
					total += itemCount * 4.00;
					break;
				case 6:
					total += itemCount * 1.50;
					break;
				case 7:
					total += itemCount * 2.50;
					break;
				case 8:
					total += itemCount * 4.75;
					break;
				}

			}
		}

		orderTotal = Math.round(total * 100.0) / 100.0;

	}

	public void generateReceipt() {
		String receipt = "";

		for (int i = 0; i < orderQtty.length; i++) {

			if (orderQtty[i] > 0 && orderQtty[i] < 100) {
				int itemCount = orderQtty[i];
				switch (i) {
				case 0:
					receipt += itemCount + "x Americano \n";
					break;
				case 1:
					receipt += itemCount + "x Capuccino \n";
					break;
				case 2:
					receipt += itemCount + "x Espresso \n";
					break;
				case 3:
					receipt += itemCount + "x Hot Chocolate \n";
					break;
				case 4:
					receipt += itemCount + "x White Chocolate \n";
					break;
				case 5:
					receipt += itemCount + "x Matcha Latte \n";
					break;
				case 6:
					receipt += itemCount + "x Doughnut \n";
					break;
				case 7:
					receipt += itemCount + "x Croissant \n";
					break;
				case 8:
					receipt += itemCount + "x Cheesecake \n";
					break;
				}
			}

		}

		setOrderReceipt(receipt);

	}

	public int[] generateNutrition() {

		int[] orderNutrition = new int[4];

		int calories = 0;
		int fat = 0;
		int protein = 0;
		int carbohydrates = 0;

		for (int i = 0; i < orderQtty.length; i++) {

			if (orderQtty[i] != 0) {
				int[] itemNutrition = getItemNutriton(i);
				calories += itemNutrition[0];
				fat += itemNutrition[1];
				protein += itemNutrition[2];
				carbohydrates += itemNutrition[3];
			}

		}

		orderNutrition[0] = calories;
		orderNutrition[1] = fat;
		orderNutrition[2] = protein;
		orderNutrition[3] = carbohydrates;

		return orderNutrition;
	}

	public int[] getItemNutriton(int itemCode) {

		if (itemCode < 0 || itemCode > 9)
			throw new IllegalArgumentException();

		int[] itemNutrition = new int[4];

		int calories = 0;
		int fat = 0;
		int protein = 0;
		int carbohydrates = 0;

		switch (itemCode) {
		case 0:
			calories = 15;
			fat = 0;
			protein = 1;
			carbohydrates = 2;
			break;
		case 1:
			calories = 140;
			fat = 5;
			protein = 9;
			carbohydrates = 14;
			break;
		case 2:
			calories = 170;
			fat = 9;
			protein = 9;
			carbohydrates = 14;
			break;
		case 3:
			calories = 440;
			fat = 19;
			protein = 15;
			carbohydrates = 55;
			break;
		case 4:
			calories = 370;
			fat = 16;
			protein = 14;
			carbohydrates = 43;
			break;
		case 5:
			calories = 240;
			fat = 7;
			protein = 12;
			carbohydrates = 34;
			break;
		case 6:
			calories = 480;
			fat = 27;
			protein = 5;
			carbohydrates = 56;
			break;
		case 7:
			calories = 260;
			fat = 15;
			protein = 5;
			carbohydrates = 27;
			break;
		case 8:
			calories = 321;
			fat = 23;
			protein = 6;
			carbohydrates = 26;
			break;
		}

		itemNutrition[0] = calories;
		itemNutrition[1] = fat;
		itemNutrition[2] = protein;
		itemNutrition[3] = carbohydrates;

		return itemNutrition;

	}

	public void addCoupon(String code) throws IllegalArgumentException {
		if (code == "123")
			setOrderTotal(getOrderTotal() / 2);
	}

	public boolean verifyCoupon(String code) {
		return code == "123";
	}

	public int[] compareNutrition() {

		if (orderQtty.length < 0 || orderQtty.length > 9)
			throw new IllegalArgumentException();

		int[] comparison = new int[4];
		int[] orderNutrition = generateNutrition();

		comparison[0] = orderNutrition[0] < dailyCalories ? 0 : 1;
		comparison[1] = orderNutrition[1] < dailyFat ? 0 : 1;
		comparison[2] = orderNutrition[2] < dailyProtein ? 0 : 1;
		comparison[3] = orderNutrition[3] < dailyCarbohydrates ? 0 : 1;

		return comparison;
	}

	public int[] getOrderQtty() {
		return orderQtty;
	}

	public void setOrderQtty(int[] orderQtty) {
		this.orderQtty = orderQtty;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = Math.round(orderTotal * 100.0) / 100.0;
	}

	public String getOrderReceipt() {
		return orderReceipt;
	}

	public void setOrderReceipt(String orderReceipt) {
		this.orderReceipt = orderReceipt;
	}

	public int getDailyCalories() {
		return dailyCalories;
	}

}