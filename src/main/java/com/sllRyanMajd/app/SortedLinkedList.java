package com.sllRyanMajd.app;

import java.lang.Exception.*;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;
    private int size = 0;
    private ItemType[] itemList;
    private NodeType[] nodeList;

    public SortedLinkedList() {
        // ADD SHIT HERE
    } // sll const

    public SortedLinkedList(int[] array) {
        this.size = array.length;
        itemList = new ItemType[this.size];
        nodeList = new NodeType[this.size];
        for (int i = 0; i < this.size; i++) {
            itemList[i] = new ItemType(array[i]);
            nodeList[i] = new NodeType(itemList[i]);
        } // For

        for (int j = 0; j < this.size; j++) {
            if (!(j == this.size - 1)) {
                nodeList[j].addNext(nodeList[j + 1]);
            }
            System.out.println(nodeList[j].toString());                   //TODO RM
        } // for loop for this.next function
    } // sll const using pre-made array

    public int getLength() {
        return this.size;
    } // getLength


    public void insertItem(ItemType item) {
        throw new UnsupportedOperationException("TODO");
    }
    public void deleteItem(ItemType item) {
        throw new UnsupportedOperationException("TODO");
    }
    public int searchItem(ItemType item) {
        throw new UnsupportedOperationException("TODO");
    }
    public ItemType getNextItem() {
        throw new UnsupportedOperationException("TODO");
    }
    public void resetList() {
        this.size = 0;
        this.head = new NodeType();
        this.currentPos = this.head;
    }
    public void delAlternateNodes() {
        throw new UnsupportedOperationException();
    } // delete 2nd, 4th, 6th... nodes in list and relink them
    /** OTHER METHODS REQUIRE INPUT OF 2nd LIST. */

    public void mergeList() {
        throw new UnsupportedOperationException();
    } // mergelist

    public void intersection() {
        throw new UnsupportedOperationException();
    }

/*
    @Override
    public String toString() {
        return ("List (Sorted) " + );
    }
*/
} // sll
