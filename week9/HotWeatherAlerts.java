public class HotWeatherAlerts {

    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings.length < k) {
            return 0;
        }

        long currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += readings[i];
        }

        long targetSum = (long) k * threshold;
        int alertCount = (currentSum >= targetSum) ? 1 : 0;

        for (int i = k; i < readings.length; i++) {
            currentSum += readings[i] - readings[i - k];
            if (currentSum >= targetSum) {
                alertCount++;
            }
        }

        return alertCount;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 5, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        int alerts = countAlerts(readings, k, threshold);
        System.out.println("Alert Count: " + alerts);
        // Output: Alert Count: 3
    }
}