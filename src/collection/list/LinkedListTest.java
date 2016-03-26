package collection.list;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(100);
		list.addFirst(200);
		list.addFirst(300);
		list.addLast(400);
		list.add(500, 2);
		list.add(800, 5);
		
		System.out.println(list);
		
//		System.out.println(list.contains(800));
//		System.out.println(list.contains(888));
		
		list.removeFirst();
		
		list.removeLast();
		
		list.add(888, 2);
		
		list.remove(2);
		
		System.out.println(list);
	}
	
}
