package fleet;
/**
 * Description
 *
 * @author Alec Cotler
 */
public class Node {

    public Trip trip;
    public Node next;

    /**
     *
     * @param trip
     */
    public Node(Trip trip) {
        this.trip = trip;
        this.next = null;
    }
}

