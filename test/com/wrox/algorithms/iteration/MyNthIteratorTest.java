package com.wrox.algorithms.iteration;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

/**
 * Tests the NthIterator
 * @author David Nelson
 *
 */
public class MyNthIteratorTest extends TestCase {

	/**
	 * Test forwards
	 */
	public void testForwardsIterator() {
        Object[] array = new Object[] {"A", "B", "C", "D", "E", "F"};
        MyNthIterator iterator = new MyNthIterator(array, 1, 5, 2);

        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(array[1], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(array[3], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(array[5], iterator.current());

        iterator.next();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
    }

	/**
	 * Test Backwards
	 */
    public void testReverseIteration() {
        Object[] array = new Object[] {"A", "B", "C"};
        MyNthIterator iterator = new MyNthIterator(array,0,3,2,false);

        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(array[2], iterator.current());

        iterator.next();
        assertFalse(iterator.isDone());
        assertSame(array[0], iterator.current());        

        iterator.next();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
    }

}
