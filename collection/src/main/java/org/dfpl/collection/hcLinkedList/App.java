package org.dfpl.collection.hcLinkedList;

import java.util.Iterator;
import java.util.List;

public class App {

	public static void main(String[] args) {
		JLinkedList<Integer> a = new JLinkedList<Integer>();
		for (int i = 1; i <= 10; i++) {
			a.add(i);
		}

		List<Integer> sub = a.subList(3, 7);

		Iterator<Integer> a_iter = a.iterator();
		Iterator<Integer> sub_iter = sub.iterator();
		while (a_iter.hasNext()) {
			System.out.println(a_iter.next());
		}
		System.out.println("==============================================");
		while (sub_iter.hasNext()) {
			System.out.println(sub_iter.next());
		}
	}

}
