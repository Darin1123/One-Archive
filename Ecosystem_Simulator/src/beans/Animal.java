package beans;

import java.util.ArrayList;
import java.util.Random;

public class Animal extends Creature {
	public static int MALE = 0;
	public static int FEMALE = 1;
	private AnimalEnum race;
	public void setRace(AnimalEnum race) {
		this.race = race;
	}

	private int gender;    
	private boolean isAvailable;

	public Animal(int lifeSpan, String id, int[] position, AnimalEnum race,World world) {
		super(lifeSpan,world);
		super.id = id;
		super.position = position;
		this.race = race;
		Random r = new Random(47);
		gender = r.nextInt(2);
		isAvailable=true;
	}
	
	public int getGender() {
		return gender;
	}
	
	public AnimalEnum getRace() {
		return race;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setUnavailable() {
		isAvailable = false;
	}
	
	public void setAvailable() {
		isAvailable = true;
	}
	
	public boolean isReady() {
		return (isAvailable && age>3 && age<lifeSpan-3);
	}
	
	public int[] move() {
		int[] origin = super.position;
		if (isAvailable) {
			ArrayList<Integer> ds = world.getDirections(origin);
			if (ds.size()==0)
				return origin;
			Random r = new Random(47);
			int d = ds.get(r.nextInt(ds.size()));
			int[] result=origin.clone();
			return select(d, result);
		}
		return origin;
	}

	@Override
	public int[] reproduce() { 
		int[] result = null;
		if (isReady()) {	//is available for reproduction
			String[] surroundings = world.getSurroundings(position);
			for (int i=0; i<4; i++) {
				String id = surroundings[i];
				if (id!=null && id.length()>=2 && id.startsWith("a")) { //this is an animal
					Animal a = (Animal) world.getCreature(id);
					if (a.isReady() && a.getRace().equals(race) && a.getGender()!=gender) {
						a.setUnavailable();
						ArrayList<Integer> ds = world.getDirections(position);
						if (!ds.isEmpty()) {
							result = select(ds.get(0), position);
							break;
						} else {
							ds = world.getDirections(a.position);
							if (!ds.isEmpty()) {
								result = select(ds.get(0), position);
								break;
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Random r = new Random(47);
		for (int i=0; i<10; i++)
			System.out.println(r.nextInt(2));
	}
}
