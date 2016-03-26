package collection.list;

/**
 * ������
 * @author Alias
 * @date 2016-3-26����10:01:29
 */
public class LinkedList<T> {
	
	// ͷ���
	private Node<T> first;
	
	// β���
	private Node<T> last;
	
	// �����С
	private int size;
	
	/**
	 * ������ͷ���������
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
	 * ������β���������
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
	 * ��ȡ����Ĵ�С
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * �����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * ���
	 * @author Alias
	 * @date 2016-3-26����10:33:00
	 * @param <T>
	 */
	private class Node<T> {
		
		// ����
		private T elem;
		
		// ��һ�����
		private Node<T> next;
		
		public Node(T elem) {
			this.elem = elem;
		}
		
	}
	
}
