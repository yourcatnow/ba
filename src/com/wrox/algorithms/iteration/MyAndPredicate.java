package com.wrox.algorithms.iteration;

/**|
 * Chapter 2, Problem 2
 * @score 8/10
 *  - missed asserts (nullcheck) on construction
 * @author David Nelson
 *
 */
public class MyAndPredicate implements Predicate {
	
	/** predicate one */
	private final Predicate predicate1;
	
	/** predicate two */
	private final Predicate predicate2;
	
	/**
	 * Constructs an AND predicate
	 * @param one first predicate
	 * @param two second predicate
	 */
	public MyAndPredicate(Predicate one, Predicate two) {
		predicate1 = one;
		predicate2 = two;
	}

	/**
	 * Overridden to && predicate1 with predicate2
	 */
	@Override
	public boolean evaluate(Object object) {
		return predicate1.evaluate(object) && predicate2.evaluate(object);
	}

}
