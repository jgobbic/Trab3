package Item;

public abstract class Potion extends Item{
	private int restorepts;
	
	
	
	public Potion(String s, double p, int r){
		super(s,p);
		restorepts = r;	
	}
	
	public Potion(Potion p){
		super(p.getName(),p.getPrice());
		restorepts = p.getRestorePts();
	}
	
	
	/*TODO*/
	//public ~Potion(){} Java nao precisa de um destrutor;

	public int getRestorePts(){
		return restorepts;
	}
	
	public int getPts(){
		return getRestorePts();
	}
	
	public abstract int use();

}