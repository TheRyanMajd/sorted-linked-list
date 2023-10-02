Ryan Majd | rm97798@uga.edu

    # sorted-linked-list assignment

    cs2720



    # Sorting Linked List Program

This Java program demonstrates the creation and manipulation of a sorted linked list, providing various operations on the list, including insertion, deletion, search, merging, finding intersections, and more.

## Table of Contents

- [Overview](#overview)
- [Usage](#usage)
- [Available Commands](#available-commands)
- [Big-O Complexity of Functions](#Big-O)

## Overview

This program implements a `SortedLinkedList` class, which is a sorted singly linked list of integer values. It allows you to perform various operations on the list through a command-line interface.

## Usage

Once the program is running, you will be prompted to enter commands. You can interact with the sorted linked list using the available commands.

## Available Commands

The program supports the following commands:

- `(i)` - Insert value
- `(d)` - Delete value
- `(s)` - Search value
- `(n)` - Print next iterator value
- `(r)` - Reset iterator
- `(a)` - Delete alternate nodes
- `(m)` - Merge lists
- `(t)` - Find intersection
- `(p)` - Print list
- `(l)` - Print length
- `(q)` - Quit program

## Big-O

- Intersection

1. Sort the secondList array in ascending order.
2. Create a new ItemType[] array to store the intersection list.
3. Iterate over the two arrays and add the matching elements to the intersection list.
   - Use binary search to check if the current item exists in the secondList.
   - If the item is found in secondList, add it to the intersection list.
4. Resize the intersection list to the actual size of the intersection.
5. Create a new SortedLinkedList to store the intersection list.
6. Copy the intersection list to the current SortedLinkedList.
   The overall complexity of the intersection() function is O(n log n) + O(n) + O(1) + O(1) + O(1) + O(n) = **O(n log n)**.

- Merge

1. Sort the secondList array in ascending order.
2. Convert the secondList array to an ItemType[] array.
3. Create a new SortedLinkedList to store the merged list.
4. Traverse the current linked list and insert elements into the merged list.
5. Sort the merged list.
6. Copy the merged list to the current linked list.
   The overall complexity of the mergeList() function is O(n log n) + O(n) + O(1) + O(n) + O(n log n) + O(n) = **O(n log n)**.
