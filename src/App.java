public class App {
    public static void main(String[] args) throws Exception {
        
        int customer_ID = 0;

        CardRenewalBooking.createBooking(customer_ID);
        CardRenewalBooking.updateBookingTimeList();
        CardRenewalBooking.updateBookingStatus();
    }
}
