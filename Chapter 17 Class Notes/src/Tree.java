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
        return root.size();
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
}
