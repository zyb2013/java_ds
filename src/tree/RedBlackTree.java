package tree;

/**
 * 红黑树
 * @author Alias
 * @date 2016年5月24日 下午2:13:20
 *
 * @param <K>
 * @param <V>
 */
public class RedBlackTree<K extends Comparable<K>, V> {
	
	private static final boolean RED = true;
	
	private static final boolean BLACK = false;

	// 根节点
	private Node root;
	
	private int size;
	
	/**
	 * 根据Key查找对应的Value
	 * @param key
	 * @return
	 */
	public V get(K key) {
		Node current = root;
		while (current != null) {
			if (key.compareTo(current.key) < 0) {
				current = current.left;
			} else if (key.compareTo(current.key) > 0) {
				current = current.right;
			} else {
				return current.value;
			}
		}
		return null;
	}
	
	/**
	 * 插入节点
	 * @param key
	 * @param value
	 * @return
	 */
	public V put(K key, V value) {
		return null;
	}
	
	/**
	 * 左旋
	 * @param node
	 */
	private void rotateLeft(Node node) {
		
	}
	
	/**
	 * 右旋
	 * @param node
	 */
	private void rotateRight(Node node) {
		
	}
	
	/**
	 * 红黑树节点
	 * @author Alias
	 * @date 2016年5月24日 下午2:14:39
	 *
	 */
	private class Node {
		// 键
		private K key;
		
		// 值
		private V value;
		
		// 左子树
		private Node left;
		
		// 右子树
		private Node right;
		
		// 结点颜色
		private boolean color = RED;
		
	}
	
}
