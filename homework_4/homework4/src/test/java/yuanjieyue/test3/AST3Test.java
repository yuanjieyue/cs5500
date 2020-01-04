package yuanjieyue.test3;

import org.junit.Test;

import yuanjieyue.ast3.*;

public class AST3Test {
	private NodeFactory expressionFactory = new ExpressionFactory();
	private NodeFactory stateFactory = new StatementFactory();

	@Test
	public void test1() {
		Node node1 = expressionFactory.createNode("NumberExpression", 1);
		Node node2 = expressionFactory.createNode("StringExpression", "hello");
		Node node3 = expressionFactory.createNode("VariableExpression", Variable.getVariable("x"));
		Node node4 = expressionFactory.createNode("PrefixExpression", Operator.getOperator("+"),
			(Expression)node1, (Expression)node2);
		Node node5 = expressionFactory.createNode("StringExpression", "world");
		Node node6 = expressionFactory.createNode("VariableExpression", Variable.getVariable("y"));
		Node node7 = stateFactory.createNode("Declaration", Variable.getVariable("x"));
		Node node8 = stateFactory.createNode("Assignment", Variable.getVariable("x"), (Expression)
		node4);
		Node node9 = stateFactory.createNode("Sequence", (Statement)node7, (Statement)node8);
		expressionFactory.report();
		stateFactory.report();
	}
}
