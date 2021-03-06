import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> list = new ArrayList<>();
        list = preHelper(root, list);
        return list;
    }

    private List<T> preHelper(TreeNode<T> curr, List<T> res) {
        if (curr != null) {
            res.add(curr.getData());
            preHelper(curr.getLeft(), res);
            preHelper(curr.getRight(), res);
        }
        return res;
    }



    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> list = new LinkedList<>();
        list = inHelper(root, list);
        return list;
    }

    private List<T> inHelper(TreeNode<T> curr, List<T> res) {
        if (curr != null) {
            inHelper(curr.getLeft(), res);
            res.add(curr.getData());
            inHelper(curr.getRight(), res);
        }
        return res;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> list = new LinkedList<>();
        list = postHelper(root, list);
        return list;
    }

    private List<T> postHelper(TreeNode<T> curr, List<T> res) {
        if (curr != null) {
            postHelper(curr.getLeft(), res);
            postHelper(curr.getRight(), res);
            res.add(curr.getData());
        }
        return res;
    }
}