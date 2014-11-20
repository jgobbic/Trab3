class Wizard extends Character{
	protected int wisdom;
	
	
	
	
	public Wizard(String nome, int wsd){ //No driagrama construtor estava com nome errado
	super(nome);
	wisdom = wsd;
	}
	
	protected int getDefensePoints(){
		double DEF;
		DEF = (0.6*this.constitution + 0.1*this.dexterity + 0.3*this.speed) + item_def_points ; 
		DEF = DEF *XP;
		DEF = DEF/6;
//		System.out.println("Defesa pts foi: " + DEF);
		return (int)DEF + (wisdom)/2;
	}
	
	protected int getAttackPoints(){
		double ATK;
		ATK = (0.6*this.strenght + 0.1*this.dexterity) + item_att_points; 
		ATK = ATK *XP;
		ATK = ATK/2;
//		System.out.println("ATK pts foi: " + ATK);
		return (int)ATK;
	}
	
	
	

	public int attackCharacter(Character v){
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
	v.tookDMG(dmg);
	return dmg;
	}


	public void addWisdom(int v){
	wisdom = wisdom + v;
	}

}