package org.dfpl.collection.hcLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JLinkedList<E> implements List<E> {

	JNode<E> head;
	JNode<E> tail;
	JNode<E> start;
	JNode<E> end;
	int size;

	public JLinkedList() {
		head = tail = start = end = null;
		size = 0;
	}

	public JLinkedList(JNode<E> head, JNode<E> tail, JNode<E> start, JNode<E> end, int size) {
		this.head = head;
		this.tail = tail;
		this.start = start;
		this.end = end;
		this.size = size;
	}

	public JNode<E> getNode(int index) {
		JNode<E> result = head;
		for (int i = 0; i < index; i++) {
			result = result.next;
		}
		return result;
	}

	public E removeLink(JNode<E> oldNode) {
		JNode<E> prevNode = oldNode.prev;
		JNode<E> nextNode = oldNode.next;
		E result = oldNode.value;
		if (prevNode == null) {
			head = nextNode;
		} else {
			prevNode.next = nextNode;
			oldNode.prev = null;
		}
		if (nextNode == null) {
			tail = prevNode;
		} else {
			nextNode.prev = prevNode;
			oldNode.next = null;
		}
		size--;
		oldNode.value = null;
		return result;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	public class JListIterator implements ListIterator<E> {
		JNode<E> lastReturned;
		JNode<E> nextNode;
		int nextIdx;

		public JListIterator() {
			lastReturned = null;
			nextNode = head;
			nextIdx = 0;
		}

		public JListIterator(int index) {
			lastReturned = null;
			nextNode = getNode(index);
			nextIdx = index;
		}

		@Override
		public boolean hasNext() {
			boolean result = nextIdx < size;
			if (!result) {
				nextIdx = 0;
				nextNode = head;
				lastReturned = null;
			}
			return result;
		}

		@Override
		public E next() {
			lastReturned = nextNode;
			nextNode = nextNode.next;
			nextIdx++;
			return lastReturned.value;
		}

		@Override
		public boolean hasPrevious() {
			return nextIdx > 0;
		}

		@Override
		public E previous() {
			lastReturned = nextNode = nextNode.prev;
			nextIdx--;
			return lastReturned.value;
		}

		@Override
		public int nextIndex() {
			return nextIdx;
		}

		@Override
		public int previousIndex() {
			return nextIdx--;
		}

		@Override
		public void remove() {
			JNode<E> result = lastReturned.next;
			removeLink(lastReturned);
			if (nextNode == lastReturned)
				nextNode = result;
			else
				nextIdx--;
			lastReturned = null;
		}

		@Override
		public void set(E e) {
			lastReturned.value = e;
		}

		@Override
		public void add(E e) {
			JNode<E> newNode = new JNode<E>(null, e, null);
			if (lastReturned == null) {
				nextNode.prev = newNode;
				newNode.next = nextNode;
				head = newNode;
			} else if (nextNode == tail.next) {
				newNode.prev = lastReturned;
				lastReturned.next = newNode;
				tail = newNode;
			} else {
				nextNode.prev = newNode;
				lastReturned.next = newNode;
				newNode.next = nextNode;
				newNode.prev = lastReturned;
			}
			size++;
			lastReturned = newNode;
			nextIdx++;
		}

	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> result = new JListIterator();
		return result;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[size];
		int idx = 0;
		for (JNode<E> i = head;; i = i.next) {
			result[idx++] = i.value;
			if (i == tail) {
				break;
			}
		}
		return result;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		int idx = a.length;
		Object[] result = a;
		for (JNode<E> i = head;; i = i.next) {
			result[idx++] = i.value;
			if (i == tail) {
				break;
			}
		}

		return a;
	}

	@Override
	public boolean add(E e) {
		add(size(), e);
		return true;
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
	public boolean containsAll(Collection<?> c) {
		for (Object object : c) {
			if (!contains(object)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for (E e : c) {
			add(e);
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		for (E e : c) {
			add(index, e);
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		Iterator<?> iter = iterator();
		while (iter.hasNext()) {
			if (c.contains(iter.next())) {
				iter.remove();
			}
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		Iterator<?> iter = iterator();
		while (iter.hasNext()) {
			if (!c.contains(iter.next())) {
				iter.remove();
			}
		}
		return true;
	}

	@Override
	public void clear() {
		Iterator<E> it = iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
	}

	@Override
	public E get(int index) {
		return getNode(index).value;
	}

	@Override
	public E set(int index, E element) {
		E prev = getNode(index).value;
		getNode(index).value = element;
		return prev;
	}

	@Override
	public void add(int index, E element) {
		JNode<E> newNode = new JNode<E>(null, element, null);
		if (head == null) {
			head = newNode;
			tail = newNode;

		} else if (index == 0) {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		} else if (index == size()) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		} else {
			JNode<E> prevNode = getNode(index);
			JNode<E> nextNode = getNode(index + 1);
			newNode.next = nextNode;
			newNode.prev = prevNode;
			prevNode.next = newNode;
			nextNode.prev = newNode;
		}
		size++;

	}

	@Override
	public E remove(int index) {
		E result = removeLink(getNode(index));
		return result;
	}

	@Override
	public int indexOf(Object o) {
		int idx = 0;
		for (JNode<E> i = head;; i = i.next, idx++) {
			if (i.value.equals(o)) {
				return idx;
			}
			if (i == tail) {
				break;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		int idx = size() - 1;
		for (JNode<E> i = tail;; i = i.prev, idx--) {
			if (i.value.equals(o)) {
				return idx;
			}
			if (i == head) {
				break;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new JListIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new JListIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		int length = toIndex - fromIndex + 1;
		List<E> result = new JLinkedList<E>(getNode(fromIndex), getNode(toIndex), head, tail, length);
		return result;
	}

}
