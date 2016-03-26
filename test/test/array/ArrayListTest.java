package test.array;

import test.Data;
import collection.array.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Data> list = new ArrayList<>(2);
		list.add(new Data(1001, "zyb"));
		list.add(new Data(1002, "zyb1"));
		list.add(new Data(1003, "zyb2"));
		
		list.add(new Data(8888, "1688"), 1);
//		list.remove();
		list.remove(1);
		System.out.println(list);
		
		System.out.println(list.contains(new Data(8888, "1688")));
	}
	
}
