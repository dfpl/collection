package org.dfpl.collection.jaehyunList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.dfpl.collection.jaehyunList.*;

@SuppressWarnings("unused")
public class JLinkedList<E> implements List<E> {

	private JNode<E> head;
	private JNode<E> tail;
	private int length ;
	public JLinkedList() {
		//생성자 
		head = null;
		tail = null;
		this.length = 0;
	}
	public class JIterator<E>  implements ListIterator<E>{
		
		JNode<E> pointer;
		JIterator(){
			pointer = null;
		}
		public JIterator(JNode head) {
			pointer = head;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(this.pointer.Get_next_node()== null)
				return null;
			else {
				pointer = pointer.Get_next_node();
				return pointer.Get_value();
			}
		}
		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			if(this.pointer.Get_prev_node() == null)
				return false;
			else {
				return  true;
			}
		}
		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void add(E e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.length;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.length == 0) 
			return false;
		else
			return true;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new JIterator<>();
	}
	

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		if(head == null) { // 처음 삽입 할 때 
			JNode<E> new_node= new JNode(head ,e , tail);
			head = new_node;
			tail = new_node;
		}
		else {
			
		}
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		// TODO Auto-generated method stub

	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
