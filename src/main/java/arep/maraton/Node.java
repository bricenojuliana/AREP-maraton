package arep.maraton;

public class Node<T> {
    T value;
    Node<T> left, right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
