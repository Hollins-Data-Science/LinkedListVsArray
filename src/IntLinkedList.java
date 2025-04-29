/*
This class implements a general list interface using an array

General List Interface:
size() - return the number of values in the list
get(i) - return the value at position i
set(i, v) - set the value at position i to v
add(i, v) - insert the value v into position i
remove(i) - remove the value at position i
*/
public class IntLinkedList implements IntList {
    // This item class is internal to our list.
    // No one else needs to use it.
    private class IntListItem {
      int value;
      IntListItem next;
    }
  
    // The front of the linked list
    private IntListItem head = null;
    // The number of values in the list
    private int count = 0;
  
  /*
  size() - return the number of elements in the list
  */
    public int size() {
      return count;
    }
    
  /*
  get(i) - return the value at position i
  */
    public int get(int index) {
      // Check for valid index
      if ((index < 0) || (index >= count)) {
        throw new ArrayIndexOutOfBoundsException(index);
      }
      // If its the first value then its easy
      if (index == 0) {
        // Simply return the value at the head of the list
        // Complexity: O(1) which is constant time 
        return head.value;
      }
      else {
        // Loop over the list keeping track of our numeric position and a link to the current list item
        // Stop when we reach the target index
        // Complexity: O(n) which is linear time 
        IntListItem current = head;
        int position = 0;
        while (position != index) {
          current = current.next;
          position++;
        }
        // Return the current list item's value
        return current.value;
      }
    }
  
    public void set(int index, int value) {
      // Check for valid index
      if ((index < 0) || (index >= count)) {
        throw new ArrayIndexOutOfBoundsException(index);
      }
      // If its the first value then its easy
      if (index == 0) {
        // Simply set the value at the head of the list
        // Complexity: O(1) which is constant time 
        head.value = value;
      }
      else {
        // Loop over the list keeping track of our numeric position and a link to the current list item
        // Stop when we reach the target index
        // Complexity: O(n) which is linear time 
        IntListItem current = head;
        int position = 0;
        while (position != index) {
          current = current.next;
          position++;
        }
        // Set the current list item's value
        current.value = value;
      }
    }
  
    public void add(int index, int value) {
      // Check for valid index
      if ((index < 0) || (index > count)) {
        throw new ArrayIndexOutOfBoundsException(index);
      }
  
      // Create a new list item and set its value
      IntListItem newItem = new IntListItem();
      newItem.value = value;
  
      // If we are inserting at the front then its easy
      if (index == 0) {
        // Set the new item's next link to the current head and set the head to the new item
        // Complexity: O(1) which is constant time 
        newItem.next = head;
        head = newItem;
        count++;
      }
      else {
        // Loop over the list starting at numeric position 1 and keeping a link to the current item and the previous item (as well as our numeric index)
        // We need the current and previous item, so that we can thread our new item between them
        // Stop when we reach the target index
        // Complexity: O(n) which is linear time 
        IntListItem previous = head;
        IntListItem current = head.next;
        int position = 1;
        while (position != index) {
          previous = current;
          current = current.next;
          position++;
        }
        // Insert new item between previous and current
        newItem.next = current;
        previous.next = newItem;
        count++;
      }
    }
  
    public void remove(int index) {
      // Check for valid index
      if ((index < 0) || (index > count)) {
        throw new ArrayIndexOutOfBoundsException(index);
      }
  
      // If we are removing from the front then its easy
      if (index == 0) {
        // Set the head to the item following the current head
        // Complexity: O(1) which is constant time 
        head = head.next;
        count--;
      }
      else {
        // Loop over the list starting at numeric position 1 and keeping a link to the current item and the previous item (as well as our numeric index)
        // We need the current and previous item, so that we can link previous to the item following current, thereby cutting out the current item
        // Stop when we reach the target index
        // Complexity: O(n) which is linear time 
        IntListItem previous = head;
        IntListItem current = head.next;
        int position = 1;
        while (position != index) {
          previous = current;
          current = current.next;
          position++;
        }
        // Link previous to the item following current
        previous.next = current.next;
        count--;
      }
    }
  /*
  toString() overloads the base toString method to print out the contents of the list.
  Use this for debugging
  */
    public String toString() {
      String output = "";
      // Start the top item
      IntListItem current = head;
      int position = 0;
      while (current != null) {
        output += String.format("%d: %d%n", position, current.value);
        // Shift to the item below
        current = current.next;
        position++;
      }
      return output;
    }
  }