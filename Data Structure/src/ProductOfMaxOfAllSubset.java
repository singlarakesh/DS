
public class ProductOfMaxOfAllSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[] = { 1, 2, 3 };
		int product = 1;
		for (int i = 0; i < ar.length; i++) {
			int j = i + 1;
			int temp=1;
			while (j > 0) {
				temp = ar[i] * ar[i];
				j--;
			}
			System.out.println(temp);
			product*=temp;
		}
		System.out.println(product);
	}

}
