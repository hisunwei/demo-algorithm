package com.isunwei.demo.algorithm.sort;


/**
 * 冒泡排序
 * 
 * 原理：将序列划分为无序和有序区，不断通过交换较大元素至无序区尾完成排序。
 * 要点：设计交换判断条件，提前结束以排好序的序列循环。
 * 
 * @author sunwei
 * @date 2014-2-24
 */
public class BubbleSort implements Sort {

	@Override
	public int[] sort(int[] input) {
		for (int i = input.length-1; i >0 ; i--) {
			boolean changed = false;
			for (int j = 0; j <i; j++) {
				if(input[j]>input[j+1]){
					int tmp = input[j];
					input[j] = input[j+1];
					input[j+1] = tmp;
					changed = true;
				}
			}
			if(changed){
				break;
			}
		}
		return input;
	}

}
