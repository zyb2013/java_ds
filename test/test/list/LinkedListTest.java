package test.list;

import collection.list.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(100);
		list.addLast(300);
		list.addLast(200);
		list.add(888, 1);
		
		System.out.println(list);
		list.removeFirst();
		list.removeLast();
		list.addFirst(666);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		
		
	}
	
}
