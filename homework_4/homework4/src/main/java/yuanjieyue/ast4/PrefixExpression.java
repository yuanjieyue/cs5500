package yuanjieyue.ast4;
/**
 * Repesents the an prefix expression.
 * @author Yuanjie Yue
 */
public class PrefixExpression implements Expression {

	private Operator operator;
	private Expression expression1;
	private Expression expression2;

	/**
	 * Create a new prefix expression given an operator and two expression operands.
	 * @param operator the operator.
	 * @param expression1 the first operand.
	 * @param expression2 the second operand.
	 */
	protected PrefixExpression(Operator operator, Expression expression1, Expression expression2) {
		this.expression1 = expression1;
		this.expression2 = expression2;
		this.operator = operator;
	}

	/**
	 * Getter for the operator attribute.
	 * @return the operator.
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * Setter for the operator attribute.
	 * @param operator the operator to be assigned to the operator.
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	/**
	 * Getter for the first expression operand.
	 * @return the first operand expression.
	 */
	public Expression getExpression1() {
		return expression1;
	}

	/**
	 * Setter for the first expression operand.
	 * @param expression1 value to be assigned to the first expression operand.
	 */
	public void setExpression1(Expression expression1) {
		this.expression1 = expression1;
	}

	/**
	 * Getter for the second expression operand.
	 * @return the second expression.
	 */
	public Expression getExpression2() {
		return expression2;
	}

	/**
	 * Setter for the second expression operand.
	 * @param expression2 the value to be assigned to the second expression operand.
	 */
	public void setExpression2(Expression expression2) {
		this.expression2 = expression2;
	}

	/**
	 *
	 * @return the text representation of the prefix expression.
	 */
	public String textRepresentation() {
		String operatorStr = operator.getOperator();
		String operand1 = expression1.textRepresentation();
		String operand2 = expression2.textRepresentation();

		return operatorStr + " " + operand1 + " " + operand2;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof PrefixExpression)) {
			return false;
		}

		PrefixExpression that = (PrefixExpression) o;

		if (getOperator() != null ? !getOperator().equals(that.getOperator()) : that.getOperator() != null) {
			return false;
		}
		if (getExpression1() != null ? !getExpression1().equals(that.getExpression1()) : that.getExpression1() != null) {
			return false;
		}
		return getExpression2() != null ? getExpression2().equals(that.getExpression2()) : that.getExpression2() == null;
	}

	@Override
	public int hashCode() {
		int result = getOperator() != null ? getOperator().hashCode() : 0;
		result = 31 * result + (getExpression1() != null ? getExpression1().hashCode() : 0);
		result = 31 * result + (getExpression2() != null ? getExpression2().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "PrefixExpression{" +
			"operator=" + operator +
			", expression1=" + expression1 +
			", expression2=" + expression2 +
			'}';
	}
}
