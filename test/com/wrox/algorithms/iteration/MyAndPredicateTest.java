package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

/**
 * Chapter 2, Problem 2 Test
 * @score 4/10
 *    - missed half the test (false-false and false-true)
 *    - over-complicated DummyPredicate
 * @author David Nelson
 *
 */
public class MyAndPredicateTest extends TestCase {
	private static final Object[] ARRAY = {"A", "B", "C"};
	private static final DummyPredicate DUMMY_TRUE = new DummyPredicate(true, new ArrayIterator(ARRAY));
	private static final DummyPredicate DUMMY_TRUE_2 = new DummyPredicate(true, new ArrayIterator(ARRAY));
	private static final DummyPredicate DUMMY_FALSE = new DummyPredicate(false, new ArrayIterator(ARRAY));
	
	public void testAndTrueTrue() {
		MyAndPredicate and = new MyAndPredicate(DUMMY_TRUE, DUMMY_TRUE_2);
		Iterator arrayIter = new ArrayIterator(ARRAY);
		FilterIterator iterator = new FilterIterator(arrayIter,and);
		
		iterator.first();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[0], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[1], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[2], iterator.current());
		
		iterator.next();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
	}
	
    public void testAndTrueFalse() {
    	Predicate and = new MyAndPredicate(DUMMY_TRUE, DUMMY_FALSE);
    	Iterator arrayIter = new ArrayIterator(ARRAY);
		FilterIterator iterator = new FilterIterator(arrayIter,and);
		
		iterator.first();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
	}
	
	private static final class DummyPredicate implements Predicate {
        private final Iterator iterator;
        private final boolean result;

        public DummyPredicate(boolean result, Iterator iterator) {
            this.iterator = iterator;
            this.result = result;
            this.iterator.first();
        }

        public boolean evaluate(Object object) {
            iterator.next();
            return result;
        }
    }
}
