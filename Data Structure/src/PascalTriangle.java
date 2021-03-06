import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		List<List<Integer>>  ans=findPascaltri(n);
		System.out.println(ans);
	}

	private static List<List<Integer>> findPascaltri(int n) {
		// TODO Auto-generated method stub
		if (n == 1) {
			List<List<Integer>> ans=new ArrayList<List<Integer>>();
			List<Integer> subRes = new ArrayList<Integer>();
			subRes.add(1);
			ans.add(subRes);
			return ans;
		}
		List<List<Integer>> ans = findPascaltri(n - 1);
		List<Integer> res = ans.get(ans.size() - 1);
		List<Integer> subRes = new ArrayList<Integer>();
		if (res.size() == 1) {
			subRes.add(1);
			subRes.add(1);
		} else {
			int i = 0;
			int j = 1;
			subRes.add(1);
			while (j < res.size()) {
				int v1 = res.get(i);
				int v2 = res.get(j);
				subRes.add(v1 + v2);
				i++;
				j++;
			}
			subRes.add(1);
		}
		ans.add(subRes);
		return ans;
	}
}
