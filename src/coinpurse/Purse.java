package coinpurse;

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  coins to remove.
 *  
 * @author Noppawan Kulchol
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Purse implements Valuable {

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	// public static void main(String[] args) {
	// Purse purse = new Purse(5);
	// System.out.println(purse.getBalance());
	// System.out.println(purse.count());
	// System.out.println(purse.isFull());
	// System.out.println(purse.insert(new Valuable(5)));
	// System.out.println(purse.insert(new Valuable(10)));
	// System.out.println(purse.insert(new Valuable(0)));
	// System.out.println(purse.insert(new Valuable(1)));
	// System.out.println(purse.insert(new Valuable(5)));
	// System.out.println(purse.count());
	// System.out.println(purse.isFull());
	// System.out.println(purse.getBalance());
	// System.out.println(purse.toString());
	//
	// System.out.println(Arrays.toString(purse.withdraw(12)));
	// System.out.println(purse.getBalance());
	//
	// System.out.println(Arrays.toString(purse.withdraw(11)));
	// System.out.println(purse.getBalance());
	//
	// }

	/** Collection of objects in the purse. */
	private List<Valuable> money = new ArrayList<Valuable>();

	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private int capacity;

	/** amount is number of coin that we require withdraw from the purse. */
	private int amount;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		/** total is all value of coins in the purse. */
		double total = 0;
		for (int i = 0; i < money.size(); i++) {
			total = total + money.get(i).getValue();
		}
		return total;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (money.size() == capacity)
			return true;
		return false;
	}

	/**
	 * Insert a coin or banknote into the purse. The coin or banknote is only
	 * inserted if the purse has space for it and the coin or banknote has
	 * positive value. No worthless coins or No worthless banknote!
	 * 
	 * @param value
	 *            is a Coin or Banknote object to insert into purse.
	 * @return true if coin or banknote inserted, false if can't insert.
	 */
	public boolean insert(Valuable value) {
		if ((isFull() == true) || (value.getValue() <= 0)) {
			return false;
		}
		for (int i = 0; i < money.size(); i++) {
			if (value.getValue() >= this.money.get(i).getValue()) {
				money.add(i, value);
				return true;
			}
		}

		money.add(value);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins or
	 * Banknotes withdrawn from purse, or return null if cannot withdraw the
	 * amount requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin or Banknote objects for money withdrawn, or null if
	 *         cannot withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		List<Valuable> templist = new ArrayList<Valuable>();

		for (int i = 0; i <= money.size() - 1; i++) {
			Valuable coin = money.get(i);
			if (coin.getValue() <= amount) {
				templist.add(coin);
				amount = amount - coin.getValue();
			}
		}

		if (amount == 0) {
			for (Valuable coin : templist) {
				this.money.remove(coin);
			}
			Valuable[] deleted = new Valuable[templist.size()];
			templist.toArray(deleted);
			return deleted;
		}

		return null;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return (money.size() + " coins with value " + this.getBalance());
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCurrency() {
		// TODO Auto-generated method stub
		return null;
	}

}
