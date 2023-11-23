package main;

public class BronzePlan extends ElectricityPlan{

	@Override
	public void calculateTotalCost(int offPeakTime, int midPeakTime, int onPeakTime) {
		
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

}
