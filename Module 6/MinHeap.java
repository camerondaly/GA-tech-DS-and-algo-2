import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data.");
        }
        if (size + 1 == backingArray.length) {
            backingArray = resizeBackingArray(backingArray);
        }
        size++;
        backingArray[size] = data;
        backingArray = upHeap(backingArray, size);
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        T res = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray = downHeap(backingArray, 1);
    }

    /**
     * Handles resizing of backing array by returning a new array with twice
     * the capacity that contains all of backingArray's data. 
     * 
     * Runs in O(n) time.
     * 
     * @param prevBackingArray
     * @return The new backing array.
     */
    private T[] resizeBackingArray(T[] prevBackingArray) {
        T[] newArray= (T[]) new Comparable[prevBackingArray.length * 2];
        for (int i = 1; i < prevBackingArray.length; i++) {
            newArray[i] = prevBackingArray[i];
        }
        return newArray;
    }

    /**
     * Recursively upHeaps the array to resolve violations of the minHeap data ordering
     * properties. Compares data with parent until either a swap is not necessary
     * or the root is reached.
     *  
     * @param heap
     * @param i
     * @return Valid heap.
     */
    private T[] upHeap(T[] heap, int i) {
        int parent = Math.floorDiv(i, 2);
        if (i > 1 && heap[i].compareTo(heap[parent]) < 0) {
            T temp = heap[i];
            heap[i] = heap[parent];
            heap[parent] = temp;
            return upHeap(heap, parent);
        }
        return heap;
    }

    /**
     * Recursively downHeaps data as necessary to ensure valid ordering after
     * a removal. Stops when leaf is reached or a swap is not necessary. 
     * 
     * @param heap
     * @param i
     * @return Valid heap.
     */
    private T[] downHeap(T[] heap, int i) {
        
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}