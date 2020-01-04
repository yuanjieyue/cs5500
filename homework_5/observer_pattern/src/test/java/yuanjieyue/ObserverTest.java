package yuanjieyue;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ObserverTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private ConcreteSubject subject1;
	private ConcreteSubject subject2;
	private ConcreteSubject subject3;
	private ConcreteSubject nullStateSubject;
	private ConcreteSubject nullSubject;
	private DecimalObserver decimalObserverobserver1;
	private DecimalObserver decimalObserverobserver2;
	private DecimalObserver decimalObserverobserver3;
	private DecimalObserver decimalObserverobserver4;
	private DecimalObserver decimalObserverobserver5;
	private HexadecimalObserver hexadecimalObserverobserver1;
	private HexadecimalObserver hexadecimalObserverobserver2;
	private HexadecimalObserver hexadecimalObserverobserver3;
	private HexadecimalObserver hexadecimalObserverobserver4;
	private HexadecimalObserver hexadecimalObserverobserver5;
	private ReverseObserver reverseObserver1;
	private ReverseObserver reverseObserver2;
	private ReverseObserver reverseObserver3;
	private ReverseObserver reverseObserver4;
	private ReverseObserver reverseObserver5;

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));

		subject1 = new ConcreteSubject("");
		subject2 = new ConcreteSubject("hello");
		subject3 = new ConcreteSubject("hello world 123");
		nullStateSubject = new ConcreteSubject(null);
		decimalObserverobserver1 = new DecimalObserver(subject1);
		decimalObserverobserver2 = new DecimalObserver(subject2);
		decimalObserverobserver3 = new DecimalObserver(subject3);
		decimalObserverobserver4 = new DecimalObserver(nullStateSubject);
		decimalObserverobserver5 = new DecimalObserver(nullSubject);
		hexadecimalObserverobserver1 = new HexadecimalObserver(subject1);
		hexadecimalObserverobserver2 = new HexadecimalObserver(subject2);
		hexadecimalObserverobserver3 = new HexadecimalObserver(subject3);
		hexadecimalObserverobserver4 = new HexadecimalObserver(nullStateSubject);
		hexadecimalObserverobserver5 = new HexadecimalObserver(nullSubject);
		reverseObserver1 = new ReverseObserver(subject1);
		reverseObserver2 = new ReverseObserver(subject2);
		reverseObserver3 = new ReverseObserver(subject3);
		reverseObserver4 = new ReverseObserver(nullStateSubject);
		reverseObserver5 = new ReverseObserver(nullSubject);
	}

	@Test
	public void update() {
		decimalObserverobserver1.update();
		assertEquals("", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
		outContent.reset();
		decimalObserverobserver2.update();
		assertEquals("104 101 108 108 111", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
		outContent.reset();
		decimalObserverobserver3.update();
		assertEquals("104 101 108 108 111 32 119 111 114 108 100 32 49 50 51", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
		outContent.reset();
		decimalObserverobserver4.update();
		assertEquals("", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
		outContent.reset();
		decimalObserverobserver5.update();
		assertEquals("", outContent.toString()
			.replaceAll("\n", "")
			.replaceAll("\r", ""));
	}
}