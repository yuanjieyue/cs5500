package yuanjieyue;

/**
 * A generic queue.
 * @param <T> the type holds in the queue.
 */
public interface Queue<T> {

	/**
	 * Add an element to the head of the queue.
	 * @param t the element to be added into the queue.
	 * @return true if added successfully, false otherwise.
	 */
	boolean add(T t);

	/**
	 * Remove an element from the end of the queue. Returns null if queue is empty.
	 * @return the element at the end of the queue.
	 */
	T remove();

	/**
	 * Returns the head of the queue. Return null if the queue is empty.
	 * @return the element at the head of the queue.
	 */
	T peek();
}
