package dp;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Item {
	int val;
	int count;

//	Item() {
//	}

	Item(int val, int count) {
		this.val = val;
		this.count = count;
	}

@Override
	public String toString() {
		return "Item [val=" + val + ", count=" + count + "]";
	}

public void setCount(int i) {
	// TODO Auto-generated method stub
	this.count=i;
}
}

public class DistingElementsRemovingm {

	public static void main(String[] args) {
		int arr[] = {2, 4, 1, 5, 3, 5, 1, 3 };
		int m = 2;
		Map<Integer, Integer> map = new HashMap<>();
		for (int a : arr) {
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		}
		PriorityQueue<Item> queue = new PriorityQueue<Item>((a, b) -> {
			return a.count - b.count;
		});
		for (int a : map.keySet()) {
			Item item = new Item(a, map.get(a));
			queue.add(item);
		}
		while (m > 0) {
			Item t=queue.peek();
			System.out.println(t);
			if(t.count>1) {
				t.setCount(--t.count);			
			}else {
				queue.remove();
			}
			
			
			m--;
		}
		System.out.println(queue.size());
	}
}
