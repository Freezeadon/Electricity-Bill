package main;

public abstract class ElectricityPlan {
    // Common fields for all plans
    protected static float overCost;
    protected static double offPeakPrice;
    protected static double midPeakPrice;
    protected static double onPeakPrice;

    protected static double deliveryPrice;
    protected static double regulatoryCharge;
    protected static float overTime;
    protected static float totalCost;
    protected static float hst;
    protected static float total;

    // Abstract method to be implemented by concrete classes
    public abstract void calculateTotalCost(int offPeakTime, int midPeakTime, int onPeakTime);
}
