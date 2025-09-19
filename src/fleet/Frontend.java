package fleet;
import java.util.Objects;
import java.util.Scanner;
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
                    processCommand(command);
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
    private void processCommand(String cmd) {
        //function to call commands based on parameters
//        switch(cmd){
//            case "L":
//                break;
//            case "A":
//                break;
//            case "D":
//                break;
//            case "B":
//                break;
//            case "C":
//                break;
//            case "R":
//                break;
//            case "PF":
//                break;
//            case "PR":
//                break;
//            case "PD":
//                break;
//            case "PT":
//                break;
//            default:
//                System.out.println("Unknown command: " + command);
//        }
    }
    private boolean validCommand(String inputCommand){
        for(int i = 0; i < commands.length; i++){
            if(inputCommand.equals(commands[i])){
                return true;
            }
        }
        return false;
    }

}
