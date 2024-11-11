// Node class to represent each element of the doubly linked list
class Node {
    int data;      // Data of the node
    Node next;     // Reference to the next node
    Node prev;     // Reference to the previous node

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// DoublyLinkedList class to represent the doubly linked list
class DoublyLinkedList {
    Node head;  // Head of the doubly linked list

    // Constructor to initialize an empty doubly linked list
    DoublyLinkedList() {
        head = null;
    }

    // Method to add a new node at the end of the list
    public void append(int data) {
        Node newNode = new Node(data);

        // If the list is empty, the new node becomes the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the end of the list
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // Insert the new node at the end and update the pointers
        last.next = newNode;
        newNode.prev = last;
    }

    // Method to delete a node by value
    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty, cannot delete.");
            return;
        }

        // Find the node to be deleted
        Node current = head;
        while (current != null && current.data != key) {
            current = current.next;
        }

        // If the node was not found
        if (current == null) {
            System.out.println("Node with value " + key + " not found.");
            return;
        }

        // If the node to be deleted is the head
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        // If the node is in the middle or end
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
    }

    // Method to print the list from the beginning to the end
    public void printListForward() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Method to print the list from the end to the beginning
    public void printListBackward() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // Traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Print the list in reverse
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Method to search for an element in the list
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to get the size of the list
    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}

// Main class to test the DoublyLinkedList
public class DoublyLinkedListExample {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Adding elements to the doubly linked list
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        // Print the list from the beginning to the end
        System.out.println("Doubly Linked List (Forward): ");
        list.printListForward();

        // Print the list from the end to the beginning
        System.out.println("Doubly Linked List (Backward): ");
        list.printListBackward();

        // Search for an element in the list
        int searchValue = 30;
        if (list.search(searchValue)) {
            System.out.println(searchValue + " is present in the list.");
        } else {
            System.out.println(searchValue + " is not present in the list.");
        }

        // Delete an element from the list
        list.delete(20);
        System.out.println("After deleting 20, Doubly Linked List (Forward): ");
        list.printListForward();

        // Get the size of the doubly linked list
        System.out.println("Size of the doubly linked list: " + list.size());
    }
}
