package org.dfpl.collection.hcLinkedList;

import java.util.Iterator;

public class App {

	public static void main(String[] args) {
		JLinkedList<Integer> x = new JLinkedList<Integer>();
		
		for(int i = 0;i<10;i++) {
			x.add(i);
		}
		
		Iterator<Integer> iter = x.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

}
