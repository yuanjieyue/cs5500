package yuanjieyue;

/**
 * A Concrete observer that returns the decimal value of the new state of the subject when
 * updating.
 */
public class DecimalObserver extends Observer {

	/**
	 * Create a new Decimal Observer given a subject for this observer.
	 * @param subject the subject the observer will observe.
	 */
	public DecimalObserver(ConcreteSubject subject) {
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
		char[] chars = state.toCharArray();
		StringBuilder res = new StringBuilder();
		int len = chars.length;
		for (int i = 0; i < len; i++) {
			res.append((int)chars[i]);
			if (i < len - 1) {
				res.append(" ");
			}
		}
		System.out.println(res.toString());
	}

	@Override
	public String toString() {
		return "DecimalObserver" + super.toString();
	}
}
