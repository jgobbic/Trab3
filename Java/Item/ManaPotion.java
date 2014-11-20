package Item;

public class ManaPotion extends Potion {
	public ManaPotion(String n, double v, int r){
		super(n,v,r);
	}
	
	//~ManaPotion

	//**TODO**//
	public int use(){return (-1)*getRestorePts();
	}

}