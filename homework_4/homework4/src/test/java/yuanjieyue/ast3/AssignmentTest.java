package yuanjieyue.ast3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssignmentTest {
	private String str1;
	private String str2;
	private Variable var1;
	private Variable var2;
	private Expression exp1;
	private Expression exp2;
	private Assignment assign1;
	private Assignment assign2;
	private Assignment assign3;
	private Assignment assign4;
	private Assignment sameRefAssign;
	private Assignment sameAsStateAssign;
	private Assignment yetAnotherAssign;
	private Assignment nullAssign;

	@Before
	public void setUp() throws Exception {
		str1 = "x";
		str2 = "y";
		var1 = new Variable(str1);
		var2 = new Variable(str2);
		exp1 = new NumberExpression(1);
		exp2 = new StringExpression("hello");
		assign1 = new Assignment(var1, exp1);
		assign2 = new Assignment(var1, exp2);
		assign3 = new Assignment(var2, exp1);
		assign4 = new Assignment(var2, exp2);
		sameRefAssign = assign1;
		sameAsStateAssign = new Assignment(var1, exp1);
		yetAnotherAssign = new Assignment(var1, exp1);
		nullAssign = null;
	}

	@Test
	public void getVariable() {
		assertEquals(assign1.getVariable(), var1);
	}

	@Test
	public void setVariable() {
		assign1.setVariable(var2);
		assertEquals(assign1.getVariable(), var2);
	}

	@Test
	public void getExpression() {
		assertEquals(assign1.getExpression(), exp1);
	}

	@Test
	public void setExpression() {
		assign1.setExpression(exp2);
		assertEquals(assign1.getExpression(), exp2);
	}

	@Test
	public void textRepresentation() {
		String text = assign1.textRepresentation();
		assertEquals(text, "x = 1;");
	}

	@Test
	public void equals() {
		assertTrue(assign1.equals(sameRefAssign));
		assertTrue(sameRefAssign.equals(assign1));
		assertTrue(assign1.equals(sameAsStateAssign));
		assertTrue(assign1.equals(yetAnotherAssign));
		assertFalse(assign1.equals(assign2));
		assertFalse(assign1.equals(nullAssign));
		assertFalse(assign1.equals(var1));
		assertFalse(assign1.equals(assign3));
		assertFalse(assign1.equals(assign4));
	}

	@Test
	public void testHashCode() {
		assertTrue(assign1.hashCode() == sameAsStateAssign.hashCode());
		assertFalse(assign1.hashCode() == assign2.hashCode());
		assertFalse(assign1.hashCode() == assign3.hashCode());
		assertFalse(assign1.hashCode() == assign4.hashCode());
	}

	@Test
	public void testToString() {
		String testString = "Assignment{variable=Variable{variable='x'}, expression=NumberExpression{num=1}}";
		assertEquals(assign1.toString(), testString);
	}
}