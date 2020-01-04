package yuanjieyue.ast2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatementFactoryTest {
	NodeFactory stateFactory;
	NumberExpression numExp;
	StringExpression strExp;
	Declaration decl;
	Assignment assign;
	Sequence seq;

	@Before
	public void setUp() throws Exception {
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
}