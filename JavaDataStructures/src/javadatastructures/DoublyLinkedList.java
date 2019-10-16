package javadatastructures;

public class DoublyLinkedList<G>{
	
	private class Node<G>{
		
		private Node<G> prev;
		private Node<G> next;
		private G element;
		
		
		public Node(G data, Node<G> p, Node<G> n) {
			element = data;
			prev = p;
			next =n;
		}
		
		public G getElement() {																//get element from current node
			return this.element;
		}
		
		public Node<G> getPrevNode() {													   //get previous node
			return this.prev;
		}
		
		public Node<G> getNextNode() {													   //get next node							
			return this.next;
		}
		
//		public void setElement(G data) {
//			this.element = data;
//		}
		
		public void setPrevNode(Node<G> p) {                                               //set previous node
			this.prev = p;
		}
		
		public void setNextNode(Node<G> n) {                                              //set next node
			this.next = n;
		}
		
		
	}
	
	private int size = 0;
	
	private Node<G> head;                                                                 //head of Doubly Linked List
	private Node<G> tail;                                                                 //tail of Doubly Linked List
	
	public DoublyLinkedList() {
		
		head = new Node<>(null,null,null);                                               //cannot set tail as next for head now
		tail = new Node<>(null,head,null);	                                             //set tail's previous node as head
		head.setNextNode(tail);                                                          //since tail is instantiated, point head.next to tail 
	}
	
	public int size() {																     //returns the size of the Doubly Linked List
		return size;
	}
	
	public void sizeIncrement() {                                                        //Increment the DLL Size
		size++;
	}
	
	public void sizeDecrement() {                                                        //Decrement the DLL Size
		size--;
	}
	
	public boolean isEmpty() {                                                           //indicate if DLL is empty
		return(this.size == 0);
	}
	
	public G first() {                                                                  //show the first element of the list
		if(isEmpty()) {
			System.out.println("Function first: the list is empty");
			return null;
		}
		return head.getNextNode().getElement();
	}
	
	public G last() {                                                                   //indicate the last element of list
		if (isEmpty()) {
			System.out.println("Function last: the list is empty");
			return null;
		}
		return tail.getPrevNode().getElement();
	}
	
	
	public void addFirst(G data) {                                                       //add node and element at front 
		Node<G> newnode = new Node<>(data,head,head.getNextNode());
		head.getNextNode().setPrevNode(newnode);
		head.setNextNode(newnode);
		this.sizeIncrement();		
	}
	
	public void addLast(G data) {                                                        //add node and element at last
		Node<G> newnode = new Node<>(data,tail.getPrevNode(),tail);
		newnode.getPrevNode().setNextNode(newnode);
		tail.setPrevNode(newnode);
		this.sizeIncrement();
	}
	
	public void addBefore(G data1, G data2) {                                            //add node and element before element 
		if(this.isEmpty()) {
			System.out.println("Function addBefore: No such element exist"); 
			return ;
		}
		Node<G> tempnode = head.getNextNode();
		
		while(tempnode != tail) {
			if(tempnode.getElement() == data1)
				break;
			else {
				tempnode = tempnode.getNextNode();
				if (tempnode == tail) {
					System.out.println("Function addBefore: reached end of dll, no such element");
					return;
				}
			}	
		}
		Node<G> newnode = new Node<>(data2,tempnode.getPrevNode(),tempnode);
		tempnode.getPrevNode().setNextNode(newnode);
		tempnode.setPrevNode(newnode);
		this.sizeIncrement();
	}
	
	
	public void addAfter(G data1, G data2) {                                          //add node and element after element
		if(this.isEmpty()) {
			System.out.println("Function addAfter: No such element exist"); 
			return ;
		}
		Node<G> tempnode = head.getNextNode();
		
		while(tempnode != tail){
			if(tempnode.getElement() == data1)
				break;
			else {
				tempnode = tempnode.getNextNode();
				if(tempnode == tail) {
					System.out.println("Function addAfter: reached end of dll, no such element");
					return;
				}
			}
		}
		
		Node<G> newnode = new Node<>(data2,tempnode,tempnode.getNextNode());
		tempnode.getNextNode().setPrevNode(newnode);
		tempnode.setNextNode(newnode);
		this.sizeIncrement();
	}
	
