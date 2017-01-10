package CappointmentApp;

public class Ctime {
	private int hour;   
	private int min;     //minute
	
	public Ctime(int hour, int min) {
		super();
		this.hour = hour;
		this.min = min;
	}
	//public  CTime(String hhmm)
	//{
		
	//s}
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	@Override
	public String toString(){
		String time = null;
		if(hour > 12){
			time = Integer.toString(hour - 12) + ":" + Integer.toString(min) + "pm";
		}else{
			time = Integer.toString(hour) + ":" + Integer.toString(min) + "am";
		}
		return time;
		
	}

}
