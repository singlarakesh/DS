package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> {
	private Map<String, CacheItem<K, V>> map;
	private CacheItem<K, V> first;
	private CacheItem<K, V> last;
	int capacity;

	public Cache(int capacity) {
		map = new HashMap<>(capacity);
		this.capacity = capacity;
	}

	private void addItem(String key, Integer value) {
		// TODO Auto-generated method stub
		CacheItem<K, V> item = (CacheItem<K, V>) new CacheItem<String, Integer>(key, value);
		if (map.containsKey(key)) {
            this.deleteItem(item);
            this.addToLL(item);
		} else {
			if (map.size() > capacity) {
				this.deleteItem(last);
				map.remove(last.getKey());
			}
		}

		map.put(key, item);
	}

	private void addToLL(CacheItem<K, V> item) {
		// TODO Auto-generated method stub
		
	}

	private void deleteItem(CacheItem<K, V> last2) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		Cache<String, Integer> cache = new Cache<>(4);
		cache.addItem("Parusha", 45);
	}
}
