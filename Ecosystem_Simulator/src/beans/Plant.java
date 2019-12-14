package beans;

import java.util.ArrayList;
import java.util.Random;

public class Plant extends Creature {
	private PlantEnum type;
	public PlantEnum getType() {
		return type;
	}

	public void setType(PlantEnum type) {
		this.type = type;
	}

	public Plant( int lifeSpan,String id, int[] position, PlantEnum type,World world) {
		super(lifeSpan,world);
		super.id = id;
		super.position = position;
		this.type = type;	
	}
	
	@Override
	public int[] reproduce() {
		ArrayList<Integer> ds = world.getDirections(position);
		Random random = new Random(47);
		
		if (ds.isEmpty()) 
			return null;
		int d = ds.get(random.nextInt(ds.size()));
		return select(d, position);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
