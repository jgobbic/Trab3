package Item;

public class Armor extends Item{
	protected int defensepts;
	protected double weight;
	
	public Armor(String n, double p, int def, double w){
		
		super(n,p);		
		
		if(def<1)
			def = 1;
		if(def>20)
			def = 20;
		
		defensepts = def;
		weight = w;
	
	}


	public Armor(Armor a){
		super(a.getName(),a.getPrice());
		defensepts = a.getDefensePts();
		weight = a.getWeight();
	}
	
	public int getDefensePts(){
		return defensepts;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public int getPts(){
		return defensepts;
	}
}