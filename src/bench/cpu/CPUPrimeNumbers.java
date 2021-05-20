package bench.cpu;

import bench.IBenchmark;
import javafx.fxml.Initializable;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CPUPrimeNumbers implements IBenchmark {
    private long N;
    public static int number;
    public static int primeCount;
    public static String result="";
    @Override
    public void run(Object... options) {
    }

    @Override
    public String getResult() {
        return null;
    }

    private void primeNumbers(int digits) {
        number=2;
        primeCount=0;
        while(primeCount<digits) {
            if(isPrime(number)) {
                primeCount++;
                result = result + " " + number;
            }
            number=number +1;
        }
    }

    private static boolean isPrime(long x) {
        if(x==0 || x==1)
            return false;
        for(int i=2; i<=x/2; i++) {
            if(x%i==0)
                return false;
        }
        return true;
    }


    @Override
    public void clean() {
        System.gc();
    }

    @Override
    public void warmUp() {
        this.run("primeNumbers");
    }

    @Override
    public void warmUp(Object option) {

    }

    @Override
    public void initialize(int size) {
        this.N=size;

    }

    @Override
    public void initialize(String str) {
        // TODO Auto-generated method stub

    }

    @Override
    public void initialize(ArrayList<String> words) {
        // TODO Auto-generated method stub

    }
    @Override
    public void intialize(int size) {
        result="";

    }

    @Override
    public void run() {

    }

    @Override
    public void run(int digits) {
        this.primeNumbers(digits);

    }

    @Override
    public void run(Object option) {

    }
}
