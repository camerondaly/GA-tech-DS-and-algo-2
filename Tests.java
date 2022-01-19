import java.util.LinkedList;

public class Tests {
    public static void main(String[] args) {
        TreeNode<Integer> testTree = buildTestTree();
        Traversals<Integer> testDriver = new Traversals<>();
        List<Integer> preOrderLL = testDriver.preorder(testTree);
        System.out.println;
    }
    
    

    public TreeNode<Integer> buildTestTree() {
        TreeNode<Integer> root = new TreeNode<>(50);
        root.setLeft(new TreeNode<Integer>(25));
        root.getLeft().setLeft(new TreeNode<Integer>(10));
        root.setRight(new TreeNode<Integer>(100));
        root.getRight().setLeft(new TreeNode<Integer>(75));
        root.getRight().setRight(new TreeNode<Integer>(125));
        root.getRight().getRight().setLeft(new TreeNode<Integer>(110));
        return root;
    }

    public void printList(List<T> list) {
        String res = "";
        for (Integer x: list) {
            res = res.concat(x.toString());
        }
        System.out.println(res);
    }
}
