package yuanjieyue.ast2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberExpressionTest {
	private int num1;
	private int num2;
	private int num3;
	private NumberExpression numExp1;
	private NumberExpression numExp2;
	private NumberExpression numExp3;
	private NumberExpression sameRefExp;
	private NumberExpression sameAsStateExp;
	private NumberExpression yetAnotherExp;
	private NumberExpression nullExp;

	@Before
	public void setUp() throws Exception {
		num1 = 1;
		num2 = 2;
		num3 = 3;
		numExp1 = new NumberExpression(num1);
		numExp2 = new NumberExpression(num2);
		numExp3 = new NumberExpression(num3);

		sameRefExp = numExp1;
		sameAsStateExp = new NumberExpression(num1);
		yetAnotherExp = new NumberExpression(num1);
		nullExp = null;
	}

	@Test
	public void getNum() {
		assertEquals(numExp1.getNum(), num1);
		assertFalse(numExp1.getNum() == num2);
	}

	@Test
	public void setNum() {
		numExp1.setNum(num2);
		assertTrue(numExp1.getNum() == num2);
		assertFalse(numExp1.getNum() == num1);
	}

	@Test
	public void textRepresentation() {
		String text = numExp1.textRepresentation();
		assertEquals(text, "1");
		assertFalse(text.equals("2"));
	}

	@Test
	public void equals() {
		assertTrue(numExp1.equals(sameRefExp));
		assertTrue(sameAsStateExp.equals(numExp1));
		assertTrue(numExp1.equals(sameRefExp));
		assertTrue(numExp1.equals(sameAsStateExp));
		assertTrue(numExp1.equals(yetAnotherExp));
		assertFalse(numExp1.equals(numExp2));
		assertFalse(numExp2.equals(numExp1));
		assertFalse(numExp1.equals(nullExp));
		assertFalse(numExp1.equals(num1));
	}

	@Test
	public void testHashCode() {
		assertTrue(numExp1.hashCode() == sameAsStateExp.hashCode());
		assertFalse(numExp1.hashCode() == numExp2.hashCode());
	}

	@Test
	public void testToString() {
		String testString = "NumberExpression{num=1}";
		String testString2 = "dafd";
		assertEquals(numExp1.toString(), testString);
		assertFalse(numExp1.toString().equals(testString2));
	}
}