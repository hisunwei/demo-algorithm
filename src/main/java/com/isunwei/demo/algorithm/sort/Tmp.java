package com.isunwei.demo.algorithm.sort;

public class Tmp {

	public static void main(String[] args) throws InterruptedException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		// System.out.println("x1");
		// Thread.sleep(1000);
		// X x;
		// System.out.println("x2");
		// System.out.println(X.y);
		// System.out.println("x3");
		// System.out.println(X.a);
		
		System.out.println(E.class.getName());
//		Class<?> ca = Class.forName("com.isunwei.demo.algorithm.sort.C2", true,
//				Tmp.class.getClassLoader());
		Class<?> ca = Tmp.class.getClassLoader().loadClass("com.isunwei.demo.algorithm.sort.C2");
		System.out.println("ca:" + ca);
//		Class<?> cb = Class.forName("com.isunwei.demo.algorithm.sort.C2", true,
//				Sort.class.getClassLoader());
		Class<?> cb = Sort.class.getClassLoader().loadClass("com.isunwei.demo.algorithm.sort.C2");
		System.out.println("cb:" + cb);
		System.out.println("ca: " + ((C2) ca.newInstance()).s);
		System.out.println("cb: " + ((C2) cb.newInstance()).s);
		
		System.out.println(E.class.getName());
		Class<?> c1 = Class.forName("com.isunwei.demo.algorithm.sort.C", true,
				Tmp.class.getClassLoader());
		System.out.println("c1:" + c1);
		Class<?> c2 = Class.forName("com.isunwei.demo.algorithm.sort.C", true,
				Sort.class.getClassLoader());
		System.out.println("c2:" + c2);
		System.out.println("c1: " + ((C) c1.newInstance()).getS());
		System.out.println("c2: " + ((C) c2.newInstance()).getS());

		Class<?> c3 = Class.forName("com.isunwei.demo.algorithm.sort.E", true,
				Tmp.class.getClassLoader());
		System.out.println("c3:" + c3);
		Class<?> c4 = Class.forName("com.isunwei.demo.algorithm.sort.E", true,
				Sort.class.getClassLoader());
		System.out.println("c4:" + c4);
		System.out.println("c3:" + Enum.valueOf((Class<E>) c3, "a").s);
		System.out.println("c4:" + Enum.valueOf((Class<E>) c4, "b").s);

		// System.out.println(((X)c2.newInstance()).y);

	}

}

class C2 {
	static S s = new S();
}

class C {
	static S getS() {
		return Q.s;
	}

	static class Q {
		static S s = new S();
	}
}

class S {
	S() {
		System.out.println("init Y");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

enum E {
	a(1), b(2), c(3);
	static S s = new S();

	E(int i) {
		System.out.println("enum" + i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static {
		System.out.println("check" + E.s);
	}
}