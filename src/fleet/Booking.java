package fleet;
/**
 This class implements bookings for the fleet including an equals and toString method.

 @author Alec Cotler
 */
public class Booking {
    private Date begin;
    private Date end;
    private Employee employee;
    private Vehicle vehicle;

    public Booking(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Booking(Date end, Vehicle vehicle){
        this.begin = end;
        this.end = end;
        this.vehicle = vehicle;
    }

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

    public Date getBegin() {
        return begin;
    }

    public Date getEnd() {
        return end;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Booking other = (Booking) obj;
        return begin.equals(other.begin) && end.equals(other.end) && vehicle.equals(other.vehicle);
    }

    @Override
    public String toString() {
        return this.vehicle.toString() + " [beginning " + this.begin.toString() + " ending "
                + this.end.toString() +":" + this.employee + "]";
    }

    public boolean equalsNoBeginDate(Booking booking){
        return this.end.equals(booking.end) && this.vehicle.equals(booking.vehicle);
    }

    public boolean equalsNoDate(Booking booking){
        return this.vehicle.equals(booking.vehicle);
    }


    //make sure to add another constructor that only holds the vehicle (nothing else) cuz i fear i need that
}
