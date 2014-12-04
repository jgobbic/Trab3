
//essa classe generica voce manda um objeto qualquer, e um double, e ela ao usar a funcao amIGetting() tem a porcentagem 
//de chance de retornar o objeto igual ao double que foi enviado

//enviar chance em double decimal. exemplo 30% = 0.3

public class ChanceToGet<B>{
	private double odds;
	private B Getting;
	
	public ChanceToGet(double chance, B get){
		if(chance>1.0)
			chance=1.0;
		if(chance<0.0)
			chance=0.0001;
		
		odds = chance;
		Getting = get;
	}
	
	public B amIGetting(){
		int chance = (int)( Math.random() * ((1/odds)+1));
		
		if(chance==0){
			return Getting;
		}
		else return null;
	}

}