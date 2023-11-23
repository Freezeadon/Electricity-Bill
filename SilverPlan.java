package main;

public class SilverPlan extends ElectricityPlan {

	@Override
	public void calculateTotalCost(int offPeakTime, int midPeakTime, int onPeakTime) {
		
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
	
}
