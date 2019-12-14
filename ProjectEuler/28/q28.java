public class q28 {
	public int index = 1;
	public q28() {}

	public int oneRound(int n) {
		int t = this.index;
		int o = this.index;
		for (int i=0; i<4; i++) {
			this.index += 2*n;
			t += this.index;
		}
		t -= o;
		return t;
	}
	public static void main(String[] args) {
		int res = 1;
		q28 q = new q28();
		for (int i=1; i<1001/2+1; i++) {
			int t = q.oneRound(i);
			res += t;
		}
		System.out.println(res);
	}
}
