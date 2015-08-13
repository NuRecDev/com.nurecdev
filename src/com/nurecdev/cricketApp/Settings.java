package com.nurecdev.cricketApp;

import java.io.File;
import java.util.ArrayList;

/**
 * Class: Settings
 *
 * @author Mike Deiters
 * @version 1.0
 * Written: July 23, 2015
 *
 * Description: Settings of for the app
 *
 * Purpose: Load and store the apps settings
 */
public class Settings {

	private File settingsFile = new File("C:\\Users\\miked49er\\git\\com.nurecdev\\src\\com\\nurecdev\\cricketApp\\Txt\\SettingsData.txt");
//	private File settingsFile = new File("/home/miked49er/git/com.nurecdev/src/com/nurecdev/cricketApp/Txt/SettingsData.txt");
	private ArrayList< String > settings;
	private double salesTax;
	private double activationFee;
	private double upgradeFee;

	/**
	 * Constructor: Settings
	 */
	public Settings() throws FileMissingException {
		this.settings = new ArrayList< String >();
		this.salesTax = 0;
		this.activationFee = 0;
		this.upgradeFee = 0;

		load();
	}

	/**
	 * Method: load
	 * @return void
	 * Method Description: grab the settings values
	 */
	private void load() throws FileMissingException {

		ReadFile rf = new ReadFile();
		rf.readFile(this.settingsFile);
		settings = rf.getFileList();

		for ( int i = 0; i < settings.size(); i++ ) {

			int k = settings.get(i).indexOf(":");
			if ( settings.get(i).substring(0, k).equals("Sales Tax") ) {

				this.salesTax = Double.parseDouble(settings.get(i).substring(k + 1));
			}
			else if ( settings.get(i).substring(0, k).equals("Activation Fee") ) {

				this.activationFee = Double.parseDouble(settings.get(i).substring(k + 1));
			}
			else if ( settings.get(i).substring(0, k).equals("Upgrade Fee") ) {

				this.upgradeFee = Double.parseDouble(settings.get(i).substring(k + 1));
			}
		}

	}

	/**
	 * Method: save
	 * @return void
	 * Method Description: writes the settings values to the settings file
	 */
	private void save() {

		while ( !this.settings.isEmpty() ) {

			this.settings.remove(0);
		}

		this.settings.add("Sales Tax:" + salesTax);
		this.settings.add("Activation Fee:" + activationFee);
		this.settings.add("Upgrade Fee:" + upgradeFee);

		WriteFile wf = new WriteFile(this.settings, this.settingsFile);

	}

	/**
	 * Method: getSaleTax
	 * @return salesTax
	 */
	public double getSaleTax() {
		return salesTax;
	}

	/**
	 * Method: setSaleTax
	 * @param saleTax
	 * @return void
	 */
	public void setSaleTax( double saleTax ) {

		this.salesTax = saleTax;
		save();
	}

	/**
	 * Method: getActivationFee
	 * @return activationFee
	 */
	public double getActivationFee() {
		return activationFee;
	}

	/**
	 * Method: setActivationFee
	 * @param activationFee
	 * @return void
	 */
	public void setActivationFee( double activationFee ) {

		this.activationFee = activationFee;
		save();
	}

	/**
	 * Method: getUpgradeFee
	 * @return upgradeFee
	 */
	public double getUpgradeFee() {
		return upgradeFee;
	}

	/**
	 * Method: setUpgradeFee
	 * @param upgradeFee
	 * @return void
	 */
	public void setUpgradeFee( double upgradeFee ) {

		this.upgradeFee = upgradeFee;
		save();
	}
}
