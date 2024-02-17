// Name: Phillip Bell
// Class: CS 3305/Section 04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: Inteli J
import java.util.InputMismatchException;
import java.util.Scanner;

//this class reverses strings
public class ReverseString {

    public static void main (String[] args)
    {
        Stack myStack = new Stack(); //create a Stack object
        Scanner scan = new Scanner(System.in); //initializes scanner
        int choice = 0; //hold the user choice on the method they wish to call
        Boolean sentinel= true; // general sentinel value
        String data = ""; //initializes data that might be passed through
        String word=""; //word to be added to stack
        int spaces = 0; //counts the number of spaces


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
                    System.out.print("\nEntered string:\t\t"+data);
                    //prints Stack before adding node


                    //reverse string by adding words too stack
                    for (int i = 0; i <data.length() ; i++) {
                        //if word end then it adds to stack
                        if(data.charAt(i)==' '){
                            myStack.push(word);
                            word="";
                            spaces++;
                        }
                        //if it is the last word
                        else if(i+1==data.length()){
                            word=word+data.charAt(i);
                            myStack.push(word);
                            word="";
                            spaces++;
                        }//add char to make words
                        else {
                            word=word+data.charAt(i);
                        }
                    }


                    System.out.print("\nReversed string:\t");

                    //calls stack and pops out all element
                    for (int i = 1; i <data.length() ; i++) {
                        if(myStack.tail != null) {

                            System.out.print(myStack.top() + " ");
                            myStack.pop();
                        }

                    }

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


                System.out.print("\n\n-----------------MAIN MENU--------------- \n" +
                        "1 – Read input string of words \n" +
                        "2 – Reverse string and display outputs  \n" +
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
