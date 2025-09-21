package fleet;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Calendar;
/**
 First, a single, very descriptive sentence describing the class.
 Then, additional lines of description are added to elaborate on the
 details if necessary.
 @author Carly Chick
 */
public class Frontend {
    private boolean running = true;
    private static final String[] commands = {
            "L", "A", "D", "B", "C", "R", "PF", "PR", "PD", "PT"
    };
    private final Fleet fleet = new Fleet();
    private final Reservation reservation = new Reservation();
    private final TripList trip = new TripList();

    public void run() {
        System.out.println("Vehicle Management System is running.");
        Scanner sc = new Scanner(System.in);
        while (running) {
            if (!sc.hasNextLine()) break;
            String line = sc.nextLine().trim();
            if (line.equals("Q")) {
                terminate();
                return;
            } else if (!line.isEmpty()) {
                String[] parts = line.split("\\s+");
                String command = parts[0];
                processCommand(command, parts);

            }
        }
        sc.close();
    }


    private void terminate(){
        System.out.println("Vehicle Management System is terminated.");
        running = false;
    }
    private void processCommand(String cmd, String[] parts) {
        switch(cmd){
            case "L": break;
            case "A": addToFleet(parts); break;
            case "D": removeFromFleet(parts); break;
            case "B": bookVehicle(parts); break;
            case "C": cancelBooking(parts); break;
            case "R": returnVehicle(parts); break;
            case "PF": displayVehicles(); break;
            case "PR": displayBookings1(); break;
            case "PD": displayBookings2(); break;
            case "PT": displayCompletedTrips(); break;
            default: System.out.println(cmd + " - invalid command!");
        }
    }
    private boolean validCommand(String inputCommand){
        for(int i = 0; i < commands.length; i++){
            if(inputCommand.equals(commands[i])){
                return true;
            }
        }
        return false;
    }

    //finished
    private void addToFleet(String[] parts){
        if(parts.length != 5){
            System.out.println("Not a valid A command.");
            return;
        }
        Date isValidDate = new Date(parts[2]);
        Date today = getToday();
        if(!isValidDate.isValid()){
            System.out.println(parts[2] + " - invalid calendar date.");
            return;
        }
        else if(isValidDate.compareTo(today) >= 0){
            System.out.println(parts[2] + " - is today or a future date.");
            return;
        }
        Make make = Make.parseMake(parts[3]);
        if(make == null){
            System.out.println(parts[3] + " - invalid make.");
            return;
        }
        int odo = Integer.parseInt(parts[4]);
        if (!isValidOdometer(odo)) {
            System.out.println(parts[4] + " - invalid mileage.");
            return;
        }
        Vehicle vehicle = new Vehicle(parts[1], isValidDate, make, odo);
        fleet.add(vehicle);
        System.out.println(vehicle.toString() + " has been added to the fleet.");
    }
    private Date getToday(){
        Calendar calendar = Calendar.getInstance();
        String todayString = (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.YEAR);
        return new Date(todayString);
    }
    private boolean isValidOdometer(int odo) {
        try {
            return odo > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    } //not sure about this yet

    //finished
    private void removeFromFleet(String[] parts){
        if(parts.length != 2){
            System.out.println("Not a valid A command.");
            return;
        }
        Vehicle vehicle = new Vehicle(parts[1]);
        if(!fleet.contains(vehicle)){
            System.out.println(vehicle.getPlate() + " is not in the fleet.");
            return;
        }
        Booking booking = new Booking(vehicle);
        if(reservation.contains(booking)){
            System.out.println(vehicle.getPlate() + " - has existing bookings; cannot be removed.");
            return;
        }
        Vehicle getOriginalVehicle = fleet.getVehicle(vehicle);
        System.out.println(getOriginalVehicle.toString() + " has been removed from the fleet.");
        fleet.remove(vehicle);
    }

    //TODO
    private void bookVehicle(String[] parts){
        if(parts.length != 5){
            System.out.println("Not a valid A command.");
            return;
        }
        //check if valid calendar date, today, or in the future
        Date startingDate = new Date(parts[1]);
        Date endingDate = new Date(parts[2]);

        //if starting date is beyond 3 months from today, then stop


    }
    //TODO
    private void checkValidBookingDates(Date startingDate, Date endingDate){

//        if(!startingDate.isValid() && startingDate.toString())

    }
    //TODO
    private void cancelBooking(String[] parts){}

    //TODO
    private void returnVehicle(String[] parts){}

    //finished
    private void displayVehicles(){
        if(this.fleet.getSize() == 0){
            System.out.println("There is no vehicle in the fleet.");
            return;
        }
        System.out.println("*List of vehicles in the fleet, ordered by make and date obtained.");
        fleet.printByMake();
        System.out.println("*end of list.");
    }

    private void displayBookings1(){
        if(this.reservation.getSize() == 0){
            System.out.println("There is no booking record.");
            return;
        }
//      reservation.printByVehicle();
    }

    private void displayBookings2(){
        if(this.reservation.getSize() == 0){
            System.out.println("There is no booking record.");
            return;
        }
//      reservation.printByDept();
    }

    private void displayCompletedTrips(){

//      trip.print();
    }

}
