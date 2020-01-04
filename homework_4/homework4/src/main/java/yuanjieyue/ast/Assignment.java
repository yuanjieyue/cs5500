package yuanjieyue.ast;

import java.util.Objects;

/**
 * Repesents the an assignment statement.
 * @author Yuanjie Yue
 */
public class Assignment implements Statement {

	private Variable variable;
	private Expression expression;

	/**
	 * Create a new assignment statement given the variable name and an expression.
	 * @param variable the name of the variable.
	 * @param expression the expression to be assigned to the variable {@code variable}.
	 */
	public Assignment(Variable variable, Expression expression) {
		this.variable = variable;
		this.expression = expression;
	}

	/**
	 * Getter for the variable attribute.
	 * @return the name of the variable.
	 */
	public Variable getVariable() {
		return variable;
	}

	/**
	 * Setter for the variable attribute.
	 * @param variable set the variable to be the given variable.
	 */
	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	/**
	 * Getter for the expression attribute.
	 * @return the expression.
	 */
	public Expression getExpression() {
		return expression;
	}

	/**
	 * Setter for the expression attribute.
	 * @param expression the expression to be assigned to the variable.
	 */
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	/**
	 *
	 * @return the text representation of the assignment.
	 */
	public String textRepresentation() {
		String var = variable.getVariable();
		String value = expression.textRepresentation();

		return var + " = " + value + ";";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Assignment)) {
			return false;
		}

		Assignment that = (Assignment) o;

		if (getVariable() != null ? !getVariable().equals(that.getVariable()) : that.getVariable() != null) {
			return false;
		}
		return getExpression() != null ? getExpression().equals(that.getExpression()) : that.getExpression() == null;
	}

	@Override
	public int hashCode() {

		return Objects.hash(getVariable(), getExpression());
	}

	@Override
	public String toString() {
		return "Assignment{" +
			"variable=" + variable +
			", expression=" + expression +
			'}';
	}
}
