package collection.list;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(100);
		list.addFirst(200);
		list.addFirst(300);
		list.addLast(400);
		list.add(500, 2);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
}
