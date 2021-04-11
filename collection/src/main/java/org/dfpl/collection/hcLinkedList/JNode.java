package org.dfpl.collection.hcLinkedList;

public class JNode<E> {

	private JNode<E> prev;
	private E value;
	private JNode<E> next;

	public JNode(JNode<E> prev, E value, JNode<E> next) {
		this.prev = prev;
		this.value = value;
		this.next = next;
	}
	
	public JNode<E> getPrev() {
		return prev;
	}

	public void setPrev(JNode<E> prev) {
		this.prev = prev;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public JNode<E> getNext() {
		return next;
	}

	public void setNext(JNode<E> next) {
		this.next = next;
	}
	
}
