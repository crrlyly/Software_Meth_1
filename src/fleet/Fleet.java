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
    public void remove(String plate) {
        for(int i = 0; i < this.size; i++){
            if(this.fleet[i] != null && this.fleet[i].getPlate().equals(plate)){
                this.fleet[i] = this.fleet[size-1];
                this.fleet[size-1] = null;
                this.size -= 1;
                return;
            }
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
    //TODO
    public void printByMake() {
        //order by make and then date obtained
        //will use selection sort


    }
}
