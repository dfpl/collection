package org.dfpl.collection.linkedlist;

@SuppressWarnings("unused")
public class JNode<E> {

	private JNode<E> prev;
	private E value;
	private JNode<E> next;

	public JNode(JNode<E> prev, E value, JNode<E> next) {
		this.prev = prev;
		this.value = value;
		this.next = next;
	}
}
