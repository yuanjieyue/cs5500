package yuanjieyue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
	private Queue<Integer> integerQueue;
	private Queue<String> stringQueue;
	private Queue<Boolean> booleanQueue;

	@Before
	public void setUp() throws Exception {
		integerQueue = new QueueAdapter<>();
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
}