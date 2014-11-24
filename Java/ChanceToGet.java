

public class ChanceToGet<B>{
	private Double odds;
	private B Getting;
	
	public ChanceToGet(Double chance, B get){
		odds = chance;
		Getting = get;
	}
	
	public B amIGetting(){
		//odds = odds/100;
		
		int chance = (int)( Math.random() * 1/odds);
		
		System.out.println(chance);
		if(chance==1){
			return Getting;
		}
		else return null;
	}

}