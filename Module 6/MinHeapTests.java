import javax.swing.text.html.StyleSheet;

public class MinHeapTests {

    public static void main(String[] args) {
        testAddForResize();
        testAddForUpHeap();
        testRemove();
    }

    public static void testAddForResize() {
        int ansSize = 0;
        MinHeap<Integer> testHeap = new MinHeap<>();
        for (int i = 1; i < 14; i++) {
            testHeap.add(i);
        }
        Integer[] ans = new Integer[26];
        for (int i = 1; i < 14; i++) {
            ansSize++;
            ans[i] = i;
        }
        System.out.println("TEST FOR HANDLING RESIZING: ");
        printArrays(testHeap.getBackingArray(), ans);
        System.out.printf("Size is correct?: %b \n\n", (testHeap.size() == ansSize));
    }

    public static void testAddForUpHeap() {
        MinHeap<Integer> testHeap = new MinHeap<>();
        for (int i = 1; i < 10; i++) {
            testHeap.add(i);
        }
        Integer[] ans = new Integer[]{null, 0, 1, 3, 4, 2, 6, 7, 8, 9, 5, null ,null};
        int ansSize = 10;
        System.out.println("TEST FOR HANDLING UPHEAP DURING ADD(): ");
        System.out.println("arrays prior to add(0): ");
        printArrays(testHeap.getBackingArray(), ans);
        testHeap.add(0);
        System.out.println("arrays after to add(0): ");
        printArrays(testHeap.getBackingArray(), ans);
        System.out.printf("Size is correct?: %b \n\n", (testHeap.size() == ansSize));
    }

    public static void testRemove() {
        int ansSize = 10;
        MinHeap<Integer> testHeap = new MinHeap<>();
        Integer[] testStartBackingArray = new Integer[]{0,1,2,4,3,5,7,6,8,9,10};
        for (int i = 1; i <= testStartBackingArray.length; i++) {
            testHeap.add(testStartBackingArray[i-1]);
        }
        Integer[] ans = new Integer[]{1, 3, 2, 4, 9, 5, 7, 6, 8, 10};
        System.out.println("TEST FOR HANDLING DOWNHEAP DURING REMOVE(): ");
        System.out.println("arrays prior to remove(): ");
        printArrays(testHeap.getBackingArray(), ans);
        testHeap.remove();
        System.out.println("arrays after remove(): ");
        printArrays(testHeap.getBackingArray(), ans);
        System.out.printf("Size is correct?: %b \n\n", (testHeap.size() == ansSize));
    }

    public static void printArrays(Object[] testArray, Object[] answerArray) {
        String res1 = "";
        for (Object x : testArray) {
            if (x != null) {
                res1 = res1.concat(x.toString() + " ");
            }
        }
        String res2 = "";
        for (Object y : answerArray) {
            if (y != null) {
                res2 = res2.concat(y.toString() + " ");
            }
        }
        System.out.println("testHeap as array: ");
        System.out.println(res1);
        System.out.printf("TestHeap Capacity: %d \n\n", testArray.length);
        System.out.println("ans as array: ");
        System.out.println(res2);
        System.out.printf("AnsHeap Capacity: %d \n\n", answerArray.length);
    }
}
