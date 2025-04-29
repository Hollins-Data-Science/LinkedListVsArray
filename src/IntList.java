/*
The general list interface as described in Open Data Structures.
This version is specific to integers.

General List Interface:
size() - return the number of values in the list
get(i) - return the value at position i
set(i, v) - set the value at position i to v
add(i, v) - insert the value v into position i
remove(i) - remove the value at position i
*/

public interface IntList {
    int size(); // Number of elements in list
    int get(int index); // Get element at index
    void set(int index, int value); // Set element at index to value
    void add(int index, int value); // Insert value at index
    void remove(int index); // Remove element at index
}