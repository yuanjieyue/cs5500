package yuanjieyue;

import java.util.Arrays;

/**
 * A BitVector.
 */
public class BitVector implements IBitVector {
	public static final int ARRAY_SIZE = 32;
	private int[] sets;

	/**
	 * Create a new BitVector.
	 */
	BitVector() {
		sets = new int[ARRAY_SIZE];
	}

	/**
	 * Getter for the attribute sets.
	 * @return the sets attribute.
	 */
	public int[] getSets() {
		return sets;
	}

	@Override
	public boolean get(int i) {
		int index = i / ARRAY_SIZE;
		int bitPos = i % ARRAY_SIZE;
		return (sets[index] & (1 << bitPos)) != 0;
	}

	@Override
	public void set(int i) {
		int index = i / ARRAY_SIZE;
		int bitPos = i % ARRAY_SIZE;
		sets[index] |= (1 << bitPos);
	}

	@Override
	public void clear(int i) {
		int index = i / ARRAY_SIZE;
		int bitPos = i % ARRAY_SIZE;
		sets[index] ^= (1 << bitPos);
	}

	@Override
	public void copy(BitVector b) {
		for (int i = 0; i < ARRAY_SIZE * ARRAY_SIZE; i++) {
			if (b.get(i)) {
				set(i);
			}
		}
	}

	@Override
	public int size() {
		int size = 0;
		for (int i = 0; i < ARRAY_SIZE; i++) {
			size += setBits(sets[i]);
		}
		return size;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new BitVectorIterator(this);
	}

	/**
	 * A helper function to count the number of set bits in the given integer.
	 * @param num the integer given.
	 * @return the number of set bits.
	 */
	private int setBits(int num) {
		int cnt = 0;
		for (int i = 0; i < ARRAY_SIZE; i++) {
			if ((num & (1 << i)) != 0) {
				cnt++;
			}
		}
		return cnt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof BitVector)) {
			return false;
		}

		BitVector bitVector = (BitVector) o;

		return Arrays.equals(getSets(), bitVector.getSets());
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(getSets());
	}

	@Override
	public String toString() {
		return "BitVector{" +
			"sets=" + Arrays.toString(sets) +
			'}';
	}
}
