class Thief extends Character{
	protected int stealth;
	private AttackType A;
	private AttackType Weakness;
	
	
	
	public Thief(String nome, int stf){ //No driagrama construtor estava com nome errado
	super(nome);
	stealth = stf;
	A = AttackType.Piercing; //por padrao, attacktype fisico
	Weakness = AttackType.Poison;
	}
	
	public int getDefensePoints(){
		double DEF;
		DEF = (0.6*this.constitution + 0.1*this.dexterity + 0.3*this.speed) + item_def_points ; 
		DEF = DEF*XP;
		DEF = DEF/6;
		System.out.println("Defesa pts foi: "+ item_def_points);
		return (int)DEF;
	}
	
	protected int getAttackPoints(){
		double ATK;
		ATK = (0.6*this.strenght + 0.1*this.dexterity) + item_att_points; 
		ATK = ATK *XP;
		ATK = ATK/2;
//		System.out.println("ATK pts foi: " + ATK);
		return (int)ATK + stealth;
	}
	
	
	

	public int attack(Entity v){
		recalculateItems();		
		
	int chance =(int)( Math.random() * (10*XP));
		int dmg;
		if(chance==1){
			System.out.println("Miss");
			dmg = 0;
		}
		else{
		dmg = (int)( this.getAttackPoints() - v.getDefensePoints() ) + ((int)(Math.random()*10)-5);
		System.out.println("Dmg" + dmg + " Com atck " + this.getAttackPoints() + " Defense " + v.getDefensePoints());
		if(dmg<0){
			System.out.println("Dano menor que 0, setando para 1");
			dmg = 1;
		}
		
		chance = (int)(Math.random() * (100/XP));	
	
		if(chance == 1){
			dmg = 2*dmg;
		System.out.println("Critico");
		}
		System.out.println("Damage foi " + dmg);
			
		}
		
		if(v.getWeakness()== this.A){ //Se o seu tipo de atck for igual o tipo de fraqueza do inimigo //Nessa tipo de criatura, há um bonus ainda maior caso haja weakness no inimigo
			dmg = dmg * 21;
			dmg = dmg / 10;
		System.out.println("Its Super Effective!" + dmg);
		}
		
	v.tookDMG(dmg);
	return dmg;
	}


	public void addStealth(int v){
	stealth = stealth + v;
	}

	
	public AttackType getWeakness(){
	return Weakness;
	}
}