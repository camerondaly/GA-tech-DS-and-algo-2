import org.junit.Test;
import static org.junit.Assert.*;

public class MinHeapTests {

    @Test
    public void testAdd() {
        MinHeap<Integer> testHeap = new MinHeap<>();
        for (int i = 1; i < 4; i++) {
            testHeap.add(i);
        }
        Integer[] ans = (Integer[]) new Comparable[13];
        for (int i = 1; i < 4; i++) {
            ans[i] = i;
        }
        assertArrayEquals(ans, testHeap.getBackingArray());
    }
}
