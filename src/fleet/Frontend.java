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
    private final TripList tripList = new TripList();

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
    }

    private Calendar convertDateToCalendar(Date obj){
        int month = obj.getMonth() - 1;
        int day  = obj.getDay();
        int year = obj.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    private boolean overSevenDays(Date startingDate, Date endingDate){
        Calendar startingCal = convertDateToCalendar(startingDate);
        Calendar endingCal = convertDateToCalendar(endingDate);

        long diffMillis = endingCal.getTimeInMillis() - startingCal.getTimeInMillis();
        long diffDays = diffMillis / (1000 * 60 * 60 * 24);
        return diffDays > 7;
    }

    private Date getThreeMonthsFromToday(){
        Calendar calendar = Calendar.getInstance(); // today
        calendar.add(Calendar.MONTH, 3); // add 3 months
        String threeMonthsLater = (calendar.get(Calendar.MONTH) + 1) + "/"
                + calendar.get(Calendar.DAY_OF_MONTH) + "/"
                + calendar.get(Calendar.YEAR);
        return new Date(threeMonthsLater);
    }

    private void moveFromReservationToTripList(Booking originalBooking, int originalMileage, int currentMileage){
        reservation.remove(originalBooking);
        originalBooking.getVehicle().setMileage(currentMileage);
        Trip trip = new Trip(originalBooking, originalMileage, currentMileage);
        TripList.add(tripList);
    }

    private int findIndexOfEarliestEndDate(Booking booking){
        Date earliest = booking.getEnd();
        int index = -1;
        for(int i = 0; i < reservation.getSize(); i++){
            if(reservation.getBookings()[i].getVehicle().equals(booking.getVehicle())){
                if(reservation.getBookings()[i].getEnd().compareTo(earliest) <= 0){
                    earliest = reservation.getBookings()[i].getEnd();
                    index = i;
                }
            }
        }
        return index;
    }

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

    //hopefully finished
    private void removeFromFleet(String[] parts){
        if(parts.length != 2){
            System.out.println("Not a valid D command.");
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
        if(parts.length != 5){ System.out.println("Not a valid B command."); return; }

        Date startingDate = new Date(parts[1]);
        Date endingDate = new Date(parts[2]);
        Date today = getToday();
        Date threeMonthsFromToday = getThreeMonthsFromToday();

        if(!startingDate.isValid()){  System.out.println(parts[1] + " - beginning date is not a valid calendar date."); return; }
        if(startingDate.compareTo(today) < 0){ System.out.println(parts[1] + " - beginning date is not today or a future date."); return; }
        if(startingDate.compareTo(threeMonthsFromToday) > 0){ System.out.println(startingDate + " - beginning date beyond 3 months."); return; }
        if(!endingDate.isValid()){ System.out.println(parts[2] + " - ending date is not a valid calendar date."); return; }
        if(endingDate.compareTo(startingDate) < 0){ System.out.println(parts[2] + " - ending date must be equal or after the beginning date " + startingDate); return; }
        if(overSevenDays(startingDate,endingDate)){ System.out.println(parts[1] + " ~ " + parts[2] + " - duration more than a week."); return; }

        Vehicle vehicle = new Vehicle(parts[3]);
        if(!fleet.contains(vehicle)){ System.out.println(vehicle.getPlate() + " is not in the fleet."); return; }

        //The vehicle associated with the plate is not available for the dates entered TODO

        //The employee is not eligible to book a vehicle TODO

        //The employee has an existing booking conflicting with the dates entered TODO
    }

    //TODO
    private void checkValidBookingDates(Date startingDate, Date endingDate){

//        if(!startingDate.isValid() && startingDate.toString())

    }

    //hopefully finished
    private void cancelBooking(String[] parts){
        if(parts.length != 4){ System.out.println("Not a valid B command."); return; }
        Booking booking = new Booking(new Date(parts[1]),new Date(parts[2]),new Vehicle(parts[3]));

        //check if this booking exists in the list of bookings
        if(!reservation.contains(booking)){
            System.out.println();
            return;
        }
        Booking getOriginalBooking = reservation.bookingLookup(booking);
        System.out.println(getOriginalBooking.getVehicle().toString() + " has been removed from the fleet.");
        reservation.remove(booking);
    }

    //hopefully finished
    private void returnVehicle(String[] parts){
        if(parts.length != 4){
            System.out.println("Not a valid R command.");
            return;
        }
        Booking booking = new Booking(new Date(parts[1]), new Vehicle(parts[2]));
        if(!reservation.findInstanceOfVehicle(booking)){
            System.out.println(parts[2] + " booked with ending date " + parts[1] + " - cannot find the booking.");
            return;
        }
        int index = findIndexOfEarliestEndDate(booking);
        if(index == -1){
            System.out.println("Not Found");
            return;
        }
        if(reservation.getBookings()[index].getEnd() != booking.getEnd()){
            System.out.println("Not earliest end date");
            return;
        }
        int currentMileage = Integer.parseInt(parts[3]);
        if (!isValidOdometer(currentMileage)) {
            System.out.println(parts[3] + " - invalid mileage.");
            return;
        }
        Booking originalBooking = reservation.getBookings()[index];
        int originalMileage = originalBooking.getVehicle().getMileage();
        if(currentMileage <= originalMileage){
            System.out.println("");
            return;
        }
        moveFromReservationToTripList(originalBooking, originalMileage, currentMileage);
    }

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
        System.out.println("*List of reservations ordered by license plate number and beginning date.");
        reservation.printByVehicle();
        System.out.println("*end of list.");
    }

    private void displayBookings2(){
        if(this.reservation.getSize() == 0){
            System.out.println("There is no booking record.");
            return;
        }
        System.out.println("*List of reservations ordered by department and employee.");
        reservation.printByDept();
        System.out.println("*end of list.");
    }


    private void displayCompletedTrips(){
        System.out.println("*List of completed trips ordered by ending date.");
        tripList.print();
        System.out.println("*end of list.");
    }

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
}
