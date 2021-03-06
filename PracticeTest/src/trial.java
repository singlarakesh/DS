import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class trial {
	public static void main(String[] args) {
		int nums[] = { 2, 7, 9, 3, 1 };
//		System.out.println(rec(nums, true, 0));
//		System.out.println(robber(nums));
		List<Integer> list = Arrays.asList(2, 7, 9, 3, 1, 1);
		List<Integer> ans = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(ans);
		Set<Integer> set = new HashSet();
		ans = list.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
		System.out.println(ans);
		Runnable t = () -> System.out.println("DD");
		Thread d = new Thread(() -> System.out.println("DD"));
	}

	private static int robber(int[] nums) {
		// TODO Auto-generated method stub
		int dp[][] = new int[2][nums.length + 1];
		dp[0][0] = 0;
		dp[1][0] = 0;
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
			dp[1][i] = dp[0][i - 1] + nums[i - 1];
		}
		return Math.max(dp[0][dp[0].length - 1], dp[1][dp[0].length - 1]);
	}

//with recursion
	private static int rec(int[] nums, boolean b, int i) {
		// TODO Auto-generated method stub
		if (i == nums.length) {
			return 0;
		}
		if (b) {
			return Math.max(rec(nums, false, i + 1) + nums[i], rec(nums, true, i + 1));
		} else {
			return rec(nums, true, i + 1);
		}
	}
}
