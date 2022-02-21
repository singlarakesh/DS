package Caching;

public class CacheItem<K, V> {
	private K key;
	private V value;
	private int hitCount = 0;
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

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}


	public CacheItem(K key, V value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
	}

	public void incrementHitCount() {
		this.hitCount++;
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
}
