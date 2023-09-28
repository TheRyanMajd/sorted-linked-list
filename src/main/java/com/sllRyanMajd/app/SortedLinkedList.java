package com.sllRyanMajd.app;


//TODO: REMOVE TESTING CMD
//TODO: CHECK ALL METHODS
//TODO: CHECK GIVEN TESTS
//TODO: JAVADOC IF NECESS && COMMENTS /
//TODO: README.MD FILE

import java.lang.Exception.*;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;
    private int size = 0;
    private ItemType[] itemList;
    private NodeType[] nodeList;
    private boolean firstIteration = true;
    public boolean isEmpty = true;

    public SortedLinkedList(int[] array) {
        this.size = array.length;
        itemList = new ItemType[this.size];
        nodeList = new NodeType[this.size];
        for (int i = 0; i < this.size; i++) {
            itemList[i] = new ItemType(array[i]);
            nodeList[i] = new NodeType(itemList[i]);
        } // For
        //initializes next method to NodeTypes
        for (int j = 0; j < this.size; j++) {
            if (!(j == this.size - 1)) {
                nodeList[j].addNext(nodeList[j + 1]);
            }
            this.head = nodeList[0];
            this.currentPos = this.head;
        } // for loop for this.next functio
        this.isEmpty = false;
    } // sll const using pre-made array

    public void test() {
        System.out.println(this.toString());
        System.out.println("head:" + this.head);
        System.out.println("currpos:" + this.currentPos);
        System.out.println("size:" + this.size);
        //TODO : REMOVE
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.itemList[i].toString());
            System.out.println("node stuff");
            System.out.println(this.nodeList[i].toString());
        }

    } //TESTING PURPOSES ONLY REMOVE PLEAE




    public int getLength() {
        return this.size;
    } // getLength

    public void insertItem(ItemType item) {
        System.out.println("Original list: " + this.toString());

        if (this.searchItem(item) != -1) {
            System.out.println("Item already exists");
            System.out.print("New list: " + this.toString());
            return; // Item already exists, so no need to insert it
        }

        NodeType newNode = new NodeType(item);
        NodeType current = this.head; // Not global currentPos so user doesn't lose iterator
        NodeType previous = null;

        while (current != null && current.info.compareTo(item) < 0) {
            previous = current;
            current = current.next;
        } // while loop breaks when object that satisfies if statement is found

        if (previous == null) { // beginning of list
            newNode.addNext(this.head);
            this.head = newNode;
        } else {
            // Insert after the 'previous' node
            newNode.addNext(current);
            previous.addNext(newNode);
        }

        this.size++;

        this.itemList = new ItemType[this.size];
        this.nodeList = new NodeType[this.size];
        current = this.head;
        for (int i = 0; i < this.size; i++) {
            this.itemList[i] = current.info;
            this.nodeList[i] = current;
            current = current.next;
        }

        System.out.print("New list: " + this.toString());
    }



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
            }
            // Update the itemList and nodeList arrays to reflect the new state of the linked list
            this.itemList = new ItemType[this.size];
            this.nodeList = new NodeType[this.size];
            current = this.head;
            for (int i = 0; i < this.size; i++) {
                this.itemList[i] = current.info;
                this.nodeList[i] = current;
                current = current.next;
            } // for
        } // else if

        System.out.print("New list: " + this.toString());
    } // deleteItem

    /**
     * Searches number in list.
     * @param item refers to the ItemType being searched.
     * @return index of item. -1 meaning not in list, -2 meaning empty list
     */
    public int searchItem(ItemType item) {
        if (this.size == 0) {
            return -2;
        }
        for (int i = 0; i < this.size; i++) {
            if (item.compareTo(itemList[i]) == 0) {
                this.currentPos = nodeList[i];
                return i;
            }
        } // for
        return -1;
    }
    public ItemType getNextItem() {
        if (firstIteration) {
            firstIteration = false;
            return head.info;
        } else if (currentPos != null && currentPos.next != null) {
            currentPos = currentPos.next;
            return currentPos.info;
        } else {
            // Handle the case where you reach the end of the list
            currentPos = this.head;
            return head.info; // Return the first item
        }
    } // get Next Item

    public void resetIterator() {
        if (isEmpty) {
            currentPos = null;
        } else {
            this.firstIteration = true;
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
        throw new UnsupportedOperationException("working on DAN implementation");
    } // delete 2nd, 4th, 6th... nodes in list and relink them
    /** OTHER METHODS REQUIRE INPUT OF 2nd LIST. */

    public void mergeList() {
        throw new UnsupportedOperationException("will need to do this too");
    } // mergelist

    public void intersection() {
        throw new UnsupportedOperationException("the last method :D");
    }


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
