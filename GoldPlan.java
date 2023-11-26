public class GoldPlan {
    private static final float OFF_PEAK_PRICE = 15.3f;
    private static final float MID_PEAK_PRICE = 20f;
    private static final float ON_PEAK_PRICE = 22.5f;
    private static final float DELIVERY_PRICE = 20f;
    private static final float REGULATORY_CHARGE = 15f;

    // Getter methods for the prices
    public static float getOffPeakPrice() {
        return OFF_PEAK_PRICE;
    }

    public static float getMidPeakPrice() {
        return MID_PEAK_PRICE;
    }

    public static float getOnPeakPrice() {
        return ON_PEAK_PRICE;
    }

    public static float getDeliveryPrice() {
        return DELIVERY_PRICE;
    }

    public static float getRegulatoryCharge() {
        return REGULATORY_CHARGE;
    }

    // Method to calculate cost for Gold plan
    public static float calculateCost(int offPeakTime, int midPeakTime, int onPeakTime) {
        float totalCost = (offPeakTime * OFF_PEAK_PRICE) + (midPeakTime * MID_PEAK_PRICE) + (onPeakTime * ON_PEAK_PRICE);
        float hst = totalCost * 0.13f;
        return totalCost + DELIVERY_PRICE + REGULATORY_CHARGE + hst;
    }
}
