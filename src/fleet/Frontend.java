package fleet;
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
            } else if (!line.isEmpty()) {
                String[] parts = line.split("\\s+");
                String command = parts[0];
                if (validCommand(command)){
                    processCommand(command, parts);
                }
                else{
                    System.out.println(command + " - invalid command!");
                }
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
            default: System.out.println("Unknown command: " + cmd);
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

    private void addToFleet(String[] parts){
        if(parts.length != 5){
            System.out.println("Not a valid A command.");
            return;
        }
        Date isValidDate = new Date(parts[2]);
        if(!isValidDate.isValid()){
            System.out.println("Not a valid date.");
            return;
        }
        Make make = Make.parseMake(parts[3]);
        if(make == null){
            System.out.println("Invalid make: " + parts[3]);
            return;
        }
        int odo = Integer.parseInt(parts[4]);
        if (!isValidOdometer(odo)) {
            System.out.println("Invalid mileage");
            return;
        }
        Vehicle vehicle = new Vehicle(parts[1], isValidDate, make, odo);
        fleet.add(vehicle);
    }

    private boolean isValidOdometer(int odo) {
        try {
            return odo > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    } //not sure about this yet

    //TODO
    private void removeFromFleet(String[] parts){
        if(parts.length != 2){
            System.out.println("Not a valid A command.");
            return;
        }
        if(!reservation.contains(new Booking(null,null,null,parts[1]))){
            fleet.remove(parts[1]);
        }
        else{
            return;
        }
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

        if(!startingDate.isValid() && startingDate.toString())

    }

    //TODO
    private void cancelBooking(String[] parts){}

    //TODO
    private void returnVehicle(String[] parts){}



    private void displayVehicles(){
        fleet.printByMake();
    }

    private void displayBookings1(){
        reservation.printByVehicle();
    }

    private void displayBookings2(){
        reservation.printByDept();
    }

    private void displayCompletedTrips(){
        trip.print();
    }

}
