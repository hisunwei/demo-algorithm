package com.isunwei.demo.algorithm.sort;

/**
 * 堆排序
 * 
 * @author sunwei
 * @date 2014-2-24
 */
public class HeapSort implements Sort {

	@Override
	public int[] sort(int[] input) {
		for (int i = input.length - 1; i >= 0; i--) {
			int parent = (i - 1) / 2;
			if (input[parent] < input[i]) {
				swap(input, parent, i);
			}
		}
		int end = input.length;
		while (end > 0) {
			swap(input, 0, --end);

			int parent = 0;
			while (true) {
				int left = (parent + 1) * 2 - 1;
				int right = (parent + 1) * 2;
				if (right < end) {
					int max = input[right] > input[left] ? right : left;
					if (input[max] > input[parent]) {
						swap(input, parent, max);
						parent = max;
						continue;
					}
				}
				if (left < end) {
					if (input[left] > input[parent]) {
						swap(input, left, parent);
					}
					parent = left;
				}
				break;
			}
		}

		return input;
	}

	public void maxHeap(int[] input, int length) {
		for (int i = length; i >= 0; i--) {
			int parent = (i - 1) / 2;
			if (input[parent] < input[i]) {
				swap(input, parent, i);
			}
		}
	}

	/**
	 * 精简版本
	 * 
	 * @param input
	 * @return
	 */
	public int[] sort2(int[] input) {
		for (int i = input.length - 1; i > 0; i--) {
			maxHeap(input, i);
			swap(input, 0, i);
		}
		return input;
	}

	public void swap(int[] input, int x, int y) {
		if (x != y) {
			int tmp = input[x];
			input[x] = input[y];
			input[y] = tmp;
		}
	}

}
