import java.util.Scanner;

public class UglyNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		nthUglyNumber(n);
	}
	
	UglyNumber2(){}

	private static int nthUglyNumber(int n) {
		// TODO Auto-generated method stub
		int a[] = new int[n];
		a[0] = 1;
		int index2 = 0, index3 = 0, index5 = 0;
		int factor2 = 2, factor3 = 3, factor5 = 5;
		for (int i = 1; i < a.length; i++) {
			int min = Math.min(Math.min(factor2, factor3), factor5);
			a[i] = min;
			if (factor2 == min) {
				factor2 = 2 * a[++index2];
			}  if (factor3 == min) {
				factor3 = 3 * a[++index3];
			} if(factor5==min) {
				factor5 = 5 * a[++index5];
			}
		}
		return a[n-1];
	}

}
