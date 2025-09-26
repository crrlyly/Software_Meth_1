package fleet;
/**
 * This class implements bookings for the fleet including an equals and toString method.
 *
 * @author Alec Cotler
 */
public class Booking {
    private Date begin;
    private Date end;
    private Employee employee;
    private Vehicle vehicle;

    /**
     *
     * @param vehicle
     */
    public Booking(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     *
     * @param end
     * @param vehicle
     */
    public Booking(Date end, Vehicle vehicle){
        this.begin = end;
        this.end = end;
        this.vehicle = vehicle;
    }

    /**
     *
     * @param begin
     * @param end
     * @param vehicle
     */
    public Booking(Date begin, Date end, Vehicle vehicle){
        this.begin = begin;
        this.end = end;
        this.vehicle = vehicle;
    }

    /**
     *
     * @param begin
     * @param end
     * @param employee
     * @param vehicle
     */
    public Booking(Date begin, Date end, Employee employee, Vehicle vehicle) {
        this.begin = begin;
        this.end = end;
        this.employee = employee;
        this.vehicle = vehicle;
    }

    // returns the beginning date of the booking
    public Date getBegin() {
        return begin;
    }

    // returns the ending date of the booking
    public Date getEnd() {
        return end;
    }

    // returns the employee associated with the booking
    public Employee getEmployee() {
        return employee;
    }

    // returns the vehicle associated with the booking
    public Vehicle getVehicle() {
        return vehicle;
    }

    // tests if two bookings with beginning dates, ending dates, and a vehicle are equal to each other
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Booking other = (Booking) obj;
        return begin.equals(other.begin) && end.equals(other.end) && vehicle.equals(other.vehicle);
    }

    // returns the string representation of a booking
    @Override
    public String toString() {
        return this.vehicle.toString() + " [beginning " + this.begin.toString() + " ending "
                + this.end.toString() +":" + this.employee + "]";
    }

    //tests if two bookings with no beginning dates are equal
    public boolean equalsNoBeginDate(Booking booking){
        return this.end.equals(booking.end) && this.vehicle.equals(booking.vehicle);
    }

    // tests if two bookings with no beginning or end dates are equal
    public boolean equalsNoDate(Booking booking){
        return this.vehicle.equals(booking.vehicle);
    }
}
