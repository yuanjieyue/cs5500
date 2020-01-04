package yuanjieyue.ast2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceTest {
	private Variable var1;
	private Variable var2;

	private Declaration decl1;
	private Declaration decl2;

	private Expression exp1;
	private Expression exp2;
	private Assignment assign1;
	private Assignment assign2;
	private Sequence seq1;
	private Sequence seq2;
	private Sequence seq3;
	private Sequence seq4;
	private Sequence sameRefSeq;
	private Sequence sameAsStateSeq;
	private Sequence yetAnotherSeq;
	private Sequence nullSeq;

	@Before
	public void setUp() throws Exception {
		var1 = new Variable("x");
		var2 = new Variable("y");
		decl1 = new Declaration(var1);
		decl2 = new Declaration(var2);
		exp1 = new NumberExpression(1);
		exp2 = new StringExpression("hell");
		assign1 = new Assignment(var1, exp1);
		assign2 = new Assignment(var2 ,exp2);
		seq1 = new Sequence(decl1, assign1);
		seq2 = new Sequence(decl1, assign2);
		seq3 = new Sequence(decl2, assign1);
		seq4 = new Sequence(decl2, assign2);
		sameRefSeq = seq1;
		sameAsStateSeq = new Sequence(decl1, assign1);
		yetAnotherSeq = new Sequence(decl1, assign1);
		nullSeq = null;
	}

	@Test
	public void getStatement1() {
		assertEquals(seq1.getStatement1(), decl1);
	}

	@Test
	public void setStatement1() {
		seq1.setStatement1(decl2);
		assertEquals(seq1.getStatement1(), decl2);
	}

	@Test
	public void getStatement2() {
		assertEquals(seq1.getStatement2(), assign1);
	}

	@Test
	public void setStatement2() {
		seq1.setStatement2(assign2);
		assertEquals(seq1.getStatement2(), assign2);
	}

	@Test
	public void textRepresentation() {
		String text = seq1.textRepresentation();
		assertEquals(text, "var x; x = 1;");
	}

	@Test
	public void equals() {
		assertTrue(seq1.equals(sameRefSeq));
		assertTrue(sameRefSeq.equals(seq1));
		assertTrue(seq1.equals(sameAsStateSeq));
		assertTrue(seq1.equals(yetAnotherSeq));
		assertFalse(seq1.equals(seq2));
		assertFalse(seq1.equals(nullSeq));
		assertFalse(seq1.equals(var1));
		assertFalse(seq1.equals(seq3));
		assertFalse(seq1.equals(seq4));
	}

	@Test
	public void testHashCode() {
		assertTrue(seq1.hashCode() == sameRefSeq.hashCode());
		assertFalse(seq1.hashCode() == seq2.hashCode());
		assertFalse(seq1.hashCode() == seq3.hashCode());
		assertFalse(seq1.hashCode() == seq4.hashCode());
	}

	@Test
	public void testToString() {
		String testString = "Sequence{statement1=Declaration{variable=Variable{variable='x'}}, statement2=Assignment{variable=Variable{variable='x'}, expression=NumberExpression{num=1}}}";
		assertEquals(seq1.toString(), testString);
	}
}