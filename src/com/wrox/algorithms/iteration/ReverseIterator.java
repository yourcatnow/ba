package com.wrox.algorithms.iteration;

/**
 * An {@link Iterator} that reverses the iteration direction of another.
 *
 */
public class ReverseIterator implements Iterator {
    /** The underlying iterator. */
    private final Iterator iterator;

    /**
     * Constructor.
     *
     * @param iterator The underlying iterator.
     */
    public ReverseIterator(Iterator iterator) {
        assert iterator != null : "iterator can't be null";
        this.iterator = iterator;
    }

    public void first() {
        iterator.last();
    }

    public void last() {
        iterator.first();
    }

    public boolean isDone() {
        return iterator.isDone();
    }

    public void next() {
        iterator.previous();
    }

    public void previous() {
        iterator.next();
    }

    public Object current() throws IteratorOutOfBoundsException {
        return iterator.current();
    }
}
