
import java.util.HashMap;
import java.util.Map;

class CacheItem<K, V> {
	private K key;
	private V value;
	private CacheItem prev, next;

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public CacheItem getPrev() {
		return prev;
	}

	public void setPrev(CacheItem prev) {
		this.prev = prev;
	}

	public CacheItem getNext() {
		return next;
	}

	public void setNext(CacheItem next) {
		this.next = next;
	}

	public CacheItem(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

}

public class Cache<K, V> {
	private Map<K, CacheItem> map;
	private CacheItem first, last;
	private final int CAPACITY;

	public Cache(int capacity) {
		this.CAPACITY = capacity;
		map = new HashMap<>(this.CAPACITY);
	}

	public void put(K key, V value) {
		CacheItem node = new CacheItem(key, value);
		if (!map.containsKey(key)) {
			if (size() >= CAPACITY) {
				deleteNode(first);
			}
			addNodeToLast(node);
		}
		map.put(key, node);
	}

	private void addNodeToLast(CacheItem node) {
		// TODO Auto-generated method stub
		if(last != null) {
	        last.setNext(node);
	        node.setPrev(last);
	    }

	    last = node;
	    if(first == null) {
	        first = node;
	    }
	    size++;
	}

	private void deleteNode(CacheItem node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		if (last == node) {
			last = node.getPrev();
		}
		if (first == node) {
			first = node.getNext();
		}
		map.remove(node.getKey());
		node = null; // Optional, collected by GC
		size--;
	}

	public V get(K key) {
	}

	public void delete(K key) {
		deleteNode(map.get(key));
	}

	public int size() {
		return size;
	}
}
