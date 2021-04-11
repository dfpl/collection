package org.dfpl.collection.hcLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JLinkedList<E> implements List<E> {

	private JNode<E> head;
	private JNode<E> tail;
	int length;

	public JNode<E> getHead() {
		return head;
	}

	public void setHead(JNode<E> head) {
		this.head = head;
	}

	public JNode<E> getTail() {
		return tail;
	}

	public void setTail(JNode<E> tail) {
		this.tail = tail;
	}

	public JLinkedList() {
		head = null;
		tail = null;
		length = 0;
	}

	public JNode<E> getNode(int index) {
		JNode<E> result = head;
		for (int i = 0; i < index; i++) {
			result = result.getNext();
		}
		return result;
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public boolean isEmpty() {
		if (length == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int indexOf(Object o) {
		int idx = 0;
		for (JNode<E> i = head; i != null; i = i.getNext(), idx++) {
			if (i.getValue().equals(o)) {
				return idx;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(Object o) {
		if (indexOf(o) == -1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public E get(int index) {
		return getNode(index).getValue();
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
	}

	@Override
	public E set(int index, E element) {
		E prev = getNode(index).getValue();
		getNode(index).setValue(element);
		return prev;
	}

	@Override
	public void add(int index, E element) {
		JNode<E> newNode = new JNode<E>(null, element, null);
		// idx > size ???? try,except ?
		if (head == null) {
			// empty
			head = newNode;
			tail = newNode;
		} else if (index == 0) {
			// add first
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
		} else if (index == size()) {
			// add last
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		} else {
			JNode<E> prevNode = getNode(index);
			JNode<E> nextNode = getNode(index + 1);
			newNode.setNext(nextNode);
			newNode.setPrev(prevNode);
			prevNode.setNext(newNode);
			nextNode.setPrev(newNode);
		}
		length++;
	}

	@Override
	public boolean add(E e) {
		add(size(), e);
		return true;
	}

	@Override
	public int lastIndexOf(Object o) {
		int idx = size() - 1;
		for (JNode<E> i = tail; i != null; i = i.getPrev(), idx--) {
			if (i.getValue().equals(o)) {
				return idx;
			}
		}
		return -1;
	}

	private class JListIterator<E> implements ListIterator<E> {
		JNode<E> curNode;
		int curIdx;
		JLinkedList<E> linkedList;

		JListIterator(int idx, JLinkedList<E> link) {
			curIdx = idx;
			curNode = link.getNode(idx);
			linkedList = link;
		}

		@Override
		public boolean hasNext() {
			return curNode != null;
		}

		@Override
		public E next() {
			E result = curNode.getValue();
			curNode = curNode.getNext();
			curIdx++;
			return result;
		}

		@Override
		public boolean hasPrevious() {
			return curNode != null;
		}

		@Override
		public E previous() {
			E result = curNode.getValue();
			curNode = curNode.getPrev();
			curIdx--;
			return result;
		}

		@Override
		public int nextIndex() {
			if (curIdx + 1 == linkedList.size()) {
				return linkedList.size();
			} else {
				return curIdx + 1;
			}
		}

		@Override
		public int previousIndex() {
			return curIdx - 1;
		}

		@Override
		public void remove() {
			linkedList.remove(curIdx);
		}

		@Override
		public void set(E e) {
			linkedList.set(curIdx, e);

		}

		@Override
		public void add(E e) {
			linkedList.add(curIdx, e);
		}

	}

	@Override
	public ListIterator<E> listIterator() {
		
		return new JListIterator<>(0, this);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new JListIterator<>(index, this);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		List<E> result = new JLinkedList<E>();
		JNode<E> start = getNode(fromIndex);
		JNode<E> end = getNode(toIndex);
		while(!start.equals(end)) {
			result.add(start.getValue());
			start = start.getNext();
		}
		result.add(end.getValue());
		return result;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		Iterator<?> iter = c.iterator();
		int cnt = 0;
		
		while(iter.hasNext()) {
			 if(contains(iter.next())) {
				 cnt ++;
			 }
		}
		if (cnt == c.size()){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		Iterator<?> iter = c.iterator();
		while(iter.hasNext()) {
			add((E)iter.next());
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		Iterator<?> iter = c.iterator();
		while(iter.hasNext()) {
			add(index,(E) iter.next());
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		Iterator<?> iter = c.iterator();
		while(iter.hasNext()) {
			remove(iter.next());
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		Iterator<?> iter = c.iterator();
		
		while(iter.hasNext()) {
			 if(!contains(iter.next())) {
				 remove(iter.next());
			 }
		}
		return true;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[size()];
		int num = 0;
		for (JNode<E> i = head; i != null; i = i.getNext()) {
			result[num++] = i.getValue();
		}
		return result;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return new JIterator<E>(head);
	}

	private class JIterator<E> implements Iterator<E> {
		JNode<E> curNode;

		JIterator(JNode<E> head) {
			curNode = head;
		}

		@Override
		public boolean hasNext() {
			return curNode != null ? true : false;
		}

		@Override
		public E next() {
			E value = curNode.getValue();
			curNode = curNode.getNext();
			return value;
		}

	}

	@Override
	public boolean remove(Object o) {
		if (contains(o)) {
			remove(indexOf(o));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public E remove(int index) {
		// idx > size -> getNode = null ???? try,except ?
		JNode<E> oldNode = getNode(index);
		JNode<E> prevNode = oldNode.getPrev();
		JNode<E> nextNode = oldNode.getNext();
		if (index == 0) {
			// remove first
			head = nextNode;
			nextNode.setPrev(null);
		} else if (index == size() - 1) {
			// remove last
			tail = prevNode;
			prevNode.setNext(null);
		} else {
			prevNode.setNext(nextNode);
			nextNode.setPrev(prevNode);
		}
		length--;
		return oldNode.getValue();
	}

}
