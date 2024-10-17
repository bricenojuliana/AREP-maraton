package arep.maraton;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Test inserting nodes
        bst.add(50);
        bst.add(30);
        bst.add(20);
        bst.add(40);
        bst.add(70);
        bst.add(60);
        bst.add(80);

        // In-order traversal (sorted order)
        System.out.println("In-order Traversal:");
        bst.inOrderTraversal();
        System.out.println();

        // Pre-order traversal
        System.out.println("Pre-order Traversal:");
        bst.preOrderTraversal();
        System.out.println();

        // Post-order traversal
        System.out.println("Post-order Traversal:");
        bst.postOrderTraversal();
        System.out.println();

        // Find minimum and maximum values
        System.out.println("Find Minimum: " + bst.findMin());
        System.out.println("Find Maximum: " + bst.findMax());

        // Height of the tree
        System.out.println("Height of BST: " + bst.height());

        // Check if the tree is balanced
        System.out.println("Is the BST Balanced? " + bst.isBalanced());

        // Level-order traversal (breadth-first)
        System.out.println("Level-order Traversal:");
        bst.levelOrderTraversal();
        System.out.println();

        // Count nodes
        System.out.println("Number of nodes: " + bst.countNodes());

        // Searching for a value
        System.out.println("Searching for 40: " + bst.contains(40));
        System.out.println("Searching for 100: " + bst.contains(100));

        // Deleting a node
        System.out.println("Deleting 20...");
        bst.remove(20);
        bst.inOrderTraversal();
        System.out.println();

        // Clearing the tree
        System.out.println("Clearing the BST...");
        bst.clear();
        System.out.println("Number of nodes after clearing: " + bst.countNodes());
    }
}
