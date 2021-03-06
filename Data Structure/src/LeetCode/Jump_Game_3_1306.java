package LeetCode;

public class Jump_Game_3_1306 {
	public static void main(String[] args) {
		int arr[] = { 3, 0, 2, 1, 2 };
		int start = 5;
		boolean[] visited = new boolean[arr.length];
		System.out.println(canReach(arr, 2, visited));
	}

	public static boolean canReach(int[] arr, int start, boolean visited[]) {

		if (arr[start] == 0)
			return true;
		if (visited[start])
			return false;
		

		visited[start] = true;
		Boolean ans1 = false, ans2 = false;
		if (start + arr[start] < arr.length)
			ans1 = canReach(arr, start + arr[start], visited);
		if (start - arr[start] >= 0)
			ans2 = canReach(arr, start - arr[start], visited);
		return ans1 || ans2;

	}
}
