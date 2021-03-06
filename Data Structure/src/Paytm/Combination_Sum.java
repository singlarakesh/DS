package Paytm;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
	public static void main(String[] args) {
		int candidates[] = { 2, 3, 6, 7 };
		int target = 7;
		List<Integer> ans = new ArrayList<Integer>();
		System.out.println(combinationSum(candidates, target, 0, ans));
	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target, int i, List<Integer> ans) {
		// TODO Auto-generated method stub
		List<List<Integer>> sans = new ArrayList<List<Integer>>(), ans1 = new ArrayList<List<Integer>>(),
				ans2 = new ArrayList<List<Integer>>(), ans3 = new ArrayList<List<Integer>>();
		if (target == 0) {
			sans.add(ans);
			return sans;
		}
		if (target < 0 || i >= candidates.length) {
			return sans;
		}
		if (candidates[i] > target) {
			ans1 = combinationSum(candidates, target, i + 1, ans);
		} else {
			ans2 = combinationSum(candidates, target, i + 1, ans);
//			ArrayList copy = new ArrayList(ans);
			ans.add(candidates[i]);
			ans3 = combinationSum(candidates, target - candidates[i], i, ans);
ans.remove(ans.size()-1);
		}
		for (List<Integer> s : ans1) {
			sans.add(s);
		}
		for (List<Integer> s : ans2) {
			sans.add(s);
		}
		for (List<Integer> s : ans3) {
			sans.add(s);
		}
		return sans;
	}
}
