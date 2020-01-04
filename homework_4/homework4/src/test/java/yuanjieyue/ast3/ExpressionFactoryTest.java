package yuanjieyue.ast3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionFactoryTest {
	private NodeFactory expressionFactory;
	private NodeFactory stateFactory;
	private NumberExpression numExp;
	private StringExpression strExp;
	private VariableExpression varExp;
	private PrefixExpression prefixExp;
	private InfixExpression infixExp;
	private Statement sta1;
	private Statement sta2;

	@Before
	public void setUp() throws Exception {
		expressionFactory = new ExpressionFactory();
		numExp = new NumberExpression(1);
		strExp = new StringExpression("hello");
		varExp = new VariableExpression(new Variable("x"));
		prefixExp = new PrefixExpression(new Operator("+"), numExp, strExp);
		infixExp = new InfixExpression(new Operator("+"), numExp, strExp);
		sta1 = new Declaration(new Variable("x"));
		sta2 = new Assignment(new Variable("x"), numExp);
	}


	@Test
	public void createNode() {
		assertEquals(numExp, expressionFactory.createNode("NumberExpression", 1));
	}

	@Test
	public void createNode1() {
		assertEquals(strExp, expressionFactory.createNode("StringExpression", "hello"));
	}

	@Test
	public void createNode2() {
		assertEquals(varExp, expressionFactory.createNode("VariableExpression", new Variable
			("x")));
	}

	@Test
	public void createNode3() {
		assertEquals(prefixExp, expressionFactory.createNode("PrefixExpression",
			new Operator("+"), numExp, strExp));
	}

	@Test
	public void createNode4() {
		assertEquals(infixExp, expressionFactory.createNode("InfixExpression",
			new Operator("+"), numExp, strExp));
	}

	@Test
	public void createNode5() {
		assertEquals(expressionFactory.createNode("Declaration", new Variable("x"), numExp), null);
	}

	@Test
	public void createNode6() {
		assertEquals(expressionFactory.createNode("Assignment", new Variable("x")), null);
	}

	@Test
	public void createNode7() {
		assertEquals(expressionFactory.createNode("Sequence", sta1, sta2), null);
	}

	@Test
	public void createNode8() {
		assertEquals(expressionFactory.createNode("dfsdafdsf", 1), null);
	}

	@Test
	public void report() {
		Node node1 = expressionFactory.createNode("NumberExpression", 1);
		Node node2 = expressionFactory.createNode("StringExpression", "hello");
		Node node3 = expressionFactory.createNode("VariableExpression", Variable.getVariable("x"));
		Node node4 = expressionFactory.createNode("PrefixExpression", Operator.getOperator("+"),
			(Expression)node1, (Expression)node2);
		Node node5 = expressionFactory.createNode("StringExpression", "world");
		Node node6 = expressionFactory.createNode("VariableExpression", Variable.getVariable("y"));
		String res = expressionFactory.report();

		assertEquals(res, "NumberExpression: 1\n" +
			"StringExpression: 2\n" +
			"VariableExpression: 2\n" +
			"PrefixExpression: 1\n" +
			"InfixExpression: 0");
	}
}