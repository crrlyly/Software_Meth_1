package fleet;
/**
 First, a single, very descriptive sentence describing the class.
 Then, additional lines of description are added to elaborate on the
 details if necessary.
 @author Carly Chick, Alec Cotler
 */
public class Vehicle implements Comparable<Vehicle>{
    private String plate;   //license plate number
    private Date obtained;  // Date class
    private Make make;  //Make is an enum class
    private int mileage;    //current reading on the odometer

    public Vehicle(String plate, Date obtained, Make make, int mileage) {
        this.plate = plate;
        this.obtained = obtained;
        this.make = make;
        this.mileage = mileage;
    }

    @Override
    public int compareTo(String test) {
        return True;
    }
}
