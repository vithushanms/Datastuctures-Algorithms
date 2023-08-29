public class DoublyLinkedList <T> implements Iterable <T>{
	private int size = 0;
	private Node <T> head = null;
	private Node <T> tail = null;

	private class Node<T>{
		T data;
		Node<T> prev, next;

		public Node(T data, Node<T> prev, Node<T> next){
			this.prev = prev;
			this.next = next;
			this.data = data;
		}

		@Override
		public String toString(){
			return this.data.toString();
		}
	}
	
	public void clear(){
		Node<T> trav = head;
		
		while(trav != null){
			trav.next = null;
			trav.prev = null;
			trav = trav.next;
		}

		head = tail = trav = null;
		size = 0;
	}
	
	public int size(){ return size; }

	public boolean isEmpty() { return size() == 0; }
	
	public void addFirst(T obj){
		if(isEmpty()) head = tail = new Node <T> (obj, null, null);
		else{
			Node <T> temp = head;
             		head.prev = new Node <T> (obj,null,temp);	
			head = head.prev;
		}
		size++;
	}

	public void addLast(T obj) {
		if(isEmpty()) head = tail = new Node <T> (obj, null, null);
		else{
			tail.next = new Node <T> (obj, tail, null);
			tail = tail.next;
		}
		size++;
	}

	public void add(T obj){ addLast(obj); }

	public T peekFirst() {
		if(isEmpty()) throw new RuntimeException("empty linked list");
		return head.data;
	}

	public T peekLast(){
		if(isEmpty()) throw new RuntimeException("empty linked list");
		return tail.data;
	}

	public T removeFirst(){
		if(isEmpty()) throw new RuntimeException("empty linked list");
		T data = head.data;
		head = head.next;
		--size;
		if(isEmpty()) tail = null;
		else head.prev = null;
		return data;
	}

	public T removeLast(){
		if(isEmpty()) throw new RuntimeException("empty linked list");
		T data = tail.data;
		tail = tail.prev;
		--size;

		if(isEmpty()) head = null;
		else tail.next = null;
		return data;
	}

	public T remove(Node <T> node) {
		T data = node.data;

		if(node.prev == null) return removeFirst();
		if(node.next == null) return removeLast();

		node.next.prev = node.prev;
		node.prev.next = node.next;

		node.data = null;
		node.prev = node.next = null;
		--size;
		return data;
	}

	public T removeAt(int index){
		if(index < 0 || index >= size) throw new IllegalArgumentException();
		 
		Node <T> trav;
		int i;
		if(index < size/2){
			for (i = 0, trav = head; i != index; i++){
				trav = trav.next;
			}
		}
		else {
			for (i = size, trav = tail; i != index; i--){
				trav = trav.prev;
			}
		}

		return remove(trav);
	}

	public boolean remove(Object obj){
		Node<T> trav;
		if(obj == null){
			for (trav = head; trav != null; trav = trav.next){
				if(trav.data == null) {
					remove(trav);
					return true;
				} 
			}
		}else{
			for (trav = head; trav != null; trav = trav.next){
				if(trav.data.equals(obj)) {
					remove(trav);
					return true;
				}
			}
		}
		return false;
	} 

	public int indexOf(Object obj) {
		Node <T> trav;
		int i;

		if(obj == null) {
			for (i = 0, trav = head; trav != null; trav = trav.next){
				if(trav.data == null) return i;
			}
		}
		else {
			for (i = 0, trav = head; trav != null; trav = trav.next){
				if(obj.equals(trav.data)) return i;
			}
		}

		return -1;
	}

	public Boolean contains(Object obj){
		return indexOf(obj) != -1;
	}

	@Override
	public java.util.Iterator <T> iterator() {
		return new java.util.Iterator <T> () {
			private Node <T> trav = head;
			@Override 
			public boolean hasNext(){
				return trav.next != null;
			}
			@Override
			public T next(){ return trav.next.data; }
		};
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node <T> trav = head;
		while (trav != null){
			sb.append(trav.data + ", ");
			trav = trav.next;
		}
		sb.append(" ]");
		return sb.toString();
	}
}
