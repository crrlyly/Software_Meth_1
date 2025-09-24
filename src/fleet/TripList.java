package fleet;
/**
 This class creates a circularly linked list of trips.
 Additionally it inserts the trips in order of earliest end date, and can print the list/find the number of trips in the list.
 @author Alec Cotler
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
            last.next = newNode;
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
        Node head = last.next;
        Node curr = head;

        do {
            System.out.println(curr.trip);
            curr = curr.next;
        } while (curr != head);
    }

    public int getSize() {
        if (last == null) {
            return 0;
        }

        int count = 0;
        Node curr = last.next; // head

        do {
            count++;
            curr = curr.next;
        } while (curr != last.next);

        return count;
    }

    }
