package org.dfpl.collection.hcLinkedList;

public class JNode<E> {

	JNode<E> next;
	JNode<E> prev;
	E value;

	public JNode(JNode<E> prev, E value, JNode<E> next) {
		this.prev = prev;
		this.value = value;
		this.next = next;
	}
}
