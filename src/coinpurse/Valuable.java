package coinpurse;
/**
 * An interface for objects having a monetary value and currency.
 * @author Noppawan Kulchol
 */
public interface Valuable extends Comparable<Valuable>{
	/**
	 * Get the monetary value of this object, in its own currency.
	 * @return the value of this object
	 */
	public double getValue( );
	
	/**
	 * Get the currency of value of this object.
	 * @return the currency of this object.
	 */
	public String getCurrency();
		
	
}

