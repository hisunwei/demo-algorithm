package com.isunwei.demo.algorithm.sort;

/**
 * 快速排序
 * 
 * 原理：不断寻找一个序列的中点，然后对中点左右的序列递归的进行排序，直至全部序列排序完成，使用了分治的思想。
 * 要点：递归、分治
 * 
 * @author sunwei
 * @date 2014-2-24
 */
public class QuickSort implements Sort {

	@Override
	public int[] sort(int[] input) {
		sort(input, 0, input.length - 1);
		return input;
	}

	public int partition(int[] input, int began, int end) {
		int first = input[began];
		while (began < end) {
			while (began < end && input[end] > first) end--;
			input[began] = input[end];
			while (began < end && input[began] <= first) began++;
			input[end] = input[began];
		}
		input[began] = first;
		return began;
	}

	public void sort(int[] input, int began, int end) {
		if (began < end) {
			int split = partition(input, began, end);
			sort(input, began, split - 1);
			sort(input, split + 1, end);
		}
	}

}
