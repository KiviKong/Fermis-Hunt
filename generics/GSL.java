package generics;

public class GSL <Type> implements GStack<Type>, GList<Type> {

	private Node first = null;
	private Node last = null;
	private int size = 0;
	
	public String toString(){
		String GSLstring ="";
		Node tmp = first;
		
		for (int i = 0; i < size; i++){
			GSLstring += tmp.value;
			tmp = tmp.next;
		}		
		return GSLstring;
	}
	
	@Override
	public void add(Type o) {
		
		if(isEmpty()) {
			first = last = new Node(o); 
		} else {
			Node n = new Node(o);
			n.prior = last;
			n.next = null;
			last.next = n;
			last = n;
			n = null;
			
		}
		size++;
	}

	@Override
	public void insert(int index, Type o) {
		if(index > size) {
			// If the index is bigger than the size, adds the object at the end
			add(o);
			return;
			// If the list is empty, adds the object at the end
		} else if(isEmpty()) {
			add(o);
			// If the index is smaller than the size, does nothing
		} else if(index < 0) {
			return;
			// In case the insertion is in the first position. 
		} else if(index == 0) {
			Node n = new Node(o);
			n.prior = null;
			n.next = first;
			first.prior = n;
			first = n;
			return;
		}
		
		Node tmp = first;		
		// Searches on the list until it reaches the index node
		for(int i = 0; i < index; i++)  {
			tmp = tmp.next;
		}
		
		Node n = new Node(o);
		n.prior = tmp.prior;
		n.next = tmp;
		tmp.prior = n;
		tmp = n.prior;
		tmp.next = n;
		
		size++;
	}

	@Override
	public Type remove(int index) {
		if(index > size) { return null; }
		if(index == size) return pop();
		if(index == 0) {
			Node del = first;
			Node tmp = first.next;
			
			del.next = null;
			del.prior = null;
			
			tmp.prior = null;

			first = tmp;

			return del.value;
		}
		
		Node tmp = first;
		// Searches on the list until it reaches the index node
		for(int i = 0; i < index; i++)  {
			tmp = tmp.next;
		}
		
		Node del = tmp;
		tmp = tmp.prior;
		tmp.next = del.next;
		tmp = del.next;
		tmp.prior = del.prior;
		
		del.next = del.prior = null;
		size--;
		
		return del.value;
	}

	@Override
	public Type get(int index) {
		if(index > size) { return null; }
		
		Node tmp = first;
		// Searches on the list until it reaches the index node
		for(int i = 0; i < index; i++)  {
			tmp = tmp.next;
		}
		
		return tmp.value;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void push(Type o) {
		add(o);		
	}

	@Override
	public Type pop() {
		Node toPop = last;
		Node tmp = toPop.prior;

		tmp.next = null;
		toPop.prior = null;
		toPop.next = null;
		last = tmp;
		
		size--;
		return toPop.value;
	}

	@Override
	public boolean isEmpty() {
		if(first == null) return true;
		return false;
	}
	
	private class Node {
		public Type value = null;
		public Node prior = null;
		public Node next = null;
		
		public Node(Type o) {
			value = o;
		}
	}
	
}
	