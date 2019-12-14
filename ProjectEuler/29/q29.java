import java.util.ArrayList;

public class q29 {
	public static void main(String[] args) {
		ArrayList<Double> q = new ArrayList<Double> ();
		double t = 0.0;
		for (int i = 2; i<=100; i++) {
			for (int j=2; j<=100; j++) {
				t = Math.pow((double)i, (double)j);
				if (!q.contains(t))
					q.add(t);
			}
		}
		System.out.println(q.size());
	}
}