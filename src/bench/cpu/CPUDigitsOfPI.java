package bench.cpu;

import bench.IBenchmark;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class CPUDigitsOfPI implements IBenchmark {

	private int size;
	public static BigDecimal pi_aux;
	public static BigDecimal pi =  BigDecimal.ZERO;
	public static BigDecimal denom1 =  BigDecimal.ONE;
	public static BigDecimal denom2 =  BigDecimal.ONE;
	public static BigDecimal term1 =  BigDecimal.ZERO;
	public static BigDecimal term2 =  BigDecimal.ZERO;

	@Override
	public void intialize(int size) {
		this.size = size;
	}

	@Override
	public void run() {
		// accuracy parameters set to 1000 arbitrarily
		for(int i=2;i<1000;i+=4)
		{
			denom1 =  BigDecimal.ONE;
			denom1 = denom1.multiply(new BigDecimal(i));
			denom1 = denom1.multiply(new BigDecimal(i+1));
			denom1 = denom1.multiply(new BigDecimal(i+2));

			denom2 =  BigDecimal.ONE;
			denom2 = denom2.multiply(new BigDecimal(i+2));
			denom2 = denom2.multiply(new BigDecimal(i+3));
			denom2 = denom2.multiply(new BigDecimal(i+4));

			// accuracy parameters set to 1000 arbitrarily
			term1 = new BigDecimal("4").divide(denom1, 1000, RoundingMode.HALF_UP);
			term2 = new BigDecimal("-4").divide(denom2, 1000, RoundingMode.HALF_UP);

			pi = pi.add(term1);
			pi = pi.add(term2);
		}

		// 3 + calculated value
		pi = pi.add(new BigDecimal (3));

		// user digit input applied
		pi = pi.setScale(size,  BigDecimal.ROUND_HALF_UP);
		pi_aux = pi;
		pi =  BigDecimal.ZERO;
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
	public void clean() {
	}

	@Override
	public void warmUp() {
		// TODO Auto-generated method stub

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
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}
}