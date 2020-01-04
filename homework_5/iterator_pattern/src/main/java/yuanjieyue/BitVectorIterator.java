package yuanjieyue;

import java.util.ArrayList;
import java.util.List;

public class BitVectorIterator implements Iterator<Integer> {
	private List<Integer> nums;
	private int numCnt;

	BitVectorIterator(BitVector bitVector) {
		nums = new ArrayList<>();
		populateList(nums, bitVector);
		numCnt = 0;
	}

	private void populateList(List<Integer> nums, BitVector bitVector) {
		for (int i = 0; i < BitVector.ARRAY_SIZE; i++) {
			for (int j = 0; j < BitVector.ARRAY_SIZE; j++) {
				int pos = i * BitVector.ARRAY_SIZE + j;
				if (bitVector.get(pos)) {
					nums.add(pos);
				}
			}
		}
	}

	@Override
	public boolean hasAnotherElement() {
		return numCnt < nums.size();
	}

	@Override
	public Integer nextElement() {
		int nextEle = nums.get(numCnt);
		numCnt++;
		return nextEle;
	}
}
