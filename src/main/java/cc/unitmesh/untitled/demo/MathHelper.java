package cc.unitmesh.untitled.demo;

public class MathHelper {
    /**
     * Calculates the insurance amount based on the given income.
     *
     * @param income the income of the individual for whom insurance amount needs to be calculated
     * @return the insurance amount calculated based on the income:
     * - If income is less than or equal to 10000, insurance amount is income * 0.365
     * - If income is between 10001 and 30000, insurance amount is (income - 10000) * 0.2 + 35600
     * - If income is between 30001 and 60000, insurance amount is (income - 30000) * 0.1 + 76500
     * - If income is greater than 60000, insurance amount is (income - 60000) * 0.02 + 105600
     */
    public double calculateInsurance(double income) {
        if (income <= 10000) {
            return income * 0.365;
        } else if (income <= 30000) {
            return (income - 10000) * 0.2 + 35600;
        } else if (income <= 60000) {
            return (income - 30000) * 0.1 + 76500;
        } else {
            return (income - 60000) * 0.02 + 105600;
        }
    }
}
