package test;

import tree.RedBlackTree;

public class RBTTest {

	public static void main(String[] args) {
		RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
		for (int i = 0; i < 10; i++) {
			rbt.put(i, 100 + i);
		}
	}
	
}
