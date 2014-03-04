package com.isunwei.demo.algorithm.sort;

/**
 * 插入排序
 * 
 * 原理：将数组分为无序区和有序区两个区，然后不断将无序区的第一个元素按大小顺序插入到有序区中去，
 * 最终将所有无序区元素都移动到有序区完成排序。
 * 要点：设立哨兵，作为临时存储和判断数组边界之用。
 * 
 * 
 * @author sunwei
 * @date 2014-2-24
 * 
 */
public class InsertSort implements Sort {

	@Override
	public int[] sort(int[] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = i; j >0; j--) {
				if(input[j-1]>input[j]){
					int tmp = input[j-1];
					input[j-1] = input[j];
					input[j] = tmp;
				}
			}
		}
		return input;
	}
	

}
