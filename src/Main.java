class Main {
    public static void main(String[] args) {
      // Compare the array vs list implementations
      // Comment out one of the two below lines
      //IntList storage = new IntArray();
      IntList storage = new IntLinkedList();
  
      // add some numbers
      storage.add(0, 8);
      storage.add(1, 16);
      storage.add(2, 64);
      storage.add(0, 2);
      System.out.printf("After the adds:%n%s%n", storage);
  
      // change some
      storage.set(0, 4);
      storage.set(3, 32);
      System.out.printf("After the sets:%n%s%n", storage);
  
      // remove some
      storage.remove(3);
      storage.remove(0);
      System.out.printf("After the removes:%n%s%n", storage);
  
      // try out some gets
      System.out.println("Try out some gets:");
      for (int i = 0; i < storage.size(); i++) {
        System.out.println(storage.get(i));
      }
    }
  }