package com.nurecdev.cricketApp;

import com.nurecdev.cricketApp.Data.Phone;
import com.nurecdev.cricketApp.Data.PhoneData;
import com.nurecdev.cricketApp.Data.Plan;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Created by miked49er on 7/24/15.
 */
public class CricketAppUI extends Application {

	private final int WIDTH = 400;
	private final int HEIGHT = 600;
//	private File phoneData;
//	private File planData;
//	private File settingsData;

	private PhoneData data;
	private Tender tender;
	private Settings settings;
	private Label errorLbl;

	// Main Activity
	private Button optionsBtn;
	private ComboBox< String > activationType;
	private ObservableList< String > activationList;
	private ComboBox< String > phoneCombo;
	private ObservableList< String > phoneList;
	private ComboBox< String > planCombo;
	private ObservableList< String > planList;
	private ComboBox< String > lineCombo;
	private ObservableList< String > lineList;
	private ComboBox< String > feesCombo;
	private ObservableList< String > feesList;
	private TextField feesField;
	private Label accessoriesLbl;
	private TextField accessoriesInput;
	private Label totalLbl;
	private Label totalField;
	private Button totalBtn;
	private Button resetBtn;
	private double fee;

	// Settings Activity
	private GridPane setAct;
	private Label actFeePrompt;
	private Label upgrFeePrompt;
	private BorderPane salesTaxPane;
	private Label salesTaxSetPrompt;
	private Label salesTaxPercent;
	private TextField actFeeInput;
	private TextField upgrFeeInput;
	private TextField salesTaxSetInput;
	private Label customPromoLbl;
	private CheckBox customPromoBox;
	private ComboBox< String > phoneNames;
	private Label phoneNormalPrices;
	private Label promoNewCustomerLbl;
	private Label promoUpgradeLbl;
	private TextField promoNewCustomerPrices;
	private TextField promoUpgradePrices;
	private Button promoEnd;
	private Button saveBtn;

	private GridPane inputs;
	private BorderPane actionBarPane;
	private BorderPane pane;
	private Scene scene;
	private Stage mainStage;

//	private void findFiles() {
//
//		this.phoneData = new File("/home/miked49er/git/com.nureech/src/com/nureech/cricketApp/Txt/PhoneData.txt");
//		this.planData = new File("/home/miked49er/git/com.nureech/src/com/nureech/cricketApp/Txt/PlanData.txt");
//		this.settingsData = new File("/home/miked49er/git/com.nureech/src/com/nureech/cricketApp/Txt/SettingsData.txt");
//	}

	private void homeSetup() {

		errorLbl.setText("");
		optionsBtn.setText("Settings");
		feesField.setStyle("-fx-background-color: white");
		accessoriesInput.setStyle("-fx-background-color: white");
		pane.setCenter(inputs);
		inputs.add(errorLbl, 1, 7);
		inputs.setVisible(true);
		lineCombo.setVisible(false);
		setAct.setVisible(false);
	}

	private void settingsSetup() {

		errorLbl.setText("");
		optionsBtn.setText("Back");
		salesTaxSetInput.setText("" + settings.getSaleTax());
		salesTaxSetInput.setStyle("-fx-background-color: white");
		actFeeInput.setText("" + settings.getActivationFee());
		actFeeInput.setStyle("-fx-background-color: white");
		upgrFeeInput.setText("" + settings.getUpgradeFee());
		upgrFeeInput.setStyle("-fx-background-color: white");
		promoNewCustomerPrices.setStyle("-fx-background-color: white");
		promoUpgradePrices.setStyle("-fx-background-color: white");
		pane.setCenter(setAct);
		setAct.add(errorLbl, 1, 4);
		inputs.setVisible(false);
		setAct.setVisible(true);
	}

