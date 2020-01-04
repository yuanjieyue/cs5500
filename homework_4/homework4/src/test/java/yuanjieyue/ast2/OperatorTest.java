package yuanjieyue.ast2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorTest {
	private String str1;
	private String str2;

	private Operator op1;
	private Operator op2;

	private Operator sameRefOp;
	private Operator sameAsStateOp;
	private Operator yetAnotherOp;
	private Operator nullOp;

	@Before
	public void setUp() throws Exception {
		str1 = "+";
		str2 = "-";
		op1 = new Operator(str1);
		op2 = new Operator(str2);
		sameRefOp = op1;
		sameAsStateOp = new Operator(str1);
		yetAnotherOp = new Operator("+");
		nullOp = null;
	}

	@Test
	public void getOperator() {
		String testStr = op1.getOperator();
		assertEquals(testStr, "+");
	}

	@Test
	public void setOperator() {
		op1.setOperator("-");
		assertEquals(op1.getOperator(), "-");
	}

	@Test
	public void equals() {
		assertTrue(sameRefOp.equals(op1));
		assertTrue(op1.equals(sameRefOp));
		assertTrue(op1.equals(sameAsStateOp));
		assertTrue(op1.equals(yetAnotherOp));
		assertFalse(op1.equals(op2));
		assertFalse(op1.equals(nullOp));
		assertFalse(op2.equals(op1));
		assertFalse(op1.equals(str1));
	}

	@Test
	public void testHashCode() {
		assertTrue(op1.hashCode() == sameAsStateOp.hashCode());
		assertFalse(op1.hashCode() == op2.hashCode());
	}

	@Test
	public void testToString() {
		String testString = "Operator{operator='+'}";
		assertEquals(op1.toString(), testString);
	}
}