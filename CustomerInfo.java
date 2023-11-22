package main;

import java.awt.FlowLayout;
import javax.swing.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CustomerInfo extends GUI {
	
	private static float overCost;
	private static double offPeakPrice;
	private static double midPeakPrice;
	private static double onPeakPrice;
	
	public static double deliveryPrice;
	public static double regulatoryCharge;
	public static float overTime;
	public static float totalCost;
	public static float hst;
	public static float total;
	
	CustomerInfo(Main Info) {
		super("Customer Info");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Info.setLayout(new FlowLayout());
	}
	
	public static void bronze(int offPeakTime, int midPeakTime, int onPeakTime) { //input offpeak, midpeak, and on peak times to calculate total prices
		
		offPeakPrice = 7.8;
		midPeakPrice = 10.3;
		onPeakPrice = 12.5;

		deliveryPrice = 10;
		regulatoryCharge = 15;
		
		float totalTime = offPeakTime + midPeakTime + onPeakTime;
		if (totalTime < 1000) {
			totalCost = (float) ((offPeakTime * offPeakPrice) + (midPeakTime * midPeakPrice) + (onPeakTime * onPeakPrice));
		} else {
			totalCost = (float) ((offPeakTime * offPeakPrice) + (midPeakTime * midPeakPrice) + (onPeakTime * onPeakPrice));
			overTime = totalTime - 1000;
			overCost = overTime * 20;
		}
		
		hst = (float) (totalCost + overCost * 0.13);
		
		total = totalCost + hst;
		
	}

	public static void silver(int offPeakTime, int midPeakTime, int onPeakTime) { //input offpeak, midpeak, and on peak times to calculate total prices
		
		offPeakPrice = 10.3;
		midPeakPrice = 12.5;
		onPeakPrice = 15.3;

		deliveryPrice = 15;
		regulatoryCharge = 15;
		
		float totalTime = offPeakTime + midPeakTime + onPeakTime;
		if (totalTime < 3000) {
			totalCost = (float) ((offPeakTime * offPeakPrice) + (midPeakTime * midPeakPrice) + (onPeakTime * onPeakPrice));
		} else {
			totalCost = (float) ((offPeakTime * offPeakPrice) + (midPeakTime * midPeakPrice) + (onPeakTime * onPeakPrice));
			overTime = totalTime - 3000;
			overCost = overTime * 25;
		}
		
		hst = (float) (totalCost + overCost * 0.13);
		
		total = totalCost + hst;
		
	}

	public static void gold(int offPeakTime, int midPeakTime, int onPeakTime) { //input offpeak, midpeak, and on peak times to calculate total prices
		
		offPeakPrice = 15.3;
		midPeakPrice = 20;
		onPeakPrice = 22.5;

		deliveryPrice = 20;
		regulatoryCharge = 15;
		
		float totalTime = offPeakTime + midPeakTime + onPeakTime;

		totalCost = (float) ((offPeakTime * offPeakPrice) + (midPeakTime * midPeakPrice) + (onPeakTime * onPeakPrice));
		
		hst = (float) (totalCost + overCost * 0.13);
		
		total = totalCost + hst;
		
	}

	private static JPanel Info;
	private static JLabel idLabel, meterNumLabel, offPeakLabel, midPeakLabel, onPeakLabel, deliveryLabel, regCharge, totalElecLabel, hstLabel, totalLabel;
	
	private static int offPeak = 180;
	private static int midPeak = 180;
	private static int onPeak = 180;
	
	public static String createInfo(String customerID) {
		
		int searchColumnIndex = 0; // Index of the column to search for the target value
        int resultColumnIndex = 8; // Index of the column to retrieve the result value

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
        	
            String line;
            
            while ((line = reader.readLine()) != null) {
            	
                String[] row = line.split(",");
                
                idLabel = new JLabel("Customer ID: "+ customerID);
        		meterNumLabel = new JLabel("Meter Number: "+ row[1] + "\n");
        		
        		offPeakLabel = new JLabel("kWh Off Peak \t "+ (offPeak * 8.7) + "¢\n");
        		midPeakLabel = new JLabel("kWh Off Peak \t "+ (midPeak * 12.2) + "¢\n");
        		onPeakLabel = new JLabel("kWh Off Peak \t "+ (onPeak * 18.2) + "¢\n");
        	
        		if (row[searchColumnIndex] == customerID) {
        			if (row[resultColumnIndex] == "bronze") {
        				
        				bronze(offPeak,midPeak,onPeak);
        				
        				deliveryLabel = new JLabel("Delivery fee \t "+ deliveryPrice + "¢\n"); //not actually calculating anything
                		regCharge = new JLabel("Regulatory Charges \t "+ regulatoryCharge + "¢\n"); // not actually calculating anything
                		totalElecLabel = new JLabel("Total Electricity Charges: \t "+ totalCost + "¢\n");
                		
                		hstLabel = new JLabel ("H.S.T. \t" + hst +"¢\n");
                		
                		totalLabel = new JLabel ("TOTAL \t" + total + "¢");
        			}
        			if (row[resultColumnIndex] == "silver") {
        				
        				silver(offPeak,midPeak,onPeak);
        				
        				deliveryLabel = new JLabel("Delivery fee \t "+ deliveryPrice + "¢\n"); //not actually calculating anything
                		regCharge = new JLabel("Regulatory Charges \t "+ regulatoryCharge + "¢\n"); // not actually calculating anything
                		totalElecLabel = new JLabel("Total Electricity Charges: \t "+ totalCost + "¢\n");
                		
                		hstLabel = new JLabel ("H.S.T. \t" + hst +"¢\n");
                		
                		totalLabel = new JLabel ("TOTAL \t" + total + "¢");
        			}
        			if (row[resultColumnIndex] == "gold") {
        				
        				gold(offPeak,midPeak,onPeak);
        				
        				deliveryLabel = new JLabel("Delivery fee \t "+ deliveryPrice + "¢\n"); //not actually calculating anything
                		regCharge = new JLabel("Regulatory Charges \t "+ regulatoryCharge + "¢\n"); // not actually calculating anything
                		totalElecLabel = new JLabel("Total Electricity Charges: \t "+ totalCost + "¢\n");
                		
                		hstLabel = new JLabel ("H.S.T. \t" + hst +"¢\n");
                		
                		totalLabel = new JLabel ("TOTAL \t" + total + "¢");
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
