package arep.maraton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    void testAdd() {
        assertTrue(bst.add(5));
        assertTrue(bst.add(3));
        assertTrue(bst.add(7));
        assertFalse(bst.add(5)); // Adding duplicate
        assertEquals(3, bst.size());
    }

    @Test
    void testContains() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(3));
        assertFalse(bst.contains(10));
    }

    @Test
    void testRemove() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        assertTrue(bst.remove(5));
        assertFalse(bst.contains(5));
        assertFalse(bst.remove(10)); // Removing non-existent value
    }

    @Test
    void testInOrderTraversal() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(1);
        bst.add(4);

        // Capturing the standard output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Perform in-order traversal
        bst.inOrderTraversal();

        // Restore the original standard output
        System.setOut(originalOut);

        // Checking if the output matches the expected order: 1 3 4 5 7
        String inOrderOutput = outputStream.toString().trim();
        assertEquals("1 3 4 5 7", inOrderOutput);
    }

    @Test
    void testFindMinAndMax() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(1);
        bst.add(9);
        assertEquals(Integer.valueOf(1), bst.findMin());
        assertEquals(Integer.valueOf(9), bst.findMax());
    }

    @Test
    void testHeight() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(1);
        bst.add(9);
        assertEquals(3, bst.height()); // Height of the tree
    }

    @Test
    void testIsBalanced() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Test an initially empty tree (should be balanced)
        assertTrue(bst.isBalanced(), "An empty tree should be considered balanced");

        // Test a balanced tree
        bst.add(5);
        bst.add(3);
        bst.add(7);
        assertTrue(bst.isBalanced(), "Tree with root 5, left 3, right 7 should be balanced");

        // Test unbalancing the tree by adding nodes to one side
        bst.add(9);
        bst.add(10);
        assertFalse(bst.isBalanced(), "Tree should be unbalanced after adding nodes 9 and 10");

        // Clear the tree and test a balanced scenario again
        bst.clear();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(13);
        bst.add(17);
        assertTrue(bst.isBalanced(), "Tree with a full set of left and right children should be balanced");

        // Add more nodes to unbalance the tree
        bst.add(1);
        bst.add(0);
        assertFalse(bst.isBalanced(), "Tree should be unbalanced after adding nodes 1 and 0 to the left");
    }


    @Test
    void testCountNodes() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        assertEquals(3, bst.countNodes());
    }
}
