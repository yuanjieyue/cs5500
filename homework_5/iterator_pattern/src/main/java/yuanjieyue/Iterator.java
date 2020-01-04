package yuanjieyue;

/**
 * A generic iterator
 */
public interface Iterator<T> {
	/**
	 * Check if there are more elements
	 * @return true if iterator has next element.
	 */
	boolean hasAnotherElement();

	/**
	 * Return the next element
	 * @return the next element
	 */
	T nextElement();
}