	private void buttonActions() {

		optionsBtn.setOnAction(new EventHandler< ActionEvent >() {
			@Override
			public void handle( ActionEvent event ) {

				if ( inputs.isVisible() ) {

					settingsSetup();
				}
				else if ( setAct.isVisible() ) {

					homeSetup();
				}
			}
		});

		totalBtn.setOnAction(new EventHandler< ActionEvent >() {
			@Override
			public void handle( ActionEvent event ) {

				feesField.setStyle("-fx-background-color: white");
				accessoriesInput.setStyle("-fx-background-color: white");

				try {

					if ( Double.parseDouble(feesField.getText()) != fee ) {

						tender.setFees(Double.parseDouble(feesField.getText()));
					}
					tender.setAccessories(Double.parseDouble(accessoriesInput.getText()));
				}
				catch ( NumberFormatException nfe ) {

					errorLbl.setText("Please enter a number.");
					String errorStr = nfe.getMessage();
					String checkStr = errorStr.substring(errorStr.indexOf('"') + 1, errorStr.length() - 1);
					if ( feesField.getText().equals(checkStr) ) {

						inputError(feesField);
					}
					if ( accessoriesInput.getText().equals(checkStr) ) {

						inputError(accessoriesInput);
					}
				}

				totalField.setText("$" + tender.sale());
			}
		});

		resetBtn.setOnAction(new EventHandler< ActionEvent >() {
			@Override
			public void handle( ActionEvent event ) {

				reset();
				errorLbl.setText("");
				feesField.setStyle("-fx-background-color: white");
				accessoriesInput.setStyle("-fx-background-color: white");
			}
		});

		customPromoBox.setOnAction(new EventHandler< ActionEvent >() {
			@Override
			public void handle( ActionEvent event ) {

			}
		});

		saveBtn.setOnAction(new EventHandler< ActionEvent >() {
			@Override
			public void handle( ActionEvent event ) {

				try {

					settings.setSaleTax(Double.parseDouble(salesTaxSetInput.getText()));
					settings.setActivationFee(Double.parseDouble(actFeeInput.getText()));
					settings.setUpgradeFee(Double.parseDouble(upgrFeeInput.getText()));
					errorLbl.setText("");
				}
				catch ( NumberFormatException nfe ) {

					errorLbl.setText("Please enter a number.");
					String errorStr = nfe.getMessage();
					String checkStr = errorStr.substring(errorStr.indexOf('"') + 1, errorStr.length() - 1);
					if ( salesTaxSetInput.getText().equals(checkStr) ) {

						inputError(salesTaxSetInput);
					}
					if ( actFeeInput.getText().equals(checkStr) ) {

						inputError(actFeeInput);
					}
					if ( upgrFeeInput.getText().equals(checkStr) ) {

						inputError(upgrFeeInput);
					}
				}
			}
		});
	}

