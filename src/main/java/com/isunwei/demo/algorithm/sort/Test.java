package com.isunwei.demo.algorithm.sort;

import java.util.Arrays;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input =  {6,2,4,1,5,9};
		System.out.println(Arrays.toString(input));
//		Sort sort = new QuickSort();
//		sort.sort(input);
//		System.out.println(Arrays.toString(input));
//		System.out.println(Arrays.toString(new InsertSort().sort(input)));
//		System.out.println(Arrays.toString(new BubbleSort().sort(input)));
//		System.out.println(Arrays.toString(new SelectSort().sort(input)));
//		System.out.println(Arrays.toString(new HeapSort().sort(input)));
//		System.out.println(Arrays.toString(new HeapSort().sort2(input)));
		System.out.println(Arrays.toString(new BucketSort().sort(input)));
		
		
		
	}

}
