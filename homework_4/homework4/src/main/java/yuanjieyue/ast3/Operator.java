package yuanjieyue.ast3;
/**
 * Repesents the an assignment statement.
 * @author Yuanjie Yue
 */
public class Operator {

	public static Operator getOperator(String string) {
		return new Operator(string);
	}

	private String operator;

	/**
	 * Create an operator given an operator as a string.
	 * @param operator the operator.
	 */
	protected Operator (String operator) {
		this.operator = operator;
	}

	/**
	 * Getter for the operator attribute.
	 * @return the operator as a string.
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * Setter for the operator attribute.
	 * @param operator value to be assigned to the operator.
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Operator)) {
			return false;
		}

		Operator operator1 = (Operator) o;

		return getOperator() != null ? getOperator().equals(operator1.getOperator()) : operator1.getOperator() == null;
	}

	@Override
	public int hashCode() {
		return getOperator() != null ? getOperator().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Operator{" +
			"operator='" + operator + '\'' +
			'}';
	}
}
