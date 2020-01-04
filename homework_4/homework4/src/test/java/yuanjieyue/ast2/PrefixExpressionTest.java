package yuanjieyue.ast2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrefixExpressionTest {
	private String str1;
	private String str2;
	private Operator op1;
	private Operator op2;
	private Expression exp1;
	private Expression exp2;
	private PrefixExpression prefixExp1;
	private PrefixExpression prefixExp2;
	private PrefixExpression prefixExp3;
	private PrefixExpression prefixExp4;
	private PrefixExpression sameRefPrefixExp;
	private PrefixExpression sameAsStatePrefixExp;
	private PrefixExpression yetAnotherPrefixExp;
	private PrefixExpression nullPrefixExp;

	@Before
	public void setUp() throws Exception {
		str1 = "+";
		str2 = "-";
		op1 = new Operator(str1);
		op2 = new Operator(str2);
		exp1 = new NumberExpression(1);
		exp2 = new StringExpression("hello");
		prefixExp1 = new PrefixExpression(op1, exp1, exp2);
		prefixExp2 = new PrefixExpression(op2, exp1, exp2);
		prefixExp3 = new PrefixExpression(op1, exp2, exp2);
		prefixExp4 = new PrefixExpression(op1, exp1, exp1);
		sameRefPrefixExp = prefixExp1;
		sameAsStatePrefixExp = new PrefixExpression(op1, exp1, exp2);
		yetAnotherPrefixExp = new PrefixExpression(op1, exp1, exp2);
		nullPrefixExp = null;
	}

	@Test
	public void getOperator() {
		assertEquals(prefixExp1.getOperator(), op1);
	}

	@Test
	public void setOperator() {
		prefixExp1.setOperator(op2);
		assertEquals(prefixExp1.getOperator(), op2);
	}

	@Test
	public void getExpression1() {
		assertEquals(prefixExp1.getExpression1(), exp1);
	}

	@Test
	public void setExpression1() {
		prefixExp1.setExpression1(exp2);
		assertEquals(prefixExp1.getExpression1(), exp2);
	}

	@Test
	public void getExpression2() {
		assertEquals(prefixExp1.getExpression2(), exp2);
	}

	@Test
	public void setExpression2() {
		prefixExp1.setExpression2(exp1);
		assertEquals(prefixExp1.getExpression2(), exp1);
	}

	@Test
	public void textRepresentation() {
		String text = prefixExp1.textRepresentation();
		assertEquals(text, "+ 1 hello");
	}

	@Test
	public void equals() {
		assertTrue(prefixExp1.equals(sameRefPrefixExp));
		assertTrue(sameAsStatePrefixExp.equals(prefixExp1));
		assertTrue(prefixExp1.equals(sameAsStatePrefixExp));
		assertTrue(prefixExp1.equals(yetAnotherPrefixExp));
		assertFalse(prefixExp1.equals(prefixExp2));
		assertFalse(prefixExp1.equals(nullPrefixExp));
		assertFalse(prefixExp2.equals(prefixExp1));
		assertFalse(prefixExp1.equals(exp1));
		assertFalse(prefixExp1.equals(prefixExp3));
		assertFalse(prefixExp1.equals(prefixExp4));
	}

	@Test
	public void testHashCode() {
		assertTrue(prefixExp1.hashCode() == sameAsStatePrefixExp.hashCode());
		assertFalse(prefixExp1.hashCode() == prefixExp2.hashCode());
		assertFalse(prefixExp1.hashCode() == prefixExp3.hashCode());
		assertFalse(prefixExp1.hashCode() == prefixExp4.hashCode());
	}

	@Test
	public void testToString() {
		String testString = "PrefixExpression{operator=Operator{operator='+'}, expression1=NumberExpression{num=1}, expression2=StringExpression{string='hello'}}";
		assertEquals(prefixExp1.toString(), testString);
	}
}