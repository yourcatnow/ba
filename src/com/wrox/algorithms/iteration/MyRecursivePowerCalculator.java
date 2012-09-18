package com.wrox.algorithms.iteration;

public class MyRecursivePowerCalculator implements PowerCalculator {
	/** The single, publicly accessible, instance of the comparator. */
    public static final PowerCalculator INSTANCE = new MyRecursivePowerCalculator();

    private int countdown;

    /**
     * Constructor marked private to prevent instantiation.
     */
    private MyRecursivePowerCalculator() {
    }

    public int calculate(int base, int exponent) {
        assert exponent >= 0 : "exponent can't be < 0";
        
        int result = 1;
        
        if (exponent == 0) return result;
        if (exponent == 1) return base;
        
        if (countdown == -1) {
        	countdown = exponent;
        } else if (countdown == 0) {
        	countdown = -1;
        	return result * base;
        } else {
        	result = result * base;
        	countdown--;
        }
        
        result = calculate(base, exponent);
        return result;
    }
}
