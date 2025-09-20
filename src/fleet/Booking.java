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

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Booking other = (Booking) obj;
        return begin == other.begin && end == other.end && employee == other.employee && vehicle == other.vehicle;
    }

    @Override
    public String toString() {
        return this.vehicle.toString() + " [beginning " + this.begin.toString() + " ending " + this.end.toString() +":" + this.employee + "]";
    }




    //make sure to add another constructor that only holds the vehicle (nothing else) cuz i fear i need that
}
