package CappointmentApp;

import java.util.LinkedList;  //using the data structure of linked list to link all the appointment

public class Cschedule {
	private LinkedList<Cappointment> applist = new LinkedList();  // a new list of appointments
	private int listsize;    // size of appointment linked list
	
	public Cschedule() {
		listsize = 0;
	}
	
	public int getListsize() {
		return listsize;
	}
	
	// get the appointment linked list.
	public LinkedList<Cappointment> getApplist() {
		return applist;
	}

	public void setApplist(LinkedList<Cappointment> applist) {
		this.applist = applist;
	}

	public void setListsize(int listsize) {
		this.listsize = listsize;
	}

	// adding a new appointment and check its validation
	public void add(Cappointment app){
		/*check time overlap*/
		int judge = 1;
		for(Cappointment a : applist){
			int b = a.getBegtime().getHour() * 60 + a.getBegtime().getMin();  // begin time of the first appointment
			int e = a.getEndtime().getHour() * 60 + a.getEndtime().getMin();  //end time of the first appointment
			int cb = app.getBegtime().getHour() * 60 + app.getBegtime().getMin();  // begin time of the second appointment
			int ce = app.getEndtime().getHour() * 60 + app.getEndtime().getMin();  // end time of the second appointment
			// checking the validation of the order of two appointments.
			if(((cb >= b)&&(cb <= e))||((ce > b)&&(ce <= e))){
				judge = 0;
				System.out.println("invalid appointment, conflict detected.");
				return ;
			}
		}
		//inserting sort to add app to applist
		if(judge == 1){
			if(listsize == 0){
				applist.add(app);  // add a new appointment into the appointment linked list
				listsize += 1;
				return ;
			}
			int ct = app.getBegtime().getHour() * 60 + app.getBegtime().getMin();  // getting the start time of a new appointment
			for(int i = 0; i < listsize; i++){
				int bt = applist.get(i).getBegtime().getHour() * 60 + applist.get(i).getBegtime().getMin(); // start time of one existing appointment
				// sorting the appointments
				if(ct < bt){
					applist.add(i, app);
					listsize += 1;
					return ;
				}
			}
			applist.add(app);
			listsize += 1;
		}	
	}
	// deleting a sorted appointment from the linked list
	public void delete(int i){
		if(i > listsize){
			System.out.println("No such appointment");
			return ;
		}
		applist.remove(i-1);
		listsize -= 1;
	}
	
	//display all the appointment
	public void display(){
		int i = 1;
		for(Cappointment app : applist){
			System.out.println(i + "." + app.toString());
			i++;
		}
	}
}
