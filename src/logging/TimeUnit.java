package logging;

public enum TimeUnit {

	Nano, Micro, Milli, Sec;

	/**
	 * Converts time given in nanoseconds to another time unit
	 * @param time Time in nanoseconds
	 * @param unit Unit to convert to
	 * @return Time expressed in given unit
	 */
	public static long toTimeUnit(long time, TimeUnit unit) {

		switch (unit) {
		case Nano:
			return time;
		case Micro:
			return time/1000;
		case Milli:
			return time/1000000;
		case Sec:
			return time/1000000000;		
		default:
			return time;
		}
	}
}
