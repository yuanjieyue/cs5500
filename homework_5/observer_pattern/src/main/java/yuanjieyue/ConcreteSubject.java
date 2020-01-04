package yuanjieyue;

import java.util.ArrayList;
import java.util.List;

/**
 * The Concrete Class for the subject
 */
public class ConcreteSubject implements Subject {

	private String state;
	private List<Observer> observerList;

	/**
	 * Create a new Concrete Subject with the given state as a String.
	 */
	public ConcreteSubject(String state) {
		this.state = state;
		observerList = new ArrayList<>();
	}

	/**
	 * Getter for the attribute state.
	 * @return value of the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Setter for the attribute state.
	 * @param state value to be assigned to the state.
	 */
	public void setState(String state) {
		this.state = state;
		notifyObservers();
	}

	/**
	 * Getter for the attribute observer list.
	 * @return the list of observers of the subject.
	 */
	public List<Observer> getObserverList() {
		return observerList;
	}

	@Override
	public boolean attach(Observer observer) {
		return observerList.add(observer);
	}

	@Override
	public boolean detach(Observer observer) {
		return observerList.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer currObserver : observerList) {
			currObserver.update();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ConcreteSubject)) {
			return false;
		}

		ConcreteSubject that = (ConcreteSubject) o;

		if (getState() != null ? !getState().equals(that.getState()) : that.getState() != null) {
			return false;
		}
		return getObserverList() != null ? getObserverList().equals(that.getObserverList()) : that.getObserverList() == null;
	}

	@Override
	public int hashCode() {
		int result = getState() != null ? getState().hashCode() : 0;
		result = 31 * result + (getObserverList() != null ? getObserverList().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ConcreteSubject{" +
			"state='" + state + '\'' +
			", observerList=" + observerList +
			'}';
	}
}
