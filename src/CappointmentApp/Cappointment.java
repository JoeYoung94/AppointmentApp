package CappointmentApp;

public class Cappointment {
	private Ctime begtime;       //this is the beginning time of an appointment
	private Ctime endtime;       // this is the end time of an appointment
	private String description;   // the title of an appointment
	
	// the constructor of Cappintment
	public Cappointment(Ctime begtime, Ctime endtime, String description) {
		super();
		this.begtime = begtime;
		this.endtime = endtime;
		this.description = description;
	}
	
	// get beginning time of an appointment
	public Ctime getBegtime() {
		return begtime;
	}

	// set beginning time of an appointment
	public void setBegtime(Ctime begtime) {
		this.begtime = begtime;
	}

	// get end time of an appointment
	public Ctime getEndtime() {
		return endtime;
	}

	// set end time of an appointment
	public void setEndtime(Ctime endtime) {
		this.endtime = endtime;
	}

	// get the description or title of an appointment
	public String getDescription() {
		return description;
	}

	// set the description or title of an appointment
	public void setDescription(String description) {
		this.description = description;
	}

	// displaying an appointment
	@Override    
	public String toString() {
		String dis = null;
		dis = description + " from " + begtime.toString() + " to " + endtime.toString();
		return dis;
	}
	

}
