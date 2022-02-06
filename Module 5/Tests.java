public class Tests {
    public static void main(String args[]) {
        BSTNode<Integer> root = buildTree();

    }

    public static BSTNode<Integer> buildTree() {
        //            50
        //       15       75
        //   5                100
        //     10
        BSTNode<Integer> treeRoot = new BSTNode<>(50);
        treeRoot.setLeft(new BSTNode<>(15));
        treeRoot.setRight(new BSTNode<>(75));
        treeRoot.getLeft().setLeft(new BSTNode<>(5));
        treeRoot.getLeft().getLeft().setRight(new BSTNode<>(10));
        treeRoot.getRight().setRight(new BSTNode<>(100));
        return treeRoot;
    }

    public static void levelOrderPrint() {
        // implement
    }
}
