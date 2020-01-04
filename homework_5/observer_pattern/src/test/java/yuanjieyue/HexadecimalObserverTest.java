package yuanjieyue;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class HexadecimalObserverTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private ConcreteSubject subject1;
	private ConcreteSubject subject2;
	private ConcreteSubject subject3;
	private ConcreteSubject nullStateSubject;
	private ConcreteSubject nullSubject;
	private HexadecimalObserver observer1;
	private HexadecimalObserver observer2;
	private HexadecimalObserver observer3;
	private HexadecimalObserver observer4;
	private HexadecimalObserver observer5;
	private HexadecimalObserver sameRefObserver;
	private HexadecimalObserver sameAsStateObserver;
	private HexadecimalObserver yetAnotherObserver;
	private HexadecimalObserver nullObserver;
	private DecimalObserver anotherObserver;

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));

		subject1 = new ConcreteSubject("");
		subject2 = new ConcreteSubject("world");
		subject3 = new ConcreteSubject("hello world");
		nullStateSubject = new ConcreteSubject(null);
		observer1 = new HexadecimalObserver(subject1);
		observer2 = new HexadecimalObserver(subject3);
		observer2 = new HexadecimalObserver(subject2);
		observer3 = new HexadecimalObserver(subject3);
		observer4 = new HexadecimalObserver(nullStateSubject);
		observer5 = new HexadecimalObserver(nullSubject);
		anotherObserver = new DecimalObserver(subject2);
		sameRefObserver = observer2;
		sameAsStateObserver = new HexadecimalObserver(subject2);
		yetAnotherObserver = new HexadecimalObserver(subject2);
	}

	@Test
	public void update() {
		observer1.update();
		assertEquals("", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
		outContent.reset();
		observer2.update();
		assertEquals("77 6f 72 6c 64", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
		outContent.reset();
		outContent.reset();
		observer3.update();
		assertEquals("68 65 6c 6c 6f 20 77 6f 72 6c 64", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
		outContent.reset();
		outContent.reset();
		observer4.update();
		assertEquals("", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
		outContent.reset();
		observer5.update();
		assertEquals("", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
	}

	@Test
	public void equals() {
		assertTrue(observer2.equals(sameAsStateObserver));
		assertTrue(sameAsStateObserver.equals(observer2));
		assertTrue(observer2.equals(sameRefObserver));
		assertTrue(observer2.equals(yetAnotherObserver));
		assertFalse(observer2.equals(observer1));
		assertFalse(observer2.equals(observer3));
		assertFalse(observer2.equals(observer4));
		assertFalse(observer2.equals(observer5));
		assertFalse(observer2.equals(nullObserver));
		assertFalse(observer2.equals(subject1));
	}

	@Test
	public void testHashCode() {
		assertTrue(observer2.hashCode() == sameAsStateObserver.hashCode());
		assertTrue(observer2.hashCode() == sameRefObserver.hashCode());
		assertTrue(observer2.hashCode() == yetAnotherObserver.hashCode());
		assertFalse(observer2.hashCode() == observer1.hashCode());
		assertFalse(observer2.hashCode() == observer3.hashCode());
		assertFalse(observer2.hashCode() == observer4.hashCode());
		assertFalse(observer2.hashCode() == observer5.hashCode());
		assertFalse(observer2.hashCode() == subject1.hashCode());
	}

	@Test
	public void testToString() {
		String testString1 = "HexadecimalObserver{subject=}";
		assertEquals(testString1, observer1.toString());
		String testString2 = "HexadecimalObserver{subject=world}";
		assertEquals(testString2, observer2.toString());
		String testString3 = "HexadecimalObserver{subject=hello world}";
		assertEquals(testString3, observer3.toString());
		String testString4 = "HexadecimalObserver{subject=null}";
		assertEquals(testString4, observer4.toString());
		String testString5 = "HexadecimalObserver{subject=}";
		assertEquals(testString5, observer5.toString());
	}
}