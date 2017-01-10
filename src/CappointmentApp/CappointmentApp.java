package CappointmentApp;

import java.io.IOException;
import java.util.Scanner;

public class CappointmentApp {
	public static void createApp(Cschedule schedule){
		Scanner sc = new Scanner(System.in);  
		String dsc = null; // this parameter is used to receive the inputing string as description or title of an appointment.
		String time = null;                   //timeString
		int hour,min;
		int judge = 0;        // to check the validation of time
		System.out.println("Creating new appointment...");
		System.out.print("please enter description: ");
		dsc = sc.nextLine();
		
		// checking the validation of timeString
		do{
			Scanner scanner = new Scanner(System.in);
			System.out.print("please enter start time(hh:mm) : ");
			time = scanner.next();
			String[] timearray = new String[2];
			timearray = time.split(":");
			hour = Integer.parseInt(timearray[0]);
			min = Integer.parseInt(timearray[1]);
			if((hour >=0 && hour <= 23)&&(min >= 0 && min <= 59)){
				judge = 1;
			}else{
				judge = 0;
			}
		}while(judge != 1);
		Ctime begtime = new Ctime(hour,min);   //set a begin time of an appointment
	
	    //checking the validation of timeString
		do{
			Scanner scanner = new Scanner(System.in);
			System.out.print("please enter end time(hh:mm) : ");
			time = scanner.next();
			String[] timearray = new String[2];
			timearray = time.split(":");
			hour = Integer.parseInt(timearray[0]);
			min = Integer.parseInt(timearray[1]);
			if((hour >= 0 && hour <= 23)&&(min >=0 && min <= 59)){
				judge = 1;
			}else{
				judge = 0;
			}
		}while(judge != 1);
		Ctime endtime = new Ctime(hour,min);   // set an end time of an appointment
	
	    //begin time should not greater than end time
		int b = begtime.getHour() * 60 + begtime.getMin();
		int e = endtime.getHour() * 60 + endtime.getMin();
		if(b >= e){
			System.out.println("invalid appointment, conflict detected.");
			return ;
		}
		
		Cappointment app = new Cappointment(begtime,endtime,dsc);
		schedule.add(app);   // add a new appointment into the linked list
		System.out.println("new appointment created");
	}
	
	// display all the appointments
	public static void displayAll(Cschedule schedule){
		if(schedule.getListsize() == 0){
			System.out.println("you have no appointments to display");
			return ;
		}
		System.out.println("your appointments are:");
		schedule.display();
	}
	
	// deleting a sorted appointment
	public static void deleteApp(Cschedule schedule){
		if(schedule.getListsize() == 0){
			System.out.println("you have no appointments to delete");
			return ;
		}
		System.out.println("Enter the appointment number to delete:");
		schedule.display();
		Scanner sc = new Scanner(System.in);
		String index = sc.next();
		System.out.println(">>");
		schedule.delete(Integer.parseInt(index));
	}
	
	// when entering the non-existing option
	public static void errorCho(Cschedule schedule){
		System.out.println("please enter the right choice");
	}
	
	public static void main(String[] args)throws IOException {
		Cschedule schedule = new Cschedule();
		System.out.println("**My Appointment book application**");
		System.out.println("1.Create a new appointment");
		System.out.println("2.Display all appointments");
		System.out.println("3.Delete an appointment");
		System.out.println("4.Exit");
		System.out.print(">>");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int choice = Integer.parseInt(str);    //choosing an option.
	
		while(choice != 4){
			switch (choice) {
				case 1:
					createApp(schedule);
					break;
				case 2:
					displayAll(schedule);
					break;
				case 3:
					deleteApp(schedule);
					break;
				default:
					errorCho(schedule);
					break;
			}
			System.out.println("**My Appointment book application**");
			System.out.println("1.Create a new appointment");
			System.out.println("2.Display all appointments");
			System.out.println("3.Delete an appointment");
			System.out.println("4.Exit");
			System.out.print(">>");
			str = sc.next();
			choice = Integer.parseInt(str); 
		}
		System.out.println("good bye");
		
	}

}
