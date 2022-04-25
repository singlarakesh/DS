package com.example.demo;

public class CacheItem<K, V> {
	private K key;
	private V value;
	private CacheItem<K, V> prev;
	private CacheItem<K, V> next;

	public CacheItem(K key, V value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
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

	public CacheItem<K, V> getPrev() {
		return prev;
	}

	public void setPrev(CacheItem<K, V> prev) {
		this.prev = prev;
	}

	public CacheItem<K, V> getNext() {
		return next;
	}

	public void setNext(CacheItem<K, V> next) {
		this.next = next;
	}

}
