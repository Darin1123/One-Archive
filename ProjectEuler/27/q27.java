import java.util.ArrayList;

public class q27 {
    public static int f(int x, int a, int b) {
    	return x*x+a*x+b;
    }
	public static boolean isPrime(int n) {
		if (n<=1||n%2==0)
			return false;
		if (n==2)
			return true;
		for (int i=3; i<Math.sqrt(n); i+=2)
			if (n%i==0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i=3; i<1001; i+=2)
			if (isPrime(i))
				primes.add(i);
		long s = System.currentTimeMillis();
		int aa=0;
		int bb=0;
		int max=0;
		for (int a=-1000; a<=1000; a++) {
			for (int b:primes) {
				int n = 0;
				int t = 0;
				while (isPrime(f(n, a, b))){
					t++;
					n++;
				}
				if (t>max) {
					max =t;
					aa = a;
					bb = b;
				}
			}
		}
		long e = System.currentTimeMillis();
		System.out.println("Time used: " + (e-s));
		System.out.println(aa+" "+bb);
		System.out.println(aa*bb);
	}
}