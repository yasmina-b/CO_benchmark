package bench.cpu;

import bench.IBenchmark;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BaileyBorweinPlouffePi implements IBenchmark {


    private int no_of_digits;

    public static BigDecimal pi_real;

    public BaileyBorweinPlouffePi(int no_of_digits) {
        this.no_of_digits = no_of_digits;
    }

    @Override
    public void intialize(int size) {

    }

    @Override
    public void run() {
        BigDecimal pi = BigDecimal.ZERO;
        for (int k = 0; k < no_of_digits; k++) {
            BigDecimal a = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(16).pow(k), 30, RoundingMode.HALF_UP);
            BigDecimal aux1 = BigDecimal.valueOf(4).divide(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(1)), 30, RoundingMode.HALF_UP);
            BigDecimal aux2 = BigDecimal.valueOf(2).divide(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(4)), 30, RoundingMode.HALF_UP);
            BigDecimal aux3 = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(5)), 30, RoundingMode.HALF_UP);
            BigDecimal aux4 = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(8).multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(6)), 30, RoundingMode.HALF_UP);
            BigDecimal b = aux1.subtract(aux2).subtract(aux3).subtract(aux4);
            pi = pi.add(a.multiply(b));
        }
        pi_real = pi;

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
    public void clean() {

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


}
