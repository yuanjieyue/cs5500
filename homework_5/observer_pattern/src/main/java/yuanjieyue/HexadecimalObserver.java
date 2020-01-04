package yuanjieyue;

public class HexadecimalObserver extends Observer {

	/**
	 * Create a new Hexadecimal Observer given a subject for this observer.
	 * @param subject the subject the observer will observe.
	 */
	public HexadecimalObserver(ConcreteSubject subject) {
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
			int curr = (int) chars[i];
			res.append(Integer.toHexString(curr));
			if (i < len - 1) {
				res.append(" ");
			}
		}
		System.out.println(res.toString());
	}

	@Override
	public String toString() {
		return "HexadecimalObserver" + super.toString();
	}
}
