package dp;

public class IntegerBreak {
	static int maxVal=0;
	public static void main(String[] args) {
      intBreak(1,10,10,1);
      System.out.println(maxVal);
	}

	private static void intBreak(int i, int target,int sum, int k) {
		// TODO Auto-generated method stub

		if(target==0) {
			maxVal=Math.max(maxVal, k);
			return;
		}
		if(i>=sum || i>target) {
			return;
		}
		
		
		intBreak(i, target-i,sum, k*i);
		intBreak(i+1, target,sum, k);
	}
}
