package LeetCode;

import java.util.Arrays;

public class MaxCakeBite {
	public static void main(String[] args) {
		int h = 5;
		int w = 4;
		int[] horizontalCuts = { 1, 2, 4 };
		int[] verticalCuts = { 1, 3 };
		System.out.println(maxArea(h, w, horizontalCuts, verticalCuts));
	}

	private static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		// TODO Auto-generated method stub
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		int i = 0;
		int j = i + 1;
		int hmax = horizontalCuts[i]-0;
		while (j < horizontalCuts.length) {
			int dif = horizontalCuts[j] - horizontalCuts[i];
			if (dif > hmax) {
				hmax = dif;
			}
			i++;
			j++;
		}
		System.out.println(hmax);
		hmax = (h - horizontalCuts[i]) > hmax ? (h - horizontalCuts[i]) : hmax;
		System.out.println(hmax);
		i = 0;
		j = i + 1;
		int vmax = verticalCuts[i]-0;
		while (j < verticalCuts.length) {
			int dif = verticalCuts[j] - verticalCuts[i];
			if (dif > vmax) {
				vmax = dif;
			}
			i++;
			j++;
		}
		vmax = (w - verticalCuts[i]) > vmax ? (w - verticalCuts[i]) : vmax;
		return hmax*vmax;
	}
}
