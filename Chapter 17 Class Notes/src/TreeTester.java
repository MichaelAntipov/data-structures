/**
   This program tests the binary search tree class.
*/
public class TreeTester
{ 
   public static void main(String[] args)
   {  
      /*BinarySearchTree t = new BinarySearchTree();
      t.add("D");
      t.add("B");
      t.add("A");
      t.add("C");
      t.add("F");
      t.add("E");
      t.add("I");
      t.add("G");
      t.add("H");
      t.add("J");
      t.remove("A"); // Removing leaf
      t.remove("B"); // Removing element with one child
      t.remove("F"); // Removing element with two children
      t.remove("D"); // Removing root
      t.print();
      System.out.println("Expected: C E G H I J");*/

      Tree t = new Tree("Root");
        Tree child1 = new Tree("Child 1");
        Tree child2 = new Tree("Child 2");
        Tree child3 = new Tree("Child 3");
        Tree leaf1 = new Tree("Leaf 1");
        Tree leaf2 = new Tree("Leaf 2");

        t.addSubtree(child1);
        t.addSubtree(child2);
        child1.addSubtree(child3);
        child3.addSubtree(leaf1);
        child3.addSubtree(leaf2);

        System.out.println("Number of leaves: " + t.leafCount());
   }
}

