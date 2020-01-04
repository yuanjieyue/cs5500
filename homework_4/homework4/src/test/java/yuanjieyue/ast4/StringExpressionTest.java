package yuanjieyue.ast4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringExpressionTest {
	private String str1;
	private String str2;

	private StringExpression strExp1;
	private StringExpression strExp2;

	private StringExpression sameRefExp;
	private StringExpression sameAsStateExp;
	private StringExpression yetAnotherExp;
	private StringExpression nullExp;

	@Before
	public void setUp() throws Exception {
		str1 = "hello";
		str2 = "world";
		strExp1 = new StringExpression(str1);
		strExp2 = new StringExpression(str2);
		sameRefExp = strExp1;
		sameAsStateExp = new StringExpression(str1);
		yetAnotherExp = new StringExpression(str1);
		nullExp = null;
	}

	@Test
	public void getString() {
		assertEquals(strExp1.getString(), "hello");
	}

	@Test
	public void setString() {
		strExp1.setString(str2);
		assertEquals(strExp1.getString(), "world");
	}

	@Test
	public void textRepresentation() {
		String text = strExp1.textRepresentation();
		assertEquals(text, "hello");
	}


	@Test
	public void equals() {
		assertTrue(strExp1.equals(sameRefExp));
		assertTrue(sameRefExp.equals(strExp1));
		assertTrue(strExp1.equals(sameAsStateExp));
		assertTrue(strExp1.equals(yetAnotherExp));
		assertFalse(strExp1.equals(strExp2));
		assertFalse(strExp1.equals(nullExp));
		assertFalse(strExp1.equals(str1));
	}

	@Test
	public void testHashCode() {
		assertTrue(strExp1.hashCode() == sameRefExp.hashCode());
		assertFalse(strExp1.hashCode() == strExp2.hashCode());
	}

	@Test
	public void testToString() {
		String testString = "StringExpression{string='hello'}";
		assertEquals(strExp1.toString(), testString);
	}
}