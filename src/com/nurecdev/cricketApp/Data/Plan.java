package com.nurecdev.cricketApp.Data;

/**
 * Plan
 * @author Mike Deiters
 * @version 1.1
 * ITEC 2150 Spring 2015
 * Written: Jan 28, 2015
 * 
 * 
 * This will create plan instances
 * 
 * Purpose is to provide plan information
 *
 */

public class Plan {

	private String planName;
	private int planPrice;
	private String planFeatures = "";

    public Plan() {

	    this.planName = "";
	    this.planPrice = 0;
	    this.planFeatures = "";
    }

	/**
     * @param planName
     * @param planPrice
     * @param planFeatures
     */
    public Plan(String planName, int planPrice, String planFeatures) {

	    this.planName = planName;
	    this.planPrice = planPrice;
	    this.planFeatures = planFeatures;
    }

	/**
	 * @return the planName
	 */
	public String getPlanName() {

		return planName;
	}

	/**
	 * @param planName the planName to set
	 */
	public void setPlanName(String planName) {

		this.planName = planName;
	}

	/**
	 * @return the planPrice
	 */
	public int getPlanPrice() {

		return planPrice;
	}

	/**
	 * @param planPrice the planPrice to set
	 */
	public void setPlanPrice(int planPrice) {

		this.planPrice = planPrice;
	}

	/**
	 * @return the planFeatures
	 */
	public String getPlanFeatures() {

		return planFeatures;
	}

	/**
	 * @param planFeatures the planFeatures to set
	 */
	public void setPlanFeatures(String planFeatures) {

		this.planFeatures += planFeatures + "\n";
	}

	/**
	 * @return plan to the main
	 */
	public String toString(int num) {

		String result;
		result = "-------------------------------------" + "\n" + (num + 1) + ". " + planName + "\t" + "$" + planPrice + "/Month" + "\n" + "-------------------------------------" + "\n"
		        + planFeatures;
		return result;
	}

}
