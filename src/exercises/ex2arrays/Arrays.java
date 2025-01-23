package exercises.ex2arrays;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Arrays {

    public static final Scanner input = new Scanner(in);

    public static int[] getArrayOfIntsFromUser() {

        out.println("Input 5 integers (space between, then enter) > ");
        String intValues = input.nextLine();
        String[] myArray = intValues.split(" ");

        int[] intArray = new int[5];

        for (int i = 0; i < 5; i++) {
            intArray[i] = Integer.parseInt(myArray[i]);
        }

        return intArray;
    }

    public static int getValueFromUser() {
        out.println("Enter a value");
        return Integer.parseInt(input.nextLine());

    }


    public static void printIndexToUser(int the_index, int the_value) {
        out.printf("Value %d is at index %d%n",the_index, the_value);
    }

    public static void printNotFoundToUser(int the_value) {
        out.printf("Value %s is not found", the_value);
    }

    public static void printResultToUser(int the_index, int the_value) {
        if (the_index == -1){
            printNotFoundToUser(the_index);
        }else{
            printIndexToUser(the_index, the_value);
        }
    }


    public static int findIndexOfValue(int[] a_list, int a_value) {

        for (int i = 0; i < a_list.length; i++) {
            if(a_value == a_list[i]){
                return i;
            }
        }
        return -1;
    }

    public static void listBasicsProgram() {
        // INPUT
        int[] theList = getArrayOfIntsFromUser();
        int theValue = getValueFromUser();
        // PROCESS
        int theIndex = findIndexOfValue(theList, theValue);
        // OUTPUT
        printResultToUser(theIndex, theValue);
    }


    public static void main(String[] args) {
        listBasicsProgram();
    }
}