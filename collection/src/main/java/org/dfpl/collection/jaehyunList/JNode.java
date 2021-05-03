package org.dfpl.collection.jaehyunList;

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
	
	public JNode<E> Get_prev_node(){
		
		return this.prev;
	}
	public JNode<E> Get_next_node(){
		return this.next;
	}
	public E Get_value() {
		return this.value;
	}
	// ----getter 
	public void Set_Prev(JNode<E> prev) {
		this.prev = prev;
	}
	public void Set_Next(JNode<E> next) {
		this.next = next;
	}
	public void Set_value(E value) {
		this.value = value;
	}
	// ----- setter
}
