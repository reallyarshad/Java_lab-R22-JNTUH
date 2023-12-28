class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void delete(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                }

                // Break the loop after deletion
                break;
            }
            current = current.next;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class DoublyLinkedListExample {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        // Insert elements into the doubly linked list
        doublyLinkedList.insert(1);
        doublyLinkedList.insert(2);
        doublyLinkedList.insert(3);
        doublyLinkedList.insert(4);
        doublyLinkedList.insert(5);

        // Display the original doubly linked list
        System.out.println("Original Doubly Linked List:");
        doublyLinkedList.display();

        // Delete a given element (e.g., 3) from the doubly linked list
        int elementToDelete = 3;
        doublyLinkedList.delete(elementToDelete);

        // Display the doubly linked list after deletion
        System.out.println("Doubly Linked List after deleting " + elementToDelete + ":");
        doublyLinkedList.display();
    }
}
