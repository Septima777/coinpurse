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

public class Purse {

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		Purse purse = new Purse(5);
		System.out.println(purse.getBalance());
		System.out.println(purse.count());
		System.out.println(purse.isFull());
		System.out.println(purse.insert(new Coin(5)));
		System.out.println(purse.insert(new Coin(10)));
		System.out.println(purse.insert(new Coin(0)));
		System.out.println(purse.insert(new Coin(1)));
		System.out.println(purse.insert(new Coin(5)));
		System.out.println(purse.count());
		System.out.println(purse.isFull());
		System.out.println(purse.getBalance());
		System.out.println(purse.toString());

		System.out.println(Arrays.toString(purse.withdraw(12)));
		System.out.println(purse.getBalance());

		System.out.println(Arrays.toString(purse.withdraw(11)));
		System.out.println(purse.getBalance());

	}

	/** Collection of objects in the purse. */
	private List<Coin> money = new ArrayList<Coin>();
	
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
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		if ((isFull() == true) || (coin.getValue() <= 0)) {
			return false;
		}
		for (int i = 0; i < money.size(); i++) {
			if (coin.compareTo(this.money.get(i)) == 1) {
				money.add(i, coin);
				return true;
			}
		}

		money.add(coin);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Coin[] withdraw(double amount) {
		List<Coin> templist = new ArrayList<Coin>();

		for (int i = 0; i <= money.size() - 1; i++) {
			Coin coin = money.get(i);
			if (coin.getValue() <= amount) {
				templist.add(coin);
				amount = amount - coin.getValue();
			}
		}

		if (amount == 0) {
			for (Coin coin : templist) {
				this.money.remove(coin);
			}
			Coin[] deleted = new Coin[templist.size()];
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

}
