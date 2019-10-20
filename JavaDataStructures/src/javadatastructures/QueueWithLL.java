package javadatastructures;

public class QueueWithLL<A> {
	
	private class Node<A>{
		
		A element;
		Node<A> next;
		
		public Node() {
			element = null;
			next = null;
		}
		
		public void setElement(A data) {
			this.element = data;
		}
		
		public void setNextNode(Node<A> n) {
			this.next = n;
		}
		
		public A getElement() {
			return(this.element);
		}
		
		public Node<A> getNextNode(){
			return (this.next);
		}
		
		
	}
	
	int size=0;
	
	Node<A> front = new Node<A>();
	Node<A> rear = new Node<A>();
	
	public QueueWithLL() {

		front = rear = null;
	}
	
	public boolean isEmpty() {
		return(size == 0);
	}
	
	public void sizeIncrement() {
		size+= 1;
	}

	public void sizeDecrement() {
		size -= 1;
	}
	
	public int getSize() {
		return size;
	}
	
	public void enqueue(A data) {
		
		Node<A> temp = new Node<A>();
		temp.setElement(data);
		
		if(this.isEmpty()) {
			front = temp;
		}
		else {
			rear.setNextNode(temp);
		}
		rear=temp;
		this.sizeIncrement();
	}
	
	public A dequeue() {
		if(this.isEmpty()) {
			System.out.println("The queue is empty, cannot remove the element");
			return null;
		}
		A tempdata = this.front.getElement();
		front = this.front.getNextNode();
		this.sizeDecrement();
		return tempdata;
	}

	public A firstElement() {
		if(this.isEmpty()) {
			System.out.println("The queue is empty, cannot display the first element");
			return null;
		}
		return this.front.getElement();
	}
	
	public A lastElement() {
		if(this.isEmpty()) {
			System.out.println("The queue is empty, cannot display the last element");
			return null;
		}
		return this.rear.getElement();
	}
	
	public void queueIterator() {
		
		Node<A> temp = front;
		
		while(temp != null) {
			System.out.println(temp.getElement());
			temp = temp.getNextNode();
		}
	}
}
