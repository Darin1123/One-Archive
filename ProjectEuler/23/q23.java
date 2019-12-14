import java.util.ArrayList;

public class q23 {

	public static boolean isAbandunt(int n) {
		int res = 1;
		for (int i = 2; i < n/2+1; i++) {
			if (n%i==0)
				res += i;
		}
		return res>n;
	}

	public static boolean separable(int n, ArrayList<Integer> abandunts) {
		for (int i=0; i<abandunts.size(); i++) {
			int abandunt = abandunts.get(i);
			if (abandunt>=n)
				return false;
			else {
				int temp = n - abandunt;
				if (abandunts.contains(temp))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		ArrayList<Integer> abs = new ArrayList<Integer>();
		for (int i=1; i<=28123; i++ )
			if (isAbandunt(i))
				abs.add(i);
		long mid = System.currentTimeMillis();
		System.out.println("Progess: get all abandunt numbers below 28123.\nTime used: "+(mid-start)/1000+" s.");
		System.out.println("Progess: Doing calculation...");
		int sum = 0;
		for (int i = 1; i<=28123; i++ )
			if (!separable(i, abs))
				sum += i;
		long end = System.currentTimeMillis();
		System.out.println("Answer: "+sum);
		System.out.println("Time used: "+(end-start)/1000+" s.");
	}
}