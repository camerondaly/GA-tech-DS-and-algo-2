import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 * 
 * @author Cameron Daly
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data.");
        }
        root = addH(data, root);
    }

    /**
     * Recursive helper method for the add() function.
     * 
     * @param data The data being added in the add() method.
     * @param curr The current node as we recurse through the tree.
     * @return The new node
     */
    private BSTNode<T> addH(T data, BSTNode<T> curr) {
        // Recursive helper function. add() is a public wrapper method.
        // base case
        if (curr == null) {
            size++;
            return new BSTNode<>(data);
        } else if (data.compareTo(curr.getData()) > 0) {
            curr.setRight(addH(data, curr.getRight()));
        } else if (data.compareTo(curr.getData()) < 0) {
            curr.setLeft(addH(data, curr.getLeft()));
        } 
        // returns all unchanged nodes back to their parents
        return curr;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Cannot remove null data.");
        }
        // We require a dummy node in order to return the removed data.
        BSTNode<T> dummy = new BSTNode<>(null);
        root = removeH(data, root, dummy);
        return dummy.getData();
    }

    /**
     * Recursive helper method for the remove() function. Calls successorH() 
     * as necessary. 
     * 
     * @param data The to be removed.
     * @param curr The current node as we recurse through the tree.
     * @return The new node.
     */
    private BSTNode<T> removeH(T data, BSTNode<T> curr, BSTNode<T> dummy) {
        if (curr == null) {
            throw new NoSuchElementException("Data not present in tree.");
        } else if (data.compareTo(curr.getData()) > 0) {
            curr.setRight(removeH(data, curr.getRight(), dummy));
        } else if (data.compareTo(curr.getData()) < 0) {
            curr.setLeft(removeH(data, curr.getLeft(), dummy));
        } else {
            dummy.setData(curr.getData());
            size--;
            // Three cases: No child, one child, and two children.
            if (curr.getLeft() == null && curr.getRight() == null) {
                return null;
            } else if (curr.getLeft() == null || curr.getRight() == null) {
                return (curr.getLeft() == null) ? curr.getRight() : curr.getLeft();
            } else {
                BSTNode<T> temp = new BSTNode<>(null);
                curr.setRight(successorH(curr.getRight(),temp));
                curr.setData(temp.getData());
            }
        }
        return curr;
    }

    /**
     * Establishes the successor node to be used, handles the case where the 
     * node to be removed has two children. Finds and removes successor. 
     * 
     * @param curr The node at which we began the search for the successor.
     * @param temp A temporary node used to store the successor's data.
     * @return The successor node which will be the new right child of the node 
     * we left the helper method at in the recursve stack. Recurses all the way 
     * to the left to find the successor. 
     */
    private BSTNode<T> successorH(BSTNode<T> curr, BSTNode<T> temp) {
        if (curr.getLeft() == null) {
            temp.setData(curr.getData());
            return curr.getRight();
        } else {
            curr.setLeft(successorH(curr.getLeft(), temp));
        }
        return curr;
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}