package bench.cpu;

import bench.IBenchmark;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ArctanMethod implements IBenchmark {
    private static final long serialVersionUID = 227L;
    private static final BigDecimal FOUR = BigDecimal.valueOf(4);
    private static final int roundingmode = BigDecimal.ROUND_HALF_UP;
    private final int digits;


    public ArctanMethod(int digits) {
        this.digits = digits;
    }

    public static BigDecimal arctanPi(int digits){
        int s = digits + 5;
        BigDecimal arctan15 = arctangent(5,s);
        BigDecimal arctan1239 = arctangent(239,s);
        BigDecimal pi = arctan15.multiply(FOUR).subtract(arctan1239).multiply(FOUR);
        return pi.setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal arctangent(int x,int s){

        BigDecimal number,term,arc;
        BigDecimal  inverse_x = BigDecimal.valueOf(x);
        BigDecimal inverse_x2 = BigDecimal.valueOf(x*x);
        int i = 1;

        number = BigDecimal.ONE.divide(inverse_x, s, roundingmode);

        arc = number;
        do{
            number = number.divide(inverse_x2, s, roundingmode);
            int d = 2*i+1;
            term = number.divide(BigDecimal.valueOf(d), s, roundingmode);

            if ((i % 2) != 0) {

                arc = arc.subtract(term);

            }
            else{
                arc = arc.add(term);
            }
            i++;
        }while(term.compareTo(BigDecimal.ZERO) != 0);

        return arc;
        
    }


    @Override
    public void intialize(int size) {

    }

    @Override
    public void run() {

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
