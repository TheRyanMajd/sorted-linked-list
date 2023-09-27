package com.sllRyanMajd.app;

/**
 * The ItemType class represents an item type with an associated integer value.
 * This class allows you to create and access item types with their corresponding values.
 */
public class ItemType {
    private int value;

    /**
     *ItemType constructor that creates the item type.
     *@param value would set the value (as a number) in the element.
     */

    public ItemType(int value) {
        this.value = value;
    }

/**
 * Compares this ItemType object with another ItemType object based on their values.
 *
 * @param item The ItemType object to compare with.
 * @return Negative integer if this item's value is less than the given item's value,
 *         positive integer if greater, and 0 if they are equal.
 */
    public int compareTo(ItemType item) {
        if (this.value < item.getValue()) {
            return -1;
        } else if (this.value > item.getValue()) {
            return 1;
        } else {
            return 0;
        } // else-if-else

    } // compareTo


    /**
     * Retrieves the value of this ItemType.
     *
     * @return The value of this ItemType as an integer.
     */

    public int getValue() {
        return this.value;
    } // getValue

    @Override
    public String toString() {
        return (this.value + "");
    } // toString


} // ItemType
