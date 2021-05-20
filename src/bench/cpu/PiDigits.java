package bench.cpu;

import bench.IBenchmark;

import java.util.ArrayList;

public class PiDigits implements IBenchmark {

    private static final int scale = 10000;
    private static final int arrint = 2000;

    private final int digits;

    public PiDigits(int digits) {
        this.digits = digits;
    }


    @Override
    public void intialize(int size) {

    }

    @Override
    public void run() {
        StringBuffer pi = new StringBuffer();
        int[] arr = new int[digits + 1];
        int carry = 0;

        for (int i = 0; i <= digits; ++i)
            arr[i] = arrint;

        for (int i = digits; i > 0; i-= 14) {
            int sum = 0;
            for (int j = i; j > 0; --j) {
                sum = sum * j + scale * arr[j];
                arr[j] = sum % (j * 2 - 1);
                sum /= j * 2 - 1;
            }

            pi.append(String.format("%04d", carry + sum / scale));
            carry = sum % scale;
        }

    }

    @Override
    public void run(Object option) {

    }

    @Override
    public void run(Object... objects) {

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
}
