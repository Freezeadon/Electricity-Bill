import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class Invoice extends JFrame {
	
	private JPanel invoice = new JPanel();
	private String invoiceNumber = "0001";
	private String invoiceDate = "2023-11-27";
	private String invoiceDue = "2023-12-37";
	private JLabel invoiceLabel, nameLabel, addressLabel, phoneLabel, billToLabel, buyerNameLabel, buyerPhoneNumber, invoiceNumberLabel, invoiceDateLabel;
	private JLabel invoiceDueLabel, itemLabel, totalCostLabel, quantityLabel, itemTitle, quantityTitle, amountTitle;
	
	public Invoice(String firstName, String lastName, String address, String phoneNumber, float totalCost, double quantity) {
		super("Invoice");
        
		totalCost = totalCost / 100;
		
		invoice.setLayout(null);
		
		invoiceLabel = new JLabel("Invoice");
		nameLabel = new JLabel(firstName+" "+lastName);
		addressLabel = new JLabel(address);
		phoneLabel = new JLabel(phoneNumber);
				
		billToLabel = new JLabel(address);
		buyerNameLabel = new JLabel(firstName+lastName);
		buyerPhoneNumber = new JLabel(phoneNumber);
				
		invoiceNumberLabel = new JLabel("Invoice Number: "+invoiceNumber);
		invoiceDateLabel = new JLabel("Invoice Date: "+invoiceDate);
		invoiceDueLabel = new JLabel("Payment Due: "+invoiceDue);
		
		itemTitle = new JLabel("Item");
		quantityTitle = new JLabel("Quantity");
		amountTitle = new JLabel("Amount");
		
		itemLabel = new JLabel("Electricity");
		quantityLabel = new JLabel(Double.toString(quantity));
		totalCostLabel = new JLabel("$"+ Float.toString(totalCost));
		
		Font labelFont = new Font("SansSerif", Font.BOLD, 15);
		Font title = new Font("SansSerif", Font.BOLD, 24);
		Font listFont = new Font("SansSerif", Font.BOLD, 18);
		Font itemFont = new Font("SansSerif", Font.PLAIN, 15);
		
		invoiceLabel.setFont(title);
		nameLabel.setFont(labelFont);
		addressLabel.setFont(labelFont);
		phoneLabel.setFont(labelFont);
		billToLabel.setFont(labelFont);
		buyerNameLabel.setFont(labelFont);
		buyerPhoneNumber.setFont(labelFont);
		invoiceNumberLabel.setFont(labelFont);
		invoiceDateLabel.setFont(labelFont);
		invoiceDueLabel.setFont(labelFont);
		
		itemTitle.setFont(listFont);
		quantityTitle.setFont(listFont);
		amountTitle.setFont(listFont);
		
		itemLabel.setFont(itemFont);
		quantityLabel.setFont(itemFont);
		totalCostLabel.setFont(itemFont);
		
		int X = 100; // x value for labels
		int X2 = 320; // x value for values
		int y = 50; // y value for both labels and values
		int gap = 30;
		
		int itemX = 100;
		int quantityX = 250;
		int amountX = 400;
		
		invoiceLabel.setBounds(X, y, 150, 30);
		y += gap;
	
		nameLabel.setBounds(X, y, 150, 30);
		y += gap;
		
		addressLabel.setBounds(X, y, 150, 30);
		y += gap;
		
		phoneLabel.setBounds(X, y, 150, 30);
		y += gap;
		
		billToLabel.setBounds(X, y, 150, 30);
		invoiceNumberLabel.setBounds(X2,y,300,30);
		y += gap;
		
		buyerNameLabel.setBounds(X, y, 150, 30);
		invoiceDateLabel.setBounds(X2,y,300,30);
		y += gap;
		
		buyerPhoneNumber.setBounds(X, y, 150, 30);
		invoiceDueLabel.setBounds(X2, y, 300, 30);
		y += gap+60;
		
		itemTitle.setBounds(itemX, y, 150, 30);
		quantityTitle.setBounds(quantityX, y, 150, 30);
		amountTitle.setBounds(amountX, y, 150, 30);
		y += gap;
		
		itemLabel.setBounds(itemX, y, 150, 30);
		quantityLabel.setBounds(quantityX, y, 150, 30);
		totalCostLabel.setBounds(amountX, y, 150, 30);
		
		
		invoice.add(invoiceLabel);

		invoice.add(nameLabel);
		invoice.add(addressLabel);
		invoice.add(phoneLabel);
		invoice.add(billToLabel);
		invoice.add(buyerNameLabel);
		invoice.add(buyerPhoneNumber);
		
		invoice.add(invoiceNumberLabel);
		invoice.add(invoiceDateLabel);
		invoice.add(invoiceDueLabel);
		
		invoice.add(itemTitle);
		invoice.add(quantityTitle);
		invoice.add(amountTitle);
		
		invoice.add(itemLabel);
		invoice.add(quantityLabel);
		invoice.add(totalCostLabel);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.png"));
        Image i = i1.getImage().getScaledInstance(160, 150, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(380, -60, 250, 250);
        invoice.add(image);
		
		add(invoice);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.PINK);
		setResizable(false);
		setSize(600, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}

}
