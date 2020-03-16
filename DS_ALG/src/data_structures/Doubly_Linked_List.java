package data_structures;

import java.util.Iterator;

public class Doubly_Linked_List<T> implements Iterable<T>{

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private int size=0;
	private Node<T> head=null;
	private Node<T> tail=null;
	//Internal node class to represent data
	private class Node<T> {
		T data;
		Node<T> prev,next;
		public Node(T data,Node<T> prev,Node<T> tail) {
			this.data=data;
			this.prev=prev;
			this.next=next;
		}
	}
	
	//Empty the linkedlist - O(n)
	public void clear() {
		Node<T> trav=head;
		while(trav!=null) {
			Node<T> next=trav.next;
			trav.prev=trav.next=null;
			trav.data=null;
			trav=next;
		}
		head=tail=trav=null;
		size=0;
	}
	
	//Return size of Linkedlist
	public int size() {
		return size;
	}
	//Is this linkedlist null?
	public boolean isEmpty() {
		return size()==0;
	}
	
	//Add an element to the tail of Liknedlist - O(1)
	public void add(T elem) {
		addLast(elem);
	}
	
	public void addLast(T elem) {
		if(isEmpty()) {
			head=tail=new Node<T>(elem,null,null);
		}else {
			tail.next=new Node<T>(elem,tail,null);
			tail=tail.next;
		}
		size++;
	}
	
	//Add an element to the begining of LinkedList
	public void addFirst(T elem) {
		if(isEmpty()) {
			head=tail=new Node<T>(elem,null,null);
		}
		else {
			head.prev=new Node<T>(elem,null,head);
			head=head.prev;
		}
		size++;
	}
	
	//Check the value of the first node if it exists - O(1)
	public T peekFirst() {
		if(isEmpty()) {
			throw new RuntimeException("EmptyList");
		}
		else {
			return head.data;
		}
	}
	
	//Check the value of the last node if it exists - O(1)
	public T peekLast() {
		if(isEmpty()) {
			throw new RuntimeException("EmptyList");
		}
		else {
			return tail.data;
		}
	}
	
	//
	
	
}
