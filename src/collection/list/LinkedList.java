package collection.list;

/**
 * 单链表
 * @author Alias
 * @date 2016-3-26上午10:01:29
 */
public class LinkedList<T> {
	
	// 头结点
	private Node<T> first;
	
	// 尾结点
	private Node<T> last;
	
	// 链表大小
	private int size;
	
	/**
	 * 在链表头部添加数据
	 * @param elem
	 * @return
	 */
	public boolean addFirst(T elem) {
		if (elem == null) {
			return false;
		}
		Node<T> node = new Node<>(elem);
		node.next = first;
		first = node;
		if (last == null) {
			last = node;
		}
		size++;
		return true;
	}
	
	/**
	 * 在链表尾部添加数据
	 * @param elem
	 * @return
	 */
	public boolean addLast(T elem) {
		if (elem == null) {
			return false;
		}
		Node<T> node = new Node<>(elem);
		last.next = node;
		last = node;
		size++;
		return true;
	}
	
	/**
	 * 获取链表的大小
	 * @return
	 */
	public int size() {
		return size;
	}
	
	public boolean add(T elem, int index) {
		if (elem == null) {
			return false;
		}
		checkIndex(index);
		if (index == size) {
			addLast(elem);
			size++;
			return true;
		}
		if (index == 0) {
			addFirst(elem);
			size++;
			return true;
		}
		Node<T> node = new Node<>(elem);
		Node<T> preNode = findPreviousNode(index);
		node.next = preNode.next;
		preNode.next = node;
		size++;
		return true;
	}
	
	/**
	 * 获取链表指定位置的数据
	 * @param index
	 * @return
	 */
	public T get(int index) {
		checkIndex(index);
		Node<T> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node.elem;
	}
	
	/**
	 * 链表是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
		
	}
	
	/**
	 * 查找前一个节点
	 * @param index
	 * @return
	 */
	private Node<T> findPreviousNode(int index) {
		Node<T> result = first;
		for (int i = 0; i < index - 1; i++) {
			result = result.next;
		}
		return result;
	}
	
	/**
	 * 检查索引是否正确
	 * @param index
	 */
	private void checkIndex(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index:" + index);
		}
	}

	/**
	 * 结点
	 * @author Alias
	 * @date 2016-3-26上午10:33:00
	 * @param <T>
	 */
	private class Node<T> {
		
		// 数据
		T elem;
		
		// 下一个结点
		Node<T> next;
		
		public Node(T elem) {
			this.elem = elem;
		}
		
	}
	
}
