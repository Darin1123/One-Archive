import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

//BufferedReader 可以按行读取文件。
class q22 {
	static void sort(Name[] a) {
		int N = a.length;
		for (int i=0; i<N; i++) {
			int min = i;
			for (int j=i+1; j<N; j++)
				if (less(a[j], a[min])) min = j;
			exch(a, i, min);
		}
	}

	static boolean less(Name v, Name w)
	{ return v.compareTo(w) < 0; }

	static void exch(Name[] a, int i, int j)
	{ Name t = a[i]; a[i] = a[j]; a[j] = t; }

	public static void main(String[] args) {
		File file = new File("names.txt");
		BufferedReader reader = null;
		String temp = null;
		int line = 1;
		String[] names = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			temp = reader.readLine();  //按行读，美滋滋。
		}
		catch(Exception e){
			e.printStackTrace();
		}
		names = temp.split("\",\"");
		names[0] = names[0].replace("\"", "");
		names[names.length-1] = names[names.length-1].replace("\"", "");
		Name[] Names = new Name[names.length];
		for (int i=0; i<names.length; i++) {
			Name t = new Name(names[i]);
			Names[i] = t;
		}
		sort(Names);
		int res = 0;
		for (int i=0; i<Names.length; i++) {
			res += (i+1)*Names[i].Mark();
		}
		System.out.println(res);
	}
}