	public G remove(G data1) {                                                       //remove the node with element data1
		if(this.isEmpty()) {
			System.out.println("Function removeBefore: The list is empty");
			return null;
		}
		
		Node<G> tempnode = head.getNextNode();
		while(tempnode != tail) {
			if(tempnode.getElement() == data1)
				break;
			else {
				tempnode = tempnode.getNextNode();
				if(tempnode == tail) {
					System.out.println("Function addAfter: reached end of dll, no such element");
					return null;
				}
			}
		}
		G tempdata = tempnode.getElement();
		tempnode.getNextNode().setPrevNode(tempnode.getPrevNode());
		tempnode.getPrevNode().setNextNode(tempnode.getNextNode());
		this.sizeDecrement();
		return tempdata;
	}
	
	
	public G removeBefore(G data1) {                                                 //remove node before node with element data1
		if(this.isEmpty()) {
			System.out.println("Function removeBefore: The list is empty");
			return null;
		}
		
		Node<G> tempnode = head.getNextNode();
		while(tempnode != tail) {
			if(tempnode.getElement() == data1)
				break;
			else {
				tempnode = tempnode.getNextNode();
				if(tempnode == tail) {
					System.out.println("Function removeBefore: reached end of dll, no such element");
					return null;
				}
			}
		}
		G tempdata = tempnode.getPrevNode().getElement();
		tempnode.setPrevNode(tempnode.getPrevNode().getPrevNode());
		tempnode.getPrevNode().setNextNode(tempnode);
		this.sizeDecrement();
		return tempdata;
	}
	
	
	public G removeAfter(G data1) {                                                 //remove node after node with element data1
		if(this.isEmpty()) {
			System.out.println("Function removeAfter: The list is empty");
			return null;
		}
		
		Node<G> tempnode = head.getNextNode();
		while(tempnode != tail) {
			if(tempnode.getElement() == data1) {
				if(tempnode.getNextNode() != tail)
					break;
				
				else {
					System.out.println("Function removeAfter: reached end of dll, no such element");
					return null;
				}
				
			}
			else {
				tempnode = tempnode.getNextNode();
				if(tempnode == tail) {
					System.out.println("Function removeBefore: reached end of dll, no such element");
					return null;
				}
			}
		}
		G tempdata = tempnode.getNextNode().getElement();
		tempnode.setNextNode(tempnode.getNextNode().getNextNode());
		tempnode.getNextNode().setPrevNode(tempnode);
		this.sizeDecrement();
		return tempdata;
	}
	
	public G removeFirst() {													 //remove first node
		if(this.isEmpty()) {
			System.out.println("Function removeFirst: cannot remove from empty list");
			return null;
		}
		G tempdata = head.getNextNode().getElement();
		head.setNextNode(head.getNextNode().getNextNode());
		head.getNextNode().setPrevNode(head);
		this.sizeDecrement();
		return tempdata;
	}
	
	public G removeLast() {                                                      //remove last node
		if(this.isEmpty()) {
			System.out.println("Function removeFirst: cannot remove from empty list");
			return null;
		}
		
		G tempdata = tail.getPrevNode().getElement();
		tail.getPrevNode().getPrevNode().setNextNode(tail);
		tail.setPrevNode(tail.getPrevNode().getPrevNode());
		this.sizeDecrement();
		return tempdata;
	}
	
	public void dllIterator() {                                                  //iterate through the DLL
		Node<G> tempnode = head.getNextNode();
		
		while(tempnode != tail) {
			System.out.println(tempnode.getElement());
			tempnode = tempnode.getNextNode();
		}
	}	
}
