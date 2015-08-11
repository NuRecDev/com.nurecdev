package com.nureech.cricketApp;

import com.nureech.cricketApp.Data.Phone;
import com.nureech.cricketApp.Data.Plan;

import java.text.DecimalFormat;

/**
 * Class: Tender
 *
 * @author Mike Deiters
 * @version 1.0
 * Written: July 23, 2015
 *
 * Description: The App's Calculator
 *
 * Purpose: Calulate the final total of the perspective sale
 */
public class Tender {

	private Settings settings;
	private boolean newCustomer;
	private Phone phone;
	private Plan plan;
	private double adjustment;
	private double fees;
	private double accessories;

	/**
	 * Constructor: Tender
	 * @param none
	 */
	public Tender() {
		settings = new Settings();
		this.newCustomer = true;
		this.phone = new Phone();
		this.plan = new Plan();
		this.adjustment = 0;
		this.fees = 0;
		this.accessories = 0;
	}

	/**
	 * Method: setNewCustomer
	 * @param newCustomer
	 * @return void
	 */
	public void setNewCustomer( boolean newCustomer ) {
		this.newCustomer = newCustomer;
	}

	/**
	 * Method: setPhone
	 * @param phone
	 * @return void
	 */
	public void setPhone( Phone phone ) {
		this.phone = phone;
	}

	/**
	 * Method: setPlan
	 * @param plan
	 * @return void
	 */
	public void setPlan( Plan plan ) {
		this.plan = plan;
	}

	public void setAdjustment( double adjustment ) {
		this.adjustment = adjustment;
	}

	/**
	 * Method: setFees
	 * @param fees
	 * @return none
	 */
	public void setFees( double fees ) {
		this.fees = fees;
	}

	/**
	 * Method: setAccessories
	 * @param accessories
	 * @return void
	 */
	public void setAccessories( double accessories ) {
		this.accessories = accessories;
	}

	/**
	 * round
	 * @param a double
	 * @return String
	 * This will round a double to two decimal places
	 */
	private String round( double num ) {

		// Creates a pattern for the DecimalFormat

		String pattern = "###0.00";

		// Creates a DecimalFormat to round the currency values with

		DecimalFormat df = new DecimalFormat(pattern);

		return df.format(num);
	}

	/**
	 * Method: Sale
	 * @return sale The final total of the sale
	 */
	public String sale() {

		double sale;

		if ( newCustomer && phone.hasPromo() ) {

			sale = ( ( phone.getPromoPrice() + fees + accessories ) * ( settings.getSaleTax() / 100 ) ) + phone.getPromoPrice() + plan.getPlanPrice() - adjustment + fees + accessories;
		}
		else {

			sale = ( ( phone.getPhonePrice() + fees + accessories ) * ( settings.getSaleTax() / 100 ) ) + phone.getPhonePrice() + plan.getPlanPrice() - adjustment + fees + accessories;
		}
		return round(sale);
	}
}
