class Node {
    int data;
    Node next;

    // Constructor to initialize a node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node curr = head;

        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }
    public void insertAtPostion(int data,int pos) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
        }
        Node curr = head;

        for(int i=1;i<pos-1;i++){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;

    }


     // Method to display the linked list
     public void display() {
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

    //delete Opertion
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    public void deleteAtend() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next = null;
    }

    public void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (pos == 0) {
           head = head.next;
        }
        Node curr = head;

        for(int i=1;i<pos-1;i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
    }





    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtPostion(50,3);

        System.out.println("Linked List after insertions:");
        list.display();

        list.deleteFirst();
        list.display();
        System.out.println("Linked List after First:");
        list.display();

        list.deleteAtend();
        System.out.println("Linked List after last:");
        list.display();

        list.deleteAtPosition(0);
        list.display();

        // list.deleteByValue(50); // Attempting to delete a non-existent value
    }
}