package main;

import java.awt.FlowLayout;
import javax.swing.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CustomerInfo extends GUI {

	private static JPanel Info;
	private static JLabel idLabel, meterNumLabel, offPeakLabel, midPeakLabel, onPeakLabel, deliveryLabel, regCharge, totalElecLabel, hstLabel, totalLabel;
	
	private static int offPeak = 180;
	private static int midPeak = 180;
	private static int onPeak = 180;
	
	public CustomerInfo() {
        super("Customer Info");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Info.setLayout(new FlowLayout());
    }
	
	public static String createInfo(String customerID) {
		
		int searchColumnIndex = 0; // Index of the column to search for the target value
        int resultColumnIndex = 8; // Index of the column to retrieve the result value

        try (BufferedReader reader = new BufferedReader(new FileReader("user_data.csv"))) {
        	
            String line;
            
            while ((line = reader.readLine()) != null) {
            	
                String[] row = line.split(",");
                
                idLabel = new JLabel("Customer ID: "+ customerID);
        		meterNumLabel = new JLabel("Meter Number: "+ row[1] + "\n");
        		
        		offPeakLabel = new JLabel("kWh Off Peak \t "+ (offPeak * 8.7) + "¢\n");
        		midPeakLabel = new JLabel("kWh Off Peak \t "+ (midPeak * 12.2) + "¢\n");
        		onPeakLabel = new JLabel("kWh Off Peak \t "+ (onPeak * 18.2) + "¢\n");
        	
        		if (row[searchColumnIndex] == customerID) {
        			
        			ElectricityPlan electricityPlan = null;
        			
        			if (row[resultColumnIndex] == "bronze") {
        				
        				electricityPlan = new BronzePlan();
        				
        				electricityPlan.calculateTotalCost(offPeak, midPeak, onPeak);
        				
        				deliveryLabel = new JLabel("Delivery fee \t "+ electricityPlan.deliveryPrice + "¢\n"); //not actually calculating anything
                		regCharge = new JLabel("Regulatory Charges \t "+ electricityPlan.regulatoryCharge + "¢\n"); // not actually calculating anything
                		totalElecLabel = new JLabel("Total Electricity Charges: \t "+ electricityPlan.totalCost + "¢\n");
                		
                		hstLabel = new JLabel ("H.S.T. \t" + electricityPlan.hst +"¢\n");
                		
                		totalLabel = new JLabel ("TOTAL \t" + electricityPlan.total + "¢");
        			}
        			if (row[resultColumnIndex] == "silver") {
        				
        				electricityPlan = new SilverPlan();
        				
        				electricityPlan.calculateTotalCost(offPeak, midPeak, onPeak);
        				
        				deliveryLabel = new JLabel("Delivery fee \t "+ electricityPlan.deliveryPrice + "¢\n"); //not actually calculating anything
                		regCharge = new JLabel("Regulatory Charges \t "+ electricityPlan.regulatoryCharge + "¢\n"); // not actually calculating anything
                		totalElecLabel = new JLabel("Total Electricity Charges: \t "+ electricityPlan.totalCost + "¢\n");
                		
                		hstLabel = new JLabel ("H.S.T. \t" + electricityPlan.hst +"¢\n");
                		
                		totalLabel = new JLabel ("TOTAL \t" + electricityPlan.total + "¢");
        			}
        			if (row[resultColumnIndex] == "gold") {
        				
        				electricityPlan = new GoldPlan();
        				
        				electricityPlan.calculateTotalCost(offPeak, midPeak, onPeak);
        				
        				deliveryLabel = new JLabel("Delivery fee \t "+ electricityPlan.deliveryPrice + "¢\n"); //not actually calculating anything
                		regCharge = new JLabel("Regulatory Charges \t "+ electricityPlan.regulatoryCharge + "¢\n"); // not actually calculating anything
                		totalElecLabel = new JLabel("Total Electricity Charges: \t "+ electricityPlan.totalCost + "¢\n");
                		
                		hstLabel = new JLabel ("H.S.T. \t" + electricityPlan.hst +"¢\n");
                		
                		totalLabel = new JLabel ("TOTAL \t" + electricityPlan.total + "¢");
        			}
        		}
        		
            }

            // Handle the case where the target value is not found
            return "Target value not found in the CSV file.";

        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred while processing the CSV file.";
        }
	}
}
