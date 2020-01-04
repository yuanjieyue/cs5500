package yuanjieyue.ast4;

import java.util.HashMap;
import java.util.Map;

public class StatementFactory extends NodeFactory {
	private Map<Variable, Declaration> map = new HashMap<>();

	public String report() {
		StringBuilder res = new StringBuilder();
		System.out.println("Declaration: " + declCnt);
		res.append("Declaration: ");
		res.append(declCnt);
		res.append("\n");
		System.out.println("Assignment: " + assignCnt);
		res.append("Assignment: ");
		res.append(assignCnt);
		res.append("\n");
		System.out.println("Sequence: " + seqCnt);
		res.append("Sequence: ");
		res.append(seqCnt);
		return res.toString();
	}

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
			if (!map.containsKey(var)) {
				declCnt++;
				map.put(var, new Declaration(var));
			}
			node = map.get(var);
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
			assignCnt++;
			node = new Assignment(var, expression);
		}
		return node;
	}

	@Override
	public Statement createNode(String type, Statement sta1, Statement sta2) {
		if (type == null) return null;
		Statement node = null;
		if (type.equals("Sequence")) {
			seqCnt++;
			node = new Sequence(sta1, sta2);
		}
		return node;
	}
}
