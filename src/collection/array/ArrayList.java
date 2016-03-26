package collection.array;

/**
 * 动态数组列表
 * @author Alias
 * @date 2016-3-26下午1:08:11
 */
public class ArrayList<T> {
	
	// 列表默认容量
	private static final int DEFAULT_CAPACITY = 10;

	// 数据元素
	private T[] elems;
	
	// 列表大小
	private int size;
	
	// 列表最大容量
	private int capacity;
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		this.capacity = capacity;
		elems = (T[]) new Object[capacity];
	}
	
	/**
	 * 获取列表的大小
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 列表是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 获取列表的容量
	 * @return
	 */
	public int capacity() {
		return capacity;
	}
	
	/**
	 * 获取指定位置的值
	 * @param index
	 * @return
	 */
	public T get(int index) {
		checkIndex(index);
		return elems[index];
	}
	
	/**
	 * 在列表的后面加入数据
	 * @param elem
	 */
	public boolean add(T elem) {
		expandCapacity();
		elems[size++] = elem;
		return true;
	}
	
	/**
	 * 在指定位置插入数据
	 * @param elem
	 * @param index
	 * @return
	 */
	public boolean add(T elem, int index) {
		checkIndex(index);
		expandCapacity();
		for (int i = size; i > index; i--) {
			elems[i] = elems[i - 1];
		}
		elems[index] = elem;
		size++;
		return true;
	}
	
	/**
	 * 是否包含指定的元素
	 * @param elem
	 * @return
	 */
	public boolean contains(T elem) {
		for (int i = 0; i < size; i++) {
			if (elems[i].equals(elem)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 在尾部删除元素
	 * @return
	 */
	public boolean remove() {
		elems[--size] = null;
		return true;
	}
	
	/**
	 * 在指定位置删除元素
	 * @param index
	 * @return
	 */
	public boolean remove(int index) {
		checkIndex(index);
		for (int i = index; i < size - 1; i++) {
			elems[i] = elems[i + 1];
		}
		size--;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("size:").append(size);
		result.append(",capacity:").append(capacity);
		result.append(" [");
		for (int i = 0; i < size; i++) {
			result.append(get(i)).append(",");
		}
		result.deleteCharAt(result.length() - 1);
		result.append("]");
		return result.toString();
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index:" + index);
		}
	}

	/**
	 * 扩展列表的容量
	 */
	@SuppressWarnings("unchecked")
	private void expandCapacity() {
		if (isFull()) {
			capacity *= 2;
			Object[] tmp = new Object[capacity];
			for (int i = 0; i < elems.length; i++) {
				tmp[i] = elems[i];
			}
			elems = (T[]) tmp;
		}
	}

	/**
	 * 列表是否已经满
	 * @return
	 */
	private boolean isFull() {
		return size == capacity;
	}
	
}
