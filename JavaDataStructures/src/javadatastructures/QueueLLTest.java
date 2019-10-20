package javadatastructures;

public class QueueLLTest {
	
	static class PersonalDetails{
		String fname;
		String lname;
		int age;
		
		
		public PersonalDetails(String fn, String ln, int a) {
			this.fname = fn;
			this.lname = ln;
			this.age = a;
		}
		
		
	}
	
//	PersonalDetails p1 = new PersonalDetails("Tom","Cruise",30);
//	PersonalDetails p2 = new PersonalDetails("Dan","Brown",31);
//	PersonalDetails p3 = new PersonalDetails("Rachel","Green",32);
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueWithLL<PersonalDetails> QLL = new QueueWithLL<PersonalDetails>();

		QLL.enqueue(new PersonalDetails("Tom","Cruise",30));
		QLL.enqueue(new PersonalDetails("Dan","Brown",31));
		QLL.enqueue(new PersonalDetails("Rachel","Green",32));
		
		
//		System.out.println(QLL.dequeue().fname);
//		System.out.println(QLL.dequeue().fname);
//		System.out.println(QLL.dequeue().fname);
		
		System.out.println("Printing the details of the first applicant");
		System.out.println(QLL.firstElement().fname);
		System.out.println(QLL.firstElement().lname);
		System.out.println(QLL.firstElement().age);
		
		
		System.out.println("Printing the details of the last applicant");
		System.out.println(QLL.lastElement().fname);
		System.out.println(QLL.lastElement().lname);
		System.out.println(QLL.lastElement().age);
		
		
//		
//		QueueWithLL<Integer> QLL = new QueueWithLL<Integer>();
//		
//		System.out.println(QLL.isEmpty());
//		
//		QLL.enqueue(9);
//		QLL.enqueue(6);
//		QLL.enqueue(3);
//		System.out.println(QLL.isEmpty());
//		
//		QLL.queueIterator();
//		
//		System.out.println("Dequeue: " + QLL.dequeue());
//		System.out.println("Dequeue: " + QLL.dequeue());
//		System.out.println("Dequeue: " + QLL.dequeue());
//		System.out.println("Dequeue: " + QLL.dequeue());
//		
//		QLL.enqueue(0);
//		QLL.queueIterator();
//		
////		System.out.println("Dequeue: " + QLL.dequeue());
		
		
		
		
		
		
		
	}

}
