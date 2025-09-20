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

        //search for the given booking and return index
        private int find(Booking booking) {


        }

        //resize the array (add 4 spots)
        private void grow() {

        }

        //add booking to end of array
        public void add(Booking booking) {

        }


        public void remove(Booking booking) {} //overwrite with last element
        public boolean contains(Booking booking) {}
        public void printByVehicle(){} //ordered by plate then beginning date
        public void printByDept() {} //ordered by department then by employee
    }




    //please refer to my removeFromFleet method in Frontend to see what im doing for reservation and create the
    //.contains method according to that

    //also use my .equals method in Vehicle class for it but u prob already knew that

