package fleet;
/**
 * A dynamic array–backed collection of Vehicle objects that supports
 * add, remove, lookup, and a utility print sorted by make (then obtained date).
 * Capacity grows in fixed increments as elements are added.
 *
 * @author Carly Chick
 */
public class Fleet {
    private static final int CAPACITY = 4;
    private static final int NOT_FOUND = -1;
    private Vehicle[] fleet;
    private int size;

    /**
     * Creates an empty fleet with an initial capacity of 4.
     */
    public Fleet() {
        this.fleet = new Vehicle[CAPACITY];
        this.size = 0;
    }

    /**
     * Finds the position of a vehicle in the fleet array.
     *
     * @param vehicle the vehicle to look for
     * @return the index of the vehicle if found; -1 if not found
     */
    private int find(Vehicle vehicle) {
        if(vehicle == null){
            return NOT_FOUND;
        }
        for(int i = 0; i < this.size; i++){
            if(vehicle.equals(this.fleet[i])){
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * Increases the size of the fleet array by 4.
     */
    private void grow() {
        Vehicle[] newArray = new Vehicle[this.fleet.length + CAPACITY];
        for(int i = 0; i < size; i++){
            newArray[i] = this.fleet[i];
        }
        this.fleet = newArray;
    }

    /**
     * Adds a vehicle to the fleet if it is not null and not already present.
     * Expands the array if there is no room left.
     *
     * @param vehicle the vehicle to add
     */
    public void add(Vehicle vehicle) {
        if(vehicle == null){
            return;
        }
        if(contains(vehicle)){
            return;
        }
        if(size == fleet.length){
            grow();
        }
        this.fleet[size++] = vehicle;
    }

    /**
     *  Removes a vehicle from the fleet if it exists.
     *  The last vehicle in the array is moved into the removed spot.
     *
     * @param vehicle the vehicle to remove
     */
    public void remove(Vehicle vehicle) {
        int index = find(vehicle);
        if(index != -1){
            this.fleet[index] = this.fleet[size-1];
            this.fleet[size-1] = null;
            this.size -= 1;
        }
    }

    /**
     * Checks whether a given vehicle is already in the fleet.
     *
     * @param vehicle the vehicle to check
     * @return true if the vehicle is found; false otherwise
     */
    public boolean contains(Vehicle vehicle) {
        for(int i = 0; i < this.size; i++){
            if(this.fleet[i] != null && this.fleet[i].equals(vehicle)){
               return true;
            }
        }
        return false;
    }

    /**
     * Prints all vehicles in the fleet in order by make and obtained date.
     * Sorting is done using a simple selection sort algorithm.
     */
    public void printByMake() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (fleet[j].compareTo(fleet[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Vehicle temp = fleet[i];
            fleet[i] = fleet[minIndex];
            fleet[minIndex] = temp;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(fleet[i]);
        }
    }

    /**
     * Returns the vehicle in the fleet equal to the given one.
     *
     * @param vehicle the vehicle to search for
     * @return the stored vehicle if found; null if not found
     */
    public Vehicle getVehicle(Vehicle vehicle) {
        if(vehicle == null){
            return null;
        }
        int index = find(vehicle);
        if(index == -1){
            return null;
        }
        return fleet[index];
    }

    public int getSize() {
        return size;
    }

}
