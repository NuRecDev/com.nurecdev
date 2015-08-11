package com.nureech.cricketApp.Data;

/**
 * Phone
 * @author Mike Deiters
 * @version 1.1
 * ITEC 2150 Spring 2015
 * Written: Jan 28, 2015
 *
 *
 * This will create phone instances
 *
 * Purpose is to provide information about the phones
 *
 */
public class Phone {

	private String phoneName;
	private double phonePrice;
	private boolean hasPromo;
	private double promoPrice;
	private boolean hasCustomPromo;
	private double customPromoNewCustomer;
	private double customPromoUpgrade;

	public Phone() {

		this.phoneName = "";
		this.phonePrice = 0;
		this.hasPromo = false;
		this.promoPrice = 0;
		this.hasCustomPromo = false;
		this.customPromoNewCustomer = 0;
		this.customPromoUpgrade = 0;
	}

	/**
	 * @param phoneName
	 * @param phonePrice
	 */
	public Phone( String phoneName, double phonePrice ) {

		this.phoneName = phoneName;
		this.phonePrice = phonePrice;
		this.hasPromo = false;
		this.promoPrice = 0;
	}

	/**
	 * @param phoneName
	 * @param phonePrice
	 * @param promoPrice
	 */
	public Phone( String phoneName, double phonePrice, double promoPrice ) {

		this.phoneName = phoneName;
		this.phonePrice = phonePrice;
		this.hasPromo = true;
		this.promoPrice = promoPrice;
	}

	/**
	 * @return the phonePrice
	 */
	public double getPhonePrice() {

		return phonePrice;
	}

	/**
	 * @param phonePrice the phonePrice to set
	 */
	public void setPhonePrice( double phonePrice ) {

		this.phonePrice = phonePrice;
	}

	/**
	 * Method: getPromoPrice
	 * @return promooPrice
	 */
	public double getPromoPrice() {
		return promoPrice;
	}

	/**
	 * Method: setPromoPrice
	 * @param promoPrice
	 */
	public void setPromoPrice( double promoPrice ) {
		this.promoPrice = promoPrice;
	}

	/**
	 * Method: getCustomPromoCustomer
	 * @return double
	 */
	public double getCustomPromoNewCustomer() {
		return customPromoNewCustomer;
	}

	/**
	 * Method: setCustomPromoNewCustomer
	 * @param customPromoNewCustomer
	 */
	public void setCustomPromoNewCustomer( double customPromoNewCustomer ) {
		this.customPromoNewCustomer = customPromoNewCustomer;
	}

	/**
	 * Method: getCustomPromoUpgrade
	 * @return customPromoUpgrade
	 */
	public double getCustomPromoUpgrade() {
		return customPromoUpgrade;
	}

	/**
	 * Method: setCustomPromoUpgrade
	 * @param customPromoUpgrade
	 */
	public void setCustomPromoUpgrade( double customPromoUpgrade ) {
		this.customPromoUpgrade = customPromoUpgrade;
	}

	/**
	 * Method: hasPromo
	 * @return hasPromo
	 */
	public boolean hasPromo() {
		return hasPromo;
	}

	/**
	 * Method: setHasPromo
	 * @param hasPromo
	 */
	public void setHasPromo( boolean hasPromo ) {
		this.hasPromo = hasPromo;
	}

	/**
	 * Method: hasCustomPromo
	 * @return hasCustomPromo
	 */
	public boolean hasCustomPromo() {
		return hasCustomPromo;
	}

	/**
	 * Method: setHasCustomPromo
	 * @param hasCustomPromo
	 */
	public void setHasCustomPromo( boolean hasCustomPromo ) {
		this.hasCustomPromo = hasCustomPromo;
	}

	/**
	 * @return the phoneName
	 */
	public String getPhoneName() {

		return phoneName;
	}

	/**
	 * @param phoneName the phoneName to set
	 */
	public void setPhoneName( String phoneName ) {

		this.phoneName = phoneName;
	}

	/**
	 * @return the phone with its price to the main
	 */
	public String phone() {

		String result;
		if ( phoneName.length() >= 14 ) { // If phoneName is greater than or equal to 14 characters use 1 tab

			result = " " + phoneName + "\t" + "$" + phonePrice;

		}
		else { // Otherwise use 2 tabs

			result = " " + phoneName + "\t\t" + "$" + phonePrice;

		}
		return result;
	}

}
