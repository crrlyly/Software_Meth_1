package fleet;
/**
 * Represents a vehicle with a license plate, obtained date, make, and mileage,
 * Also has methods for comparison, equality checks, and string representation.
 *
 * @author Carly Chick
 */
public class Vehicle implements Comparable<Vehicle> {
    private String plate;
    private Date obtained;
    private Make make;
    private int mileage;

    /**
     * Creates a Vehicle with the specified license plate.
     *
     * @param plate the license plate identifier for the vehicle
     */
    public Vehicle(String plate) {
        this.plate = plate;
    }

    /**
     * Creates a Vehicle with the specified license plate, obtained date, make, and mileage.
     *
     * @param plate the license plate identifier for the vehicle
     * @param obtained the date the vehicle was acquired
     * @param make the manufacturer or brand of the vehicle
     * @param mileage the mileage (in miles) recorded for the vehicle
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
        return this.plate != null && this.plate.equals(other.plate);
    }

    @Override
    public String toString() {
        return this.plate + ":" + this.make + ":" + this.obtained + " [mileage:" + this.mileage + "]";
    }

    @Override
    public int compareTo(Vehicle other) {
        if (other == null) {
            throw new NullPointerException("Cannot compare to null Vehicle");
        }

        int byMake = Make.compareStringsIgnoreCase(this.getMake().name(), other.getMake().name());
        if (byMake != 0) {
            return byMake < 0 ? -1 : 1;
        }

        int byDate = this.getObtained().compareTo(other.getObtained());
        if (byDate != 0) {
            return byDate < 0 ? -1 : 1;
        }

        return 0;
    }

    public String getPlate() {
        return plate;
    }

    public Date getObtained() {
        return obtained;
    }

    public Make getMake() {
        return make;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }


    public static void main(String[] args) {
        testVehiclesEqual();
        testVehiclesSameMakeEarlierThis();
        testVehiclesDiffMakesBiggerThis();
    }

    private static void testVehiclesEqual() {
        Vehicle one = new Vehicle("192837D", new Date("1/15/2008"), Make.CHEVY, 38);
        Vehicle two = new Vehicle("192837D", new Date("1/15/2008"), Make.CHEVY, 38);

        int expectedOutput = 0;
        int actualOutput = one.compareTo(two);
        System.out.println("**Test case 1: Testing two same vehicles");
        testResult(one, two, expectedOutput, actualOutput);
    }

    private static void testVehiclesSameMakeEarlierThis() {
        Vehicle one = new Vehicle("192437D", new Date("1/15/2008"), Make.CHEVY, 38);
        Vehicle two = new Vehicle("194837D", new Date("1/16/2008"), Make.CHEVY, 38);

        int expectedOutput = -1;
        int actualOutput = one.compareTo(two);
        System.out.println("**Test case 3: Testing two vehicles with the same make but this vehicle has an earlier date " +
                "than the vehicle that was passed in.");
        testResult(one, two, expectedOutput, actualOutput);
    }

    private static void testVehiclesDiffMakesBiggerThis() {
        Vehicle one = new Vehicle("192437D", new Date("1/15/2008"), Make.FORD, 38);
        Vehicle two = new Vehicle("194837D", new Date("1/16/2008"), Make.CHEVY, 38);

        int expectedOutput = 1;
        int actualOutput = one.compareTo(two);
        System.out.println("**Test case 4: Testing two vehicles where this vehicle has a " +
                "larger make which makes it go after the passed in vehicle.");
        testResult(one, two, expectedOutput, actualOutput);
    }

    private static void testResult(Vehicle one, Vehicle two, int expectedOutput, int actualOutput) {
        System.out.println("Test input: " + one + " and " + two);
        System.out.println("Expected output: " + expectedOutput);
        System.out.println("Actual output: " + actualOutput);
        System.out.println(expectedOutput != actualOutput ? " (FAIL)\n" : " (PASS)\n");
    }
}
