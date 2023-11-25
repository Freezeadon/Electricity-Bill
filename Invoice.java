package main;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class Invoice extends GUI {
	
	private static JPanel invoice;
	private static String invoiceNumber = "0001";
	private static String invoiceDate = "2023-11-26";
	private static JLabel invoiceLabel, nameLabel, addressLabel, phoneLabel, billToLabel, buyerNameLabel, buyerPhoneNumber, invoiceNumberLabel, invoiceDateLabel;
	
	public Invoice() {
		super("Invoice");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        invoice.setLayout(new FlowLayout());
	}
	
	public static String callInvoice(String ID) {
		
		try (BufferedReader reader = new BufferedReader(new FileReader("user_data.csv"))) {
        	
            String line;
            
            while ((line = reader.readLine()) != null) {
            	
            	String[] row = line.split(",");
            	
				invoiceLabel = new JLabel("Invoice");
				nameLabel = new JLabel(row[2]+" "+row[3]);
				addressLabel = new JLabel(row[4]);
				phoneLabel = new JLabel(row[6]);
				
				billToLabel = new JLabel(row[4]);
				buyerNameLabel = new JLabel(row[2]);
				buyerPhoneNumber = new JLabel(row[6]);
				
				invoiceNumberLabel = new JLabel(invoiceNumber);
				invoiceDateLabel = new JLabel(invoiceDate);
				
				invoice.add(invoiceLabel);
				invoice.add(nameLabel);
				invoice.add(addressLabel);
				invoice.add(phoneLabel);
				invoice.add(billToLabel);
				invoice.add(buyerNameLabel);
				invoice.add(buyerPhoneNumber);
				invoice.add(invoiceNumberLabel);
				invoice.add(invoiceDateLabel);
            }
            
            return("");
		
		} catch (IOException e) {
            e.printStackTrace();
            return "An error occurred while processing the CSV file.";
		}
		
	}

}
