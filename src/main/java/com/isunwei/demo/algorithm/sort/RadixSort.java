package com.isunwei.demo.algorithm.sort;

import java.util.Arrays;

public class RadixSort implements Sort {

	final static int divisor = 8;
	int[] count = new int[1 << 8];

	public int[] getCounter() {
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		return this.count;
	}

	public int[] sort(int[] input) {
		int max = maxPass(input);

		for (int i = max; i > 0; i = i >> 8) {
			onepass(input, i);
		}
		return input;
	}

	public static int oneByte(int val, int time) {
		int x = time * 8;
		val >>>= x;
		return (byte) val;
	}

	public void onepass(int[] input, int time) {
		int[] count = this.getCounter();

		int len = input.length;
		for (int i = 0; i < len; i++) {
			count[oneByte(input[i], time)]++;
		}

		for (int i = 1; i < len; i++) {
			count[i] += count[i - 1];
		}

		int[] tmp = new int[len];
		for (int i = len - 1; i >= 0; i--) {
			int index = oneByte(input[i], time);
			count[index] = count[index] - 1;
			tmp[count[index]] = input[i];
		}

		for (int i = 0; i < len; i++) {
			input[i] = tmp[i];
		}

	}

	public static int maxPass(int[] input) {
		assert input.length > 0;
		int max = 0;
		for (int i = 1; i < input.length; i++) {
			if (input[i] > input[max]) {
				max = i;
			}
		}

		return input[max];
	}

	public static void main(String[] args) {
		int[] input = { 93, 12, 41, 833, 34, 15, 04, 13, 51, 36, 94,05, 122 };
		System.out.println(Arrays.toString(input));
		System.out.println(">>>RadixSort排序后>>>\n"
				+ Arrays.toString(new RadixSort().sort(input)));
//		System.out.println(">>>CountSort排序后>>>\n"
//				+ Arrays.toString(new CountSort().sort(input)));

	}
}
