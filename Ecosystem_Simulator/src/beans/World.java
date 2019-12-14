package beans;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class World {
	private int size;
	private String[][] data;
	private HashMap<String,Animal> mapOfAnimal;
	private HashMap<String,Plant> mapOfPlant;
	private Factory newfactory;
	public  World(Factory factory){
		size=20;
		newfactory=factory;
		int n=size;
		mapOfAnimal=new HashMap<String,Animal>();
		mapOfPlant=new HashMap<String,Plant>();
		data=new String[n][n];
		//设置三种障碍类型
		//直线型，L型，田字型，每个障碍设置最左下角点，再生成障碍
		//障碍数量为(n/5)^2
		//障碍点位置随机
		int numOfBarrier=(int)(n/5)*(int)(n/5);
		int x;
		int y;
		int typeOfBarrier;
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				data[i][j]="0";
			}
		}
		for (int j=0;j<n;j++){
			data[j][0]="1";
			data[0][j]="1";
			data[j][n-1]="1";
			data[n-1][j]="1";
		}
		for(int j=0;j<numOfBarrier;j++){
			//随机障碍的坐标
			x=(int)(Math.random()*n);
			y=(int)(Math.random()*n);
			//随机障碍的类型
			typeOfBarrier=(int)(Math.random()*3);
			if (typeOfBarrier==0){
				for (int i=0;i<4;i++){
					if ((x+i)>=n){
						break;
					}
					data[x+i][y]="1";
				}
			}
			else if(typeOfBarrier==1){
				for (int i=0;i<3;i++){
					if (x+i>=n){
						break;
					}
					if ((y+i)>=n){
						break;
					}
					data[x+i][y]="1";
					data[x][y+i]="1";
				}
			}
			else if((typeOfBarrier==2)){
				for (int i=0;i<2;i++){
					for(int k=0;k<2;k++){
						if ((x+i)>=n || (y+k)>=n){
							break;
						}
						data[x+i][y+k]="1";
					}
				}
			}
		}
	
		int numOfAnimal=(int)(n/2);
		int count=0;//计算初始化已经创建了几个动物
		x=0;
		y=0;
		while(count<numOfAnimal){
			int ran=(int)(Math.random()*3);
			AnimalEnum typeOfAnimal;
			switch (ran){
				case 0:typeOfAnimal=AnimalEnum.A1;
				break;
				case 1:typeOfAnimal=AnimalEnum.A2;	
				break;
				case 2:typeOfAnimal=AnimalEnum.A3;
				break;
				default: typeOfAnimal=AnimalEnum.A1;
			}
			while(data[x][y]!="0"){
				x=(int)(Math.random()*n);
				y=(int)(Math.random()*n);
			}
			setAnimal(x,y,typeOfAnimal);
			count++;
		}
		count=0;
		x=0;
		y=0;
		int numOfPlant=(int)(n/2);
		while(count<numOfPlant){
			int ran=(int)(Math.random()*3);
			PlantEnum typeOfPlant;
			switch (ran){
				case 0:typeOfPlant=PlantEnum.P1;
				break;
				case 1:typeOfPlant=PlantEnum.P2;	
				break;
				case 2:typeOfPlant=PlantEnum.P3;
				break;
				default: typeOfPlant=PlantEnum.P1;
			}
			while(data[x][y]!="0"){
				x=(int)(Math.random()*n);
				y=(int)(Math.random()*n);
			}
			setPlant(x,y,typeOfPlant);
			count+=1;
		}
	}
	public void setAnimal(int x,int y,AnimalEnum typeOfAnimal){
		Animal newAnimal=newfactory.getAnimal(x,y,typeOfAnimal,this);
		data[x][y]=newAnimal.id;
		mapOfAnimal.put(newAnimal.id, newAnimal);
	}
	public void setPlant(int x,int y,PlantEnum typeOfPlant){
		Plant newPlant=newfactory.createPlant(x, y, typeOfPlant,this);
		data[x][y]=newPlant.id;
		mapOfPlant.put(newPlant.id, newPlant);
	}
	public void run(){
		//这里对于已经添加到hashmap中的对象，对象执行内部函数以后，在hashmap中的属性值能不能跟着一起改变？
		for(Iterator<Map.Entry<String,Animal>> it =mapOfAnimal.entrySet().iterator();it.hasNext();){
			Map.Entry<String,Animal> item=it.next();
			item.getValue().setAge(item.getValue().getAge()+1);
			int[] oldpos=item.getValue().getPosition();
			data[oldpos[0]][oldpos[1]]="0";
			int[] newpos=item.getValue().move();
			item.getValue().setPosition(newpos);
			data[newpos[0]][newpos[1]]=item.getValue().id;
			if (item.getValue().getAge()>item.getValue().getLifeSpan()){
				it.remove();
			}
		}
		HashMap<String,Plant> tempMapOfPlant=new HashMap<String,Plant>();
		for(Iterator<Map.Entry<String,Plant>> it =mapOfPlant.entrySet().iterator();it.hasNext();){
			Map.Entry<String,Plant> item=it.next();
			item.getValue().setAge(item.getValue().getAge()+1);
//			if(item.getValue().getAge()>3){
//				if(item.getValue().reproduce()!=null){
//					int[] newpos=item.getValue().reproduce();
//					data[newpos[0]][newpos[1]]=
//				}
//			}
			
			if (item.getValue().getAge()>item.getValue().getLifeSpan()){
				it.remove();
			}
		}
	}
	public ArrayList<Integer> getDirections(int[] position) {
		int x=position[0];
		int y=position[1];
		boolean[] directions = {true, true, true, true};
		if (x==0||this.data[x-1][y].equals("1")) 
			directions[2]=false;		//left
		if (x==size-1||data[x+1][y].equals("1")) 
			directions[3]=false;		//right
		if (y==0||data[x][y-1].equals("1")) 
			directions[0]=false;		//up
		if (y==size-1||data[x][y+1].equals("1")) 
			directions[1]=false;		//down
		ArrayList<Integer> ds = new ArrayList<Integer>();
		for (int i=0; i<directions.length; i++) {
			if (directions[i]) {
				ds.add(i);
			}
		}
		return ds;
	}
	public boolean check(){
		if (mapOfAnimal.size()!=0 | mapOfPlant.size()!=0){
			return true;
		}
		return false;
	}
	public Creature getCreature(String id){
		//判断id在动物内还是在植物内
		for (AnimalEnum type:AnimalEnum.values()){
			if (id.contains(type.toString())){
				return mapOfAnimal.get(id);
			}
		}
		for (PlantEnum type:PlantEnum.values()){
			if (id.contains(type.toString())){
				return mapOfPlant.get(id);
			}
		}
		return null;
	}
	public String[] getSurroundings(int[] position) {
		int x = position[0];
		int y = position[1];
		String[] result = new String[4];  //[up, down, left, right]
		if (y>0)  			//there is something up there
			result[0] = this.data[x][y-1];
		if (y>size-1) 		//there is something down there
			result[1] = this.data[x][y+1];
		if (x>0)		 	//there is something on the left
			result[2] = this.data[x-1][y];
		if (x<size-1)  		//there is something on the right
			result[3] = this.data[x+1][y];
		return result;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String[][] getData() {
		return data;
	}
	
	public void setData(String[][] data) {
		this.data = data;
	}
	public void show(){
		String pic="";
		for(int i=0;i<size;i++){
			for (int j=0;j<size;j++){
				if(mapOfAnimal.containsKey(data[i][j])){
					pic+=mapOfAnimal.get(data[i][j]).getId();
				}
				else if(mapOfPlant.containsKey(data[i][j])){
					pic+=mapOfPlant.get(data[i][j]).getId();
				}
				else{
					if(data[i][j]=="0"){
						pic+="  ";
					}
					else{
						pic+="--";
					}
				}

			}
			pic+="\n";
		}
		pic+="\n\n\n";
		System.out.println(pic);
	}
	public static void main(String args[]){
		Factory factory=new Factory();
		World w0=new World(factory);
		
		w0.show();
		for (int j=0;j<11;j++){
			w0.run();
			if (w0.check()==false){
				break;
			}
			
		}
		w0.show();
	}
}
