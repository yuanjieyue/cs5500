package yuanjieyue;

/**
 * A bitvector.
 */
public interface IBitVector {

	/**
	 * Determine if the bit at position i is set.
	 * @param i the position in the set.
	 * @return true if the ith position is set, false otherwise.
	 */
	boolean get(int i);

	/**
	 * Set the bit at position i.
	 * @param i the position in the set
	 */
	void set(int i);

	/**
	 * Clear the bit at position i.
	 * @param i reset the ith position to 0.
	 */
	void clear(int i);

	/**
	 * Set the bits in the argument BitVector b.
	 * @param b a bit vector.
	 */
	void copy(BitVector b);

	/**
	 * Determine the number of non-zero bits in the BitVector.
	 * @return the number of the set bits in the BitVector.
	 */
	int size();

	/**
	 * Iterator over the Integer values represented by this BitVector.
	 * @return
	 */
	Iterator<Integer> iterator();
}