	private void comboActions() {

		phoneCombo.setOnAction(new EventHandler< ActionEvent >() {
			@Override
			public void handle( ActionEvent event ) {

				if ( phoneCombo.getValue().equals(phoneList.get(0)) ) { // GS5

					tender.setPhone(data.gs5);
				}
				else if ( phoneCombo.getValue().equals(phoneList.get(1)) ) { // GS4

					tender.setPhone(data.gs4);
				}
				else if ( phoneCombo.getValue().equals(phoneList.get(2)) ) { // iPhone 6

					tender.setPhone(data.iPhone6);
				}
				else if ( phoneCombo.getValue().equals(phoneList.get(3)) ) { // iPhone 5s

					tender.setPhone(data.iPhone5s);
				}
				else if ( phoneCombo.getValue().equals(phoneList.get(4)) ) { // Moto G

					tender.setPhone(data.motoG);
				}
				else if ( phoneCombo.getValue().equals(phoneList.get(5)) ) { // HTC 510

					tender.setPhone(data.htc510);
				}
				else if ( phoneCombo.getValue().equals(phoneList.get(6)) ) { // Nokia 635

					tender.setPhone(data.nokia635);
				}
				else if ( phoneCombo.getValue().equals(phoneList.get(7)) ) { // Nokia 1320

					tender.setPhone(data.nokia1320);
				}
			}
		});

		planCombo.setOnAction(new EventHandler< ActionEvent >() {
			@Override
			public void handle( ActionEvent event ) {

				if ( planCombo.getValue().equals(planList.get(0)) ) { // Basic

					tender.setPlan(data.basic);
				}
				else if ( planCombo.getValue().equals(planList.get(1)) ) { // Smart

					tender.setPlan(data.smart);
				}
				else if ( planCombo.getValue().equals(planList.get(2)) ) { // Pro

					tender.setPlan(data.pro);
				}
			}
		});

		activationType.setOnAction(new EventHandler< ActionEvent >() {
			@Override
			public void handle( ActionEvent event ) {

				if ( activationType.getValue().equals(activationList.get(0)) ) { // New Customer

					tender.setNewCustomer(true);
					planCombo.setVisible(true);
					lineCombo.setVisible(false);
					feesCombo.setValue(feesList.get(0));
					feesField.setText("" + settings.getActivationFee());
				}
				else if ( activationType.getValue().equals(activationList.get(1)) ) { // Upgrade

					tender.setNewCustomer(false);
					planCombo.setVisible(false);
					lineCombo.setVisible(false);
					feesCombo.setValue(feesList.get(1));
					feesField.setText("" + settings.getUpgradeFee());
				}
				else if ( activationType.getValue().equals(activationList.get(2)) ) { // Add a Line

					tender.setNewCustomer(true);
					planCombo.setVisible(true);
					lineCombo.setVisible(true);
					feesCombo.setValue(feesList.get(0));
					feesField.setText("" + settings.getActivationFee());
				}
			}
		});

		lineCombo.setOnAction(new EventHandler< ActionEvent >() {
			@Override
			public void handle( ActionEvent event ) { // Line Discounts

				if ( lineCombo.getValue().equals(lineList.get(0)) ) { // Two Line

					tender.setAdjustment(10);
				}
				else if ( lineCombo.getValue().equals(lineList.get(1)) ) { // Third Line

					tender.setAdjustment(30);
				}
				else if ( lineCombo.getValue().equals(lineList.get(2)) ) { // Fourth Line

					tender.setAdjustment(30);
				}
				else if ( lineCombo.getValue().equals(lineList.get(3)) ) { // Fifth Line

					tender.setAdjustment(40);
				}
				else if ( lineCombo.getValue().equals(lineList.get(4)) ) { // Sixth Line

					// No Extra Discount
					tender.setAdjustment(0);
				}
			}
		});

		feesCombo.setOnAction(new EventHandler< ActionEvent >() {
			@Override
			public void handle( ActionEvent event ) {

				if ( feesCombo.getValue().equals(feesList.get(0)) ) { // Activation Fee

					tender.setFees(settings.getActivationFee());
					feesField.setText("" + settings.getActivationFee());
					fee = settings.getActivationFee();
				}
				else if ( feesCombo.getValue().equals(feesList.get(1)) ) { // Upgrade Fee

					tender.setFees(settings.getUpgradeFee());
					feesField.setText("" + settings.getUpgradeFee());
					fee = settings.getUpgradeFee();
				}
				else if ( feesCombo.getValue().equals(feesList.get(2)) ) { // No Fees

					tender.setFees(0);
					feesField.setText("0");
					fee = 0;
				}
			}
		});

		phoneNames.setOnAction(new EventHandler< ActionEvent >() {
			@Override
			public void handle( ActionEvent event ) {

				if ( phoneCombo.getValue().equals(phoneList.get(0)) ) { // GS5

				}
				else if ( phoneCombo.getValue().equals(phoneList.get(1)) ) { // GS4

				}
				else if ( phoneCombo.getValue().equals(phoneList.get(2)) ) { // iPhone 6

				}
				else if ( phoneCombo.getValue().equals(phoneList.get(3)) ) { // iPhone 5s

				}
				else if ( phoneCombo.getValue().equals(phoneList.get(4)) ) { // Moto G

				}
				else if ( phoneCombo.getValue().equals(phoneList.get(5)) ) { // HTC 510

				}
				else if ( phoneCombo.getValue().equals(phoneList.get(6)) ) { // Nokia 635

				}
				else if ( phoneCombo.getValue().equals(phoneList.get(7)) ) { // Nokia 1320

				}
			}
		});
	}

