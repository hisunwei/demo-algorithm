package com.isunwei.demo.algorithm.sort;

/**
 * 选择排序 
 * 
 * 原理：将序列划分为无序和有序区，寻找无序区中的最小值和无序区的首元素交换，有序区扩大一个，循环最终完成全部排序。
 * 
 * @author sunwei
 * @date 2014-2-24
 */
public class SelectSort implements Sort {

	@Override
	public int[] sort(int[] input) {
		int i, j, k;
		for (i = 0; i < input.length; i++) {
			k = i;
			for (j = i + 1; j < input.length; j++) {
				if (input[j] < input[k]) {
					k = j;
				}
			}
			if (k != i) {
				int tmp = input[k];
				input[k] = input[i];
				input[i] = tmp;
			}
		}
		return input;
	}

}
