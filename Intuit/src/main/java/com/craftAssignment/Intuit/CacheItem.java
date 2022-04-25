package com.craftAssignment.Intuit;

public class CacheItem<K, V> {
	K key;
	V value;
	CacheItem<K, V> next;
	CacheItem<K, V> prev;

	CacheItem(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "CacheItem [key=" + key + ", value=" + value + ", next=" + next + ", prev=" + prev + "]";
	}

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

	public CacheItem<K, V> getNext() {
		return next;
	}

	public void setNext(CacheItem<K, V> next) {
		this.next = next;
	}

	public CacheItem<K, V> getPrev() {
		return prev;
	}

	public void setPrev(CacheItem<K, V> prev) {
		this.prev = prev;
	}

}
