package arep.maraton;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements Collection<T> {

    private Node<T> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    // 1. Insert a value into the BST
    @Override
    public boolean add(T value) {
        if (!contains(value)) {
            root = insertRec(root, value);
            size++;
            return true;
        }
        return false;
    }

    private Node<T> insertRec(Node<T> root, T value) {
        if (root == null) {
            return new Node<>(value);
        }

        if (value.compareTo(root.value) < 0) {
            root.left = insertRec(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // 2. Delete a value from the BST
    @Override
    public boolean remove(Object value) {
        if (contains(value)) {
            root = deleteRec(root, (T) value);
            size--;
            return true;
        }
        return false;
    }

    private Node<T> deleteRec(Node<T> root, T value) {
        if (root == null) {
            return null;
        }

        if (value.compareTo(root.value) < 0) {
            root.left = deleteRec(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            T minValue = findMinRec(root.right);
            root.value = minValue;
            root.right = deleteRec(root.right, minValue);
        }

        return root;
    }

    // 3. Search for a value in the BST
    @Override
    public boolean contains(Object value) {
        return searchRec(root, (T) value) != null;
    }

    private Node<T> searchRec(Node<T> root, T value) {
        if (root == null || root.value.equals(value)) {
            return root;
        }

        if (value.compareTo(root.value) < 0) {
            return searchRec(root.left, value);
        }

        return searchRec(root.right, value);
    }

    // 4. In-order traversal (left, root, right)
    public void inOrderTraversal() {
        inOrderTraversalRec(root);
        System.out.println();
    }

    private void inOrderTraversalRec(Node<T> root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.value + " ");
            inOrderTraversalRec(root.right);
        }
    }

    // 5. Pre-order traversal (root, left, right)
    public void preOrderTraversal() {
        preOrderTraversalRec(root);
        System.out.println();
    }

    private void preOrderTraversalRec(Node<T> root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraversalRec(root.left);
            preOrderTraversalRec(root.right);
        }
    }

    // 6. Post-order traversal (left, right, root)
    public void postOrderTraversal() {
        postOrderTraversalRec(root);
        System.out.println();
    }

    private void postOrderTraversalRec(Node<T> root) {
        if (root != null) {
            postOrderTraversalRec(root.left);
            postOrderTraversalRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Additional methods for BST functionality
    public T findMin() {
        return findMinRec(root);
    }

    private T findMinRec(Node<T> root) {
        if (root == null) {
            return null;
        }

        while (root.left != null) {
            root = root.left;
        }
        return root.value;
    }

    public T findMax() {
        return findMaxRec(root);
    }

    private T findMaxRec(Node<T> root) {
        if (root == null) {
            return null;
        }

        while (root.right != null) {
            root = root.right;
        }
        return root.value;
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node<T> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Collection interface methods
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new BSTIterator<>(root);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            if (remove(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (T element : this) {
            if (!c.contains(element)) {
                remove(element);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public Object[] toArray() {
        LinkedList<T> list = new LinkedList<>();
        for (T element : this) {
            list.add(element);
        }
        return list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        LinkedList<T> list = new LinkedList<>();
        for (T element : this) {
            list.add(element);
        }
        return list.toArray(a);
    }

    public boolean isBalanced() {
        return isBalancedRec(root) != -1;
    }

    private int isBalancedRec(Node<T> node) {
        if (node == null) {
            return 0; // An empty tree is considered balanced
        }

        int leftHeight = isBalancedRec(node.left);
        int rightHeight = isBalancedRec(node.right);

        // If the left or right subtree is not balanced, propagate the failure upwards
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        // If the height difference is more than 1, the tree is not balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }



    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }
}

