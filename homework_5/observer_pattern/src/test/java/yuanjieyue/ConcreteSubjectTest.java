package yuanjieyue;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConcreteSubjectTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	private ConcreteSubject subject1;
	private ConcreteSubject subject2;
	private ConcreteSubject subject3;
	private ConcreteSubject sameResSubject;
	private ConcreteSubject sameAsStateSubject;
	private ConcreteSubject yetAnotherSubject;
	private ConcreteSubject nullSubject;
	private ConcreteSubject nullStateSubject;

	private Observer observer1;
	private Observer observer2;
	private Observer observer3;
	private Observer observer4;

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		subject1 = new ConcreteSubject("hello");
		subject2 = new ConcreteSubject("");
		subject3 = new ConcreteSubject("hello world");
		nullStateSubject = new ConcreteSubject(null);
		sameResSubject = subject1;
		sameAsStateSubject = new ConcreteSubject("hello");
		yetAnotherSubject = new ConcreteSubject("hello");
	}

	@Test
	public void getState() {
		assertEquals("hello", subject1.getState());
		assertEquals("", subject2.getState());
	}

	@Test
	public void setState() {
		subject1.setState("world");
		assertEquals("world", subject1.getState());
		subject2.setState("world");
		assertEquals("world", subject2.getState());
	}

	@Test
	public void getObserverList() {
		List<Observer> list = new ArrayList<>();
		assertEquals(subject1.getObserverList(), list);
		observer1 = new DecimalObserver(subject1);
		list.add(observer1);
		assertEquals(subject1.getObserverList(), list);

		observer2 = new DecimalObserver(subject1);
		list.add(observer2);
		assertEquals(subject1.getObserverList(), list);

		observer3 = new DecimalObserver(subject1);
		list.add(observer3);
		assertEquals(subject1.getObserverList(), list);

		subject1.detach(observer1);
		list.remove(observer1);
		assertEquals(subject1.getObserverList(), list);

		List<Observer> list2 = new ArrayList<>();
		assertEquals(subject2.getObserverList(), list2);
		observer1 = new DecimalObserver(subject2);
		list2.add(observer1);
		assertEquals(subject2.getObserverList(), list2);

		observer2 = new DecimalObserver(subject2);
		list2.add(observer2);
		assertEquals(subject2.getObserverList(), list2);
	}

	@Test
	public void attach() {
		List<Observer> observers = new ArrayList<>();
		observer1 = new DecimalObserver(subject1);
		observers.add(observer1);
		assertEquals(observers.size(), subject1.getObserverList().size());
		for (int i = 0; i < observers.size(); i++) {
			assertEquals(subject1.getObserverList().get(i), observers.get(i));
		}

		observer2 = new DecimalObserver(subject1);
		observers.add(observer2);
		assertEquals(observers.size(), subject1.getObserverList().size());
		for (int i = 0; i < observers.size(); i++) {
			assertEquals(subject1.getObserverList().get(i), observers.get(i));
		}

		observer3 = new HexadecimalObserver(subject1);
		observers.add(observer3);
		assertEquals(observers.size(), subject1.getObserverList().size());
		for (int i = 0; i < observers.size(); i++) {
			assertEquals(subject1.getObserverList().get(i), observers.get(i));
		}
		observer4 = new ReverseObserver(subject1);
		observers.add(observer4);

		assertEquals(observers.size(), subject1.getObserverList().size());
		for (int i = 0; i < observers.size(); i++) {
			assertEquals(subject1.getObserverList().get(i), observers.get(i));
		}

		List<Observer> observers2 = new ArrayList<>();
		observer1 = new DecimalObserver(subject2);
		observers2.add(observer1);
		assertEquals(observers2.size(), subject2.getObserverList().size());
		for (int i = 0; i < observers2.size(); i++) {
			assertEquals(subject2.getObserverList().get(i), observers2.get(i));
		}

		observer2 = new DecimalObserver(subject2);
		observers2.add(observer2);
		assertEquals(observers2.size(), subject2.getObserverList().size());
		for (int i = 0; i < observers2.size(); i++) {
			assertEquals(subject2.getObserverList().get(i), observers2.get(i));
		}
	}

	@Test
	public void detach() {
		List<Observer> observers = new ArrayList<>();
		observer1 = new DecimalObserver(subject1);
		observer2 = new DecimalObserver(subject1);
		observer3 = new HexadecimalObserver(subject1);
		observer4 = new ReverseObserver(subject1);

		observers.add(observer1);
		observers.add(observer2);
		observers.add(observer3);
		observers.add(observer4);

		subject1.detach(observer1);
		observers.remove(observer1);
		assertEquals(observers.size(), subject1.getObserverList().size());
		for (int i = 0; i < observers.size(); i++) {
			assertEquals(subject1.getObserverList().get(i), observers.get(i));
		}

		subject1.detach(observer2);
		observers.remove(observer2);
		assertEquals(observers.size(), subject1.getObserverList().size());
		for (int i = 0; i < observers.size(); i++) {
			assertEquals(subject1.getObserverList().get(i), observers.get(i));
		}

		subject1.detach(observer3);
		observers.remove(observer3);
		assertEquals(observers.size(), subject1.getObserverList().size());
		for (int i = 0; i < observers.size(); i++) {
			assertEquals(subject1.getObserverList().get(i), observers.get(i));
		}

		subject1.detach(observer4);
		observers.remove(observer4);
		assertEquals(observers.size(), subject1.getObserverList().size());
		for (int i = 0; i < observers.size(); i++) {
			assertEquals(subject1.getObserverList().get(i), observers.get(i));
		}


		List<Observer> observers2 = new ArrayList<>();
		observer1 = new DecimalObserver(subject2);
		observer2 = new DecimalObserver(subject2);
		observer3 = new HexadecimalObserver(subject2);
		observer4 = new ReverseObserver(subject2);

		observers2.add(observer1);
		observers2.add(observer2);
		observers2.add(observer3);
		observers2.add(observer4);

		subject2.detach(observer1);
		observers2.remove(observer1);
		assertEquals(observers2.size(), subject2.getObserverList().size());
		for (int i = 0; i < observers2.size(); i++) {
			assertEquals(subject2.getObserverList().get(i), observers2.get(i));
		}

		subject2.detach(observer2);
		observers2.remove(observer2);
		assertEquals(observers2.size(), subject2.getObserverList().size());
		for (int i = 0; i < observers2.size(); i++) {
			assertEquals(subject2.getObserverList().get(i), observers2.get(i));
		}
	}

	@Test
	public void notifyObservers() {
		observer1 = new DecimalObserver(subject1);
		observer2 = new HexadecimalObserver(subject1);
		observer3 = new ReverseObserver(subject1);
		subject1.notifyObservers();
		assertEquals(outContent.toString().replaceAll("\r", "")
			.replaceAll("\n", ""), "104 101" +
			" 108 108 11168 65 6c 6c 6folleh");

		observer1 = new DecimalObserver(subject2);
		observer2 = new HexadecimalObserver(subject2);
		observer3 = new ReverseObserver(subject2);
		subject2.notifyObservers();
		assertEquals(outContent.toString().replaceAll("\r", "")
			.replaceAll("\n", ""), "104 101" +
			" 108 108 11168 65 6c 6c 6folleh");
	}

	@Test
	public void equals() {
		assertTrue(subject1.equals(sameAsStateSubject));
		assertTrue(sameAsStateSubject.equals(subject1));
		assertTrue(subject1.equals(sameResSubject));
		assertTrue(subject1.equals(yetAnotherSubject));
		assertFalse(subject1.equals(nullSubject));
		assertFalse(subject1.equals(nullStateSubject));
		assertFalse(nullStateSubject.equals(subject1));
		observer1 = new DecimalObserver(subject1);
		assertFalse(subject1.equals(observer1));
		assertFalse(subject1.equals(subject2));
		observer2 = new DecimalObserver(subject1);
		assertFalse(subject1.equals(subject3));
	}

	@Test
	public void testHashCode() {
		assertTrue(subject1.hashCode() == sameAsStateSubject.hashCode());
		assertTrue(subject1.hashCode() == sameResSubject.hashCode());
		assertTrue(subject1.hashCode() == yetAnotherSubject.hashCode());
		assertFalse(subject1.hashCode() == nullStateSubject.hashCode());
		assertFalse(subject1.hashCode() == subject2.hashCode());
		observer1 = new DecimalObserver(subject1);
		assertFalse(subject1.hashCode() == observer1.hashCode());
		observer2 = new DecimalObserver(subject1);
		assertFalse(subject1.hashCode() == subject3.hashCode());
	}

	@Test
	public void testToString() {
		String testString1 = "ConcreteSubject{state='hello', observerList=[]}";
		assertEquals(subject1.toString(), testString1);
		String testString2 = "ConcreteSubject{state='', observerList=[]}";
		assertEquals(subject2.toString(), testString2);
	}
}



