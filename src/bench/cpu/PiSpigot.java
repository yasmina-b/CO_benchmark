package bench.cpu;

import bench.IBenchmark;

import java.util.ArrayList;

public class PiSpigot implements IBenchmark {

    private int digits_requested;
    private int[] digits;
    public static StringBuilder predigits = new StringBuilder();
    public static String pi;

    private static final int MAX_DIGITS_REQUESTED = 644245094;

    public PiSpigot(int digits_requested) {
        this.digits_requested = digits_requested + 1;
    }


    public boolean init() {
        int array_size_needed = digits_requested * 10 / 3 + 1;
        digits = new int[array_size_needed];
        if (digits == null) {
            System.err.printf("Failed to allocate " + (array_size_needed*4)
                    + " bytes.");
            return false;
        }

        for (int i=0; i < digits.length; i++)
            digits[i] = 2;

        return true;
    }


    @Override
    public void intialize(int size) {

    }

    public void run() {
        if (!init()) return;

        for (int iter = 0; iter < digits_requested; iter++) {


            int carry = 0;
            for (int i=digits.length-1; i > 0; i--) {
                int numerator = i;
                int denomenator = i * 2 + 1;
                int tmp = digits[i] * 10 + carry;
                digits[i] = tmp % denomenator;
                carry = tmp / denomenator * numerator;
            }

            int tmp = digits[0] * 10 + carry;
            digits[0] = tmp % 10;
            int digit = tmp / 10;

            if (digit < 9) {
                if (iter == 1) {

                    predigits.append(".");
                }
                addDigit(digit);
            } else if (digit == 9) {
                addDigit(digit);
            } else {
                overflowDigits();
                addDigit(0);
            }
        }


        System.out.println();
    }

    @Override
    public void run(Object option) {

    }

    @Override
    public void run(Object... objects) {

    }

    @Override
    public void run(int digits) {

    }

    @Override
    public String getResult() {
        return null;
    }

    @Override
    public void warmUp() {

    }

    @Override
    public void warmUp(Object option) {

    }

    @Override
    public void initialize(int size) {

    }

    @Override
    public void initialize(String str) {

    }

    @Override
    public void initialize(ArrayList<String> words) {

    }

    @Override
    public void clean() {

    }

    void addDigit(int digit) {
        predigits.append((char)('0' + digit));
    }


    void overflowDigits() {
        for (int i=0; i < predigits.length(); i++) {
            char digit = predigits.charAt(i);
            if (digit == '9') {
                predigits.setCharAt(i, '0');
            } else {
                predigits.setCharAt(i, (char)(digit + 1));
            }
        }
    }
}
