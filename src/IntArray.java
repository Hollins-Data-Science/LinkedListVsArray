/*
This class implements a general list interface using an array

General List Interface:
size() - return the number of values in the list
get(i) - return the value at position i
set(i, v) - set the value at position i to v
add(i, v) - insert the value v into position i
remove(i) - remove the value at position i
*/
public class IntArray implements IntList {
    private int[] array; // the array backend
    private int arraySize; // the size of the array backend
    private int count; // the number of values being stored
  
    public IntArray() {
      count = 0; // storage starts out with zero values in it
      arraySize = 2; // initial array size of 2 elements
      array  = new int[arraySize]; // create the array
    }
  
  /*
    Resize the array to be larger
    Private method to be used internally
  */
    private void resize() {
      // keep track of the previous array and its array size
      int[] oldArray = array;
      int oldArraySize = arraySize;
  
      // new array is twice the size of the old
      arraySize = oldArraySize*2;
      // allocate new array
      array = new int[arraySize];
  
      // Loop over the old array and copy it to the new array
      for (int i = 0; i < oldArraySize; i++) {
        array[i] = oldArray[i];
      }
    }
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
      // Simply return the value at index position from the array
      // Complexity: O(1) which is constant time 
      return array[index];
    }
  /*
  set(i,v) - set the value at position i to be v
  */
    public void set(int index, int value) {
      // Check for valid index
      if ((index < 0) || (index >= count)) {
        throw new ArrayIndexOutOfBoundsException(index);
      }
      // Simply set the value at the index position in the array
      // Complexity: O(1) which is constant time 
      array[index] = value;
    }
  /*
  add(i,v) - insert the value v into position i
  */
    public void add(int index, int value) {
      if ((index < 0) || (index > count)) {
        throw new ArrayIndexOutOfBoundsException(index);
      }
      // Check if we need to increase the array size to accommodate the new value
      if (count == arraySize) {
        // If so we must copy values into the new array
        // Complexity: O(n) which is linear time 
        resize();
      }
      // Check if we are inserting at the end
      if (index == count) {
        // This is easy as we have empty space at the end of the array
        // Simply set the value at the index position
        // Complexity: O(1) which is constant time 
        array[index] = value;
        count++;
      }
      else {
        // We must loop down to insertion point, shifting every element up one position, so that there is a free spot at the insertion point
        // Complexity: O(n) which is linear time 
        for (int i = count; i > index; i--) {
          array[i] = array[i - 1];
        }
        // Insertion point is now free to set
        array[index] = value;
        count++;
      }
    }
  /*
  remove(i) - remove the value at position i
  */
    public void remove(int index) {
      if ((index < 0) || (index > count)) {
        throw new ArrayIndexOutOfBoundsException(index);
      }
      // Check if we are removing from the end
      if (index == count-1) {
        // Simply decrement the count and our storage will no longer include the value at the end
        // Complexity: O(1) which is constant time 
        count--;
      }
      else {
        // We must loop up from the insertion point, shifting every element down one position, thereby erasing the removed value
        // Complexity: O(n) which is linear time 
        for (int i = index; i < count-1; i++) {
          array[i] = array[i + 1];
        }
        count--;
      }
    }
  /*
  toString() overloads the base toString method to print out the contents of the list.
  Use this for debugging
  */
    public String toString() {
      String output = "";
      // Loop from the beginning outputting all the elements
      for (int i = 0; i < count; i++) {
        output += String.format("%d: %d%n", i, array[i]);
      }
      return output;
    }
  }