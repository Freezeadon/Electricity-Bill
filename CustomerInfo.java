import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerInfo extends JFrame {

	private JLabel customerIDtext, planType, offPeak, midPeak, onPeak, overCosted, delivery, regulatory, HST, subTotal, totalHST;
	private JLabel customerIDNo, planValue, offPeakValue, midPeakValue, onPeakValue, overCostedValue, deliveryValue, regulatoryValue,
			HSTValue, subTotalValue, totalHSTValue;
	private JButton closeButton, invoiceButton;
	private JPanel infoPanel;

	public CustomerInfo(String customerId, String plan, int offPeakTime, int midPeakTime, int onPeakTime, float total, String firstName, String lastName, String address, String phoneNumber) {
		super("Customer Information");

		float offPeakPrice, midPeakPrice, onPeakPrice, deliveryPrice, overCost = 0, totalTime;

		// Determine the plan and set prices accordingly
		if (plan.equalsIgnoreCase("Bronze")) {
			offPeakPrice = BronzePlan.getOffPeakPrice();
			midPeakPrice = BronzePlan.getMidPeakPrice();
			onPeakPrice = BronzePlan.getOnPeakPrice();
			deliveryPrice = BronzePlan.getDeliveryPrice();
			totalTime = offPeakTime + midPeakTime + onPeakTime;
			if (totalTime > 1000) {
				overCost = (totalTime - 1000) * 20;
			}

		} else if (plan.equalsIgnoreCase("Silver")) {
			offPeakPrice = SilverPlan.getOffPeakPrice();
			midPeakPrice = SilverPlan.getMidPeakPrice();
			onPeakPrice = SilverPlan.getOnPeakPrice();
			deliveryPrice = SilverPlan.getDeliveryPrice();
			totalTime = offPeakTime + midPeakTime + onPeakTime;
			if (totalTime > 3000) {
				overCost = (totalTime - 3000) * 25;
			}

		} else if (plan.equalsIgnoreCase("Gold")) {
			offPeakPrice = GoldPlan.getOffPeakPrice();
			midPeakPrice = GoldPlan.getMidPeakPrice();
			onPeakPrice = GoldPlan.getOnPeakPrice();
			deliveryPrice = GoldPlan.getDeliveryPrice();
		} else {
			JOptionPane.showMessageDialog(this, "Unknown plan: " + plan);
			return;
		}

		// Calculate other charges based on plan

		float overCosts = overCost;
		float regulatoryCharge = BronzePlan.getRegulatoryCharge(); // since it is the same throughout the plans
		float totalCharged = (offPeakPrice * offPeakTime) + (midPeakPrice * midPeakTime) + (onPeakPrice * onPeakTime)
				+ deliveryPrice + regulatoryCharge + overCosts;
		float hst = totalCharged * 0.13f;
		float totalChargedWithHST = total;

		customerIDtext = new JLabel("Customer ID: ");
		planType = new JLabel("Plan:");
		offPeak = new JLabel("Off-Peak Time:");
		midPeak = new JLabel("Mid-Peak Time:");
		onPeak = new JLabel("On-Peak Time:");
		overCosted = new JLabel("OverCost:");
		delivery = new JLabel("Delivery:");
		regulatory = new JLabel("Regulatory:");
		HST = new JLabel("HST:");
		subTotal = new JLabel("Subtotal:");
		totalHST = new JLabel("Total:");

		customerIDNo = offPeakValue = new JLabel(customerId);
		planValue = new JLabel(plan);
		offPeakValue = new JLabel(Integer.toString(offPeakTime));
		midPeakValue = new JLabel(Integer.toString(midPeakTime));
		onPeakValue = new JLabel(Integer.toString(onPeakTime));
		overCostedValue = new JLabel(Float.toString(overCosts));
		deliveryValue = new JLabel(Float.toString(deliveryPrice));
		regulatoryValue = new JLabel(Float.toString(regulatoryCharge));
		HSTValue = new JLabel(Float.toString(hst));
		subTotalValue = new JLabel(Float.toString(totalCharged));
		totalHSTValue = new JLabel(Float.toString(totalChargedWithHST));

		closeButton = new JButton("Close");
		invoiceButton = new JButton("Invoice");

		// Font settings
		Font customerFont = new Font("SansSerif", Font.BOLD, 17);
		Font labelFont = new Font("SansSerif", Font.BOLD, 15);
		Font valueFont = new Font("SansSerif", Font.PLAIN, 14);

		customerIDtext.setFont(customerFont);
		planType.setFont(labelFont);
		offPeak.setFont(labelFont);
		midPeak.setFont(labelFont);
		onPeak.setFont(labelFont);
		overCosted.setFont(labelFont);
		delivery.setFont(labelFont);
		regulatory.setFont(labelFont);
		HST.setFont(labelFont);
		subTotal.setFont(labelFont);
		totalHST.setFont(labelFont);
		
		customerIDNo.setFont(customerFont);
		planValue.setFont(valueFont);
		offPeakValue.setFont(valueFont);
		midPeakValue.setFont(valueFont);
		onPeakValue.setFont(valueFont);
		overCostedValue.setFont(valueFont);
		deliveryValue.setFont(valueFont);
		regulatoryValue.setFont(valueFont);
		HSTValue.setFont(valueFont);
		subTotalValue.setFont(valueFont);
		totalHSTValue.setFont(valueFont);

		closeButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		invoiceButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBackground(Color.PINK);

		int labelX = 150; // x value for labels
		int valueX = 330; // x value for values
		int y = 50; // y value for both labels and values
		int gap = 30;

		customerIDtext.setBounds(35, 25, 150, 30);
		customerIDNo.setBounds(145, 25, 200, 30);
		y += gap;

		planType.setBounds(labelX, y, 150, 30);
		planValue.setBounds(valueX, y, 200, 30);
		y += gap;

		offPeak.setBounds(labelX, y, 150, 30);
		offPeakValue.setBounds(valueX, y, 200, 30);
		y += gap;

		midPeak.setBounds(labelX, y, 150, 30);
		midPeakValue.setBounds(valueX, y, 200, 30);
		y += gap;

		onPeak.setBounds(labelX, y, 150, 30);
		onPeakValue.setBounds(valueX, y, 200, 30);
		y += gap;

		overCosted.setBounds(labelX, y, 150, 30);
		overCostedValue.setBounds(valueX, y, 200, 30);
		y += gap;

		delivery.setBounds(labelX, y, 150, 30);
		deliveryValue.setBounds(valueX, y, 200, 30);
		y += gap;

		regulatory.setBounds(labelX, y, 150, 30);
		regulatoryValue.setBounds(valueX, y, 200, 30);
		y += gap;

		subTotal.setBounds(labelX, y, 150, 30);
		subTotalValue.setBounds(valueX, y, 200, 30);
		y += gap;

		HST.setBounds(labelX, y, 150, 30);
		HSTValue.setBounds(valueX, y, 200, 30);
		y += gap;

		totalHST.setBounds(labelX, y, 150, 30);
		totalHSTValue.setBounds(valueX, y, 200, 30);

		closeButton.setBounds(280, 400, 100, 30);
		closeButton.addActionListener(e -> dispose());
		
		float allTime = offPeakTime + midPeakTime + onPeakTime;
		
		invoiceButton.setBounds(170, 400, 100, 30);
		invoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of AnotherClass and call the method
            	new Invoice(firstName, lastName, address, phoneNumber, totalChargedWithHST, allTime);
            	
            	dispose();
            }
        });
		
		infoPanel.add(customerIDtext);
		infoPanel.add(planType);
		infoPanel.add(offPeak);
		infoPanel.add(midPeak);
		infoPanel.add(onPeak);
		infoPanel.add(overCosted);
		infoPanel.add(delivery);
		infoPanel.add(regulatory);
		infoPanel.add(HST);
		infoPanel.add(subTotal);
		infoPanel.add(totalHST);

		infoPanel.add(customerIDNo);
		infoPanel.add(planValue);
		infoPanel.add(offPeakValue);
		infoPanel.add(midPeakValue);
		infoPanel.add(onPeakValue);
		infoPanel.add(overCostedValue);
		infoPanel.add(deliveryValue);
		infoPanel.add(regulatoryValue);
		infoPanel.add(HSTValue);
		infoPanel.add(subTotalValue);
		infoPanel.add(totalHSTValue);

		infoPanel.add(closeButton);
		infoPanel.add(invoiceButton);

		add(infoPanel);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.PINK);
		setResizable(false);
		setSize(600, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
