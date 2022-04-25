package com.craftAssignment.Intuit;

import java.util.HashMap;

public class Caching<K, V> {

	private HashMap<String, CacheItem<String, Integer>> cache;
	private int capacity;
	private int size;
	private CacheItem<String, Integer> first;
	private CacheItem<String, Integer> last;

	Caching(int capacity) {
		this.cache = new HashMap<String, CacheItem<String, Integer>>(capacity);
		this.capacity = capacity;
	}

	private void put(String name, int marks) {
		CacheItem<String, Integer> item = new CacheItem<String, Integer>(name, marks);
		if (!cache.containsKey(name)) {
			if (this.size >= capacity) {
				removeFirstElement();
			}
			addToLast(item);
		}
		cache.put(name, item);
	}

	private void addToLast(CacheItem<String, Integer> item) {
		// TODO Auto-generated method stub
		if (last != null) {
			CacheItem<String, Integer> lastItem = last;
			lastItem.setNext(item);
			item.setPrev(lastItem);
			last = item;
		} else {
			last = item;
			first = item;
		}
		size++;
	}

	private void removeFirstElement() {
		if (first == null)
			return;

		CacheItem<String, Integer> firstItem = first;
		cache.remove(first.getKey());
		first = first.getNext();
		first.setPrev(null);
		firstItem.setNext(null);
		size--;
	}

	private void get(String name) {
		// TODO Auto-generated method stub
		if (cache.containsKey(name)) {
			CacheItem<String, Integer> item = cache.get(name);
			remove(item);
			addToLast(item);
		}
	}

	private void remove(CacheItem<String, Integer> item) {
		// TODO Auto-generated method stub
		if (last == item) {
			return;
		}
		if (item == first) {
			first = item.getNext();
		} else {
			item.getNext().setPrev(item.getPrev());
			item.getPrev().setNext(item.getNext());
		}
		last.setNext(item);
		item.setPrev(last);
		item.setNext(null);
		last = item;
	}

	public static void main(String[] args) {
		Caching<String, Integer> cacheObj = new Caching<String, Integer>(5);
		cacheObj.put("Parusha", 10);
		cacheObj.put("Hemant", 20);
		cacheObj.put("Vanshika", 30);
		cacheObj.put("Piyush", 40);
		cacheObj.put("Bharti", 50);
		cacheObj.get("Parusha");
	}

}
