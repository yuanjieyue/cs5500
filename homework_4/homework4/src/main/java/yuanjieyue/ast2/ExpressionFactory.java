package yuanjieyue.ast2;

public class ExpressionFactory extends NodeFactory {

	@Override
	public Expression createNode(String type, int num) {
		if (type == null) return null;
		Expression node = null;
		if (type.equals("NumberExpression")) {
			node = new NumberExpression(num);
		}
		return node;
	}

	@Override
	public Expression createNode(String type, String string) {
		if (type == null) return null;
		Expression node = null;
		if (type.equals("StringExpression")) {
			node = new StringExpression(string);
		}
		return node;
	}

	@Override
	public Expression createNode(String type, Variable var) {
		if (type == null) return null;
		Expression node = null;
		if (type.equals("VariableExpression")) {
			node = new VariableExpression(var);
		}
		return node;
	}

	@Override
	public Expression createNode(String type, Operator operator, Expression operand1, Expression operand2) {
		if (type == null) return null;
		Expression node = null;
		if (type.equals("PrefixExpression")) {
			node = new PrefixExpression(operator, operand1, operand2);
		} else if (type.equals("InfixExpression")) {
			node = new InfixExpression(operator, operand1, operand2);
		}
		return node;
	}

	@Override
	public Node createNode(String type, Variable var, Expression expression) {
		return null;
	}

	@Override
	public Node createNode(String type, Statement sta1, Statement sta2) {
		return null;
	}
}
