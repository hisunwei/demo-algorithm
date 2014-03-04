package com.isunwei.demo.algorithm.sort;

import java.util.Arrays;

/**
 * 
 * (spit "number.txt" (seq (repeatedly 10000 #(rand-int 10000))))
 * 
 * 
 * 只适用于最大值不大于数组最大下标的情况
 * 
 * @author sw
 * 
 */
public class CountSort implements Sort {

	@Override
	public int[] sort(int[] input) {
		int len = input.length;

		int[] count = new int[len];
		for (int i = 0; i < len; i++) {
			if (input[i] > len - 1) {
				throw new RuntimeException("第" + i + "个值" + input[i]
						+ "大于最大数组长度" + len + "-1");
			}
			count[input[i]]++;
		}

		for (int i = 1; i < len; i++) {
			count[i] += count[i - 1];
		}

		int[] tmp = new int[len];
		for (int i = len - 1; i >= 0; i--) {
			int value = input[i];
			count[value] = count[value] - 1;
			tmp[count[value]] = input[i];
		}

		for (int i = 0; i < len; i++) {
			input[i] = tmp[i];
		}
		return input;
	}

	public static void main(String args[]) {
		int[] input = { 3, 2, 4, 8, 3, 1, 0, 3, 1, 6, 4, 5, 2 };
		System.out.println(Arrays.toString(input));

		System.out.println(">>>排序后>>>\n"
				+ Arrays.toString(new CountSort().sort(input)));
	}

}
