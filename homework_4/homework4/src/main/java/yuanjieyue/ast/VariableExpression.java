package yuanjieyue.ast;
/**
 * Repesents the a variable expression.
 * @author Yuanjie Yue
 */
public class VariableExpression implements Expression {

	private Variable variable;


	/**
	 * Create a new variable expression.
	 * @param variable the variable.
	 */
	public VariableExpression(Variable variable) {
		this.variable = variable;
	}

	/**
	 * Getter for the attribute variable.
	 * @return the variable.
	 */
	public Variable getVariable() {
		return variable;
	}

	/**
	 * Setter for the attribute variable.
	 * @param variable the variable.
	 */
	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	/**
	 *
	 * @return the text representation of the variable expression.
	 */
	public String textRepresentation() {
		return variable.getVariable();
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof VariableExpression)) {
			return false;
		}

		VariableExpression that = (VariableExpression) o;

		return getVariable().equals(that.getVariable());
	}

	@Override
	public int hashCode() {
		return getVariable().hashCode();
	}

	@Override
	public String toString() {
		return "VariableExpression{" +
			"variable=" + variable +
			'}';
	}
}
