package fleet;
/**
 First, a single, very descriptive sentence describing the class.
 Then, additional lines of description are added to elaborate on the
 details if necessary.
 @author [insert name]
 */
    public class Reservation {
        private Booking[] bookings;
        private int size;
        private final int initialArraySize = 4;
        private final int NOT_FOUND = -1;
        private final int growSize = 4;

    public Reservation() {
        this.size = 0;
        this.bookings = new Booking[initialArraySize];
    }



    //search for the given booking and return index, -1 if the booking is not in the reservation.
        private int find(Booking booking) {
        if (booking == null){
            return NOT_FOUND;
        }
        for(int i =0; i<size; i++){
            if (bookings[i].equals(booking)){
                return i;
            }
        }
        return NOT_FOUND;
        }

        //resize the array (add 4 spots)
        private void grow() {

            Booking[] newBookings = new Booking[this.bookings.length+growSize];
            for (int i = 0; i < this.bookings.length; i++) {
                newBookings[i] = this.bookings[i]; // copy over each element
                }
            this.bookings = newBookings;
        }

        //add booking to end of array
        public void add(Booking booking) {
            if(booking == null){
                return;
            }
            if(contains(booking)){
                return;
            }
            if (this.size == this.bookings.length) {
                this.grow();
            }
            this.bookings[this.size] = booking;
            size++;
        }


        public void remove(Booking booking) {
        int bookingIndex = NOT_FOUND;
        if (contains(booking)){
            bookingIndex = find(booking);
            }
        else return;

        this.bookings[bookingIndex]=bookings[size-1];
        this.bookings[size-1] = null;
        size--;
    } //overwrite with last element

    public boolean contains(Booking booking) {
        int index = find(booking);
        if (index == NOT_FOUND) {
            return false;
        }
        return true;
        }

        public void printByVehicle(){} //ordered by plate then beginning date
        public void printByDept() {} //ordered by department then by employee
    }




    //please refer to my removeFromFleet method in Frontend to see what im doing for reservation and create the
    //.contains method according to that

    //also use my .equals method in Vehicle class for it but u prob already knew that

