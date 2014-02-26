package com.isunwei.demo.algorithm.sort;

public class BucketSort implements Sort {

	class Node {
		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node cur = this;
			while (cur != null) {
				sb.append("," + cur.value + "");
				cur = cur.next;
			}
			return sb.toString();
		}

		int value;
		Node next;
	}

	class Bucket {
		int count;
		int maxValue;
		Node[] roots;

		public Bucket(int[] input) {
			this.count = input.length;
			this.roots = new Node[count];
			int maxIndex = 0;
			for (int i = 1; i < input.length; i++) {
				if (input[maxIndex] < input[i]) {
					maxIndex = i;
				}
			}
			this.maxValue = input[maxIndex];
		}

		public void append(int value) {
			int index = (value - 1) * count / maxValue;
			Node root = this.roots[index];
			if (root == null || root.value >= value) {
				this.roots[index] = new Node(value, root);
				return;
			}
			Node cur = root;
			while (cur != null) {
				if (cur.value < value && (cur.next == null || cur.next.value >= value)) {
					Node tmp = cur.next;
					cur.next = new Node(value, tmp);
					
					break;
				}
				cur = cur.next;
			}
		}

		public void sort(int[] input) {
			for (int i = 0; i < input.length; i++) {
				this.append(input[i]);
			}

			for (int i = 0; i < roots.length; i++) {
				System.out.println("index: " + i + "values: " + roots[i]);
			}

			int i = 0;
			for (Node root : roots) {
				Node node = root;
				while (node != null) {
					input[i++] = node.value;
					node = node.next;
				}
			}
		}
	}

	@Override
	public int[] sort(int[] input) {
		new Bucket(input).sort(input);
		return input;
	}

}
