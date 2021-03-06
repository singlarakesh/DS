package Amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Nodev implements Comparator<Nodev> {
	char ch;
	int count;

	public Nodev() {
		// TODO Auto-generated constructor stub
	}

	Nodev(char ch, int count) {
		this.ch = ch;
		this.count = count;
	}

	@Override
	public int compare(Nodev o1, Nodev o2) {
		// TODO Auto-generated method stub
		return o2.count - o1.count;
	}
}

public class ReaarangeCharInStringNoadjacent {
	public static void main(String[] args) {
		String str = "aaab";
		rearrangeString(str);
	}

	private static void rearrangeString(String str) {
		// TODO Auto-generated method stub
		int k = str.length() - 1;
		Map<Character, Integer> map = new HashMap<>();
		while (k >= 0) {
			char c = str.charAt(k);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			k--;
		}
		Queue<Nodev> q = new PriorityQueue<>(new Nodev());
		for (char c : map.keySet()) {
			Nodev node = new Nodev(c, map.get(c));
			q.add(node);
		}
		String s = "";

		Nodev prev = new Nodev('#', -1);
		while (!q.isEmpty()) {
			Nodev node = q.poll();
			s += node.ch;
			if (prev.count > 0) {
				q.add(prev);
			}
			node.count -= 1;
			prev = node;
		}
		if (s.length() != str.length()) {
			return "";
		}else {
			return s;
		}
	}
}
