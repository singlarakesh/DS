import java.util.Stack;

public class Maximum_Rectangle_01 {
	public static void main(String[] args) {

	}

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)
            return 0;
       int max = Integer.MIN_VALUE;
	   int d[] = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
                int v= Integer.parseInt(matrix[i][j]+"");
                if(v!=0)
				d[j] += Integer.parseInt(matrix[i][j]+"");
                else{
                    d[j]=0;
                }
                
			}
			max = max < getMaxArea(d, d.length) ? getMaxArea(d, d.length) : max;
		}

		return max;

	}

	private static int getMaxArea(int[] hist, int length) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		int sr[] = new int[length];
		int sl[] = new int[length];
		int res = 0;
		for (int i = length - 1; i >= 0; i--) {
			while (!s.isEmpty() && hist[s.peek()] >= hist[i]) {
				s.pop();
			}
			if (s.isEmpty()) {
				sr[i] = length;
			} else {
				sr[i] = s.peek();
			}
			s.push(i);
		}
		s = new Stack<>();
		for (int i = 0; i < length; i++) {
			while (!s.isEmpty() && hist[s.peek()] > hist[i]) {
				s.pop();
			}
			if (s.isEmpty()) {
				sl[i] = -1;
			} else {
				sl[i] = s.peek();
			}
			s.push(i);
		}
		for (int i = 0; i < length; i++) {
			int v = sr[i] - sl[i] - 1;
			int val = v * hist[i];
//			System.out.println(v * hist[i]);
			res = res > val ? res : val;
		}
		return res;
	}
}
