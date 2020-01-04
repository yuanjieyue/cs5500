package yuanjieyue.ast2;
/**
 * Repesents the an assignment statement.
 * @author Yuanjie Yue
 */
public class NumberExpression implements Expression {

	private int num;

	/**
	 * Create a number expression given a integer.
	 * @param num value of the integer.
	 */
	protected NumberExpression(int num) {
		this.num = num;
	}

	/**
	 * Getter for the num attribute.
	 * @return the value of number.
	 */
	public int getNum() {
		return num;
	}

	/**
	 * Setter for the num attribute.
	 * @param num value to be assigned to the number.
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 *
	 * @return the text representation of the number expression.
	 */
	public String textRepresentation() {
		return String.valueOf(num);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof NumberExpression)) {
			return false;
		}

		NumberExpression that = (NumberExpression) o;

		return getNum() == that.getNum();
	}

	@Override
	public int hashCode() {
		return getNum();
	}

	@Override
	public String toString() {
		return "NumberExpression{" +
			"num=" + num +
			'}';
	}
}
