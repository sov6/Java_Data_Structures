package javadatastructures;

import java.util.Arrays;

public class ArrayListI<T>{
	
	private int capacity;                                                           //maximum capacity of the array
	private int len;                                                                //number of elements in the array
	private Object[] arr;                                                           //generic object array
		
	public ArrayListI() {                                                           //constructor 
		capacity = 10;                                                              //default value = 10       
		arr = new Object[capacity];                                                 //creating array of maximum capacity
	}
	
	public Object getAtIndex(int index) {                                           //get the element in a specified index
		if (index < len)
			return arr[index];
		else
			throw new ArrayIndexOutOfBoundsException();                             //if invalid index is requested
	}

	public void add(Object o) {                                                     //to add a new element into the array
		//System.out.println("add. capacity = " + capacity +  "len = " + len);
		if(arrCapacity() - len <= 5)                                                //dynamic array resizing-increase 
			increaselen();
		arr[len++] = o;
	}
	
	public Object remove(int index) {                                              //removing the element from the index
		if(index >= len)
			throw new ArrayIndexOutOfBoundsException();                            //exception for invalid array
		else {
			Object temp = arr[index];
			for (int i = index; i<len;i++) {
				arr[i] = arr[i+1];                                                //moving the elements to have continuity
			}
			len--;
			if(capacity-len > 5) {
				decreaselen();                                                    //dynamic array resizing - decrease
			}
			return temp;
		}
	}
	
	public void increaselen() {                                                   //function for dynamic resizing of array
		capacity = capacity + (capacity >>1);
		//System.out.println("Capacity = " + capacity);
		arr = Arrays.copyOf(arr, capacity);
	}
	
	public void decreaselen() {                                                  //function for dynamic resizing of array
		capacity = len*2;
		arr = Arrays.copyOf(arr, capacity);
	}
	
	public int arrCapacity() {                                                   //return the capacity of array
		return capacity;
	}
	
	public int arrlen() {                                                        //return the length of array
		return len;
	}
	
	public static void main (String[] args) {
		
		ArrayListI<String> qwerty = new ArrayListI<String>();
		
		System.out.println("1.qwerty capacity " + qwerty.arrCapacity());
		System.out.println("2. qwerty length" + qwerty.arrlen());
		
		qwerty.add("Unni");
		qwerty.add("pomi");
		qwerty.add("sarath");
		qwerty.add("soumya");
		
		System.out.println("3.qwerty capacity " + qwerty.arrCapacity());
		System.out.println("4. qwerty length" + qwerty.arrlen());
		
		qwerty.add("unnikuttan");
		qwerty.add("pomikutty");
		
		System.out.println("5.qwerty capacity " + qwerty.arrCapacity());
		System.out.println("6. qwerty length" + qwerty.arrlen());
		
		
//		for (int i=0;i<qwerty.arrCapacity();i++) {
//			System.out.println(qwerty.getAtIndex(i));
//		}
		
		System.out.println("7.qwerty capacity " + qwerty.arrCapacity());
		System.out.println("8. qwerty length" + qwerty.arrlen());
	
		
		System.out.println("Removing the third element from the arraylist");
		qwerty.remove(3);
		
		System.out.println("9.qwerty capacity " + qwerty.arrCapacity());
		System.out.println("10. qwerty length" + qwerty.arrlen());
	
		
		for (int i=0;i<qwerty.arrlen();i++) {
			System.out.println(qwerty.getAtIndex(i));
		}
		
		System.out.println("11.qwerty capacity " + qwerty.arrCapacity());
		System.out.println("12. qwerty length" + qwerty.arrlen());
	
		
		
	}
}