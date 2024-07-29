public class FutureValueCalculator {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: when periods is 0, the future value is the present value itself
        if (periods == 0) {
            return presentValue;
        }
        // Recursive case: calculate future value for one less period and then apply growth rate
        return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial amount
        double growthRate = 0.05;     // Growth rate (5%)
        int periods = 10;             // Number of periods (years)

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods: " + futureValue);
    }
}
