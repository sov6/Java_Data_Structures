package javadatastructures;

public class SinglyLinkedList <T>{
	
	private class Node<T>{
		
		private T element;
		private Node<T> next;
		
		public Node() {
			
			element = null;
			next = null;
		}
		
		public void setElement(T val) {
			this.element = val;
		}
		
		public T getElement() {
			return this.element;
		}
		
		public Node<T> getNextNode(){
			return this.next;
		}
		
		public void setNextNode(Node<T> n) {
			this.next = n;
		}
	}
	
	private int size = 0;
	private Node<T> head;
	private Node<T> tail;

	
	public int getSize() {
		return size;
	}
	
	public void sizeIncrement() {
		size += 1;
	}
	
	public void sizeDecrement() {
		size -= 1;
	}
	
	public boolean isEmpty() {
		if (this.getSize() == 0)
			return true;
		return false;
	}
	
	public void addFirst(T data) {
		Node<T> newnode = new Node<T>();
		newnode.setElement(data);
		if(this.isEmpty()) {
			newnode.setNextNode(null);
			tail = newnode;
		}
		else
			newnode.setNextNode(head);                         //redundant? - test it
		head = newnode;
		this.sizeIncrement();
	}
	
	public void addLast(T data) {
		
		Node<T> newnode = new Node<>();
		newnode.setElement(data);
		
		if(this.isEmpty()) {
			head = newnode;
			tail = head;
		}
		else{
			Node <T> tempnode = head;
			while(tempnode.getNextNode() != null) {
				tempnode = tempnode.getNextNode();
			}
			tempnode.setNextNode(newnode);
			newnode.setNextNode(null);
			tail = newnode;
		}
		this.sizeIncrement();
	}
	
	
	public void addBefore(T data1, T data2) {
		boolean headflag = false;
		if(this.isEmpty() || (this.getSize() == 1 && head.getElement() != data1)) {
			System.out.println("Function addBefore: No such element");
			return;
		}
		
		else {
			Node<T> tempnode = head;
			
			while(true) {
				if(tempnode.getElement() == data1) {
					if(tempnode == head)
						headflag = true;
					break;
				}
				
				else {
					if(tempnode.getNextNode() != null) {
						if(tempnode.getNextNode().getElement() == data1) {
							break;
							}
						else {
							tempnode = tempnode.getNextNode();
							if(tempnode == null) {
								System.out.println("Function addBefore: Hard to find");
								return;
							}
						}
				}
					else {
						System.out.println("Function addBefore: Entire list searched - No such element");
						return;
					}
			}
			}
			
			Node<T> newnode = new Node<>();
			newnode.setElement(data2);
			if(headflag) {
				newnode.setNextNode(head.getNextNode());
				head = newnode;
			}
			else {
				newnode.setNextNode(tempnode.getNextNode());
				tempnode.setNextNode(newnode);
			}
			this.sizeIncrement();
		}
	}

	public T removeFirst() {
		if(this.isEmpty()) {
			System.out.println("The Singly Linked List is empty. There is no element to remove");
			return null;
		}
		
		T tempdata = head.getElement();
		head = head.getNextNode();
		this.sizeDecrement();
		return tempdata;
		
	}
	
	public T removeLast() {
		if(this.isEmpty()) {
			System.out.println("The Singly Linked List is empty. There is no element to remove");
			return null;
		}
		
		else if(head.getNextNode() == null) {
				T tempdata = head.getElement();
				head = null;
				this.sizeDecrement();
				return tempdata;
			}
		else {
				Node<T> temp = head;
				while(true) {
					if(temp.getNextNode().getNextNode() == null)
						break;
					else
						temp = temp.getNextNode();
				}
				T tempdata = temp.getNextNode().getElement();
				temp.setNextNode(null);
				this.sizeDecrement();
				return tempdata;
			}
	}
	
	public void sllIterator() {
		if(this.isEmpty()) {
			System.out.println("The singly linked list is empty, cannot traverse the list!");
			return;
		}
		Node<T> temp = head;
		while(temp != null) {
			System.out.println(temp.getElement());
			temp=temp.getNextNode();
		}
	}
}