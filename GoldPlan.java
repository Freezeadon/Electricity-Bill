package main;

public class GoldPlan extends ElectricityPlan {

	@Override
	public void calculateTotalCost(int offPeakTime, int midPeakTime, int onPeakTime) {
		
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
}
