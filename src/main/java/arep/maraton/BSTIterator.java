package arep.maraton;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BSTIterator<T extends Comparable<T>> implements Iterator<T> {
    private Queue<T> queue = new LinkedList<>();

    public BSTIterator(Node<T> root) {
        inOrderTraversalRec(root);
    }

    private void inOrderTraversalRec(Node<T> root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            queue.add(root.value);
            inOrderTraversalRec(root.right);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return queue.poll();
    }
}

