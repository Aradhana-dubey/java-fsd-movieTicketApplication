package movieTicketApplication;

import java.util.*;
import java.util.Scanner;

class MovieTheatre {
	

  public String username;
    public String password;
    private Map<String, Map<String, Boolean>> seatingArrangement;

    public MovieTheatre(String username, String password) {
        this.username = username;
        this.password = password;
        this.seatingArrangement = new HashMap<>();
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password updated successfully!");
    }

    public void viewSeatingArrangement(String date, String showTime) {
        Map<String, Boolean> seats = seatingArrangement.getOrDefault(date + "_" + showTime, new HashMap<>());
        System.out.println("Seating Arrangement for " + date + " - " + showTime + ":");
        for (String seat : seats.keySet()) {
            System.out.print(seat + " ");
        }
        System.out.println();
    }

    public void bookTicket(String date, String showTime, String seatSelection) {
        Map<String, Boolean> seats = seatingArrangement.getOrDefault(date + "_" + showTime, new HashMap<>());

        String[] selectedSeats = seatSelection.split("-");
        for (String seat : selectedSeats) {
            seats.put(seat, true);
        }

        seatingArrangement.put(date + "_" + showTime, seats);
        System.out.println("Ticket booked successfully!");
    }

    public void viewBookingStatus() {
        System.out.println("Booking Status:");
        for (String show : seatingArrangement.keySet()) {
            System.out.println(show + ": " + seatingArrangement.get(show).toString());
        }
    }
}  


    public class movieTicketDemo {
    	
	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);
	        MovieTheatre movieTheatre = new MovieTheatre("Aradhana", "Abc@07");

	        // Front Desk Login
	        System.out.print("Enter username: ");
	        String usernameInput = scanner.nextLine();
	        System.out.print("Enter password: ");
	        String passwordInput = scanner.nextLine();
	        
	        if (usernameInput.equals(movieTheatre.username) && passwordInput.equals(movieTheatre.password)) {
	            System.out.println("Login successful!");
	        } else {
	            System.out.println("Invalid credentials. Exiting...");
	            
	        }

	       
	        while (true) {
	        
	            System.out.println(" *======================================* ");
	            System.out.println(" Movie Ticket Booking Application ");
	            System.out.println(" *======================================* ");
	            System.out.println("1. Update Password");
	            System.out.println("2. View Seating Arrangement");
	            System.out.println("3. Book Ticket");
	            System.out.println("4. View Booking Status");
	            System.out.println("5. Amount");
	            System.out.println("6. Exit");

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter new password: ");
	                    String newPassword = scanner.nextLine();
	                    movieTheatre.updatePassword(newPassword);
	                    break;
	                case 2:
	                    System.out.print("Enter date (DD-MM-YYYY): ");
	                    String date = scanner.nextLine();
	                    System.out.print("Enter show time: ");
	                    String showTime = scanner.nextLine();
	                    movieTheatre.viewSeatingArrangement(date, showTime);
	                    break;
	                case 3:
	                    System.out.print("Enter date (DD-MM-YYYY): ");
	                    date = scanner.nextLine();
	                    System.out.print("Enter show time: ");
	                    showTime = scanner.nextLine();
	                    System.out.print("Enter seat selection (e.g., B1 or B1-B5): ");
	                    String seatSelection = scanner.nextLine();
	                    movieTheatre.bookTicket(date, showTime, seatSelection);
	                    break;
	                case 4:
	                    movieTheatre.viewBookingStatus();
	                    break;
	                case 5:
	                    System.out.println("Amount of the ticket is rs 200");
	                    System.exit(0);
	                case 6:
	                    System.out.println("Exiting...");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            scanner.close();
	            }
	            
	        }
	}
	
  }
    
	


