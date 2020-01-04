package yuanjieyue.ast;
/**
 * Repesents the a variable.
 * @author Yuanjie Yue
 */
public class Variable {

	private String variable;

	/**
	 * Create a variable
	 * @param variable the variable.
	 */
	public Variable(String variable) {
		this.variable = variable;
	}

	/**
	 * Getter for the variable attribute.
	 * @return the variable.
	 */
	public String getVariable() {
		return variable;
	}

	/**
	 * Setter for the variable attribute.
	 * @param variable the value to be assigned to the variable.
	 */
	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Variable)) {
			return false;
		}

		Variable variable1 = (Variable) o;

		return getVariable().equals(variable1.getVariable());
	}

	@Override
	public int hashCode() {
		return getVariable() != null ? getVariable().hashCode() : 0;
	}

	@Override
	public String
	toString() {
		return "Variable{" +
			"variable='" + variable + '\'' +
			'}';
	}
}
