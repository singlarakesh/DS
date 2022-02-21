package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ClosestPointToOrigin {
	public static void main(String[] args) {
		int ar[][] = { { 1, 3 }, { -2, 2 } };
		int k = 1;
		HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
		int p[] = new int[ar.length];
		for (int l = 0; l < ar.length; l++) {
			int i = ar[l][0];
			int j = ar[l][1];
			int s = i * i + j * j;
			p[l] = s;
			map.put(s, ar[l]);
		}
		int res[][] = new int[k][2];
		Arrays.sort(p);
		int i = 0;
		while (k-- > 0) {
			res[i] = map.get(p[i]);
			i++;
		}
	}
}
