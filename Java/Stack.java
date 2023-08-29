import java.util.LinkedList;

public class Stack <T> implements Iterable <T> {
	private LinkedList <T> list = new LinkedList<T>();

	public Stack(){}

	public Stack(T firstElement){
		push(firstElement);
	}

	public void push(T element){
		list.addLast(element);
	}

	public int size() { return list.size(); }

	public boolean isEmpty(){ return list.size() == 0; }

	public T pop(){
		if(isEmpty()) throw new java.util.EmptyStackException();
		return list.removeLast();
	}

	public T peek(){
		if(isEmpty()) throw new java.util.EmptyStackException();
		return list.peekLast();
	}

	@Override 
	public java.util.Iterator<T> iterator(){ return list.iterator(); }
}
