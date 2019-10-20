package javadatastructures;


public class DequeWithDLL <B>{
	
	private class Node<B>{
		
		B element;
		Node<B> prev;
		Node<B> next;
		
		
		public Node() {
			element = null;
			this.prev = null;
			this.next = null;
		}
		
		public void setElement(B data) {
			this.element = data;
		}
		
		public void setNextNode(Node<B> n) {
			this.next = n;
		}
		
		public void setPrevNode(Node<B> n) {
			this.prev = n;
		}
		
		public B getElement() {
			return(this.element);
		}
		
		public Node<B> getNextNode(){
			return (this.next);
		}
		
		public Node<B> getPrevNode(){
			return (this.prev);
		}
		
		
	}
	
	int size = 0;
	
	Node<B> front = new Node<>();
	Node<B> rear = new Node<>();
	
	public DequeWithDLL() {
		front.setNextNode(rear);
		rear.setPrevNode(front);	
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
	
	public void enqueueBack(B data){
		
		Node<B> tempnode = new Node<>();
		tempnode.setElement(data);
		
		tempnode.setPrevNode(rear.getPrevNode());
		rear.getPrevNode().setNextNode(tempnode);
		tempnode.setNextNode(rear);
		rear.setPrevNode(tempnode);
		
		this.sizeIncrement();
	}
	
	public void enqueueFront(B data) {
		
		Node<B> tempnode = new Node<>();
		tempnode.setElement(data);
		
		tempnode.setNextNode(front.getNextNode());
		front.getNextNode().setPrevNode(tempnode);
		front.setNextNode(tempnode);
		tempnode.setPrevNode(front);
		
		this.sizeIncrement();
	}
	
	public B dequeueFront() {
		
		B tempdata ;
		
		if(this.isEmpty()) {
			System.out.println("The Deque is empty, cannot remove elements from front");
			return null;
		}
		
		tempdata = front.getNextNode().getElement();
		front.getNextNode().getNextNode().setPrevNode(front);
		front.setNextNode(front.getNextNode().getNextNode());
		//front.setNextNode(front.getNextNode());
		
		this.sizeDecrement();
		return tempdata;
	}
	
	public B dequeueBack() {
		
		B tempdata;
		
		if(this.isEmpty()) {
			System.out.println("The Deque is empty, cannot remove elements from front");
			return null;
		}
		
		tempdata = rear.getPrevNode().getElement();
		rear.getPrevNode().getPrevNode().setNextNode(rear);
		rear.setPrevNode(rear.getPrevNode().getPrevNode());
		//rear.setPrevNode(rear.getPrevNode());
		
		this.sizeDecrement();
		return tempdata;
	}
	
	public B firstElement() {
		if(this.isEmpty()) {
			System.out.println("The queue is empty, cannot display the first element");
			return null;
		}
		return this.front.getNextNode().getElement();
	}
	
	public B lastElement() {
		if(this.isEmpty()) {
			System.out.println("The queue is empty, cannot display the last element");
			return null;
		}
		return this.rear.getPrevNode().getElement();
	}
	
	public void dequeIterator() {
		
		Node<B> temp = front.getNextNode();
		
		while(temp != rear) {
			System.out.println(temp.getElement());
			temp = temp.getNextNode();
		}
	}
}
