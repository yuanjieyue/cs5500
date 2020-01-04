package yuanjieyue;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DecimalObserverTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private ConcreteSubject subject1;
	private ConcreteSubject subject2;
	private ConcreteSubject subject3;
	private ConcreteSubject nullStateSubject;
	private ConcreteSubject nullSubject;
	private DecimalObserver observer1;
	private DecimalObserver observer2;
	private DecimalObserver observer3;
	private DecimalObserver observer4;
	private DecimalObserver observer5;
	private DecimalObserver sameRefObserver;
	private DecimalObserver sameAsStateObserver;
	private DecimalObserver yetAnotherObserver;
	private DecimalObserver nullObserver;
	private HexadecimalObserver anotherObserver;

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));

		subject1 = new ConcreteSubject("");
		subject2 = new ConcreteSubject("world");
		subject3 = new ConcreteSubject("hello world");
		nullStateSubject = new ConcreteSubject(null);
		observer1 = new DecimalObserver(subject1);
		observer2 = new DecimalObserver(subject3);
		observer2 = new DecimalObserver(subject2);
		observer3 = new DecimalObserver(subject3);
		observer4 = new DecimalObserver(nullStateSubject);
		observer5 = new DecimalObserver(nullSubject);
		anotherObserver = new HexadecimalObserver(subject2);
		sameRefObserver = observer2;
		sameAsStateObserver = new DecimalObserver(subject2);
		yetAnotherObserver = new DecimalObserver(subject2);
	}

	@Test
	public void update() {
		observer1.update();
		assertEquals("", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
		outContent.reset();
		observer2.update();
		assertEquals("119 111 114 108 100", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
		outContent.reset();
		observer3.update();
		assertEquals("104 101 108 108 111 32 119 111 114 108 100", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
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
		String testString1 = "DecimalObserver{subject=}";
		assertEquals(testString1, observer1.toString());
		String testString2 = "DecimalObserver{subject=world}";
		assertEquals(testString2, observer2.toString());
		String testString3 = "DecimalObserver{subject=hello world}";
		assertEquals(testString3, observer3.toString());
		String testString4 = "DecimalObserver{subject=null}";
		assertEquals(testString4, observer4.toString());
		String testString5 = "DecimalObserver{subject=}";
		assertEquals(testString5, observer5.toString());
	}
}