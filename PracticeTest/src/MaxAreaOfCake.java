import java.util.Arrays;

public class MaxAreaOfCake {

	public static void main(String[] args) {
		int h = 5;
		int w = 4;
		int horizontalCuts[] = { 1, 2, 4 };
		int verticalCuts[] = { 1, 3 };
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		MaxAreaOfCake(horizontalCuts, verticalCuts, h, w);
	}

	private static void MaxAreaOfCake(int[] horizontalCuts, int[] verticalCuts, int h, int w) {
		// TODO Auto-generated method stub
		int maxHor = Integer.MIN_VALUE;
		int maxVer = Integer.MIN_VALUE;
		if (horizontalCuts.length > 1) {
			maxHor = Math.max(maxHor, horizontalCuts[0] - 0);
			maxHor = Math.max(maxHor, h - horizontalCuts[horizontalCuts.length - 1]);
		}
		for (int i = 0; i < horizontalCuts.length - 1; i++) {
			maxHor = Math.max(maxHor, horizontalCuts[i + 1] - horizontalCuts[i]);
		}
		
		if (verticalCuts.length > 1) {
			maxVer = Math.max(maxHor, verticalCuts[0] - 0);
			maxVer = Math.max(maxHor, w - verticalCuts[verticalCuts.length - 1]);
		}
		for (int i = 0; i < verticalCuts.length - 1; i++) {
			maxVer = Math.max(maxHor, verticalCuts[i + 1] - verticalCuts[i]);
		}
		System.out.println(maxVer*maxHor);
	}

}
