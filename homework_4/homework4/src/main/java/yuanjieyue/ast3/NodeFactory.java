package yuanjieyue.ast3;

abstract public class NodeFactory {

	protected int numExpCnt = 0;
	protected int strExpCnt = 0;
	protected int varExpCnt = 0;
	protected int infixExpCnt = 0;
	protected int prefixExpCnt = 0;
	protected int declCnt = 0;
	protected int assignCnt = 0;
	protected int seqCnt = 0;

	/**
	 * Report the number of instances of each type of nodes that are created so far.
	 * @return the relative log as a string.
	 */
	public abstract String report();
	/**
	 * Create a node given its type as string and an integer.
	 * @param type the type of the node.
	 * @param num the integer.
	 * @return the relative node.
	 */
	public abstract Node createNode(String type, int num);

	/**
	 * Create a node given its type as string and a string.
	 * @param type the type of the node.
	 * @param string the string.
	 * @return the relative node.
	 */
	public abstract Node createNode(String type, String string);

	/**
	 * Create a node given its type as string and a variable.
	 * @param type the type of the node.
	 * @param var the variable.
	 * @return the relative node.
	 */
	public abstract Node createNode(String type, Variable var);

	/**
	 * Create a node given its type as string and an operator and two operands as expression.
	 * @param type the type of the node.
	 * @param operator the operator.
	 * @param operand1 the first operand.
	 * @param operand2 the second operand.
	 * @return the relative node.
	 */
	public abstract Node createNode(String type, Operator operator, Expression operand1, Expression
		operand2);

	/**
	 * Create a node given its type as string and an variable and an expression.
	 * @param type the type of the node.
	 * @param var the variable.
	 * @param expression the expression.
	 * @return the relative node.
	 */
	public abstract Node createNode(String type, Variable var, Expression expression);

	/**
	 * Create a node given its type as string and two statements.
	 * @param type the type of the node.
	 * @param sta1 the first statement.
	 * @param sta2 the second statement.
	 * @return the relative node.
	 */
	public abstract Node createNode(String type, Statement sta1, Statement sta2);

}
