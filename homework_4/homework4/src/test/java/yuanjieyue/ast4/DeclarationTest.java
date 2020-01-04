package yuanjieyue.ast4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeclarationTest {

	private String str1;
	private String str2;
	private Variable var1;
	private Variable var2;
	private Declaration decl1;
	private Declaration decl2;
	private Declaration sameRefDecl;
	private Declaration sameAsStateDecl;
	private Declaration yetAnotherDecl;
	private Declaration nullDecl;

	@Before
	public void setUp() throws Exception {
		str1 = "x";
		str2 = "y";
		var1 = new Variable(str1);
		var2 = new Variable(str2);
		decl1 = new Declaration(var1);
		decl2 = new Declaration(var2);
		sameRefDecl = decl1;
		sameAsStateDecl = new Declaration(var1);
		yetAnotherDecl = new Declaration(var1);
		nullDecl = null;
	}

	@Test
	public void getVariable() {
		assertEquals(decl1.getVariable(), var1);
	}

	@Test
	public void setVariable() {
		decl1.setVariable(var2);
		assertEquals(decl1.getVariable(), var2);
	}

	@Test
	public void textRepresentation() {
		String text = decl1.textRepresentation();
		assertEquals(text, "var x;");
	}

	@Test
	public void equals() {
		assertTrue(decl1.equals(sameRefDecl));
		assertTrue(sameRefDecl.equals(decl1));
		assertTrue(decl1.equals(sameAsStateDecl));
		assertTrue(decl1.equals(yetAnotherDecl));
		assertFalse(decl1.equals(decl2));
		assertFalse(decl1.equals(nullDecl));
		assertFalse(decl1.equals(var1));
	}

	@Test
	public void testHashCode() {
		assertTrue(decl1.hashCode() == sameAsStateDecl.hashCode());
		assertFalse(decl1.hashCode() == decl2.hashCode());
	}

	@Test
	public void testToString() {
		String testString = "Declaration{variable=Variable{variable='x'}}";
		assertEquals(decl1.toString(), testString);
	}
}