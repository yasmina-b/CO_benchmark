package bench;

public interface IBenchmark {
	
	/**
	 * Called to explicitly initialize benchmark data. <br>
	 * This call should not be benchmarked.
	 * 
	 * @param size Size of data to be initialized
	 */
	public void intialize(int size);
	
	/**
	 * Calls the actual benchmarking algorithm, optionally after <b>initialize</b> was called. <br>
	 * This call should be benchmarked.	
	 */	
	public void run();
	
	/**
	 * Calls the actual benchmarking algorithm, optionally after <b>initialize</b> was called. <br>
	 * This call should be benchmarked.	
	 * 
	 * @param option May pass a benchmark option defined by the benchmark class itself
	 */	
	public void run(Object option);
	
	
	public String getResult();
	
	public void warmUp();
	
	public void warmUp(Object option);
	
	/**
	 * Called to explicitly release allocated data. <br>
	 * This call should not be benchmarked.
	 */
	
	public void clean();
}
