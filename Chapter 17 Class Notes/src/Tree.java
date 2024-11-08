import java.util.ArrayList;
import java.util.List;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    private Node root;

    static class Node
    {
        public Object data;
        public List<Node> children;


        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int total = 1;
            for(Node child :this.children){
                total += child.size();
            }
            return 0;
        }
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        this.root = new Node();
        this.root.data = rootData;
        this.root.children = new ArrayList<>();
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        this.root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() 
    {
        return this.root.size();
    }

    /**
        Counts the number of leaves in this tree.
        @return the number of leaf nodes in the tree
    */
    public int leafCount() {
        return countLeaves(root);
    }

    /**
        Recursive helper method to count the leaves starting from a given node.
        @param node the starting node
        @return the number of leaf nodes in the subtree rooted at this node
    */
    private int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.children.isEmpty()) {
            return 1;  // It's a leaf if it has no children
        }
        int leafCount = 0;
        for (Node child : node.children) {
            leafCount += countLeaves(child);
        }
        return leafCount;
    }

    // Additional methods will be added in later sections.

    /*
     * A visitor whose visit method is called for each
     * visited node during a tree traversal
     */
    public interface Visitor{
        /*
         * The visit method is called for each visited node
         * @param data: The data of the node being visited
         */
        void visit(Object data);
    }

    /*
     * Traverse this tree in preorder
     * @param v: The visitor to be invoked on each node.
     */
    public void preorder(Visitor v){
        Tree.preorder(this.root, v);

    }

    /*
     * Traverse the tree with a given root in preorder.
     * @param n: The root of the tree to traverse.
     * @param v: The visitor to be invoked on each node.
     */
    private static void preorder(Node n, Visitor v){
        if(n== null){
            return;
        }
        v.visit(n.data);

        for(Node child: n.children){
            Tree.preorder(child, v);
        }
    }

    /**
     * Traverse this tree in depth-first order (preorder).
     * @param v: The visitor to be invoked on each node.
     */
    public void depthFirst(Visitor v){
        Tree.depthFirst(this.root, v);
    }

    /**
     * Helper method to traverse the tree in depth-first order.
     * @param n: The current node.
     * @param v: The visitor to be invoked on each node.
     */
    private static void depthFirst(Node n, Visitor v){
        if(n == null){
            return;
        }
        v.visit(n.data); // Visit the node before its children (preorder)

        for(Node child : n.children){
            Tree.depthFirst(child, v);
        }
    }

    /**
     * Traverse this tree in postorder.
     * @param v: The visitor to be invoked on each node.
     */
    public void postorder(Visitor v){
        Tree.postorder(this.root, v);
    }

    /**
     * Helper method to traverse the tree in postorder.
     * @param n: The current node.
     * @param v: The visitor to be invoked on each node.
     */
    private static void postorder(Node n, Visitor v){
        if(n == null){
            return;
        }

        for(Node child : n.children){
            Tree.postorder(child, v);
        }
        v.visit(n.data); // Visit the node after its children
    }

}
