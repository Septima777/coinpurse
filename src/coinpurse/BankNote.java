package coinpurse;

/**
 * A banknote with a monetary value and currency.
 * 
 * @author Noppawan Kulchol
 *
 */

public class BankNote extends AbstractValuable implements Valuable {
	/* default Serial number */
	private static long nextSerialNumber = 1000000;
	/* Serail number of the banknote */
	private long serialNumber;
	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value
	 */
	public BankNote(double value) {
		this.value = value;
	}

	/**
	 * A banknote with given value andF currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public BankNote(double value, String currency) {
		this.currency = currency;
		this.value = value;

	}

	/**
	 * Get the monetary value of this object, in its own currency.
	 * 
	 * @return the value of this object
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of value of this object.
	 * 
	 * @return the currency of this object.
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Get the serial number of this object.
	 * 
	 * @return serial number.
	 */
	public long getSerial() {
		return serialNumber;
	}

	/**
	 * check 2 banknotes that are equals in the same value and currency.
	 * now it use equals from AbstractValuable.
	 */
//	public boolean equals(Object object) {
//		if (object == null) {
//			return false;
//		}
//		if (object.getClass() != this.getClass()) {
//			return false;
//		}
//		BankNote bankNote = (BankNote) object;
//		if (this.currency.equals(bankNote.currency) && (this.value == bankNote.value)) {
//			return true;
//		}
//		return false;
//	}

	/**
	 * return the value in each currency.
	 * @return value with currency.
	 */
	@Override
	public String toString() {
		return (value + "-currency note [" + serialNumber + "]");
	}
}
