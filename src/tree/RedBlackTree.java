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
		if (key == null) {
			throw new IllegalArgumentException("key is null");
		}
		Node node = new Node(key, value);
		if (root == null) {
			root = node;
			node.color = BLACK;
			return value;
		}
		Node current = root;
		Node parent = root;
		int cmp = 0;
		while (current != null) {
			parent = current;
			cmp = key.compareTo(current.key);
			if (cmp < 0) {
				current = current.left;
			} else if (cmp > 0) {
				current = current.right;
			} else {
				current.value = value;
			}
		}
		if (cmp < 0) {
			parent.left = node;
		} else if (cmp > 0) {
			parent.right = node;
		}
		root = fixAfterInsertion(parent);
		return null;
	}
	
	/**
	 * 插入数据后，修正红黑树以保证平衡
	 * @param node
	 */
	private Node fixAfterInsertion(Node node) {
		Node result = node;
		if (!isRed(node.left) && isRed(node.right)) {
			result = rotateLeft(node);
		}
		if (isRed(node) && isRed(node.left.left)) {
			result = rotateRight(node);
		}
		if (isRed(node.left) && isRed(node.right)) {
			flipColor(node);
		}
		return result;
	}
	
	/**
	 * 修改节点的颜色
	 * @param node
	 */
	private void flipColor(Node node) {
		node.color = RED;
		node.left.color = BLACK;
		node.right.color = BLACK;
	}

	/**
	 * 左旋
	 * @param node
	 */
	private Node rotateLeft(Node node) {
		Node result = node.right;
		node.right = result.left;
		result.left = node;
		node.color = result.color;
		result.color = BLACK;
		return result;
	}
	
	/**
	 * 右旋
	 * @param node
	 */
	private Node rotateRight(Node node) {
		Node result = node.left;
		node.left = result.right;
		result.right = node;
		node.color = result.color;
		result.color = BLACK;
		return result;
	}
	
	/**
	 * 是否红色节点
	 * @param node
	 * @return
	 */
	private boolean isRed(Node node) {
		if (node == null) {
			return false;
		}
		return node.color;
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
		
		public Node(K key, V value) {
			this(key, value, null, null);
		}
		
		public Node(K key, V value, Node left, Node right) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
	}
	
}
