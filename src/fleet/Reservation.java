package fleet;
/**
 This class creates an array of bookings, where if the array is full adds 4 more spaces to the array
 Then, additional lines of description are added to elaborate on the
 details if necessary.
 @author Alec Cotler
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

    public int getSize() {
        return size;
    }

    public Booking[] getBookings() {
        return bookings;
    }

    //search for the given booking and return index, -1 if the booking is not in the reservation.
    private int find(Booking booking) {
        if (booking == null) {
            return NOT_FOUND;
        }
        for (int i = 0; i < size; i++) {
            if (bookings[i].equals(booking)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    //resize the array (add 4 spots)
    private void grow() {

        Booking[] newBookings = new Booking[this.bookings.length + growSize];
        for (int i = 0; i < this.bookings.length; i++) {
            newBookings[i] = this.bookings[i]; // copy over each element
        }
        this.bookings = newBookings;
    }

    //add booking to end of array
    public void add(Booking booking) {
        if (booking == null) {
            return;
        }
        if (contains(booking)) {
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
        if (contains(booking)) {
            bookingIndex = find(booking);
        } else return;

        this.bookings[bookingIndex] = bookings[size - 1];
        this.bookings[size - 1] = null;
        size--;
    } //overwrite with last element

    public boolean contains(Booking booking) {
        int index = find(booking);
        if (index == NOT_FOUND) {
            return false;
        }
        return true;
    }

    public void printByVehicle() {
        sortByPlateThenDate();
        for (int i = 0; i < size; i++) {
            System.out.println(bookings[i]);
        }

    } //ordered by plate then beginning date

    public void printByDept() {
        sortByDeptThenEmployee();
        Department dept = bookings[0].getEmployee().getDept();
        System.out.println("--" + dept.convertToWords() + "--");
        for (int i = 0; i < size; i++) {
            if(!dept.name().equals(bookings[i].getEmployee().getDept().name())){
                dept = bookings[i].getEmployee().getDept();
                System.out.println("--" + dept.convertToWords() + "--");
            }
            System.out.println(bookings[i]);
        }
    } //ordered by department then by employee

    public void sortByPlateThenDate() {
        for (int i = 1; i < size; i++) {
            Booking key = bookings[i];
            int index = i - 1;

            while (index >= 0 && (
                    // compare plate alphabetically
                    bookings[index].getVehicle().getPlate().compareTo(key.getVehicle().getPlate()) > 0 ||

                            // if plates are equal, compare by beginDate
                            (bookings[index].getVehicle().getPlate().equals(key.getVehicle().getPlate()) &&
                                    bookings[index].getBegin().compareTo(key.getBegin()) > 0)
            )) {
                bookings[index + 1] = bookings[index];
                index--;
            }
            bookings[index + 1] = key;
        }
    }

    public void sortByDeptThenEmployee() {
        for (int i = 1; i < size; i++) {
            Booking key = bookings[i];
            int index = i - 1;
            while (index >= 0 && (
                    // compare department alphabetically
                    bookings[index].getEmployee().getDept().name().compareTo(key.getEmployee().getDept().name()) > 0 ||

                            // if departments are equal, compare employees alphabetically by name
                            (bookings[index].getEmployee().getDept().name().equals(key.getEmployee().getDept().name()) &&
                                    bookings[index].getEmployee().name().compareTo(key.getEmployee().name()) > 0)
            )) {
                bookings[index + 1] = bookings[index];
                index--;
            }
            bookings[index + 1] = key;
        }
    }

    public Booking bookingLookup(Booking booking) {
        if(booking == null){
            return null;
        }
        int index = find(booking);
        if(index == -1){
            return null;
        }
        return bookings[index];
    }

    public boolean findInstanceOfVehicle(Booking booking){
        if (booking == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (bookings[i].equalsNoBeginDate(booking)) {
                return true;
            }
        }
        return false;
    }

    public boolean findInstanceOfVehicleOnlyPlate(Booking booking){
        if (booking == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (bookings[i].equalsNoDate(booking)) {
                return true;
            }
        }
        return false;
    }
}





    //please refer to my removeFromFleet method in Frontend to see what im doing for reservation and create the
    //.contains method according to that

    //also use my .equals method in Vehicle class for it but u prob already knew that

