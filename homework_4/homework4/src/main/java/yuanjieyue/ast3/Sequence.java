package yuanjieyue.ast3;
/**
 * Repesents the an infix expression.
 * @author Yuanjie Yue
 */
public class Sequence implements Statement {
	private Statement statement1;
	private Statement statement2;

	/**
	 * Create a sequence statement given two statements.
	 * @param statement1 the first statement.
	 * @param statement2 the second statement.
	 */
	protected Sequence(Statement statement1, Statement statement2) {
		this.statement1 = statement1;
		this.statement2 = statement2;
	}

	/**
	 * Getter for the first statement attribute.
	 * @return the first statement.
	 */
	public Statement getStatement1() {
		return statement1;
	}

	/**
	 * Setter for the first statement attribute.
	 * @param statement1 value to be assigned to the first statement.
	 */
	public void setStatement1(Statement statement1) {
		this.statement1 = statement1;
	}

	/**
	 * Getter for the second statement.
	 * @return the second statement.
	 */
	public Statement getStatement2() {
		return statement2;
	}

	/**
	 * Setter for the second statement attribute.
	 * @param statement2 the value to be assigned to the second statement.
	 */
	public void setStatement2(Statement statement2) {
		this.statement2 = statement2;
	}

	/**
	 *
	 * @return the text presentation of the sequence.
	 */
	public String textRepresentation() {
		String part1 = statement1.textRepresentation();
		String part2 = statement2.textRepresentation();
		return part1 + " " + part2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Sequence)) {
			return false;
		}

		Sequence sequence = (Sequence) o;

		if (getStatement1() != null ? !getStatement1().equals(sequence.getStatement1()) : sequence.getStatement1() != null) {
			return false;
		}
		return getStatement2() != null ? getStatement2().equals(sequence.getStatement2()) : sequence.getStatement2() == null;
	}

	@Override
	public int hashCode() {
		int result = getStatement1() != null ? getStatement1().hashCode() : 0;
		result = 31 * result + (getStatement2() != null ? getStatement2().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Sequence{" +
			"statement1=" + statement1 +
			", statement2=" + statement2 +
			'}';
	}
}
