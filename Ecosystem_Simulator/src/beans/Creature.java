package beans;

public abstract class Creature {
	protected int age;
	protected int lifeSpan;
	protected String id;
	protected int[] position;
	protected World world;
	
	public Creature(int lifeSpan,World world) {
		this.lifeSpan=lifeSpan;
		this.world=world;
	}
	
	public abstract int[] reproduce();
	
	boolean die() {
		if (this.age==this.lifeSpan) 
			return true;
		return false;
	}
	
	void grow() { 
		this.age++; 
	}
	
	protected int[] select(int d, int[] origin) {
		int[] result = origin.clone();
		switch (d) {
		case 0:
			result[1]++;
			break;
		case 1:
			result[1]--;
			break;
		case 2:
			result[0]--;
			break;
		case 3:
			result[0]++;
			break;
		}
		return result;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(int lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}
}
