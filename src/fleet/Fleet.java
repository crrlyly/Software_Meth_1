package fleet;

import fleet.Vehicle;

/**
 First, a single, very descriptive sentence describing the class.
 Then, additional lines of description are added to elaborate on the
 details if necessary.
 @author Carly Chick
 */
public class Fleet {
    private static final int CAPACITY = 4;
    private static final int NOT_FOUND = -1;
    private Vehicle[] fleet;
    private int size;

    public Fleet() {
        this.fleet = new Vehicle[CAPACITY];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }
    /**
     *
     * @param vehicle
     * @return
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
     *
     */
    private void grow() {
        Vehicle[] newArray = new Vehicle[this.fleet.length + CAPACITY];
        for(int i = 0; i < this.size; i++){
            newArray[i] = this.fleet[i];
        }
        this.fleet = newArray;
    }

    /**
     *
     * @param vehicle
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
     *
     * @param vehicle
     */
    public void remove(Vehicle vehicle) {
        int index = find(vehicle);
        if(index != -1){
            this.fleet[index] = this.fleet[size-1];
            this.fleet[size-1] = null;
            this.size -= 1;
            return;
        }

    }

    /**
     *
     * @param vehicle
     * @return
     */
    public boolean contains(Vehicle vehicle) {
        for(int i = 0; i < this.size; i++){
            if(this.fleet[i] != null && this.fleet[i].equals(vehicle)){
               return true;
            }
        }
        return false;
    }

    public void printByMake() {
        for (int i = 0; i < fleet.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < fleet.length; j++) {
                if (fleet[j] != null && fleet[minIndex] != null) {
                    if (compareMakeDate(fleet[j],fleet[minIndex]) < 0) {
                        minIndex = j;
                    }
                }
            }
            Vehicle temp = fleet[i];
            fleet[i] = fleet[minIndex];
            fleet[minIndex] = temp;
        }
        for (Vehicle v : fleet) {
            if (v != null) {
                System.out.println(v);
            }
        }
    }

    private int compareMakeDate(Vehicle a, Vehicle b){
        if (a == null || b == null) throw new NullPointerException();
        int byMake = Make.compareStringsIgnoreCase(a.getMake().name(), b.getMake().name());
        if (byMake != 0) return byMake;
        return a.getObtained().compareTo(b.getObtained());
    }

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

}
