import java.util.List;
import java.util.LinkedList;

public class Tests {
    public static void main(String[] args) {
        TreeNode<Integer> testTreeRoot = buildTestTree();
        Traversals<Integer> traversalDriver = new Traversals<>();
        List<Integer> preOrderLL = new LinkedList<Integer>();
        preOrderLL = traversalDriver.preorder(testTreeRoot);
        System.out.print("preorder: ");
        printList(preOrderLL);

        List<Integer> inOrderLL = new LinkedList<Integer>();
        inOrderLL = traversalDriver.inorder(testTreeRoot);
        System.out.print("inorder: ");
        printList(inOrderLL);
    
        List<Integer> postOrderLL = new LinkedList<Integer>();
        postOrderLL = traversalDriver.postorder(testTreeRoot);
        System.out.print("postorder: ");
        printList(postOrderLL);
    }
    
    

    public static TreeNode<Integer> buildTestTree() {
        TreeNode<Integer> root = new TreeNode<>(50);
        root.setLeft(new TreeNode<Integer>(25));
        root.getLeft().setLeft(new TreeNode<Integer>(10));
        root.setRight(new TreeNode<Integer>(100));
        root.getRight().setLeft(new TreeNode<Integer>(75));
        root.getRight().setRight(new TreeNode<Integer>(125));
        root.getRight().getRight().setLeft(new TreeNode<Integer>(110));
        return root;
    }

    public static void printList(List<Integer> list) {
        String res = "";
        for (Integer x: list) {
            res = res.concat(x.toString() + ", ");
        }
        res = res.substring(0, res.length() - 2);
        System.out.println(res);
    }
}
