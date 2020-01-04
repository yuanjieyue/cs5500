package yuanjieyue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BitVectorIteratorTest {
	private BitVector bitVector;
	private BitVectorIterator iter;

	@Before
	public void setUp() throws Exception {
		bitVector = new BitVector();
		bitVector.set(0);
		bitVector.set(1);
		bitVector.set(5);
		bitVector.set(32);
		bitVector.set(31 * 32 + 31);
		iter = new BitVectorIterator(bitVector);
	}

	@Test
	public void hasAnotherElement() {
		assertEquals(true, iter.hasAnotherElement());
		iter.nextElement();
		assertEquals(true, iter.hasAnotherElement());
		iter.nextElement();
		assertEquals(true, iter.hasAnotherElement());
		iter.nextElement();
		assertEquals(true, iter.hasAnotherElement());
		iter.nextElement();
		assertEquals(true, iter.hasAnotherElement());
		iter.nextElement();
		assertEquals(false, iter.hasAnotherElement());
	}

	@Test
	public void nextElement() {
		assertEquals(0, iter.nextElement());
		assertEquals(1, iter.nextElement());
		assertEquals(5, iter.nextElement());
		assertEquals(32, iter.nextElement());
		assertEquals(31 * 32 + 31, iter.nextElement());
	}
}