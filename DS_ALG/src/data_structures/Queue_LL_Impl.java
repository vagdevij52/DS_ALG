// LINKEDLIST IMPLEMENTATION OF QUEUE
package data_structures;

import java.util.Iterator;
import java.util.LinkedList;


public class Queue_LL_Impl<T> implements Iterable<T> {

	private LinkedList<T> list = new LinkedList<T>();

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Queue_LL_Impl() {
		// TODO Auto-generated constructor stub
	}
	
	public Queue_LL_Impl(T firstElem) {
		offer(firstElem);
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public T peek() {
		if(isEmpty())
			throw new RuntimeException("Empty queue");
		return list.peekFirst();
	}
	
	//Polling - Removing element at the start of queue
	public T poll() {
		if(isEmpty())
			throw new RuntimeException("Empty queue");
		return list.removeFirst();
	}
	
	//Offer - Adding element at the end of queue
	public void offer(T elem) {
		list.addLast(elem);
	}
	
}
