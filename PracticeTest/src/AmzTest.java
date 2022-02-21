import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AmzTest {
	public static void main(String[] args) {
		int ar[] = { 4, 1, 3, 2 };
		Arrays.sort(ar);
		maxLength(ar);
	}

	public static void maxLength(int A[]) {
		 int n = A.length, j, k;
	        long res = 0;
	        
	        Stack<Integer> s = new Stack<>();
	        for (int i = 0; i <= n; i++) {
	            while (!s.isEmpty() && A[s.peek()] > (i == n ? Integer.MIN_VALUE : A[i])) {
	                j = s.pop();
	                k = s.isEmpty() ? -1 : s.peek();
	                res -= (long)A[j] * (i - j) * (j - k);

	            }
	            s.push(i);
	        }
	        
	        s.clear();
	        for (int i = 0; i <= n; i++) {
	            while (!s.isEmpty() && A[s.peek()] < (i == n ? Integer.MAX_VALUE : A[i])) {
	                j = s.pop();
	                k = s.isEmpty() ? -1 : s.peek();
	                res += (long)A[j] * (i - j) * (j - k);

	            }
	            s.push(i);
	        }
       System.out.println(res);
	}
}
