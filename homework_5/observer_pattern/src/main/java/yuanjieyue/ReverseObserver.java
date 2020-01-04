package yuanjieyue;

public class ReverseObserver extends Observer {

	/**
	 * Create a new Reverse Observer given a subject for this observer.
	 * @param subject the subject the observer will observe.
	 */
	public ReverseObserver(ConcreteSubject subject) {
		if (subject == null) return;
		if (this.subject != null) {
			this.subject.detach(this);
		}
		this.subject = subject;
		subject.attach(this);
	}

	@Override
	public void update() {
		if (subject == null || subject.getState() == null) return;
		String state = subject.getState();
		System.out.println(new StringBuilder(state).reverse());
	}

	@Override
	public String toString() {
		return "ReverseObserver" + super.toString();
	}
}
