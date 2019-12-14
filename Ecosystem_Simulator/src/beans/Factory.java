package beans;
import beans.AnimalEnum;
import beans.PlantEnum;
public class Factory {
	private int animalNum;
	private int plantNum;
	public Factory(){
		animalNum=0;
		plantNum=0;
	}
	public  Animal getAnimal(int x,int y,AnimalEnum race,World world){
		int[] pos={x,y};
		Animal newA=new Animal(10,"a"+animalNum,pos,race,world);
		animalNum+=1;
		return newA;
	}
	public Plant createPlant(int x,int y,PlantEnum race,World world){
		int[] pos={x,y};
		Plant newP=new Plant(10,"p"+plantNum,pos,race,world);
		plantNum+=1;
		return newP;
	}
}
