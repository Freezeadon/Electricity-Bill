public class SilverPlan {
    private static final float OFF_PEAK_PRICE = 7.8f;
    private static final float MID_PEAK_PRICE = 10.3f;
    private static final float ON_PEAK_PRICE = 12.5f;
    private static final float DELIVERY_PRICE = 10f;
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

    public static float calculateCost(int offPeakTime, int midPeakTime, int onPeakTime) {
        float totalTime = offPeakTime + midPeakTime + onPeakTime;
        float totalCost = (offPeakTime * OFF_PEAK_PRICE) + (midPeakTime * MID_PEAK_PRICE) + (onPeakTime * ON_PEAK_PRICE);

        // Calculate overcost if total time exceeds 3000 hours
        if (totalTime > 3000) {
            float overTime = totalTime - 3000;
            float overCost = overTime * 25;
            totalCost += overCost;
        }

        float hst = totalCost * 0.13f;

        return totalCost + DELIVERY_PRICE + REGULATORY_CHARGE + hst;
    }

}
