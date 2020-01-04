package yuanjieyue.ast2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VariableTest {
	private String str1;
	private String str2;

	private Variable var1;
	private Variable var2;

	private Variable sameRefVar;
	private Variable sameAsStateVar;
	private Variable yetAnotherVar;
	private Variable nullVar;

	@Before
	public void setUp() throws Exception {
		str1 = "x";
		str2 = "y";

		var1 = new Variable(str1);
		var2 = new Variable(str2);

		sameRefVar = var1;
		sameAsStateVar = new Variable(str1);
		yetAnotherVar = new Variable("x");
		nullVar = null;
	}

	@Test
	public void getVariable() {
		Variable resVar1 = new Variable ("x");
		assertEquals(resVar1, var1);
	}

	@Test
	public void setVariable() {
		var1.setVariable("m");
		assertEquals(var1, new Variable("m"));
	}

	@Test
	public void equals() {
		assertTrue(sameRefVar.equals(var1));
		assertTrue(var1.equals(sameRefVar));
		assertTrue(var1.equals(sameAsStateVar));
		assertTrue(var1.equals(yetAnotherVar));
		assertFalse(var1.equals(var2));
		assertFalse(var1.equals(nullVar));
		assertFalse(var2.equals(var1));
		assertFalse(var1.equals(str1));
	}

	@Test
	public void testHashCode() {
		assertTrue(var1.hashCode() == sameRefVar.hashCode());
		assertFalse(var1.hashCode() == var2.hashCode());
	}

	@Test
	public void testToString() {
		String testString = "Variable{variable='x'}";
		assertEquals(var1.toString(), testString);
		assertTrue(var1.toString().equals(sameRefVar.toString()));
	}
}