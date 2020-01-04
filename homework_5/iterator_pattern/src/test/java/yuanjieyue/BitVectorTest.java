package yuanjieyue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BitVectorTest {
	private BitVector bitVector1;
	private BitVector bitVector2;
	private BitVector sameRefBitVector;
	private BitVector sameAsStateBitVector;
	private BitVector yetAnotherBitVector;
	private BitVector nullVector;

	@Before
	public void setUp() throws Exception {
		bitVector1 = new BitVector();
		bitVector2 = new BitVector();
		sameRefBitVector = bitVector1;
		sameAsStateBitVector = new BitVector();
		yetAnotherBitVector = new BitVector();
	}

	@Test
	public void getSets() {
		int[] test = new int[BitVector.ARRAY_SIZE];
		int[] sets = bitVector1.getSets();
		assertEquals(sets.length, test.length);
		for (int i = 0; i < test.length; i++) {
			assertEquals(sets[i], test[i]);
		}
	}

	@Test
	public void get() {
		assertEquals(false, bitVector1.get(0));
		assertEquals(false, bitVector1.get(1));
		assertEquals(false, bitVector1.get(5));
		assertEquals(false, bitVector1.get(32));
		assertEquals(false, bitVector1.get(31 * 32 + 31));
	}

	@Test
	public void set() {
		assertEquals(false, bitVector1.get(0));
		bitVector1.set(0);
		assertEquals(true, bitVector1.get(0));
		bitVector1.set(1);
		assertEquals(true, bitVector1.get(1));
		bitVector1.set(5);
		assertEquals(true, bitVector1.get(5));
		bitVector1.set(32);
		assertEquals(true, bitVector1.get(32));
		bitVector1.set(31 * 32 + 31);
		assertEquals(true, bitVector1.get(31 * 32 + 31));
	}

	@Test
	public void clear() {
		assertEquals(false, bitVector1.get(0));
		bitVector1.set(0);
		bitVector1.set(1);
		bitVector1.set(5);
		bitVector1.set(32);
		bitVector1.set(31 * 32 + 31);
		bitVector1.clear(0);
		assertEquals(false, bitVector1.get(0));
		bitVector1.clear(1);
		assertEquals(false, bitVector1.get(1));
		bitVector1.clear(5);
		assertEquals(false, bitVector1.get(5));
		bitVector1.clear(32);
		assertEquals(false, bitVector1.get(32));
		bitVector1.clear(31 * 32 + 31);
		assertEquals(false, bitVector1.get(31 * 32 + 31));
	}

	@Test
	public void copy() {
		bitVector1.set(0);
		bitVector1.set(1);
		bitVector1.set(5);
		bitVector1.set(32);
		bitVector1.set(31 * 32 + 31);
		bitVector2.copy(bitVector1);
		assertEquals(true, bitVector2.get(0));
		assertEquals(true, bitVector2.get(1));
		assertEquals(true, bitVector2.get(5));
		assertEquals(true, bitVector2.get(32));
		assertEquals(true, bitVector2.get(31 * 32 + 31));
	}

	@Test
	public void size() {
		bitVector1.set(0);
		assertEquals(1, bitVector1.size());
		bitVector1.set(1);
		assertEquals(2, bitVector1.size());
		bitVector1.set(5);
		assertEquals(3, bitVector1.size());
		bitVector1.set(32);
		assertEquals(4, bitVector1.size());
		bitVector1.set(31 * 32 + 31);
		assertEquals(5, bitVector1.size());
	}

	@Test
	public void iterator() {
		bitVector1.set(0);
		bitVector1.set(1);
		bitVector1.set(5);
		bitVector1.set(32);
		bitVector1.set(31 * 32 + 31);
		Iterator<Integer> iter = bitVector1.iterator();
		assertEquals(0, iter.nextElement());
		assertEquals(1, iter.nextElement());
		assertEquals(5, iter.nextElement());
		assertEquals(32, iter.nextElement());
		assertEquals(31 * 32 + 31, iter.nextElement());
	}

	@Test
	public void equals() {
		assertTrue(bitVector1.equals(sameAsStateBitVector));
		assertTrue(sameAsStateBitVector.equals(bitVector1));
		assertTrue(bitVector1.equals(sameRefBitVector));
		assertTrue(bitVector1.equals(yetAnotherBitVector));
		assertFalse(bitVector1.equals(nullVector));
		assertFalse(bitVector1.equals("hello"));
		bitVector2.set(1);
		assertFalse(bitVector1.equals(bitVector2));
	}

	@Test
	public void testHashCode() {

		assertTrue(bitVector1.hashCode() == sameAsStateBitVector.hashCode());
		assertTrue(bitVector1.hashCode() == sameRefBitVector.hashCode());
		assertTrue(bitVector1.hashCode() == yetAnotherBitVector.hashCode());
		assertTrue(bitVector1.hashCode() == bitVector2.hashCode());
		bitVector2.set(1);
		assertFalse(bitVector1.hashCode() == bitVector2.hashCode());
	}

	@Test
	public void testToString() {
		assertEquals("BitVector{sets=[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, " +
			"0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]}", bitVector1.toString());
		bitVector2.set(1);
		bitVector2.set(124);
		assertEquals("BitVector{sets=[2, 0, 0, 268435456, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, " +
			"0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]}", bitVector2.toString());
	}

}