package com.wrox.algorithms.iteration;

/**
 * An {@link Iterator} that filters the results according to some {@link Predicate}.
 *
 */
public class FilterIterator implements Iterator {
    /** The underlying iterator. */
    private final Iterator iterator;

    /** The filter to apply. */
    private final Predicate predicate;

    /**
     * Constructor.
     *
     * @param iterator The underlying iterator.
     * @param predicate The filter to apply.
     */
    public FilterIterator(Iterator iterator, Predicate predicate) {
        assert iterator != null : "iterator can't be null";
        assert predicate != null : "predicate can't be null";
        this.iterator = iterator;
        this.predicate = predicate;
    }

    public void first() {
        iterator.first();
        filterForwards();
    }

    public void last() {
        iterator.last();
        filterBackwards();
    }

    public boolean isDone() {
        return iterator.isDone();
    }

    public void next() {
        iterator.next();
        filterForwards();
    }

    public void previous() {
        iterator.previous();
        filterBackwards();
    }

    public Object current() throws IteratorOutOfBoundsException {
        return iterator.current();
    }

    /**
     * Applies the filter, calling {@link Iterator#next()} on the underlying iterator until either a match is found; or
     * the iterator is done.
     */
    private void filterForwards() {
        while (!iterator.isDone() && !predicate.evaluate(iterator.current())) {
            iterator.next();
        }
    }

    /**
     * Applies the filter, calling {@link Iterator#previous()} on the underlying iterator until either a match is found;
     * or the iterator is done.
     */
    private void filterBackwards() {
        while (!iterator.isDone() && !predicate.evaluate(iterator.current())) {
            iterator.previous();
        }
    }
}
