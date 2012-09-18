package com.wrox.algorithms.iteration;

/**
 * Chapter 2, Problem 1
 * @author David Nelson
 *
 */
public class MyNthIterator implements Iterator {
	
	/** a delegate iterator */
	Iterator delegate;
	
	/** the step, n */
	private final int step;
	
	/**
	 * Constructor. Creates a delegate {@link ArrayIterator} and sets the step.
	 * @param array the array to iterate over
	 * @param start the starting index
	 * @param end the ending index
	 * @param step the desired step
	 */
	public MyNthIterator(Object[] array, final int start, final int end, final int step) {
		this(array ,start, end, step, true);
	}
	
	/**
	 * Constructor. Creates a delegate {@link ArrayIterator} and sets the step.
	 * @param array the array to iterate over
	 * @param start the starting index
	 * @param end the ending index
	 * @param step the desired step
	 */
	public MyNthIterator(Object[] array, final int start, final int end, final int step, boolean forward) {
			
		ArrayIterator iterator = new ArrayIterator(array,start,end);
		if (!forward) {
			delegate = new ReverseIterator(iterator);
		} else {
			delegate = iterator;
		}
		this.step = step;
	}

	@Override
	public void first() {
		delegate.first();
	}

	@Override
	public void last() {
		delegate.last();
	}

	@Override
	public boolean isDone() {
		return delegate.isDone();
	}

	@Override
	public void next() {
		for (int i=0; i < step; i++) {
			delegate.next();
		}
	}

	@Override
	public void previous() {
		for (int i=0; i < step; i++) {
			delegate.previous();
		}
	}

	@Override
	public Object current() throws IteratorOutOfBoundsException {
		return delegate.current();
	}
}
