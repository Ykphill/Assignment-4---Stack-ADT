// Name: Phillip Bell
// Class: CS 3305/Section 04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: Inteli J
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

//this class check if the user enters a palindrome
public class CheckPalindrome {

    public static void main (String[] args)
    {
        Stack myStack = new Stack(); //create a Stack object
        Scanner scan = new Scanner(System.in); //initializes scanner
        int choice = 0; //hold the user choice on the method they wish to call
        Boolean sentinel= true; // general sentinel value
        String data = ""; //initializes data that might be passed through
        int index = 0; //initializes index that might be passed through
        String reversed = "";


        //used for testing purposes
        //for (int i=1; i <= 5; i++) //add 5 nodes to the Stack
        //{
        //   myStack.addLastNode(i*10);
        //}


        //sentinel loop for program
        do {


            choice = menu(); // calls menu method and return choice



            //read string
            if(choice == 1){

                //method sentinel loop
                do {
                    sentinel=true;

                    System.out.print("\nplease enter string:\t");
                    data=scan.nextLine();

                    if (data.equals("")){
                        System.out.print("\nstring is empty");
                    }
                    else {
                        sentinel= false;
                    }
                }while (sentinel);


            }



            //removes last node
            if(choice == 2){

                //if the Stack is empty tells the user "Stack is Empty"
                if(data.equals("")){
                    System.out.print("\nString is Empty");
                }
                //else run method
                else {
                    System.out.print("\nEntered string: \t"+data);
                    //prints Stack before adding node

                    for (int i = 0; i <data.length() ; i++) {
                        myStack.push(data.charAt(i));
                    }

                    System.out.print("\nJudgment:  \t\t\t");

                    //reverse string by poping off top
                    for (int i = 0; i <data.length() ; i++) {
                        if(myStack.tail != null) {
                            reversed = reversed + myStack.top();
                            myStack.pop();
                        }
                    }

                    if (reversed.toLowerCase(Locale.ROOT).equals(data.toLowerCase())){
                        System.out.print("Palindrome");
                    }
                    else {
                        System.out.print("Not Palindrome");
                    }
                    reversed="";

                }
            }









        }while(choice!=3);


    }

    //prints out menu and read message
    public static int menu(){
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        boolean sentinel=true;

        do {

            try {


                System.out.print("\n\n-----------------MAIN MENU---------------- \n" +
                        "1 – Read input string \n" +
                        "2 – Check palindrome and display output \n" +
                        "3 - Exit program \n\n" +
                        "Enter option number:\t");

                choice = scan.nextInt();
                scan.nextLine();

                if(choice >= 1 && choice <= 3){
                    sentinel=false;
                }
                else {
                    sentinel= true;
                    System.out.println("\nplease only input values that are integers and between 1-3 ");
                }
            }catch (InputMismatchException e){
                System.out.println("\nplease only input values that are integers and between 1-3 ");
                scan.nextLine();
            }

        }while (sentinel);
        return choice;
    }

}
