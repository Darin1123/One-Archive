public class Name implements Comparable<Name> {
	private String name;

	public Name(String name) 
	{ this.name = name; }

	public String N() 
	{ return this.name; }

	public int compareTo(Name that) {
		return this.name.compareTo(that.N());
	}

	public int Mark() {
		int res = 0;
		for (int i=0; i<name.length(); i++) {
			int t = (int) name.charAt(i);
			res += t-64;
		}
		return res;
	}

	public static void main(String[] args) {
		//char c = 'A';
		//System.out.println((byte) c);
		//Name n = new Name("AMY");
		//System.out.println(n.Mark());
	}
}