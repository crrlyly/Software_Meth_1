package fleet;

public class Vehicle implements Comparable<Vehicle> {
    private String plate;   // license plate number
    private Date obtained;
    private Make make;      // Make is an enum class
    private int mileage;    // current reading on the odometer

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
    public String toString() {
        return this.plate + ":" + this.make + " [mileage:" + this.mileage + "]";
    }

    @Override
    public int compareTo(Vehicle other) {
        if (other == null) {
            throw new NullPointerException("Cannot compare to null Vehicle");
        }
        return this.plate.compareTo(other.plate);
    }

    // Testbed main
    public static void main(String[] args) {
        testTwoVehiclesEqual();
    }

    /**
     * Testing out the equals method with two identical Vehicle objects
     */
    private static void testTwoVehiclesEqual() {
        Vehicle one = new Vehicle("192837D", null, Make.CHEVY, 38);
        Vehicle two = new Vehicle("192837D", null, Make.CHEVY, 38);

        boolean expectedOutput = true;
        boolean actualOutput = one.equals(two);
        System.out.println("**Test case 1: Testing two same vehicles");
        testResult(one, two, expectedOutput, actualOutput);
    }

    private static void testResult(Vehicle one, Vehicle two, boolean expectedOutput, boolean actualOutput) {
        System.out.println("Test input: " + one + " and " + two);
        System.out.println("Expected output: " + expectedOutput);
        System.out.println("Actual output: " + actualOutput);
        System.out.println(expectedOutput != actualOutput ? " (FAIL)\n" : " (PASS)\n");
    }
}
