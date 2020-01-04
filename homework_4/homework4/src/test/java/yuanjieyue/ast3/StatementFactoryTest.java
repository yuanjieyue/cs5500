package yuanjieyue.ast3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatementFactoryTest {
	private NodeFactory expressionFactory;
	private NodeFactory stateFactory;
	private NumberExpression numExp;
	private StringExpression strExp;
	private Declaration decl;
	private Assignment assign;
	private Sequence seq;

	@Before
	public void setUp() throws Exception {
		expressionFactory = new ExpressionFactory();
		stateFactory = new StatementFactory();
		numExp = new NumberExpression(1);
		strExp = new StringExpression("hello");
		decl = new Declaration(new Variable("x"));
		assign = new Assignment(new Variable("x"), numExp);
		seq = new Sequence(decl, assign);
	}

	@Test
	public void createNode() {
		assertEquals(null, stateFactory.createNode("NumberExpression", 1));
	}

	@Test
	public void createNode1() {
		assertEquals(null, stateFactory.createNode("StringExpression", "hello"));
	}

	@Test
	public void createNode2() {
		assertEquals(null, stateFactory.createNode("VariableExpression", new Variable
			("x")));
	}

	@Test
	public void createNode3() {
		assertEquals(null, stateFactory.createNode("PrefixExpression",
			new Operator("+"), numExp, strExp));
	}

	@Test
	public void createNode4() {
		assertEquals(null, stateFactory.createNode("InfixExpression",
			new Operator("+"), numExp, strExp));
	}

	@Test
	public void createNode5() {
		assertEquals(stateFactory.createNode("Declaration", new Variable("x")), decl);
	}

	@Test
	public void createNode6() {
		assertEquals(stateFactory.createNode("Assignment", new Variable("x"), numExp), assign);
	}

	@Test
	public void createNode7() {
		assertEquals(stateFactory.createNode("Sequence", decl, assign), seq);
	}

	@Test
	public void createNode8() {
		assertEquals(stateFactory.createNode("dfsdafdsf", 1), null);
	}

	@Test
	public void report() {
		Node node1 = expressionFactory.createNode("NumberExpression", 1);
		Node node2 = expressionFactory.createNode("StringExpression", "hello");
		Node node3 = stateFactory.createNode("Declaration", Variable.getVariable("x"));
		Node node4 = stateFactory.createNode("Assignment", Variable.getVariable("x"), (Expression)
			node1);
		Node node9 = stateFactory.createNode("Sequence", (Statement)node3, (Statement)node4);
		String res = stateFactory.report();
		assertEquals(res, "Declaration: 1\n" +
			"Assignment: 1\n" +
			"Sequence: 1");
	}
}