package com.sllRyanMajd.app;

/**
 * Node creation for the linkedList.
 */

public class NodeType {
    public ItemType info;
    public NodeType next;

    /**
     * Generic constructor suitable for unknown items.
     */
    public NodeType() {
        this.info = null;
        this.next = null;
    }

    /**
     * Constructor for NodeType which takes data in terms of value.
     * 
     * @param val refers to the actual item being added.
     */
    public NodeType(ItemType val) {
        this.info = val;
        this.next = null;

    } // constructor

    /**
     * Function addNext linked two nodes together by altering the next var.
     * 
     * @param nextNode reference to another node that is established.
     */
    protected void addNext(NodeType nextNode) {
        this.next = nextNode;
    }

    /*
     * public ItemType getItem() {
     * return this.info;
     * }
     */
    public NodeType getNext() {
        NodeType temp = this.next;
        return temp;
    }

    /**
     * Temp method, unknown if needed atp.
     * Breaks the linkage of nodes by setting next to null.
     */
    protected void resetNext() {
        this.next = null;
    }

    /**
     * @Override
     */
    @Override
    public String toString() {
        return ("[" + this.info + "]" + " next-> " + this.getNext());
    }

} // NodeType
