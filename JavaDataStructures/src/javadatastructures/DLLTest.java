package javadatastructures;

public class DLLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		
		System.out.println(dll.first());
		System.out.println(dll.last());
		
		System.out.println(dll.isEmpty());
		
		dll.addFirst(9);
		dll.addFirst(6);
		
//		System.out.println(dll.first());
//		System.out.println(dll.last());
		
		dll.addLast(12);
		
//		System.out.println(dll.first());
//		System.out.println(dll.last());
		
		
		
		//System.out.println(dll.removeFirst());
		
//		dll.removeFirst();
//
//		dll.removeLast();
	//	dll.removeLast();
		
		
		dll.addBefore(6, 3);
		
		dll.addBefore(12,10);
		
		dll.addAfter(12, 15);
		
		dll.addAfter(6, 7);
		
		dll.removeBefore(9);
		
		dll.removeAfter(9);
		
		dll.removeAfter(12);
		
//		dll.removeBefore(12);
		
//		dll.removeBefore(16);
//		dll.remove(9);
//		
//		dll.remove(3);
//		
//		dll.remove(15);
//		
//		dll.remove(0);
		
		dll.dllIterator();
		
	}

}
