package Item;

public class HealthPotion extends Potion {
	public HealthPotion(String n, double v, int r){
		super(n,v,r);
	}
	public int use(){ return getRestorePts();
	}

}