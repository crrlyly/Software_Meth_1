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
     * constructor of a booking with just a vehicle
     *
     * @param vehicle
     */
    public Booking(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * constructor of a booking with the same beginning and ending date, and a vehicle
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
     * constructor of a booking with a beginning date, end date, and vehicle
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
     * constructor of a booking with a beginning date, end date, vehicle, and employee
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

    /**
     * returns the beginning date of the booking
     *
     * @return begin the beginning date of the booking
     */
    public Date getBegin() {
        return begin;
    }

    /**
     * returns the ending date of the booking
     *
     * @return end the ending date of the booking
     */
    public Date getEnd() {
        return end;
    }

    /**
     * returns the employee associated with the booking
     *
     * @return employee the employee in the booking
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * returns the vehicle associated with the booking
     *
     * @return vehicle the vehicle in the booking
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * tests if two bookings with beginning dates, ending dates, and a vehicle are equal to each other
     *
     * @param obj   the reference object with which to compare.
     * @return true if the bookings are the same as each other, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Booking other = (Booking) obj;
        return begin.equals(other.begin) && end.equals(other.end) && vehicle.equals(other.vehicle);
    }

    /**
     * the string representation of a booking
     *
     * @return the string representation of a booking
     */
    @Override
    public String toString() {
        return this.vehicle.toString() + " [beginning " + this.begin.toString() + " ending "
                + this.end.toString() +":" + this.employee + "]";
    }

    /**
     * tests if two bookings with no beginning dates are equal
     *
     * @param booking the booking being compared to
     * @return true if the bookings are equal, false if they are not
     */
    public boolean equalsNoBeginDate(Booking booking){
        return this.end.equals(booking.end) && this.vehicle.equals(booking.vehicle);
    }

    /**
     * tests if two bookings with no beginning or end dates are equal
     *
     * @param booking the booking being compared to
     * @return true if the bookings are equal, false if not
     */
    public boolean equalsNoDate(Booking booking){
        return this.vehicle.equals(booking.vehicle);
    }
}
