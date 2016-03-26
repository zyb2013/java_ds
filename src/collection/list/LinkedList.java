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
			return addLast(elem);
		}
		if (index == 0) {
			return addFirst(elem);
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
		return getNode(index).elem;
	}
	
	/**
	 * 链表中是否包含指定的数据
	 * @param elem
	 * @return
	 */
	public boolean contains(T elem) {
		Node<T> node = first;
		while (node != null) {
			if (node.elem.equals(elem)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	/**
	 * 在链表的头部删除元素
	 * @return
	 */
	public boolean removeFirst() {
		if (isEmpty()) {
			return false;
		}
		first = first.next;
		size--;
		return true;
	}
	
	/**
	 * 在链表尾部删除元素
	 * @return
	 */
	public boolean removeLast() {
		if (isEmpty()) {
			return false;
		}
		Node<T> preNode = findPreviousNode(size - 1);
		last = preNode;
		preNode.next = null;
		size--;
		return true;
	}
	
	/**
	 * 在链表指定位置删除元素
	 * @param index
	 * @return
	 */
	public boolean remove(int index) {
		checkIndex(index);
		if (index == 0) {
			return removeFirst();
		}
		if (index == size - 1) {
			return removeLast();
		}
		Node<T> node = getNode(index);
		Node<T> preNode = findPreviousNode(index);
		preNode.next = node.next;
		node = null;
		size--;
		return true;
	}
	
	/**
	 * 链表是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
		
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("size:").append(size);
		result.append(" [");
		for (int i = 0; i < size; i++) {
			result.append(get(i)).append(",");
		}
		result.deleteCharAt(result.length() - 1);
		result.append("]");
		return result.toString();
	}
	
	private Node<T> getNode(int index) {
		Node<T> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
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
