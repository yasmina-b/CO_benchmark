package bench.cpu;

import bench.IBenchmark;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class PiDigits implements IBenchmark{

    private static final int scale = 10000;
    private static final int arrint = 2000;

    private int digits;

    public PiDigits(int digits) {
        this.digits = digits;
    }


    @Override
    public void intialize(int size) {

    }

    @Override
    public void run() {
//        StringBuffer pi = new StringBuffer();
//        int[] arr = new int[digits + 1];
//        int carry = 0;
//
//        for (int i = 0; i <= digits; ++i)
//            arr[i] = arrint;
//
//        for (int i = digits; i > 0; i-= 14) {
//            int sum = 0;
//            for (int j = i; j > 0; --j) {
//                sum = sum * j + scale * arr[j];
//                arr[j] = sum % (j * 2 - 1);
//                sum /= j * 2 - 1;
//            }
//
//            pi.append(String.format("%04d", carry + sum / scale));
//            carry = sum % scale;
//        }
//        System.out.println(carry);
        System.out.println("ok");
            digits -= 1;
            BigDecimal pi = new BigDecimal(3);
            BigDecimal divisorBegin = new BigDecimal(2);
            BigDecimal divisor;
            BigDecimal one = new BigDecimal(1);
            BigDecimal two = new BigDecimal(2);
            BigDecimal four = new BigDecimal(4);
            BigDecimal minusFour = new BigDecimal(-4);
            MathContext mc = new MathContext(digits);
            for (long i = 0; i < digits; ++i) {
                divisor = one;
                for(long j = 0; j < 3; ++j) {
                    divisor = divisor.multiply(new BigDecimal(j).add(divisorBegin, mc), mc);
                }
                pi = pi.add(i % 2 == 0 ? four.divide(divisor, mc) : minusFour.divide(divisor, mc), mc);
                divisorBegin = divisorBegin.add(two, mc);
            }

            System.out.println(pi);
        }
//


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
}
