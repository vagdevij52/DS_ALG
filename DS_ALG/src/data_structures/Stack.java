/*
 *     TIME COMPLEXITY
 * Pushing - O(1) 
 * Popping - O(1)
 * Peeking - O(1)
 * Searching-O(n)
 * Size - O(1)
 * */
package data_structures;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T>{

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}
	
	private LinkedList<T> list=new LinkedList<>();
	
	//Create empty Stack
	public void Stack() {}
	
	//Create Stack with initial element
	public void Stack(T firstElem) {
		push(firstElem);
	}
	
	//Know the size of Stack
	public int size() {
		return list.size();
	}
	
	//Check if Stack is empty or not
	public boolean isEmpty() {
		return size()==0;
	}
	
	//Push an element on the Stack
	public void push(T elem) {
		list.addLast(elem);
	}
	
	//Pop an element off the Stack
	//Throws an error if Stack is empty
	public T pop() {
		if(isEmpty()) throw new EmptyStackException();
	return list.removeLast();
	}
	
	//Peek the last element of Stack without popping
	//Throws error if Stack is empty
	public T peek() {
		if(isEmpty()) throw new EmptyStackException();
	return list.peekLast();
	}
	
	
	
	

}
