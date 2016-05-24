package test;

import tree.RedBlackTree;

public class RBTTest {

	public static void main(String[] args) {
		RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
		rbt.put(1, 100);
		rbt.put(2, 200);
		rbt.put(3, 300);
	}
	
}
