package Item;

public class Weapon extends Item{
	protected int attackpts;
	protected double range;
	
	public Weapon(String n, double p, int atk, double r){
		super(n,p);
		
		if(atk<1)
			atk = 1;
		if(atk>9)
			atk = 9;
		
		attackpts = atk;
		range = r;
	}


	public Weapon(Weapon w){
		super(w.getName(),w.getPrice());
		attackpts = w.getAttackPts();
		range = w.getRange();
	}
	
	public int getAttackPts(){
		return attackpts;
	}
	
	public double getRange(){
		return range;
	}
	
	public int getPts(){
		return getAttackPts();
	}
	
}