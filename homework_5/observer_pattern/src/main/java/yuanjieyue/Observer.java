package yuanjieyue;

/**
 * The Abstract Observer with the attribute of Subject.
 */
public abstract class Observer {

	protected ConcreteSubject subject;

	/**
	 * Abstract method to update the Observer.
	 */
	public abstract void update();

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Observer)) {
			return false;
		}

		Observer observer = (Observer) o;

		return subject != null ? subject.equals(observer.subject) : observer.subject == null;
	}

	@Override
	public int hashCode() {
		if (subject != null) {
			return subject.getState() != null ? subject.getState().hashCode() : 0;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "{" + "subject=" + (subject != null ? subject.getState() : "") + '}';
	}
}
