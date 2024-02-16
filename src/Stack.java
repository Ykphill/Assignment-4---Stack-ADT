// Name: Phillip Bell
// Class: CS 3305/Section 04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: Inteli J

//class is use to make a stack to store data
public class Stack<E> {
    public Node<E> head, tail;

    // constructor method to create a list of objects with head, tail, and size.
    public Stack() {
        head = null;
        tail = null;
    }

    // pushes data on stacks
    public void push(E data) {
        // if the list is empty
        if (tail == null)
            head = tail = new Node<>(data); // empty list
        else {
            tail.next = new Node<>(data); // link new node as the last node
            tail = tail.next; // make tail pointer point to the last node
        }
    }

    // method #4: remove the node on the top of the stack
    public void pop() {
        // if there are more than one node
        if (head.next != null) {
            Node<E> current = head; // creates a temp node = to head
            // iterates until at the second to last node
            while (current.next != tail) {
                current = current.next;
            }

            Node<E> temp = tail;
            tail = current; // links tail to the current node
            tail.next = null; // set the temp to null
        } else { // if there is only 1 node, delete the list
            head = null;
            tail = null;
        }
    }

    // method #4: get the node on the top of the stack
    public E top() {
        return tail.data;//return the top of the stack
    }

    // counts the number of nodes in  the stack
    public int size() {
        int listSize = 0;
        Node<E> temp = head;

        // iterate through nodes
        while (temp != null) {
            temp = temp.next;
            listSize++;
        }

        // this method returns the list size
        return listSize;
    }

    //tell the user if the list is empty
    public boolean isEmpty(){

        if(head==null){
            return false;
        }
        else {
            return true;
        }
    }


    // method #7: printInReverse (Recursive method)
    public String printInReverse(Node<E> L) {
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
        Node<E> temp;
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
    }

    // class to create nodes as objects
    private static class Node<E> {
        private E data;  // data field
        private Node<E> next; // link field

        public Node(E item) { // constructor method
            data = item;
            next = null;
        }
    }
}