	private void inputError( TextField txt ) {

		txt.setStyle("-fx-background-color: red");
	}

	private void reset() {

		activationType.setValue("New/Upgrade");
		phoneCombo.setValue("Phone");
		planCombo.setValue("Plan");
		planCombo.setVisible(true);
		lineCombo.setValue("What Line");
		lineCombo.setVisible(false);
		tender.setAdjustment(0);
		feesCombo.setValue("Fees");
		feesField.setText("0");
		fee = 0;
		accessoriesInput.setText("0");
		totalField.setText("");
	}

	public void start( Stage arg0 ) throws Exception {

//		findFiles();
		pane = new BorderPane();

		try {
			data = new PhoneData();
			settings = new Settings();
		}
		catch ( FileMissingException fme ) {

			System.out.println(fme.getMessage());
		}

		tender = new Tender();

		optionsBtn = new Button();
		optionsBtn.setMinHeight(30);
		optionsBtn.setMinWidth(100);
		optionsBtn.setStyle("-fx-color: #fff");

		actionBarPane = new BorderPane();
		actionBarPane.setMinHeight(50);
		actionBarPane.setPadding(new Insets(10));
		actionBarPane.setStyle("-fx-background-color: #000");
		actionBarPane.setRight(optionsBtn);

		errorLbl = new Label();

		// Home UI

		inputs = new GridPane();
		inputs.setPadding(new Insets(30, 30, 30, 30));
		inputs.setVgap(30);
		inputs.setHgap(30);

		activationList = FXCollections.observableArrayList("New Customer", "Upgrade", "Add a Line");
		activationType = new ComboBox< String >(activationList);
		activationType.setMinWidth(150);
		activationType.setMinHeight(40);
		activationType.setValue("New/Upgrade");

		phoneList = FXCollections.observableArrayList(data.getPhonesNames());
		phoneCombo = new ComboBox< String >(phoneList);
		phoneCombo.setMinWidth(150);
		phoneCombo.setMinHeight(40);
		phoneCombo.setValue("Phone");

		planList = FXCollections.observableArrayList(data.getPlansNames());
		planCombo = new ComboBox< String >(planList);
		planCombo.setMinWidth(150);
		planCombo.setMinHeight(40);
		planCombo.setValue("Plan");

		lineList = FXCollections.observableArrayList("2nd Line", "3rd Line", "4th Line", "5th Line", "6th Line");
		lineCombo = new ComboBox< String >(lineList);
		lineCombo.setMinHeight(40);
		lineCombo.setMinWidth(150);
		lineCombo.setValue("What Line?");

		feesList = FXCollections.observableArrayList("Activation Fee", "Upgrade Fee", "None");
		feesCombo = new ComboBox< String >(feesList);
		feesCombo.setMinWidth(150);
		feesCombo.setMinHeight(40);
		feesCombo.setValue("Fees");
		feesField = new TextField();
		feesField.setMinWidth(100);
		feesField.setMinHeight(40);
		feesField.setText("0");

		accessoriesLbl = new Label("Accessories");

		accessoriesInput = new TextField();
		accessoriesInput.setMaxWidth(150);
		accessoriesInput.setMinHeight(40);
		accessoriesInput.setText("0");

		totalLbl = new Label("Total: ");

		totalField = new Label();

		totalBtn = new Button();
		totalBtn.setMinHeight(40);
		totalBtn.setMinWidth(100);
		totalBtn.setText("Total");

		resetBtn = new Button();
		resetBtn.setMinHeight(40);
		resetBtn.setMinWidth(100);
		resetBtn.setText("Reset");

		inputs.add(activationType, 0, 0);
		inputs.add(phoneCombo, 0, 1);
		inputs.add(planCombo, 0, 2);
		inputs.add(lineCombo, 1, 2);
		inputs.add(feesCombo, 0, 3);
		inputs.add(feesField, 1, 3);
		inputs.add(accessoriesLbl, 0, 4);
		inputs.add(accessoriesInput, 1, 4);
		inputs.add(totalLbl, 0, 5);
		inputs.add(totalField, 1, 5);
		inputs.add(totalBtn, 1, 6);
		inputs.add(resetBtn, 0, 6);

		fee = 0;

		// Settings Page UI

		setAct = new GridPane();
		setAct.setPadding(new Insets(50, 50, 50, 50));
		setAct.setVgap(10);
		setAct.setHgap(30);

		salesTaxSetPrompt = new Label("Sales Tax: ");
		salesTaxSetPrompt.setWrapText(true);

		salesTaxPercent = new Label(" %");
		salesTaxPercent.setStyle("-fx-font-size: 24");

		salesTaxSetInput = new TextField();
		salesTaxSetInput.setMinHeight(40);
		salesTaxSetInput.setMinWidth(60);

		salesTaxPane = new BorderPane();
		salesTaxPane.setLeft(salesTaxSetInput);
		salesTaxPane.setRight(salesTaxPercent);

		actFeePrompt = new Label("Activation Fee: ");
		actFeePrompt.setWrapText(true);

		actFeeInput = new TextField();
		actFeeInput.setMinHeight(40);
		actFeeInput.setMinWidth(80);

		upgrFeePrompt = new Label("Upgrade Fee: ");
		upgrFeePrompt.setWrapText(true);

		upgrFeeInput = new TextField();
		upgrFeeInput.setMinHeight(40);
		upgrFeeInput.setMinWidth(80);

		customPromoLbl = new Label("Custom\nPromo?");
		customPromoBox = new CheckBox();

		phoneNames = new ComboBox< String >(phoneList);
		phoneNames.setMinHeight(40);
		phoneNames.setMinWidth(100);
		phoneNames.setValue("Phone");

		promoNewCustomerLbl = new Label("New Customer\nPromo");
		promoUpgradeLbl = new Label("Upgrade\nPromo");

		phoneNormalPrices = new Label("");
		promoNewCustomerPrices = new TextField();
		promoNewCustomerPrices.setMinWidth(80);
		promoNewCustomerPrices.setMinWidth(40);

		promoUpgradePrices = new TextField();
		promoUpgradePrices.setMinWidth(80);
		promoUpgradePrices.setMinHeight(40);

		promoEnd = new Button();
		promoEnd.setMinHeight(40);
		promoEnd.setMinWidth(100);
		promoEnd.setText("End Promo");

		saveBtn = new Button();
		saveBtn.setMinWidth(100);
		saveBtn.setMinHeight(40);
		saveBtn.setText("Save");

		setAct.add(salesTaxSetPrompt, 0, 0);
		setAct.add(salesTaxPane, 1, 0);
		setAct.add(actFeePrompt, 0, 1);
		setAct.add(actFeeInput, 1, 1);
		setAct.add(upgrFeePrompt, 0, 2);
		setAct.add(upgrFeeInput, 1, 2);
		setAct.add(customPromoLbl, 0, 3);
		setAct.add(customPromoBox, 1, 3);
		setAct.add(phoneNames, 0, 4);
		setAct.add(phoneNormalPrices, 1, 4);
		setAct.add(promoNewCustomerLbl, 0, 5);
		setAct.add(promoNewCustomerPrices, 1, 5);
		setAct.add(promoUpgradeLbl, 0, 6);
		setAct.add(promoUpgradePrices, 1, 6);
		setAct.add(promoEnd, 0, 7);
		setAct.add(saveBtn, 1, 7);

		homeSetup();
		buttonActions();
		comboActions();

		pane.setTop(actionBarPane);
		scene = new Scene(pane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(scene);
		mainStage.setMinWidth(WIDTH);
		mainStage.setMinHeight(HEIGHT);
		mainStage.setTitle("Cricket Calculator");
		mainStage.show();

	}
}
