package javadatastructures;

//import SinglyLinkedList;

public class SLLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> list1= new SinglyLinkedList<Integer>() ;
		
		//boolean flag = list1.isEmpty();
		//System.out.println(flag);
		
		list1.addLast(100);
		list1.addLast(200);
		//flag = list1.isEmpty();
		//System.out.println(flag);
		
		list1.addFirst(0);
		//list1.addAfter(-1, -2);						
		//list1.addBefore(100, 50);
		
		
		

		
		//System.out.println("remove " + list1.removeFirst());
		//System.out.println("remove " + list1.removeLast());
		//System.out.println("remove " + list1.removeFirst());
		list1.sllIterator();
		
		
		list1.removeFirst();
		list1.removeLast();
		
		list1.addLast(5000);
		list1.addFirst(0);
		list1.addLast(10000);
		System.out.println("\n \n ");
		
		
		
		list1.sllIterator();

		
	}

}
