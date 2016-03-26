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
	
	/**
	 * 链表是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 结点
	 * @author Alias
	 * @date 2016-3-26上午10:33:00
	 * @param <T>
	 */
	private class Node<T> {
		
		// 数据
		private T elem;
		
		// 下一个结点
		private Node<T> next;
		
		public Node(T elem) {
			this.elem = elem;
		}
		
	}
	
}
