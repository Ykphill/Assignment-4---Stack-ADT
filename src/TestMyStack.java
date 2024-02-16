// Name: Phillip Bell
// Class: CS 3305/Section 04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: Inteli J
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMyStack {


    public static void main (String[] args)
    {
        Stack myStack = new Stack(); //create a Stack object
        Scanner scan = new Scanner(System.in); //initializes scanner
        int choice = 0; //hold the user choice on the method they wish to call
        Boolean sentinel= true; // general sentinel value
        int data = 0; //initializes data that might be passed through
        int index = 0; //initializes index that might be passed through


        //used for testing purposes
        //for (int i=1; i <= 5; i++) //add 5 nodes to the Stack
        //{
        //   myStack.addLastNode(i*10);
        //}


        //sentinel loop for program
        do {


            choice = menu(); // calls menu method and return choice

           

            //pushes node
            if(choice == 1){

                //method sentinel loop
                do {
                    sentinel=true;

                    try {

                        //prompt user to enter data
                        System.out.print("\nPlease enter a data (int) :\t");
                        data = scan.nextInt();
                        scan.nextLine();
                        sentinel=false;


                    }
                    //catches any wrong inputs
                    catch (InputMismatchException e){
                        scan.nextLine();
                        System.out.println("\nPlease enter only integers");
                    }

                }while (sentinel);

                System.out.print("\nAdding value "+data+" to stack. \n" +
                        "Stack content before adding "+data+" is:\t");
                myStack.printStack();//prints Stack before adding node

                myStack.push(data);//adds data as the last node

                System.out.print("\nStack content after adding "+data+" is:\t");
                myStack.printStack();//prints Stack after node is added
            }

           

            //removes last node
            if(choice == 2){

                //if the Stack is empty tells the user "Stack is Empty"
                if(myStack.head==null){
                    System.out.print("\nStack is Empty");
                }
                //else run method
                else {
                    System.out.print("\nMethod pop()\n" +
                            "Stack content before removing last node is:\t");
                    myStack.printStack();//prints Stack before adding node

                    myStack.pop();//removes data at the firs node

                    System.out.print("\nStack content after removing last node is:\t");
                    myStack.printStack();//prints Stack after node is added

                }
            }

            //check if Stack is empty
            if(choice == 3){
                if(myStack.isEmpty()==false){
                    System.out.print("\nStack is Empty");
                }
                else {
                    System.out.print("\nStack top element is:\t"+myStack.top());
                }

            }
            
            //printd Stack size
            if(choice == 4){
                if(myStack.head==null){
                    System.out.print("\nStack is Empty");
                }
                else {
                    System.out.print("\nMethod size()\n" +
                            "Stack Size:\t"+myStack.size());
                }

            }

            //check if Stack is empty
            if(choice == 5){
                if(myStack.isEmpty()==false){
                    System.out.print("\nStack is Empty");
                }
                else {
                    System.out.print("\nStack is Populated\n" +
                            "Stack:\t");
                    myStack.printStack();
                }

            }

            //prints Stack forward
            if(choice == 6){
                //if Stack is empty
                if(myStack.head==null){
                    System.out.print("\nStack is Empty");
                }
                //prints Stack
                else {
                    System.out.print("\nMethod printStack()\n" +
                            "Stack:\t");
                    myStack.printStack();
                }
            }


        }while(choice!=7);


    }

    //prints out menu and read message
    public static int menu(){
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        boolean sentinel=true;

        do {

            try {


                System.out.print("\n\n--------MAIN MENU------- \n" +
                        "1 – Push element \n" +
                        "2 – Pop element  \n" +
                        "3 – Get top element \n" +
                        "4 – Get stack size \n" +
                        "5 – Is empty stack? \n" +
                        "6 - Print stack \n" +
                        "7 - Exit program \n\n" +
                        "Enter option number:\t");

                choice = scan.nextInt();
                scan.nextLine();

                if(choice >= 1 && choice <= 7){
                    sentinel=false;
                }
                else {
                    sentinel= true;
                    System.out.println("\nplease only input values that are integers and between 1-7 ");
                }
            }catch (InputMismatchException e){
                System.out.println("\nplease only input values that are integers and between 1-7 ");
                scan.nextLine();
            }

        }while (sentinel);
        return choice;
    }


}
