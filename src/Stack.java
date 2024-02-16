// Name: Phillip Bell
// Class: CS 3305/Section 04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: Inteli J

//class is use to make a stack to store data
public class Stack<e> {
    public Node<e> head, tail;

    // constructor method to create a list of objects with head, tail, and size.
    public Stack() {
        head = null;
        tail = null;
    }

    // pushes data on stack
    public void addLastNode(e data) {
        // if the list is empty
        if (tail == null)
            head = tail = new Node<>(data); // empty list
        else {
            tail.next = new Node<>(data); // link new node as the last node
            tail = tail.next; // make tail pointer point to the last node
        }
    }

    // method #1: add the first node
    public void addFirstNode(e data) {
        // if the list is empty
        if (tail == null) {
            head = tail = new Node<>(data); // empty list
        } else {
            Node<e> temp = new Node<>(data); // creates a temp node
            temp.next = head; // links temp node to head
            head = temp; // head is set to temp
        }
    }

    // method #2: add node at index
    public void addAtIndex(int index, e data) {
        System.out.print("\nAdding value " + data + " at the index of " + index + ".\n" +
                "List content before adding " + data + " is:\t");
        printList();
        Node<e> current = head;
        Node<e> temp = head.next;
        do {
            temp = temp.next; // moves the node up the link list
            current = current.next; // moves the node up the link list
            index--;
        } while (index != 1);

        current.next = new Node<>(data); // inserts nodes
        (current.next).next = temp; // attaches node to the next node
    }

    // method #3: remove the first node
    public void removeFirstNode() {
        // if there are more than one node
        if (head.next != null) {
            Node<e> temp = head; // creates a temp node = to head
            head = temp.next; // links head to the next node
            temp = null; // set the temp to null
        } else { // if there is only 1 node, delete the list
            head = null;
            tail = null;
        }
    }

    // method #4: remove the last node
    public void removeLastNode() {
        // if there are more than one node
        if (head.next != null) {
            Node<e> current = head; // creates a temp node = to head
            // iterates until at the second to last node
            while (current.next != tail) {
                current = current.next;
            }

            Node<e> temp = tail;
            tail = current; // links tail to the current node
            tail.next = null; // set the temp to null
        } else { // if there is only 1 node, delete the list
            head = null;
            tail = null;
        }
    }

    // method #5: remove node at index
    public void removeAtIndex(int index) {
        // if there are more than one node
        if (head.next != null) {
            Node<e> current = head; // creates a temp node = to head

            // iterates until at the index
            for (int i = 0; i < index + 1; i++) {
                current = current.next;
            }

            Node<e> temp = current.next; // sets unwanted node to temp
            current.next = current.next.next; // connect the two nodes to exclude the unwanted
            temp = null; // discard unwanted node
        } else {
            // if there is only 1 node, delete the list
            head = null;
            tail = null;
        }
    }

    // method #6: countNodes
    public int countNodes() {
        int listSize = 0;
        Node<e> temp = head;

        // iterate through nodes
        while (temp != null) {
            temp = temp.next;
            listSize++;
        }

        // this method returns the list size
        return listSize;
    }

    // method #7: printInReverse (Recursive method)
    public String printInReverse(Node<e> L) {
        String list = ""; // String variable that holds reverse

        // base case
        if (L.next == null) {
            return L.data + "   ";//
        }
        // recursive call
        else {
            list = printInReverse(L.next) + L.data + "   ";
        }
        return list;
        // complete this method as recursive methods
    }

    // method to print out the list
    public void printList() {
        Node<e> temp;
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
    }

    // class to create nodes as objects
    private static class Node<e> {
        private e data;  // data field
        private Node<e> next; // link field

        public Node(e item) { // constructor method
            data = item;
            next = null;
        }
    }
}
