// Name: Phillip Bell
// Class: CS 3305/Section 04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: Inteli J

//class is used to make a stack to store data
public class Stack<E> {
    public Node<E> head, tail;

    // constructor method to create a list of objects with head, tail,
    public Stack() {
        head = null;
        tail = null;
    }

    // pushes data ontop of stacks
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

        // if there are 0 nodes
        if (head==null){
            return;
        }// if there are more than one node
        if (head.next != null) {
            Node<E> current = head; // creates a temp node = to head
            // iterates until at the second to last node
            while (current.next != tail) {
                current = current.next;//move to next node in list
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

        return tail.data;//return the top of the stack]
    }

    // counts the number of nodes in  the stack
    public int size() {
        int listSize = 0;//initializes the size too 0
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
        //returns false if empty
        if(head==null){
            return false;
        }
        //returns true if populated
        else {
            return true;
        }
    }



    // method to print out the stack
    public void printStack() {
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
