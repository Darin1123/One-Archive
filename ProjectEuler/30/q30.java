public class q30 {
	public static int fifpow(int a) {
		int res=0;
		while (a!=0) {
			int pow=1;
			int temp=a%10;
			for (int i=0; i<5; i++) {
				pow*=temp;
			}
			res+=pow;
			a=(a-a%10)/10;
		}
		return res;
	}

	public static int bf() {
		int res=0;
		for (int i=11; i<1000000; i++)
			if (i==fifpow(i))
				res+=i;
		return res;
	}

	public static void main(String[] args) {
		long start_time=System.currentTimeMillis();
		System.out.println(bf());
		long end_time=System.currentTimeMillis();
		System.out.println("Time used: " + (end_time-start_time));
		
	}
}