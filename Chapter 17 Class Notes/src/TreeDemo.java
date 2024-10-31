/**
   This class demonstrates the tree class.
*/
public class TreeDemo
{
   public static void main(String[] args)
   {
      BinaryTree t1 = new BinaryTree("Anne");
      BinaryTree t2 = new BinaryTree("Peter");
      BinaryTree t3 = new BinaryTree("Zara");
      BinaryTree t4 = new BinaryTree("Savannah");

      BinaryTree tLeft = new BinaryTree("Peter", t4, null);  
      BinaryTree tRight = new BinaryTree("Zara", null, null); 
      BinaryTree tRoot = new BinaryTree("Anne", tLeft, tRight); 

   
      System.out.println("Number of nodes with one child: " + tRoot.countNodesWithOneChild());
      
      
      /* Tree t1 = new Tree("Anne");
      Tree t2 = new Tree("Peter");
      t1.addSubtree(t2);
      Tree t3 = new Tree("Zara");
      t1.addSubtree(t3);
      Tree t4 = new Tree("Savannah");
      t2.addSubtree(t4);
      System.out.println("Size: " + t1.size());
      */
   }
}
