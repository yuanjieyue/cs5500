package yuanjieyue.ast3;
/**
 * Repesents the a string expression.
 * @author Yuanjie Yue
 */
public class StringExpression implements Expression {

	private String string;

	/**
	 * Create a new string expression.
	 * @param string value of the string attribute.
	 */
	protected StringExpression(String string) {
		this.string = string;
	}

	/**
	 * Getter of the string attribute.
	 * @return the string
	 */
	public String getString() {
		return string;
	}

	/**
	 * Setter of the string attribute.
	 * @param string the string to be assigned to the string.
	 */
	public void setString(String string) {
		this.string = string;
	}

	/**
	 *
	 * @return the text presentation of the string expression.
	 */
	public String textRepresentation() {
		return string;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof StringExpression)) {
			return false;
		}

		StringExpression that = (StringExpression) o;

		return getString() != null ? getString().equals(that.getString()) : that.getString() == null;
	}

	@Override
	public int hashCode() {
		return getString() != null ? getString().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "StringExpression{" +
			"string='" + string + '\'' +
			'}';
	}
}
