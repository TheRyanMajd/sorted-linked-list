package com.sllRyanMajd.app;

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
/**
 * Hello world!
 *
 */

public class LinkedListDriver {
    public static void main(String[] args) throws FileNotFoundException {

        //Input
        File input = new File(args[0]);
        Scanner scan = new Scanner(input);
        int[] list1 = inputParser(scan.nextLine());


        SortedLinkedList LinkedList1 = new SortedLinkedList(list1);
        System.out.println("List ready!");

        scan = new Scanner(System.in);
        System.out.println("Commands:\n(i) - Insert value\n(d) - Delete value\n(s) - Search value"
        + "\n(n) - Print next iterator value (r) - Reset iterator\n(a) - Delete alternate nodes"+
         "(m) - Merge lists\n(t) - Find intersection\n(p) - Print list\n(l) - Print length\n(q)"
        + " - Quit program");

        System.out.print("\nEnter a Command:");
        String cmd = scan.nextLine().toLowerCase();


        if (cmd.equals("i")) {
            System.out.print("Enter a number to insert:");
            int newNum = scan.nextInt(); //change to itemType soon!
        } else if (cmd.equals("q")) {
            System.out.println("Exiting the program...");
        } else {
            System.out.println("Invalid command, try again!");
        }
    } // main

    /**
     * Takes list of numbers and initializes and sets a sortedLinkedList Object.
     * @param list String of nextLine() from file
     * @return array that is sorted
     */
    private static int[] inputParser(String list) {
        String[] stringArray = list.split(",");
        // Create an int array to store the converted values
        int[] intArray = new int[stringArray.length];
        // Iterate over the string array and convert each element to an int
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        Arrays.sort(intArray);
        return intArray;
    } // input Parser


} // LinkedListDriver
