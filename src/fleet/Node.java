package fleet;
/**
 * Description
 *
 * @author Alec Cotler
 */
public class Node {

    Trip trip;
    Node next;

    public Node(Trip trip) {
        this.trip = trip;
        this.next = null;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

