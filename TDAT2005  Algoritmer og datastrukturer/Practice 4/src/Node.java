public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class CircularList {
    private int size = 0;
    // "First" item in list
    private Node head = null;
    // "Last" item in list
    private Node tail = null;

    // Add new node at the end of the list
    public void add(int data) {
        // Create a new node
        Node node = new Node(data);

        // Check if list is empty
        if (head == null) {
            head = node;
            tail = node;
            node.next = head;
        } else {
            tail.next = node;
            tail = node;

            // Circular lists will have the tail pointing to the head
            tail.next = head;
        }
        size++;
    }

    // Remove an node in the list
    public void remove(int index) {
        // Error check
        if (head == null || index >= size || index < 0) return;

        Node previous = tail;
        Node current = head;

        int count = 0;
        int len = size;

        if (index == 0) {
            head = current.next;
            previous.next = head;
            size--;
            return;
        }

        while (len > 0) {
            // Delete node if index found
            if (index == count) {
                previous.next = current.next;
                size--;
                return;
            }

            previous = previous.next;
            current = previous.next;
            len--;
            count++;
        }
    }

    public void printList() {
        Node current = head;

        // Check if list is empty
        if (head == null) {
            System.out.println("List is empty");
        } else {
            System.out.println("Nodes in circular list: ");

            // Go through the list until the "circle is complete"
            do {
                System.out.print(" " + current.data);
                current = current.next;
            } while (current != head) ;

            System.out.println();
        }
    }

    public int getSize() { return size; }
    public Node getFirstNode() { return head; }

    public static void main(String[] args) {
        CircularList list = new CircularList();
        list.add(0);
        list.add(1);
        list.add(4);
        list.printList();

        list.remove(1);
        list.printList();
    }
}


class Josephus {
    private CircularList list = new CircularList();

    // Create a circular list with specified amount of nodes / "soldiers"
    public Josephus(int amount) {
        for (int i = 1; i < amount; i++) {
            list.add(i);
        }
    }

    public int bestPosition(int interval) {
        int currentIndex = 0;

        while (list.getSize() > 1) {
            list.printList();

            int index = findIndex(interval, currentIndex);
            list.remove(index);
            currentIndex = index;
        }

        // Return the value of the last node
        return list.getFirstNode().data;
    }

    public int bestPosition2(int interval) {
        // Find node
        int count = 1;
        while (count != index) {
            count++;
        }
    }

    private int findIndex(int interval, int currentIndex) {
        if (currentIndex + interval < list.getSize())
            return currentIndex + interval;

        int index = currentIndex + interval;
        while (index >= list.getSize()) {
            index = index - list.getSize();
        }

        return index;
    }

    public static void main(String[] args) {
        Josephus test = new Josephus(10);
        int best = test.bestPosition(4);

        System.out.println("Best position: " + best);

        test.list.printList();
//        System.out.println("index: " + test.findIndex(3, 10));
//        test.list.remove(0);
//        test.list.printList();
//        System.out.println("size: " + test.list.getSize());
    }
}

