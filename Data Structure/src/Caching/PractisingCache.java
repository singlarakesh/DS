package Caching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Entry that contains complete data 
 * we have hashmap to get put cache item in 0(1)
 * We have doubly linked list to have LRU cache
 * it will remove or addToTop Entry in o(1)*/

class Entry {
	int key;
	int val;
	Entry left;
	Entry right;

	public Entry(int key, int val, Entry left, Entry right) {
		super();
		this.key = key;
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public Entry() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Entry [key=" + key + ", val=" + val;
	}
}

public class PractisingCache {
	HashMap<Integer, Entry> map;
	Entry start, end;
	int LRU_SIZE = 3;

	public PractisingCache() {
		map = new HashMap<Integer, Entry>(LRU_SIZE);
	}

	public int getCacheItem(int key) {
		if (map.containsKey(key)) {
			Entry entry = map.get(key);
			removeNode(entry);
			addToTop(entry);
			return entry.key;
		}
		return -1;
	}

	public void putCacheEle(int key, int val) {
		Entry entry = new Entry(key, val, null, null);
		if (map.containsKey(key)) {
			Entry getEntry = map.get(key);
			getEntry.val = entry.val;
			removeNode(getEntry);
			addToTop(getEntry);
		} else {
			if (LRU_SIZE < map.size()) {
				map.remove(end.key);
				removeNode(end);
			}
			map.put(key, entry);
			addToTop(entry);
		}
	}

	@Override
	public String toString() {
		return "PractisingCache [map=" + map + ", start=" + start + ", end=" + end + ", LRU_SIZE=" + LRU_SIZE + "]";
	}

	private void addToTop(Entry entry) {
		// TODO Auto-generated method stub
		if (start != null) {
			entry.right = start;
			entry.left = null;
			start.left = entry;
		}
		start = entry;
		if (end == null)
			end = start;
	}

	private void removeNode(Entry entry) {
		// TODO Auto-generated method stub
		if (entry.left != null) {
			entry.left.right = entry.right;
		} else {
			start = entry.right;
		}
		if (entry.right != null) {
			entry.right.left = entry.left;
		} else {
			end = entry.left;
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
//		PractisingCache lrucache = new PractisingCache();
//		lrucache.putCacheEle(1, 1);
//		lrucache.putCacheEle(10, 15);
//		lrucache.putCacheEle(8, 10);
//		lrucache.putCacheEle(1, 16);
//		lrucache.putCacheEle(10, 16);
//		lrucache.putCacheEle(12, 15);
//		lrucache.putCacheEle(18, 10);
//		lrucache.putCacheEle(13, 16);
//
//		System.out.println(lrucache.getCacheItem(1));
//		System.out.println(lrucache.getCacheItem(10));
//		System.out.println(lrucache.getCacheItem(3));
		
		/*
		 * int[] spam = new int[] { 1, 2, 3 }; List<Integer> re=new
		 * ArrayList<Integer>(); System.out.println(re);
		 * Arrays.stream(spam).boxed().collect(Collectors.toList()); for (int o : spam)
		 * { System.out.println(o); }
		 */
		
		   List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
		   myList.stream().filter(m->m%2==0).collect(Collectors.toList());
	}
}
