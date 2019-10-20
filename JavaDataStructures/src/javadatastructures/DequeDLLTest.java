package javadatastructures;

public class DequeDLLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DequeWithDLL <String> DDLL = new DequeWithDLL<String>();
		
		//System.out.println(DDLL.isEmpty());
		
		DDLL.enqueueBack("Ben");
		DDLL.enqueueFront("Phoebe");
		DDLL.enqueueFront("Joey");
		DDLL.enqueueBack("Chandler");
		DDLL.enqueueBack("Monica");
		DDLL.enqueueFront("Ross");
		DDLL.enqueueBack("Rachel");
		
		System.out.println("The first element of the list:" + DDLL.firstElement());
		System.out.println("The last element of the list: " + DDLL.lastElement());
		
		System.out.println(DDLL.dequeueBack());
		System.out.println(DDLL.dequeueFront());
		
		System.out.println("\n \n  \n");
		
		System.out.println(DDLL.dequeueBack());
		System.out.println(DDLL.dequeueFront());
		
		System.out.println("\n \n  \n");
		
		System.out.println(DDLL.dequeueBack());
		System.out.println(DDLL.dequeueFront());
		
		System.out.println("\n \n  \n");
		
		System.out.println("The first element of the list:" + DDLL.firstElement());
		System.out.println("The last element of the list: " + DDLL.lastElement());
		
		System.out.println(DDLL.dequeueFront());
		
		System.out.println("The first element of the list:" + DDLL.firstElement());
		System.out.println("The last element of the list: " + DDLL.lastElement());
		
		
		DDLL.dequeIterator();

	}

}
