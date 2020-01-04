package yuanjieyue;

import java.util.ArrayList;

/**
 * A queue adapter.
 * @param <T>
 */
public class QueueAdapter<T> implements Queue<T> {

	private ArrayList<T> adaptee;

	/**
	 * Create a new queue adapter.
	 */
	QueueAdapter() {
		adaptee = new ArrayList<>();
	}

	@Override
	public boolean add(T t) {
		if (t == null) return false;
		return adaptee.add(t);
	}

	@Override
	public T remove() {
		if (adaptee.isEmpty()) {
			return null;
		}
		return adaptee.remove(0);
	}

	@Override
	public T peek() {
		if (adaptee.isEmpty()) {
			return null;
		}
		return adaptee.get(adaptee.size() - 1);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof QueueAdapter)) {
			return false;
		}

		QueueAdapter<?> that = (QueueAdapter<?>) o;

		return adaptee != null ? adaptee.equals(that.adaptee) : that.adaptee == null;
	}

	@Override
	public int hashCode() {
		return adaptee != null ? adaptee.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "QueueAdapter{" +
			"adaptee=" + adaptee +
			'}';
	}
}
