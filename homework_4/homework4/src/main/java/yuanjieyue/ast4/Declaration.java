package yuanjieyue.ast4;

/**
 * Repesents the a declaration statement.
 * @author Yuanjie Yue
 */
public class Declaration implements Statement {

	private Variable variable;

	/**
	 * Create a declaration given a variable name.
	 * @param variable the name of a variable.
	 */
	protected Declaration(Variable variable) {
		this.variable = variable;
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
	 * @param variable the value to be set to the variable.
	 */
	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	/**
	 *
	 * @return The text representation of the declaration.
	 */
	public String textRepresentation() {
		return "var " + variable.getVariable() + ";";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Declaration)) {
			return false;
		}

		Declaration that = (Declaration) o;

		return getVariable() != null ? getVariable().equals(that.getVariable()) : that.getVariable() == null;
	}

	@Override
	public int hashCode() {
		return getVariable() != null ? getVariable().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Declaration{" +
			"variable=" + variable +
			'}';
	}
}
