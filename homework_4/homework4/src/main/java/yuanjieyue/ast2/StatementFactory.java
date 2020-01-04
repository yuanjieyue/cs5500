package yuanjieyue.ast2;

public class StatementFactory extends NodeFactory {

	@Override
	public Statement createNode(String type, int num) {
		return null;
	}

	@Override
	public Statement createNode(String type, String string) {
		return null;
	}

	@Override
	public Statement createNode(String type, Variable var) {
		if (type == null) return null;
		Statement node = null;
		if (type.equals("Declaration")) {
			node = new Declaration(var);
		}
		return node;
	}


	@Override
	public Statement createNode(String type, Operator operator, Expression operand1, Expression operand2) {
		return null;
	}

	@Override
	public Statement createNode(String type, Variable var, Expression expression) {
		if (type == null) return null;
		Statement node = null;
		if (type.equals("Assignment")) {
			node = new Assignment(var, expression);
		}
		return node;
	}

	@Override
	public Statement createNode(String type, Statement sta1, Statement sta2) {
		if (type == null) return null;
		Statement node = null;
		if (type.equals("Sequence")) {
			node = new Sequence(sta1, sta2);
		}
		return node;
	}
}
