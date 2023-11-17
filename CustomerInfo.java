package main;

import java.awt.FlowLayout;
import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

public class CustomerInfo extends GUI {

	private JPanel Info;
	private JLabel idLabel, meterNumLabel, offPeakLabel, midPeakLabel, onPeakLabel, deliveryLabel, regCharge, totalElecLabel, hstLabel, totalLabel;
	
	private int customerID, meterNum, offPeak, midPeak, onPeak; //temp numbers until we get cvs working
	
	CustomerInfo(Main Info) {
		super("Customer Info");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Info.setLayout(new FlowLayout());
		
		Plans plan = new Plans();
		
		//identify correct user profile and get values.
		
		idLabel = new JLabel("Customer ID: "+ customerID);
		meterNumLabel = new JLabel("Meter Number: "+ meterNum+ "\n");
		
		offPeakLabel = new JLabel("kWh Off Peak \t "+ (offPeak * 8.7) + "¢\n");
		midPeakLabel = new JLabel("kWh Off Peak \t "+ (midPeak * 12.2) + "¢\n");
		onPeakLabel = new JLabel("kWh Off Peak \t "+ (onPeak * 18.2) + "¢\n");
		
		//
		
		deliveryLabel = new JLabel("Delivery fee \t "+ plan.deliveryPrice+ "¢\n"); //not actually calculating anything
		regCharge = new JLabel("Regulatory Charges \t "+ plan.regulatoryCharge + "¢\n"); // not actually calculating anything
		totalElecLabel = new JLabel("Total Electricity Charges: \t "+ plan.totalCost + "¢\n");
		
		hstLabel = new JLabel ("H.S.T. \t" + plan.hst +"¢\n");
		
		totalLabel = new JLabel ("TOTAL \t" + plan.total + "¢");
	}


	//NOT FINISHED
	
	private boolean planVerify(String Plan) {
		String csvFilePath = "path/to/your/file.csv";
	    String targetValue = "silver";

	    try (planVerify reader = new planVerify(new FileReader(csvFilePath))) {
	    	String[] nextLine;
	        boolean found = false;

	        // Read each line in the CSV file
	        while ((nextLine = reader.readNext()) != null) {
	        	// Check if the third column has the desired value
	        	if (nextLine.length >= 3 && nextLine[2].equalsIgnoreCase(targetValue)) {
	        		found = true;
	        		break;
	            }
	        }

	            // Print the result
	        if (found) {
	        	System.out.println("Value '" + targetValue + "' found in the third column of the CSV file.");
	        } else {
	        	System.out.println("Value '" + targetValue + "' not found in the third column of the CSV file.");
	        }
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}

}
