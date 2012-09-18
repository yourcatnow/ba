package com.wrox.algorithms.iteration;

/**
 * An {@link Iterator} over the contents of an array.
 *
 */
public class ArrayIterator implements Iterator {
    /** The array to iterator over. */
    private final Object[] array;

    /** The position(0, 1, 2...) of the first element. */
    private final int first;

    /* The position (0, 1, 2...) of the last element. */
    private final int last;

    /** The position (0, 1, 2...) of the current element in the array. */
    private int current = -1;

    /**
     * Constructor.
     *
     * @param array The array to iterate over.
     */
    public ArrayIterator(Object[] array) {
        assert array != null : "array can't be null";
        this.array = array;
        this.first = 0;
        this.last = array.length - 1;
    }

    /**
     * Constructor.
     *
     * @param array The array to iterator over.
     * @param start The position (0, 1, 2...) of the element from which to begin iterating.
     * @param length The number of elements to iterator over.
     */
    public ArrayIterator(Object[] array, int start, int length) {
        assert array != null : "array can't be null";
        assert start >= 0 : "start can't be < 0";
        assert start < array.length : "start can't be > array.length";
        assert length >= 0 : "length can't be < 0";

        this.array = array;
        this.first = start;
        this.last = start + length - 1;

        assert last < array.length : "start + length can't be > array.length";
    }

    public void first() {
        current = first;
    }

    public void last() {
        current = last;
    }

    public boolean isDone() {
        return current < first || current > last;
    }

    public void next() {
        ++current;
    }

    public void previous() {
        --current;
    }

    public Object current() throws IteratorOutOfBoundsException {
        if (isDone()) {
            throw new IteratorOutOfBoundsException();
        }
        return array[current];
    }
}
