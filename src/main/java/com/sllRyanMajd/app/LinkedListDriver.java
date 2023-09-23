package com.sllRyanMajd.app;

import java.util.Scanner;
import java.io.*;

/**
 * Hello world!
 *
 */

public class LinkedListDriver {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File(args[0]);
        Scanner scan = new Scanner(input);
        //**** ARGUMENT MUST PASS THROUGH A LINKEDLIST METHOD and be initialized correctly!
        System.out.println("Input from " + args[0] + " loaded correctly!"); //TODO: RM WNN
        System.out.println(scan.nextLine());
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

    //Bruh
} // LinkedListDriver
