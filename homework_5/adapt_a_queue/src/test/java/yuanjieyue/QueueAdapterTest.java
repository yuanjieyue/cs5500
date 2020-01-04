package yuanjieyue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueAdapterTest {

	private Queue<Integer> integerQueue;
	private Queue<Integer> integerQueue2;
	private Queue<Integer> sameRefQueue;
	private Queue<Integer> sameAsStateQueue;
	private Queue<Integer> yetAnotherQueue;
	private Queue<Integer> nullQueue;

	private Queue<String> stringQueue;
	private Queue<Boolean> booleanQueue;

	@Before
	public void setUp() throws Exception {
		integerQueue = new QueueAdapter<>();
		integerQueue2 = new QueueAdapter<>();
		sameRefQueue = integerQueue;
		sameAsStateQueue = new QueueAdapter<>();
		yetAnotherQueue = new QueueAdapter<>();

		stringQueue = new QueueAdapter<>();
		booleanQueue = new QueueAdapter<>();
	}

	@Test
	public void add() {
		assertEquals(null, integerQueue.peek());
		assertEquals(true, integerQueue.add(0));
		assertEquals(0, integerQueue.peek());
		assertEquals(true, integerQueue.add(1));
		assertEquals(1, integerQueue.peek());
		assertEquals(true, integerQueue.add(-1));
		assertEquals(-1, integerQueue.peek());
		assertEquals(true, integerQueue.add(155));
		assertEquals(155, integerQueue.peek());
		assertEquals(true, integerQueue.add(Integer.MIN_VALUE));
		assertEquals(Integer.MIN_VALUE, integerQueue.peek());
		assertEquals(true, integerQueue.add(Integer.MAX_VALUE));
		assertEquals(Integer.MAX_VALUE, integerQueue.peek());
		assertEquals(false, integerQueue.add(null));

		assertEquals(null, stringQueue.peek());
		assertEquals(true, stringQueue.add(""));
		assertEquals("", stringQueue.peek());
		assertEquals(true, stringQueue.add("h"));
		assertEquals("h", stringQueue.peek());
		assertEquals(true, stringQueue.add("hello"));
		assertEquals("hello", stringQueue.peek());
		assertEquals(true, stringQueue.add("hello world 123"));
		assertEquals("hello world 123", stringQueue.peek());
		assertEquals(false, stringQueue.add(null));

		assertEquals(null, booleanQueue.peek());
		assertEquals(true, booleanQueue.add(true));
		assertEquals(true, booleanQueue.peek());
		assertEquals(true, booleanQueue.add(false));
		assertEquals(false, booleanQueue.peek());
		assertEquals(false, booleanQueue.add(null));

	}

	@Test
	public void remove() {
		assertEquals(null, integerQueue.remove());
		integerQueue.add(1);
		integerQueue.add(2);
		integerQueue.add(3);
		integerQueue.add(4);
		assertEquals(1, integerQueue.remove());
		assertEquals(2, integerQueue.remove());
		assertEquals(3, integerQueue.remove());
		assertEquals(4, integerQueue.remove());
		assertEquals(null, integerQueue.remove());

		assertEquals(null, stringQueue.remove());
		stringQueue.add("hello");
		stringQueue.add("world");
		stringQueue.add("this");
		stringQueue.add("is");
		assertEquals("hello", stringQueue.remove());
		assertEquals("world", stringQueue.remove());
		assertEquals("this", stringQueue.remove());
		assertEquals("is", stringQueue.remove());
	}

	@Test
	public void peek() {
		assertEquals(null, integerQueue.peek());
		assertEquals(true, integerQueue.add(0));
		assertEquals(0, integerQueue.peek());
		assertEquals(true, integerQueue.add(1));
		assertEquals(1, integerQueue.peek());
		assertEquals(true, integerQueue.add(-1));
		assertEquals(-1, integerQueue.peek());
		assertEquals(true, integerQueue.add(155));
		assertEquals(155, integerQueue.peek());
		assertEquals(true, integerQueue.add(Integer.MIN_VALUE));
		assertEquals(Integer.MIN_VALUE, integerQueue.peek());
		assertEquals(true, integerQueue.add(Integer.MAX_VALUE));
		assertEquals(Integer.MAX_VALUE, integerQueue.peek());
		assertEquals(false, integerQueue.add(null));

		assertEquals(null, stringQueue.peek());
		assertEquals(true, stringQueue.add(""));
		assertEquals("", stringQueue.peek());
		assertEquals(true, stringQueue.add("h"));
		assertEquals("h", stringQueue.peek());
		assertEquals(true, stringQueue.add("hello"));
		assertEquals("hello", stringQueue.peek());
		assertEquals(true, stringQueue.add("hello world 123"));
		assertEquals("hello world 123", stringQueue.peek());
		assertEquals(false, stringQueue.add(null));

		assertEquals(null, booleanQueue.peek());
		assertEquals(true, booleanQueue.add(true));
		assertEquals(true, booleanQueue.peek());
		assertEquals(true, booleanQueue.add(false));
		assertEquals(false, booleanQueue.peek());
		assertEquals(false, booleanQueue.add(null));
	}

	@Test
	public void equals() {
		assertTrue(integerQueue.equals(sameAsStateQueue));
		assertTrue(sameAsStateQueue.equals(integerQueue));
		assertTrue(integerQueue.equals(sameRefQueue));
		assertTrue(integerQueue.equals(yetAnotherQueue));
		assertTrue(integerQueue.equals(integerQueue2));
		assertFalse(integerQueue.equals("hello"));
		stringQueue.add("hello");
		integerQueue.add(1);
		assertFalse(integerQueue.equals(stringQueue));
		assertFalse(integerQueue.equals(nullQueue));
		integerQueue2.add(1);
		integerQueue.add(2);
		integerQueue2.add(2);
		integerQueue.add(1);
		assertFalse(integerQueue.equals(integerQueue2));
	}

	@Test
	public void testHashCode() {
		assertTrue(integerQueue.hashCode() == sameAsStateQueue.hashCode());
		assertTrue(integerQueue.hashCode() == sameRefQueue.hashCode());
		assertTrue(integerQueue.hashCode() == integerQueue2.hashCode());
		assertTrue(integerQueue.hashCode() == yetAnotherQueue.hashCode());
		assertFalse(integerQueue.hashCode() == "helo".hashCode());
		integerQueue2.add(1);
		assertFalse(integerQueue.hashCode() == integerQueue2.hashCode());
		integerQueue.add(2);
		assertFalse(integerQueue.hashCode() == integerQueue2.hashCode());
		assertFalse(integerQueue.hashCode() == stringQueue.hashCode());
	}

	@Test
	public void testToString() {
		assertEquals("QueueAdapter{adaptee=[]}", integerQueue.toString());
		integerQueue.add(1);
		assertEquals("QueueAdapter{adaptee=[1]}", integerQueue.toString());
		integerQueue.add(2);
		assertEquals("QueueAdapter{adaptee=[1, 2]}", integerQueue.toString());
		integerQueue.add(3);
		assertEquals("QueueAdapter{adaptee=[1, 2, 3]}", integerQueue.toString());
		integerQueue.remove();
		assertEquals("QueueAdapter{adaptee=[2, 3]}", integerQueue.toString());

	}
}