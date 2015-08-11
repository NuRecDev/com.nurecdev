package com.nureech.cricketApp.Data;

import java.util.ArrayList;

/** Class: Data
 * @author Mike Deiters
 * @version 1.0
 * ITEC 2150 Spring 2015
 * Written: Feb 9, 2015
 *
 *
 * This will 
 *
 * Purpose is 
 *
 */

public class PhoneData {

	public Phone gs5 = new Phone("Galaxy S5", 579.99, 479.99);
	public Phone gs4 = new Phone("Galaxy S4", 429.99);
	public Phone iPhone6 = new Phone("iPhone 6", 649.99);
	public Phone iPhone5s = new Phone("iPhone 5s", 549.99);
	public Phone motoG = new Phone("Moto G", 149.99);
	public Phone htc510 = new Phone("HTC Desire 510", 149.99);
	public Phone nokia635 = new Phone("Nokia Lumia 635", 99.99);
	public Phone nokia1320 = new Phone("Nokia Lumia 1320", 279.99);

	public Plan basic = new Plan("Basic", 40, "Unlimited Talk\nUnlimited Text\nUnlimited Data\n1 GB of High Speed Data\n");
	public Plan smart = new Plan("Smart", 50, "Unlimited Talk\nUnlimited Text\nUnlimited Data\n3 GB of High Speed Data\n");
	public Plan pro = new Plan("Pro", 60, "Unlimited Talk\nUnlimited Text\nUnlimited Data\n10 GB of High Speed Data\n");

	private ArrayList<Phone> phones;
	private ArrayList<Plan> plans;

	public PhoneData() {

		phones = new ArrayList<Phone>();
		plans = new ArrayList<Plan>();

		phones();
		plans();
	}

	private void phones() {

		phones.add(gs5);
		phones.add(gs4);
		phones.add(iPhone6);
		phones.add(iPhone5s);
		phones.add(motoG);
		phones.add(htc510);
		phones.add(nokia635);
		phones.add(nokia1320);
	}

	private void plans() {

		plans.add(basic);
		plans.add(smart);
		plans.add(pro);
	}

	public ArrayList< String > getPhonesNames() {

		ArrayList<String> phoneNames = new ArrayList<String>();

		for (int i=0; i<this.phones.size(); i++) {

			phoneNames.add(this.phones.get(i).getPhoneName());
		}

		return phoneNames;
	}

	public ArrayList< String > getPlansNames() {

		ArrayList<String> planNames = new ArrayList<String>();

		for (int i=0; i<this.plans.size(); i++) {

			planNames.add(this.plans.get(i).getPlanName());
		}

		return planNames;
	}
}
