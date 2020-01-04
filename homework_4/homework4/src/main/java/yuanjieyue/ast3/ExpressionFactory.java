package yuanjieyue.ast3;

public class ExpressionFactory extends NodeFactory {

	public String report() {
		StringBuilder res = new StringBuilder();
		System.out.println("NumberExpression: " + numExpCnt);
		res.append("NumberExpression: ");
		res.append(numExpCnt);
		res.append("\n");
		System.out.println("StringExpression: " + strExpCnt);
		res.append("StringExpression: ");
		res.append(strExpCnt);
		res.append("\n");
		System.out.println("VariableExpression: " + varExpCnt);
		res.append("VariableExpression: ");
		res.append(varExpCnt);
		res.append("\n");
		System.out.println("PrefixExpression: " + prefixExpCnt);
		res.append("PrefixExpression: ");
		res.append(prefixExpCnt);
		res.append("\n");
		System.out.println("InfixExpression: " + infixExpCnt);
		res.append("InfixExpression: ");
		res.append(infixExpCnt);
		return res.toString();
	}

	@Override
	public Expression createNode(String type, int num) {
		if (type == null) return null;
		Expression node = null;
		if (type.equals("NumberExpression")) {
			numExpCnt++;
			node = new NumberExpression(num);
		}
		return node;
	}

	@Override
	public Expression createNode(String type, String string) {
		if (type == null) return null;
		Expression node = null;
		if (type.equals("StringExpression")) {
			strExpCnt++;
			node = new StringExpression(string);
		}
		return node;
	}

	@Override
	public Expression createNode(String type, Variable var) {
		if (type == null) return null;
		Expression node = null;
		if (type.equals("VariableExpression")) {
			varExpCnt++;
			node = new VariableExpression(var);
		}
		return node;
	}

	@Override
	public Expression createNode(String type, Operator operator, Expression operand1, Expression operand2) {
		if (type == null) return null;
		Expression node = null;
		if (type.equals("PrefixExpression")) {
			prefixExpCnt++;
			node = new PrefixExpression(operator, operand1, operand2);
		} else if (type.equals("InfixExpression")) {
			infixExpCnt++;
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
