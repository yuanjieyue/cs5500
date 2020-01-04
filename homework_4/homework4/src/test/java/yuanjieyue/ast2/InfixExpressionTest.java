package yuanjieyue.ast2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InfixExpressionTest {

	private String str1;
	private String str2;
	private Operator op1;
	private Operator op2;
	private Expression exp1;
	private Expression exp2;
	private InfixExpression infixExp1;
	private InfixExpression infixExp2;
	private InfixExpression infixExp3;
	private InfixExpression infixExp4;
	private InfixExpression sameRefInfixExp;
	private InfixExpression sameAsStateInfixExp;
	private InfixExpression yetAnotherInfixExp;
	private InfixExpression nullInfixExp;

	@Before
	public void setUp() throws Exception {
		str1 = "+";
		str2 = "-";
		op1 = new Operator(str1);
		op2 = new Operator(str2);
		exp1 = new NumberExpression(1);
		exp2 = new StringExpression("hello");
		infixExp1 = new InfixExpression(op1, exp1, exp2);
		infixExp2 = new InfixExpression(op2, exp1, exp2);
		infixExp3 = new InfixExpression(op1, exp1, exp1);
		infixExp4 = new InfixExpression(op1, exp2, exp1);
		sameRefInfixExp = infixExp1;
		sameAsStateInfixExp = new InfixExpression(op1, exp1, exp2);
		yetAnotherInfixExp = new InfixExpression(op1, exp1, exp2);
		nullInfixExp = null;
	}

	@Test
	public void getOperator() {
		assertEquals(infixExp1.getOperator(), op1);
	}

	@Test
	public void setOperator() {
		infixExp1.setOperator(op2);
		assertEquals(infixExp1.getOperator(), op2);
	}

	@Test
	public void getExpression1() {
		assertEquals(infixExp1.getExpression1(), exp1);
	}

	@Test
	public void setExpression1() {
		infixExp1.setExpression1(exp2);
		assertEquals(infixExp1.getExpression1(), exp2);
	}

	@Test
	public void getExpression2() {
		assertEquals(infixExp1.getExpression2(), exp2);
	}

	@Test
	public void setExpression2() {
		infixExp1.setExpression2(exp1);
		assertEquals(infixExp1.getExpression2(), exp1);
	}

	@Test
	public void textRepresentation() {
		String text = infixExp1.textRepresentation();
		assertEquals(text, "1 + hello");
	}

	@Test
	public void equals() {
		assertTrue(infixExp1.equals(sameRefInfixExp));
		assertTrue(sameAsStateInfixExp.equals(infixExp1));
		assertTrue(infixExp1.equals(sameAsStateInfixExp));
		assertTrue(infixExp1.equals(yetAnotherInfixExp));
		assertFalse(infixExp1.equals(infixExp2));
		assertFalse(infixExp1.equals(nullInfixExp));
		assertFalse(infixExp2.equals(infixExp1));
		assertFalse(infixExp1.equals(exp1));
		assertFalse(infixExp1.equals(infixExp3));
		assertFalse(infixExp1.equals(infixExp4));
	}

	@Test
	public void testHashCode() {
		assertTrue(infixExp1.hashCode() == sameAsStateInfixExp.hashCode());
		assertFalse(infixExp1.hashCode() == infixExp2.hashCode());
		assertFalse(infixExp1.hashCode() == infixExp3.hashCode());
		assertFalse(infixExp1.hashCode() == infixExp4.hashCode());
	}

	@Test
	public void testToString() {
		String testString = "InfixExpression{operator=Operator{operator='+'}, expression1=NumberExpression{num=1}, expression2=StringExpression{string='hello'}}";
		assertEquals(infixExp1.toString(), testString);
	}
}