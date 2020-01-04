package yuanjieyue.ast4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VariableExpressionTest {
	private String str1;
	private String str2;
	private Variable var1;
	private Variable var2;
	private VariableExpression varExp1;
	private VariableExpression varExp2;
	private VariableExpression sameRefVarExp;
	private VariableExpression sameAsStateVarExp;
	private VariableExpression yetAnotherVarExp;
	private VariableExpression nullVarExp;

	@Before
	public void setUp() throws Exception {
		str1 = "x";
		str2 = "y";
		var1 = new Variable(str1);
		var2 = new Variable(str2);
		varExp1 = new VariableExpression(var1);
		varExp2 = new VariableExpression(var2);
		sameRefVarExp = varExp1;
		sameAsStateVarExp = new VariableExpression(var1);
		yetAnotherVarExp = new VariableExpression(var1);
		nullVarExp = null;
	}

	@Test
	public void getVariable() {
		assertEquals(varExp1, new VariableExpression(new Variable("x")));
	}

	@Test
	public void setVariable() {
		varExp1.setVariable(var2);
		assertEquals(varExp1.getVariable(), var2);
	}

	@Test
	public void textRepresentation() {
		String text = varExp1.textRepresentation();
		assertEquals(text, "x");
	}

	@Test
	public void equals() {
		assertTrue(sameRefVarExp.equals(varExp1));
		assertTrue(varExp1.equals(sameRefVarExp));
		assertTrue(varExp1.equals(sameAsStateVarExp));
		assertTrue(varExp1.equals(yetAnotherVarExp));
		assertFalse(varExp1.equals(varExp2));
		assertFalse(varExp1.equals(nullVarExp));
		assertFalse(varExp2.equals(varExp1));
		assertFalse(varExp1.equals(var1));
	}

	@Test
	public void testHashCode() {
		assertTrue(varExp1.hashCode() == sameAsStateVarExp.hashCode());
		assertFalse(varExp1.hashCode() == varExp2.hashCode());
	}

	@Test
	public void testToString() {
		String testString = "VariableExpression{variable=Variable{variable='x'}}";
		assertEquals(varExp1.toString(), testString);
	}
}