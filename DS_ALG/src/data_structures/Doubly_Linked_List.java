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
	
	//Remove the first value at the head of the linked list - O(1)
	public T removeFirst() {
		if(isEmpty()) throw new RuntimeException("EmptyList");
		
		T data = head.data;
		head = head.next;
		--size;
		if(isEmpty()) tail=null;
		else head.prev=null;
		return data;
	}
	
	//Remove the last element of the linked list - O(1)
	public T removeLast() {
		if(isEmpty()) throw new RuntimeException("EmptyList");
		
		T data = tail.data;
		tail=tail.prev;
		--size;
		
		if(isEmpty()) head=null;
		else tail.next=null;
		
		return data;
	}
	
	//Remove an arbitrary node from linked list
	private T remove(Node<T> node) {
		if(node.prev==null) removeFirst();
		if(node.next==null) removeLast();
		
		node.next.prev=node.prev;
		node.prev.next=node.next;
		
		T data=node.data;
		node.data=null;
		node=node.prev=node.next=null;
		--size;
		
		return data;
	}
	
	//Remove node at a particular index - O(n)
	public void removeAt(int index) {
		if(index<0||index>size) throw new IllegalArgumentException();
		
		int i;
		Node<T> trav;
		if(index<size/2) {
			for(i=0,trav=head;i!=index;i++)
				trav=trav.next;
		}else {
			for(i=size,trav=tail;i!=index;i--)
				trav=trav.prev;
		}
		remove(trav);
	}
	
	//Remove a particular value from linked list - O(n)
	public boolean remove(Object obj) {
		Node<T> trav=head;
		if(obj==null) {
			for(trav=head;trav!=null;trav=trav.next) {
				if(trav.data==null) {
					remove(trav);
					return true;
				}
			}
		}else {
			for(trav=head;trav!=null;trav=trav.next) {
				if(obj.equals(trav.data)) {
					remove(trav);
					return true;
				}
			}
		}
		return false;
	}
	
	//Find the index of particular value in the linked list , O(n)
	public int indexOf(Object obj) {
		int index=0;
		Node<T> trav=head;
		if(obj==null) {
		for(trav=head;trav!=null;trav=trav.next,index++) {
			if(trav.data==null)
				return index;
		}
		}else {
		for(trav=head;trav!=null;trav=trav.next,index++) {
			if(obj.equals(trav.data))
				return index;
		}
		}
		return -1;
	}
	
	//Check if a value is contained in the list
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}
}
