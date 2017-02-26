package coinpurse;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Noppawan Kulchol
 *
 */
public class Main {
	private static int CAPASITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		
		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable money1 = factory.createMoney(100);
		Valuable money2 = factory.createMoney(20);		
		Valuable money3 = factory.createMoney(0.5);
		System.out.println(money1);
		System.out.println(money2);
		System.out.println(money3);
		
		
		
//		Purse purse = new Purse(CAPASITY);
//		ConsoleDialog ui = new ConsoleDialog(purse);
//		ui.run();
	}
}
