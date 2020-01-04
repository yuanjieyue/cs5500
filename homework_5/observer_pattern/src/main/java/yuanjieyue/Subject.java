package yuanjieyue;

/**
 * The subject of multiple observers.
 */
public interface Subject {

	/**
	 * Attach the given observer to the observer list.
	 * @param observer the observer to be added to the observer list.
	 * @return true if add successfully, false otherwise.
	 */
	boolean attach(Observer observer);

	/**
	 * Dettach the given observer from the observer list.
	 * @param observer the observer to be removed from the observer list.
	 * @return true if remove successfully. false otherwise.
	 */
	boolean detach(Observer observer);

	/**
	 * Notify all the observers the state change of the subject.
	 */
	void notifyObservers();
}
