package com.designpatterns.iterator.exercise1;

public class Waitress {

	private PancakeHouseMenu pancakeHouseMenu;
	private DinerMenu dinerMenu;

	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}

	/*
	 * ZONDER ITERATOR-PATTERN
	 * public void printMenu() {
	 * List<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();
	 * for (MenuItem menuItem: breakfastItems)
	 * {
	 * System.out.print(menuItem.getName() + ", ");
	 * System.out.print(menuItem.getPrice() + " -- ");
	 * System.out.println(menuItem.getDescription());
	 * }
	 * 
	 * MenuItem[] lunchItems = dinerMenu.getMenuItems();
	 * for (MenuItem menuItem: lunchItems)
	 * {
	 * System.out.print(menuItem.getName() + ", ");
	 * System.out.print(menuItem.getPrice() + " -- ");
	 * System.out.println(menuItem.getDescription());
	 * }
	 * }
	 */

	// MET ITERATOR-PATTERN
	public void printMenu()
	{
		// TODO
		/*
		 * Iterator pancakeIterator =
		 * Iterator dinerIterator =
		 * 
		 * System.out.println("MENU\n----\nBREAKFAST");
		 * printMenu(pancakeIterator);
		 * System.out.println("\nLUNCH");
		 * printMenu(dinerIterator);
		 */
	}

	private void printMenu(MyIterator iterator)
	{
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(
					menuItem.getDescription());
		}
	}
}