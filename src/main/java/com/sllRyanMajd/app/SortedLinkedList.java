package com.sllRyanMajd.app;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;
    private int size = 0;
    private ItemType[] itemList;
    private NodeType[] nodeList;
    public boolean isEmpty = true;
    private boolean firstIteration = true;

    public SortedLinkedList(int[] array) {
        Arrays.sort(array);
        this.size = array.length;
        itemList = new ItemType[this.size];
        nodeList = new NodeType[this.size];
        for (int i = 0; i < this.size; i++) {
            itemList[i] = new ItemType(array[i]);
            nodeList[i] = new NodeType(itemList[i]);
        } // For
          // initializes next method to NodeTypes
        for (int j = 0; j < this.size; j++) {
            if (!(j == this.size - 1)) {
                nodeList[j].addNext(nodeList[j + 1]);
            }
            // do not need to add next for last node in list
        } // for loop for this.next function
        this.isEmpty = false;
        this.head = nodeList[0];
        this.currentPos = this.head;
    } // sll const using pre-made array

    public SortedLinkedList(ItemType[] array) {
        this.size = array.length;
        itemList = new ItemType[this.size];
        nodeList = new NodeType[this.size];
        for (int i = 0; i < this.size; i++) {
            itemList[i] = array[i];
            nodeList[i] = new NodeType(itemList[i]);
        }

        for (int j = 0; j < this.size; j++) {
            if (!(j == this.size - 1)) {
                nodeList[j].addNext(nodeList[j + 1]);
            }
        }
        this.head = nodeList[0];
        this.currentPos = this.head;
        this.isEmpty = false;
    }

    public int getLength() {
        return this.size;
    } // getLength

    public void insertItem(ItemType item) {
        System.out.println("Original list: " + this.toString());

        if (this.searchItem(item) != -1 && !this.isEmpty) {
            System.out.println("Item already exists");
            System.out.print("New list: " + this.toString());
            return; // Item already exists, so no need to insert it
        }

        NodeType newNode = new NodeType(item);
        NodeType current = this.head; // Not global currentPos so user doesn't lose iterator
        NodeType previous = null;

        if (this.isEmpty) {
            this.size++;
            this.head = newNode;
            this.currentPos = this.head;
            this.itemList = new ItemType[1];
            this.nodeList = new NodeType[1];
            this.itemList[0] = item;
            this.nodeList[0] = this.currentPos;
            System.out.print("New list: " + this.toString());
            this.isEmpty = false;
            return;
        }

        while (current != null && current.info.compareTo(item) < 0) {
            previous = current;
            current = current.next;
        } // while loop breaks when object that satisfies if statement is found

        if (previous == null && !this.isEmpty) { // beginning of list
            newNode.addNext(this.head);
            this.head = newNode;
        } else {
            if (this.isEmpty) {
                this.head = newNode;
            }
            // Insert after the 'previous' node
            newNode.addNext(current);
            previous.addNext(newNode);
        }

        this.size++;
        // Update the itemList and nodeList arrays
        ItemType[] newItemList = new ItemType[this.size];
        NodeType[] newNodeList = new NodeType[this.size];
        current = this.head;

        for (int i = 0; i < this.size; i++) {
            newItemList[i] = current.info;
            newNodeList[i] = current;
            current = current.next;
        }

        this.itemList = newItemList;
        this.nodeList = newNodeList;

        System.out.print("New list: " + this.toString());
    }

    public void insertItem(ItemType item, boolean isSilent) {
        if (this.searchItem(item) != -1 && !this.isEmpty) {
            return; // Item already exists, so no need to insert it
        }

        NodeType newNode = new NodeType(item);
        NodeType current = this.head; // Not global currentPos so user doesn't lose iterator
        NodeType previous = null;

        if (this.isEmpty) {
            this.size++;
            this.head = newNode;
            this.currentPos = this.head;
            this.itemList = new ItemType[1];
            this.nodeList = new NodeType[1];
            this.itemList[0] = item;
            this.nodeList[0] = this.currentPos;
            this.isEmpty = false;
            return;
        }

        while (current != null && current.info.compareTo(item) < 0) {
            previous = current;
            current = current.next;
        } // while loop breaks when object that satisfies if statement is found

        if (previous == null && !this.isEmpty) { // beginning of list
            newNode.addNext(this.head);
            this.head = newNode;
        } else {
            if (this.isEmpty) {
                this.head = newNode;
            }
            // Insert after the 'previous' node
            newNode.addNext(current);
            previous.addNext(newNode);
        }

        this.size++;
        // Update the itemList and nodeList arrays
        ItemType[] newItemList = new ItemType[this.size];
        NodeType[] newNodeList = new NodeType[this.size];
        current = this.head;

        for (int i = 0; i < this.size; i++) {
            newItemList[i] = current.info;
            newNodeList[i] = current;
            current = current.next;
        }

        this.itemList = newItemList;
        this.nodeList = newNodeList;
    } // insertitem silent

    public void deleteItem(ItemType item, boolean isSilent) {
        int itemIndex = this.searchItem(item);
        NodeType current = this.head;
        NodeType previous = null;
        // Traverse the list to find the node containing the item to delete
        for (int i = 0; i < itemIndex; i++) {
            previous = current;
            current = current.next;
        } // for
        if (previous == null) {
            // The item to delete is the first node
            this.head = current.next;
        } else {
            // Remove the node containing the item
            previous.addNext(current.next);
        } // else-if
        this.size--;
        if (this.size == 0) {
            this.isEmpty = true;
        } // if
        this.itemList = new ItemType[this.size];
        this.nodeList = new NodeType[this.size];
        current = this.head;
        for (int i = 0; i < this.size; i++) {
            this.itemList[i] = current.info;
            this.nodeList[i] = current;
            current = current.next;
        } // for
    } // deleteItem silent

    public void deleteItem(ItemType item) {
        if (size == 0 || isEmpty) {
            this.isEmpty = true;
            System.out.print("You cannot delete from an empty list");
            return;
        }

        System.out.println("Original list: " + this.toString());

        int itemIndex = this.searchItem(item);

        if (itemIndex == -1) {
            System.out.println("The item is not present in the list");
        } else {
            NodeType current = this.head;
            NodeType previous = null;

            for (int i = 0; i < itemIndex; i++) {
                previous = current;
                current = current.next;
            }

            if (previous == null) {
                // The item to delete is the first node
                this.head = current.next;
            } else {
                // Remove the node containing the item
                previous.addNext(current.next);
            }

            this.size--;
            if (this.size == 0) {
                this.isEmpty = true;
                resetIterator();
            }

            // Update the itemList and nodeList arrays
            this.itemList = new ItemType[this.size];
            this.nodeList = new NodeType[this.size];
            current = this.head;

            for (int i = 0; i < this.size; i++) {
                this.itemList[i] = current.info;
                this.nodeList[i] = current;
                current = current.next;
            }
        }

        System.out.print("New list: " + this.toString());
    } // del items

    /**
     * Searches number in list.
     * 
     * @param item refers to the ItemType being searched.
     * @return index of item. -1 meaning not in list, -2 meaning empty list
     */
    public int searchItem(ItemType item) {
        if (this.size == 0) {
            resetList();
            return -2;
        }
        for (int i = 0; i < this.size; i++) {
            if (item.compareTo(itemList[i]) == 0) {
                this.currentPos = nodeList[i];
                return i;
            }
        } // for
        return -1;
    } // search next item

    // public ItemType getNextItem() {

    // if (this.head == null) {
    // System.out.println("List is empty");
    // return null;
    // } else {
    // if (this.currentPos == this.head) {
    // this.currentPos = this.currentPos.getNext();
    // return this.head.info;
    // }
    // this.currentPos = currentPos.getNext();
    // return this.currentPos.info;

    // }

    // } // new get item

    public ItemType getNextItem() throws NullPointerException {
        if (firstIteration) {
            firstIteration = false;
            if (this.head == null || this.size == 0) {
                System.out.println("List is empty");
                return new ItemType(-111888333);
                // HOW CAN I MAKE IT BREAK HERE?
            } else {
                this.currentPos = this.head.getNext();
                return this.head.info;
            }
        } else if (currentPos != null) {
            ItemType currentItem = this.currentPos.info;
            this.currentPos = currentPos.next;
            return currentItem;
            // this.currentPos =
            // return currentItem;
        } else {
            if (this.size != 0) {
                // Handle the case where you reach the end of the list
                this.currentPos = this.head;
                System.out.println("The end of the list has been reached");
                return this.head.info; // Return the first item again
            } else {
                return new ItemType(-111888333);
            }
        }
    }

    public void resetIterator() {
        if (isEmpty) {
            currentPos = null;
            this.head = null;
        } else {
            currentPos = this.head;
        }
    } // reset Iterator

    public void resetList() {
        this.size = 0;
        this.head = new NodeType();
        this.currentPos = this.head;
        itemList = null;
        nodeList = null;
    }

    public void delAlternateNodes() {
        if (this.size == 0 || this.isEmpty) {
            System.out.println("The list is empty");

        } else if (this.size == 1) {
            return;
        } else if (this.size > 1) {

            this.currentPos = this.head;
            while (currentPos != null && currentPos.next != null) {
                // Delete the next node
                deleteItem(currentPos.next.info, true);
                currentPos = currentPos.next;
            } // while

        }
    }

    private String likeInput(int[] list) {
        Arrays.sort(list);
        String ans = ("");
        for (int i = 0; i < list.length; i++) {
            ans += (list[i] + " ");
        }
        return ans;
    }

    public void mergeList(int[] secondList) {
        System.out.println("list 1: " + this.toString());
        System.out.println("list 2: " + likeInput(secondList));
        secondList = removeDuplicates(secondList);
        // Convert the secondList array to ItemType[]
        Arrays.sort(secondList);
        ItemType[] secondItemList = new ItemType[secondList.length];
        for (int i = 0; i < secondList.length; i++) {
            secondItemList[i] = new ItemType(secondList[i]);
        }
        SortedLinkedList mergedList = new SortedLinkedList(secondItemList);
        // Traverse the current linked list and insert elements into the merged list
        for (int i = 0; i < this.size; i++) {
            mergedList.insertItem(itemList[i], true);
        }
        mergedList.sortList();
        // Update the current linked list with the merged and sorted list
        this.itemList = mergedList.itemList;
        this.nodeList = mergedList.nodeList;
        this.size = mergedList.size;
        this.head = mergedList.head;
        this.isEmpty = mergedList.isEmpty;
        System.out.print("Merged list: " + this.toString());
    } // merge list

    // Helper method to remove duplicates from an int[] array
    private int[] removeDuplicates(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }

    /** Sorts list. */
    private void sortList() {
        if (this.isEmpty || size == 1) {
            return;
        } // Convert the linked list to an array for sorting
        int[] arr = new int[size];
        NodeType current = this.head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.info.getValue();
            current = current.next;
        }

        // Sort the array to remove duplicates and ensure it's in ascending order
        Arrays.sort(arr);
        // sorted based on ^^ natural numbers
        // Reconstruct the linked list from the sorted array
        this.head = new NodeType(new ItemType(arr[0]));
        this.currentPos = this.head;
        current = this.head;

        for (int i = 1; i < size; i++) {
            NodeType newNode = new NodeType(new ItemType(arr[i]));
            current.addNext(newNode);
            current = newNode;
        }
    } // sortlIst

    /**
     * Computes the intersection of the current SortedLinkedList with a given
     * integer array.
     *
     * This method calculates the intersection of the current SortedLinkedList and
     * the provided int[].
     *
     * @param secondList An integer array to find the intersection with the current
     *                   list.
     */

    public void intersection(int[] secondList) {
        System.out.println("list 1: " + this.toString());
        System.out.println("list 2: " + likeInput(secondList));
        // Sort the secondList array in ascending order.
        Arrays.sort(secondList);
        // Create a new ItemType[] array to store the intersection list.
        int indexCounter = 0;
        ItemType[] secondItemList = new ItemType[secondList.length];

        // Iterate over the two arrays and add the matching elements to the intersection
        // list.
        for (int i = 0; i < this.size; i++) {
            int currentValue = itemList[i].getValue();
            // Use binary search to check if the current item exists in the secondList.
            int index = Arrays.binarySearch(secondList, currentValue);
            // If the item is found in secondList, add it to secondItemList.
            if (index >= 0) {
                secondItemList[indexCounter++] = new ItemType(currentValue);
            }
        }
        // Resize the secondItemList to the actual size of the intersection.
        ItemType[] intersectionItems = Arrays.copyOf(secondItemList, indexCounter);
        // Create a new SortedLinkedList to store the intersection list.
        SortedLinkedList intersectionList = new SortedLinkedList(intersectionItems);
        this.itemList = intersectionList.itemList;
        this.nodeList = intersectionList.nodeList;
        this.size = intersectionList.size;
        this.head = intersectionList.head;
        this.isEmpty = intersectionList.isEmpty;
        System.out.print("Intersection: " + intersectionList.toString());
    } // intersection

    /** Converts object to readable format. */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.size; i++) {
            if (i != this.size - 1) {
                str += (itemList[i].toString());
                str += (" ");
            } else {
                str += (itemList[this.size - 1].toString());
            }
        } // for
        return (str);
    }

} // sll
