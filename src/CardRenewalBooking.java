import java.util.*;
import java.text.SimpleDateFormat;
import java.io.File;

public class CardRenewalBooking{
    // local variables
    private int booking_ID;
    private int customer_ID;
    private String bookingStatus = "Unconfirmed";
    private String branch;
    private int time;

    public static void createBooking(int customer_ID){
        // local variables
        Scanner scanner = new Scanner(System.in);
        int branchOpt = 0;
        String branch;
        int timeOpt;

        // show chosen menu header
        System.out.println("--- Create Booking --- \n");
        
        // get input
        while ( !(branchOpt == 1 || branchOpt == 2 || branchOpt == 3) ){
            System.out.println("Branch: (please input 1 valid option number)");
            System.out.println("Option 1: Sungai Long");
            System.out.println("Option 2: Shah Alam");
            System.out.println("Option 3: Jalan Ampang");
            branchOpt = scanner.nextInt();
        }

        switch(branchOpt){
            case 1:
            branch = "Sungai Long";
            break;
            case 2:
            branch = "Shah Alam";
            break;
            case 3:
            branch = "Jalan Ampang";
            default:
            System.out.println("Error: branchOpt switch case");
            break;
        }

        System.out.println("Date (dd/MM/yyyy): ");
        String dateInput = scanner.nextLine();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateInput);

        System.out.println("Time: (please select 1 option only)");
        // read time slot txt file
        // display time slots based on date given before
        for (iterable_type iterable_element : iterable) {
            
        }

        // confirm with user, if not they go back and change
        System.out.println("Below is the complete list of details:");
        System.out.println("Branch: " + branch);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);

        System.out.println("Confirm submit (Y/N):");
        char confirmOpt = scanner.next().charAt(0);

        if (confirmOpt == 'N' || confirmOpt == 'n'){
            while ( !(confirmOpt == 1 || confirmOpt == 2 || confirmOpt == 3) ){
                System.out.println("Which detail do you want to edit?");
                System.out.println("Option 1: Branch");
                System.out.println("Option 2: Date");
                System.out.println("Option 3: Time");
                confirmOpt = scanner.nextInt();
            }
        }
        else{
            // write to txt file
    

        }

        // close scanner
        scanner.close();

        // no return
    }

    public static void updateBookingTimeList(){
        // local variables
        Scanner scanner = new Scanner(System.in);
        int removeAddOpt;

        // show chosen menu header
        System.out.println("--- Update Booking Time List ---\n");
        // read time slot txt file

        // ask for date
        System.out.println("Please input the date (dd/MM/yyyy):");
        String dateInput = scanner.nextLine();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateInput);

        // display time slots based on date given
        for (iterable_type iterable_element : iterable) {
            
        }

        // ask to remove or add
        while ( !(removeAddOpt == 1 || removeAddOpt == 2) ){
            System.out.println("Do you wish to remove or add a time slot?");
            System.out.println("Option 1: Remove");
            System.out.println("Option 2: Add");
            removeAddOpt = scanner.nextInt();
        }

        if (removeAddOpt == 1){
            // Option 1: Remove
            // while slotOpt is ! below 0 and above array length
            System.out.println("Which time slot would you like to remove?");
            for (iterable_type iterable_element : iterable) {
                System.out.println("Option " + i +": " + timeSlot[i]);
                i++;
            }
            // close while loop
        }
        else{
            // Option 12: Add
            System.out.println("Please input a time slot (HH:mm to HH:mm):");
            String timeSlot = scanner.nextLine();

            // write to txt file
        }

        // display time slots based on date given
        for (iterable_type iterable_element : iterable) {
            
        }
        
        // no return
    }

    // need to check this against searchBooking function
    public static void updateBookingStatus(){
        // local variables
        Scanner scanner = new Scanner(System.in);
        int statusOpt = 0;

        // show chosen menu header
        System.out.println("--- Update Booking Status ---\n");

        // read booking txt file

        
        System.out.println("Please key in the booking ID: ");
        int bookingID = scanner.nextInt();

        // find booking id
        // iterate through txt lines

        // display booking details (important: booking id, booking status)

        // prompt user to input booking status
        while ( !(statusOpt == 1 || statusOpt == 2 || statusOpt == 3 || statusOpt == 4) ){
            System.out.println("Please provide the new booking status:");
            System.out.println("Option 1: Confirmed");
            System.out.println("Option 2: Cancelled");
            System.out.println("Option 3: Rescheduled");
            System.out.println("Option 4: Closed");
            statusOpt = scanner.nextInt();
        }

        // write to txt file based on options given
        switch (statusOpt) {
            case 1:
                bookingStatus = "Confirmed";
                // write to file

                break;
            case 2:
                bookingStatus = "Cancelled";
                // write to file

                break;
            case 3:
                bookingStatus = "Rescheduled";
                // write to file

                break;
            case 4:
                bookingStatus = "Closed";
                // write to file

                break;
            default:
            System.out.println("Error: statusOpt switch case");
                break;
        }

        // no return
    }
}