class Node {
    int data;
    Node next;
    Node prev;

    // Constructor to initialize a node
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Insert at a specific position
    public void insertAtPosition(int data, int position) {
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
        } else {
            newNode.next = current.next;
            newNode.prev = current;

            if (current.next != null) {
                current.next.prev = newNode;
            }

            current.next = newNode;

            if (newNode.next == null) { // If inserted at the end
                tail = newNode;
            }
        }
    }

    // Delete from the beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete from the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Delete from a specific position
    public void deleteFromPosition(int position) {
        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
        } else {
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }

            if (current == tail) {
                tail = current.prev;
            }

            if (current == head) {
                head = current.next;
            }
        }
    }

    // Traverse forward
    public void traverseForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Traverse backward
    public void traverseBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Main method to test the operations
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insertion
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtBeginning(5);
        dll.insertAtPosition(15, 3);

        // Display forward and backward
        System.out.println("Forward Traversal:");
        dll.traverseForward();

        System.out.println("Backward Traversal:");
        dll.traverseBackward();

        // Deletion
        dll.deleteFromBeginning();
        dll.deleteFromEnd();
        dll.deleteFromPosition(2);

        // Display forward and backward after deletion
        System.out.println("Forward Traversal after deletion:");
        dll.traverseForward();

        System.out.println("Backward Traversal after deletion:");
        dll.traverseBackward();
    }
}
