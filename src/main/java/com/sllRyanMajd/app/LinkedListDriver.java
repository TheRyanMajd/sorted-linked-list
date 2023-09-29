package com.sllRyanMajd.app;

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class LinkedListDriver {
    public static void main(String[] args) throws FileNotFoundException {

        //Input
        File input = new File(args[0]);
        Scanner scan = new Scanner(input);
        int[] list1 = inputParser(scan.nextLine());
        boolean quit = false;

        SortedLinkedList LinkedList1 = new SortedLinkedList(list1);
        SortedLinkedList LinkedList2;

        scan = new Scanner(System.in);
        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(s) - Search value");
        System.out.println("(n) - Print next iterator value");
        System.out.println("(r) - Reset iterator");
        System.out.println("(a) - Delete alternate nodes");
        System.out.println("(m) - Merge lists");
        System.out.println("(t) - Find intersection");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Print length");
        System.out.println("(q) - Quit program");


        while (!quit) {
            System.out.print("\nEnter a Command: ");
            String cmd = scan.nextLine().toLowerCase();
            switch (cmd) {

            case "i":
                System.out.print("Enter a number to insert: ");
                int newNum = scan.nextInt();
                LinkedList1.insertItem(new ItemType(newNum));
                scan.nextLine();
                break;
            case "q":
                quit = true;
                System.out.println("Exiting the program...");
                break;
            case "p":
                System.out.print("The list is: " + LinkedList1.toString());
                break;
            case "d":
                System.out.print("Enter a number to delete: ");
                newNum = scan.nextInt();
                LinkedList1.deleteItem(new ItemType(newNum));
                scan.nextLine();
                break;
            case "s":
                System.out.print("Enter a number to search: ");
                newNum = scan.nextInt();
                int index = LinkedList1.searchItem(new ItemType(newNum));
                if (index == -2) {
                    System.out.println("Original list: " + LinkedList1.toString());
                    System.out.print("The list is empty");
                    scan.nextLine();
                    break;
                } else {
                    System.out.println("Original list: " + LinkedList1.toString());
                    if (index != -1) {
                        System.out.print("The item is present at index " + index);
                    } else if (LinkedList1.getLength() == 0) {
                        System.out.print("The list is empty");
                    } else {
                        System.out.print("Item is not present in the list");
                    }
                    scan.nextLine();
                    break;
                }
            case "n":
                System.out.print(LinkedList1.getNextItem());
                break;
            case "r":
                LinkedList1.resetIterator();
                System.out.print("Iterator is reset");
                break;
            case "a":
                System.out.println("Original list: " + LinkedList1.toString());
                LinkedList1.delAlternateNodes();
                System.out.print("New list: " + LinkedList1.toString());
                break;
            case "m":
                int[] temp = multiList();
                LinkedList1.mergeList(temp);
                break;
            case "t":
                int[] tempt = multiList();
                LinkedList1.intersection(tempt);
                break;
            case "l":
                System.out.print("The length of the list is " + LinkedList1.getLength());
                break;
            default:
                System.out.print("Invalid command, try again: ");
                cmd = scan.nextLine().toLowerCase();
                break;
            } // switch statement

        } // while loop

    } // main

    /**
     * Used when both the LinkedList1 and another list are being used for a case in the switch.
     * @return second list as a SortedLinkedList object.
     */
    protected static int[] multiList() {
        int listLength;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the length of the new list: ");
        listLength = scan.nextInt();
        System.out.print("Enter the numbers: ");
        int[] list = new int[listLength];
        for (int i = 0; i < listLength; i++) {
            list[i] = scan.nextInt();
        }
        return list;
    }




    /**
     * Takes list of numbers and initializes and sets a sortedLinkedList Object.
     * The sortedLinkedList Object should not contain non-unique ItemType values.
     * @param list String of nextLine() from file
     * @return array that is sorted
     */
    private static int[] inputParser(String list) {
        Scanner scan = new Scanner(System.in);
        String[] stringArray = list.split(",");
        // Create an int array to store the converted values
        int[] intArray = new int[stringArray.length];
        // Iterate over the string array and convert each element to an int
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        Arrays.sort(intArray);

        // Count the number of unique integers
        int uniqueCount = 1;
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] != intArray[i - 1]) {
                uniqueCount++;
            }
        }
        // Create a new array to store the unique integers
        int[] uniqueIntArray = new int[uniqueCount];
        // Copy unique integers to the new array
        uniqueIntArray[0] = intArray[0];
        int uniqueIndex = 1;
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] != intArray[i - 1]) {
                uniqueIntArray[uniqueIndex] = intArray[i];
                uniqueIndex++;
            }
        }
        return uniqueIntArray;
    } // input Parser


    private static int[] inputParser(String list, boolean isSecond) {
        Scanner scan = new Scanner(System.in);
        String[] stringArray = list.split(" ");
        // Create an int array to store the converted values
        int[] intArray = new int[stringArray.length];
        // Iterate over the string array and convert each element to an int
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        Arrays.sort(intArray);

        // Count the number of unique integers
        int uniqueCount = 1;
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] != intArray[i - 1]) {
                uniqueCount++;
            }
        }
        // Create a new array to store the unique integers
        int[] uniqueIntArray = new int[uniqueCount];
        // Copy unique integers to the new array
        uniqueIntArray[0] = intArray[0];
        int uniqueIndex = 1;
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] != intArray[i - 1]) {
                uniqueIntArray[uniqueIndex] = intArray[i];
                uniqueIndex++;
            }
        }
        return uniqueIntArray;
    } // input Parser


} // LinkedListDriver
