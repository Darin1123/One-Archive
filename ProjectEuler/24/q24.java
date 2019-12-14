public class q24 {
	public int[] res = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	final int[] per = {362880, 40320, 5040, 720, 120, 
					   24, 6, 2, 1};
	private int index = 1;
	public q24() {}
	public void exch(int a, int b) {
		int t = res[a];
		res[a] = res[b];
		res[b] = t;
	} 
	public String toString() {
		String s = "";
		for (int i=0; i<res.length; i++)
			s=s.concat(String.valueOf(res[i]));
		return s;
	}
	public void add(int i) {
		int t = 0;
		while (index <= 1000000) {
			index += per[i];
			t++;
		}
		index -= per[i];
		t--;
		int r = i+1;
		for (int n=0; n<t; n++) {
			exch(i, r);
			r++;
		}
	}
	public static void main(String[] args) {
		q24 q = new q24();
		for (int i=0; i<9; i++)
			q.add(i);
		System.out.println(q.toString());
	}
}