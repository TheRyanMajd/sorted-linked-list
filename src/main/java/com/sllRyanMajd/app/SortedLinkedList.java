package com.sllRyanMajd.app;
//import com.sllRyan
import java.lang.Exception.*;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;
    private int size = 0;
    public SortedLinkedList() {
        // ADD SHIT HERE
    } // sll const

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

} // sll
