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

    /**
     *
     * @param plate
     * @param obtained
     * @param make
     * @param mileage
     */
    public Vehicle(String plate, Date obtained, Make make, int mileage) {
        this.plate = plate;
        this.obtained = obtained;
        this.make = make;
        this.mileage = mileage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Vehicle other = (Vehicle) obj;

        return plate != null && plate.equals(other.plate);
    }

    @Override
    public String toString(){
        return this.plate + ":" + this.make + ":" + this.obtained + " [mileage:" + this.mileage + "]";
    }

    @Override
    //still doing this
    public int compareTo(Vehicle other){
        if(this.plate.equals(other.plate)){
            return 0;
        }
        return -1;
    }

}
