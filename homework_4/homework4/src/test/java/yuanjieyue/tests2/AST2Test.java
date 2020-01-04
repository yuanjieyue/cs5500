package yuanjieyue.tests2;

import org.junit.Test;

import yuanjieyue.ast2.*;

import static org.junit.Assert.assertEquals;

public class AST2Test {

	private NodeFactory expressionFactory = new ExpressionFactory();
	private NodeFactory statementFactory = new StatementFactory();
	@Test
	public void test1(){
		Variable x = Variable.getVariable("x");
		Operator plus = Operator.getOperator("+");
		int num1 = 1, num2 = 2;
		Expression one = (Expression) expressionFactory.createNode("NumberExpression", num1);
		Expression two = (Expression) expressionFactory.createNode("NumberExpression", num2);

		Node exp = expressionFactory.createNode("InfixExpression", plus, one, two);
		Statement decl = (Statement) statementFactory.createNode("Declaration", x);
		Statement assign = (Statement) statementFactory.createNode("Assignment", x, (Expression) exp);
		Statement seq = (Statement) statementFactory.createNode("Sequence", decl, assign);
		assertEquals("var x; x = 1 + 2;", seq.textRepresentation());
	}
}
