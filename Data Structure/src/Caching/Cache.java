package Caching;

import java.util.HashMap;

public class Cache<K, V> {
	private HashMap<K, CacheItem> map;
	private CacheItem first, last;
	private int size;
	private final int CAPACITY;

	private int hitCount = 0;
	private int missCount = 0;

	public Cache(int capacity) {
		this.CAPACITY = capacity;
		map = new HashMap<>(CAPACITY);
	}

	public void put(K key, V value) {
		CacheItem<K, V> item = new CacheItem<K, V>(key, value);
		if (!map.containsKey(key)) {
			if (size() >= CAPACITY) {
				deleteNode(first);
			}
			addNodeToLast(item);
		}
		map.put(key, item);
	}

	private void addNodeToLast(CacheItem<K, V> item) {
		// TODO Auto-generated method stub
		if (last != null) {
			this.last.setNext(item);
			item.setPrev(this.last);
		}
		this.last = item;
		if (first == null) {
			this.first = item;
		}
		size++;
	}

	private int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	public V get(K key) {
		if (!map.containsKey(key))
			return null;
		CacheItem item = map.get(key);
		item.incrementHitCount();
		reorder(item);
		return (V) item.getValue();
	}

	private void reorder(CacheItem item) {
		// TODO Auto-generated method stub
		if (last == item)
			return;
		if (first == item) {
			first = item.getNext();
		} else {
			item.getPrev().setNext(item.getNext());
		}
		last.setNext(item);
		item.setPrev(last);
		item.setNext(null);
		last = item;
	}

	public void delete(K key) {
		deleteNode(map.get(key));
	}

	private void deleteNode(CacheItem item) {
		// TODO Auto-generated method stub
		if (item == null)
			return;
		if (last == item) {
			this.last = item.getPrev();
		}
		if (first == item) {
			this.first = item.getNext();
		}
		map.remove(item.getKey());
		item = null;
		size--;
	}

	public static void main(String[] args) {
		Cache<String, Integer> cache = new Cache<>(3);
		cache.put("parusha", 123);
		cache.put("hemant", 123);
		cache.put("sdd", 123);
		cache.put("ssdddd", 123);
		cache.put("ddd", 123);
		System.out.println(cache.get("hemant"));
	}
}
