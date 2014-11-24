public class Humanoid extends Creature{
	private AttackType A;
	private AttackType Weakness;
	
	public Humanoid(String name, int HpMax, int def, int atk, int gld){
		super(name,HpMax,def,atk,gld);
		
		A = AttackType.Physical;
		Weakness = AttackType.Fire;
	}

	public int releaseXp(){
		int exp = attack + defense;
		exp = exp/5; //menos XP por monstro
		return exp;
	
	}
	
	public int attack(Entity v){	
		
		int chance =(int)( Math.random() * 10); //Alta chance de miss 10%
		int dmg;
		if(chance==1){
			System.out.println("Miss");
			dmg = 0;
		}
		
		else{
		dmg = (int)( attack - v.getDefensePoints() ) + ((int)(Math.random()*10)-5);
		
		System.out.println("Dmg" + dmg + " Com atck " + attack + " Defense " + v.getDefensePoints());
		
		if(dmg<0){
			System.out.println("Dano menor que 0, setando para 1");
			dmg = 1;
		}
		
		chance = (int)(Math.random() * (75)); //Baixa Chance de critico 1.3% 
	
		if(chance == 1){
			dmg = 2*dmg;
		System.out.println("Critico");
		}
		
		if(v.getWeakness()== this.A){ //Se o seu tipo de atck for igual o tipo de fraqueza do inimigo //Nessa tipo de criatura, há um bonus ainda maior caso haja weakness no inimigo
			dmg = dmg * 21;
			dmg = dmg / 10;
		System.out.println("Its Super Effective!" + dmg);
		}
		
		System.out.println("Damage foi " + dmg);
			
		}
		v.tookDMG(dmg);
		return dmg;
	}
	
	public int getDefensePoints(){ //esse tipo tem bonus de defesa
		return defense+5;
	};
	
	public AttackType getWeakness(){
	return Weakness;
	}
}