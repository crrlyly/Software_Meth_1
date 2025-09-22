package fleet;
/**
 First, a single, very descriptive sentence describing the class.
 Then, additional lines of description are added to elaborate on the
 details if necessary.
 @author [insert name]
 */
public class Trip {
    private Booking booking;
    private int beginMileage;
    private int endMileage;

    public Booking getBooking() {
        return booking;
    }

    public int getBeginMileage() {
        return beginMileage;
    }

    public int getEndMileage() {
        return endMileage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Trip other = (Trip) obj;
        return this.booking.equals(other.booking);
    }

    @Override
    public String toString(){
        String plate = booking.getVehicle().getPlate();
        String beginDate = booking.getBegin().toString();
        String endDate = booking.getEnd().toString();
        String originalMileage = Integer.toString(beginMileage);
        String currentMileage = Integer.toString(endMileage);
        String mileageUsed = Integer.toString(endMileage - beginMileage);
        return plate + " " + beginDate + " ~ " + endDate + " original mileage: " + originalMileage
                + " current mileage: " + currentMileage + " mileage used: " + mileageUsed;
    }

}
