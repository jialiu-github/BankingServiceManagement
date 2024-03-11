package cc.unitmesh.untitled.demo;

public class MathHelper {
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

    public int sum(int a, int b) {
        return a + b;
    }

    public double average(double a, double b) {
        return (a + b) / 2.0;
    }

}
