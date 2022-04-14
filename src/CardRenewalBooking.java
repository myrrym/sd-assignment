import java.util.*;
import java.io.*;

class CardRenewalBooking{
    // local variables
    private int booking_ID;
    private int customer_ID;
    private String bookingStatus = "Unconfirmed";
    private String branch = "";
    private String timeSlot = "";

    CardRenewalBooking(int booking_ID, int customer_ID, String bookingStatus, String branch, String timeSlot){
        this.booking_ID = booking_ID;
        this.customer_ID = customer_ID;
        this.bookingStatus = bookingStatus;
        this.branch = branch;
        this.timeSlot = timeSlot;
    }

    public void createBooking(int customer_ID){
        // local variables
        Scanner scanner = new Scanner(System.in);
        int branchOpt = 0;
        String branch = "";
        char confirmOpt = 'a';
        String date = "";
        int detailOpt = 0;
        String timeSlot = "";
        int timeOpt;
        File bookingsFile = new File("Card-Renewal-Bookings.txt");
        ArrayList<CardRenewalBooking> cardRenewalBookings = new ArrayList<CardRenewalBooking>();
        ObjectOutputStream oos = null;
        ListIterator li = null;

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

        System.out.println("Time: (please select 1 option only)");
        try (// read time slot txt file
            Scanner fileIn = new Scanner(new File("Card-Renewal-Booking-Time-Slots.txt"))) {
            while(fileIn.hasNextLine()){
                System.out.println("-------------------------------------");
                li = cardRenewalBookings.listIterator();
                while(li.hasNext()){
                    int i = 1;
                    System.out.println("Option " + i + ":" + li.next());
                    i++;
                }
                System.out.println("-------------------------------------");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // confirm with user, if not they go back and change
        System.out.println("Below is the complete list of details:");
        System.out.println("Branch: " + branch);
        System.out.println("Date: " + date);
        System.out.println("Time: " + timeSlot);

        while ( !(confirmOpt == 'Y' || confirmOpt == 'y' || confirmOpt == 'N' || confirmOpt == 'n' )) {
            System.out.println("Confirm submit (Y/N):");
            confirmOpt = scanner.next().charAt(0);
        }

        if (confirmOpt == 'N' || confirmOpt == 'n'){
            while ( !(detailOpt == 1 || detailOpt == 2 || detailOpt == 3) ){
                System.out.println("Which detail do you want to edit?");
                System.out.println("Option 1: Branch");
                System.out.println("Option 2: Date");
                System.out.println("Option 3: Time");
                detailOpt = scanner.nextInt();
            }
        }
        else{
            // write to txt file
            try {
                oos = new ObjectOutputStream(new FileOutputStream(bookingsFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oos.writeObject(cardRenewalBookings);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // close scanner
        scanner.close();

        // no return
    }

    public void updateBookingTimeList() throws IOException{
        // local variables
        Scanner scanner = new Scanner(System.in);
        int removeAddOpt = 0;
        int slotOpt = 0;
        File timeSlotsFile = new File("Card-Renewal-Booking-Time-Slots.txt");
        ArrayList<String> timeSlots = new ArrayList<String>();
        ObjectOutputStream oos = null;
        ListIterator li = null;
        String text = "";

        // show chosen menu header
        System.out.println("--- Update Booking Time List ---\n");

        // display all time slots
        Scanner fileIn = new Scanner(new File("Card-Renewal-Booking-Time-Slots.txt"));
        while(fileIn.hasNextLine()){
            System.out.println("-------------------------------------");
            text = fileIn.nextLine();
            System.out.println(text);
            System.out.println("-------------------------------------");
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
            while ( !(slotOpt < 0) ) {
                System.out.println("Which time slot would you like to remove?");
                System.out.println("-------------------------------------");
                li = timeSlots.listIterator();
                while(li.hasNext()){
                    int i = 1;
                    System.out.println("Option " + i + ":" + li.next());
                    i++;
                }
                System.out.println("-------------------------------------");
            }
        }
        else{
            // Option 2: Add
            System.out.println("Please input a time slot (HH:mm to HH:mm):");
            String timeSlot = scanner.nextLine();

            // write to txt file
            oos = new ObjectOutputStream(new FileOutputStream(timeSlotsFile));
            oos.writeObject(timeSlot);
            oos.close();
        }

        // display new time slots
        while(fileIn.hasNextLine()){
            System.out.println("-------------------------------------");
            text = fileIn.nextLine();
            System.out.println(text);
            System.out.println("-------------------------------------");
        }

        scanner.close();
        
        // no return
    }

    // need to check this against searchBooking function
    public void updateBookingStatus() throws IOException{
        // local variables
        Scanner scanner = new Scanner(System.in);
        int statusOpt = 0;
        String bookingStatus = "Unconfirmed";
        File bookingsFile = new File("Card-Renewal-Bookings.txt");
        ObjectOutputStream oos = null;
        String text;

        // show chosen menu header
        System.out.println("--- Update Booking Status ---\n");

        // read booking txt file
        Scanner fileIn = new Scanner(new File("Card-Renewal-Booking-Time-Slots.txt"));
        while(fileIn.hasNextLine()){
            System.out.println("-------------------------------------");
            text = fileIn.nextLine();
            System.out.println(text);
            System.out.println("-------------------------------------");
        }
        
        System.out.println("Please key in the booking ID: ");
        int bookingID = scanner.nextInt();
        while(fileIn.hasNextLine()){
            if(bookingID != fileIn.nextInt()){
                fileIn.nextInt();
            }
            else{
                text = fileIn.nextLine();
                System.out.println(text);
            }
        }

        // display details of this specific booking
        System.out.println("--- Update Booking Status ---\n");

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
                this.bookingStatus = "Confirmed";
                oos = new ObjectOutputStream(new FileOutputStream(bookingsFile));
                oos.writeObject(bookingStatus);
                oos.close();
                break;
            case 2:
                bookingStatus = "Cancelled";
                oos = new ObjectOutputStream(new FileOutputStream(bookingsFile));
                oos.writeObject(bookingStatus);
                oos.close();
                break;
            case 3:
                bookingStatus = "Rescheduled";
                oos = new ObjectOutputStream(new FileOutputStream(bookingsFile));
                oos.writeObject(bookingStatus);
                oos.close();
                break;
            case 4:
                bookingStatus = "Closed";
                oos = new ObjectOutputStream(new FileOutputStream(bookingsFile));
                oos.writeObject(bookingStatus);
                oos.close();
                break;
            default:
            System.out.println("Error: statusOpt switch case");
                break;
        }

        scanner.close();

        // no return
    }
}