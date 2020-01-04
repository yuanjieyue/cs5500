package yuanjieyue.ast4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionFactoryTest {
	NodeFactory expressionFacotry;
	NumberExpression numExp;
	StringExpression strExp;
	VariableExpression varExp;
	PrefixExpression prefixExp;
	InfixExpression infixExp;
	Statement sta1;
	Statement sta2;

	@Before
	public void setUp() throws Exception {
		expressionFacotry = new ExpressionFactory();
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
		assertEquals(numExp, expressionFacotry.createNode("NumberExpression", 1));
	}

	@Test
	public void createNode1() {
		assertEquals(strExp, expressionFacotry.createNode("StringExpression", "hello"));
	}

	@Test
	public void createNode2() {
		assertEquals(varExp, expressionFacotry.createNode("VariableExpression", new Variable
			("x")));
	}

	@Test
	public void createNode3() {
		assertEquals(prefixExp, expressionFacotry.createNode("PrefixExpression",
			new Operator("+"), numExp, strExp));
	}

	@Test
	public void createNode4() {
		assertEquals(infixExp, expressionFacotry.createNode("InfixExpression",
			new Operator("+"), numExp, strExp));
	}

	@Test
	public void createNode5() {
		assertEquals(expressionFacotry.createNode("Declaration", new Variable("x"), numExp), null);
	}

	@Test
	public void createNode6() {
		assertEquals(expressionFacotry.createNode("Assignment", new Variable("x")), null);
	}

	@Test
	public void createNode7() {
		assertEquals(expressionFacotry.createNode("Sequence", sta1, sta2), null);
	}

	@Test
	public void createNode8() {
		assertEquals(expressionFacotry.createNode("dfsdafdsf", 1), null);
	}
}