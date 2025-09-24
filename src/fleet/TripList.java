package fleet;
/**
 First, a single, very descriptive sentence describing the class.
 Then, additional lines of description are added to elaborate on the
 details if necessary.
 @author [insert name]
 */
public class TripList {
    private Node last; //the reference to the last node of the linked list.
    public void add(Trip trip) {
        Node newNode = new Node(trip);

        if (last == null) {
            last = newNode;
            last.next = last; // circular link
            return;
        }

        Node curr = last.next; // head
        Node prev = last;

        // If new trip ends before or equal to head trip, insert at beginning
        if (trip.getBooking().getEnd().compareTo(curr.trip.getBooking().getEnd()) <= 0) {
            newNode.next = curr;
            last.next = newNode; // new node is new head
            return;
        }

        // Traverse to find insertion point
        while (curr != last && trip.getBooking().getEnd().compareTo(curr.trip.getBooking().getEnd()) > 0) {
            prev = curr;
            curr = curr.next;
        }

        // Insert between prev and curr
        newNode.next = curr;
        prev.next = newNode;

        // If inserted after last, update last
        if (trip.getBooking().getEnd().compareTo(last.trip.getBooking().getEnd()) > 0) {
            last = newNode;
        }
    }


    public void print() {
        if (last == null) {
            System.out.println("No trips in the list.");
            return;
        }
        Node head = last.next; // first node
        Node curr = head;

        do {
            System.out.println(curr.trip); // Trip.toString() should handle formatting
            curr = curr.next;
        } while (curr != head); // stop once we've circled back
    }
    }
