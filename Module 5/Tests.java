import java.util.ArrayDeque;

public class Tests {
    public static void main(String args[]) {
        BST<Integer> emptyTree = new BST<Integer>();
        BST<Integer> tree = buildTree(emptyTree);
        levelOrderPrint(tree.getRoot());
        System.out.println("removing 10");
        tree.remove(10);
        levelOrderPrint(tree.getRoot());
        System.out.println("removing 50, which has two children: 75 should be successor");
        tree.remove(50);
        levelOrderPrint(tree.getRoot());
        System.out.println("removing 15, which now has 5 as its only child");
        tree.remove(15);
        levelOrderPrint(tree.getRoot());
        System.out.println("adding 20: should become 5's right child");
        tree.add(20);
        levelOrderPrint(tree.getRoot());
    }

    public static BST<Integer> buildTree(BST<Integer> tree) {
        //            50
        //       15       75
        //   5                100
        //     10
        tree.add(50);
        tree.add(15);
        tree.add(75);
        tree.add(5);
        tree.add(100);
        tree.add(10);
        return tree;
    }

    public static void levelOrderPrint(BSTNode<Integer> curr) {
        ArrayDeque<BSTNode<Integer>> q = new ArrayDeque<>();
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            if (curr.getLeft() != null) {
                q.add(curr.getLeft());
            }
            if (curr.getRight() != null) {
                q.add(curr.getRight());
            }
            if (!q.isEmpty()) {
                curr = q.remove();
            } else {
                System.out.println();
                return;
            }
        }
    }
}
