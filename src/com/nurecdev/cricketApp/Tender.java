package com.nurecdev.cricketApp;

import com.nurecdev.cricketApp.Data.Phone;
import com.nurecdev.cricketApp.Data.Plan;

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
		this.phone = null;
		this.plan = null;
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
	 * Method: isNewCustomer
	 * @return newCustomer
	 */
	public boolean isNewCustomer() {
		return newCustomer;
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
	 * Method: getPhone
	 * @return phone
	 */
	public Phone getPhone() {
		return phone;
	}

	/**
	 * Method: setPlan
	 * @param plan
	 * @return void
	 */
	public void setPlan( Plan plan ) {
		this.plan = plan;
	}

	public Plan getPlan() {
		return plan;
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
	 * @param double
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

		double sale = ( ( phone.getPhonePrice() + fees + accessories ) * ( settings.getSaleTax() / 100 ) )
				+ phone.getPhonePrice() + fees + accessories;

		if ( phone.hasCustomPromo() ) {
			if ( newCustomer ) {

				sale = ( ( phone.getCustomPromoNewCustomer() + fees + accessories ) * ( settings.getSaleTax() / 100 ) )
						+ phone.getCustomPromoNewCustomer() + plan.getPlanPrice() - adjustment + fees + accessories;
			}
			else {

				sale = ( ( phone.getCustomPromoUpgrade() + fees + accessories ) * ( settings.getSaleTax() / 100 ) )
						+ phone.getCustomPromoUpgrade() + fees + accessories;
			}
		}
		else if ( phone.hasPromo() ) {
			if ( newCustomer ) {

				sale = ( ( phone.getPromoPrice() + fees + accessories ) * ( settings.getSaleTax() / 100 ) )
						+ phone.getPromoPrice() + plan.getPlanPrice() - adjustment + fees + accessories;
			}
		}
		else if ( newCustomer ) {

			sale += plan.getPlanPrice() - adjustment;
		}
		return round(sale);
	}
}
