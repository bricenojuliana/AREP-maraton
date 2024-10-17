# BinarySearchTree

This project implements a generic Binary Search Tree (BST) in Java, which conforms to the Java Collections API. It supports basic operations such as insertion, deletion, searching, and various tree traversals. Additionally, it includes extra methods to check if the tree is balanced and to find the minimum and maximum elements.

## Features
- **Insertion**: Add elements to the BST while maintaining order.
- **Deletion**: Remove elements while keeping the tree structure valid.
- **Search**: Check if an element exists in the tree.
- **Traversals**: In-order, pre-order, post-order, and level-order traversals.
- **Find Minimum/Maximum**: Retrieve the smallest or largest element.
- **Check Balance**: Determine if the tree is balanced (difference in height between left and right subtrees for all nodes is not greater than 1).
- **Supports Java Collections API**: Implements methods from the `Collection` interface, such as `add`, `remove`, `contains`, `size`, and more.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven (optional, for building and running tests)

### Installation
1. **Clone the repository**:
   ```bash
   git clone https://github.com/bricenojuliana/AREP-maraton.git
   ```
2. **Navigate to the project directory**:
   ```bash
   cd AREP-maraton
   ```

3. **Compile the project**:
   ```bash
   mvn clean package
   ```

4. **Run the application**:
   ```bash
   java -cp target/BinarySearchTree-1.0-SNAPSHOT.jar arep.maraton.App
   ```

![image](https://github.com/user-attachments/assets/bc73cc3c-8436-48a7-a52d-7af69a95ac77)

### Running the Tests
To run the JUnit tests for the `BinarySearchTree` class, you can use Maven:

1. **Navigate to the project root directory**:
   ```bash
   cd BinarySearchTree
   ```

2. **Run the tests**:
   ```bash
   mvn test
   ```
![image](https://github.com/user-attachments/assets/68c51014-d1df-42fc-aff4-0c56300d3381)


## Usage

### Basic Operations
```java
import arep.maraton.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Insert elements
        bst.add(5);
        bst.add(3);
        bst.add(7);

        // Check if a value exists
        boolean containsThree = bst.contains(3); // returns true

        // Remove an element
        bst.remove(3);

        // Perform in-order traversal
        bst.inOrderTraversal(); // Output: 5 7

        // Check if the tree is balanced
        boolean isBalanced = bst.isBalanced(); // returns true or false
    }
}
```

### Collection Interface Methods
Since the `BinarySearchTree` class implements the `Collection` interface, you can use common methods like `addAll`, `clear`, `size`, `isEmpty`, and others.


## Testing
JUnit tests are provided to verify the functionality of the main methods in the `BinarySearchTree` class. The tests include:
- Insertion and deletion operations
- Checking if the tree contains specific elements
- Validating tree traversals
- Checking if the tree is balanced

## Author
Juliana Briceño
