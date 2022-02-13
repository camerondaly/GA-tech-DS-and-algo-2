public class MinHeapTests {

    public static void main(String[] args) {
        testAddForResize();
        testAddForUpHeap();
    }

    public static void testAddForResize() {
        MinHeap<Integer> testHeap = new MinHeap<>();
        for (int i = 1; i < 13; i++) {
            testHeap.add(i);
        }
        Object[] ans = (Object[]) new Comparable[26];
        for (int i = 1; i < 13; i++) {
            ans[i] = i;
        }
        System.out.println(ans.equals(testHeap.getBackingArray()));
    }

    public static void testAddForUpHeap() {
        MinHeap<Integer> testHeap = new MinHeap<>();
        for (int i = 1; i < 9; i++) {
            testHeap.add(i);
        }
        Integer[] ans = new Integer[]{null, 0, 1, 3, 4, 2, 6, 7, 8, 9, 5, null ,null};
        testHeap.add(0);
        System.out.println(ans.equals(testHeap.getBackingArray()));
    }
}
