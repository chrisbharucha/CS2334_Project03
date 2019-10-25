
public class DateTimeOne extends MesoDateTimeOneAbstract
{

	private static final int MILLI_CONSTANT = 1000;

	
	public DateTimeOne() {
		
	}
	
	public int getValueOfSecond() {
	return (int)(System.currentTimeMillis() / MILLI_CONSTANT);
	}
	
	public void sleepForFiveSec() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("me no wanna go sleep");
		}
	}
	
	public void dateTimeNow() {
		
	}
	
	
	public void dateTimeOfOtherCity() {
		
	}
	
	public void dateTimeDifferentZone() {
		
	}
	
	public void timeZoneHashMap() {
		
	}
}