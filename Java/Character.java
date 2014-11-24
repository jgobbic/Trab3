import java.util.*;
import Item.*;

public abstract class Character implements Entity{
	
	private String alias;
	private Inventory myitems;
	private int HP;
	protected int XP;
	private int MP;
	protected int strenght;
	protected int speed;
	protected int dexterity;
	protected int constitution;
	private int power;
	private int accuracy;
	private boolean morto;
	
	protected int item_att_points;
	protected int item_def_points;

	
	public Character(String name){
		alias = name;
		HP = 100;
		XP = 0;
		strenght = 1;
		speed = 1;
		dexterity = 1;
		constitution = 1;
		morto = false;
		myitems = new Inventory();
	}
	
	
	
	private void checkSkills(){
		//System.out.println("Skill Checking");
		if((strenght+speed+dexterity+speed)> 100){
			System.out.println("Soma dos skills do eh maior que 100, setando todos os skills para 25");
			strenght=25;
			speed = 25;
			dexterity = 25;
			constitution = 25;
		}
	}
	
	protected void recalculateItems(){
		item_att_points = myitems.calc_atk_points();
		item_def_points = myitems.calc_def_points();
	
	}
	
	public int getDefensePoints(){
		recalculateItems();
		double DEF;
		DEF = (0.6*this.constitution + 0.1*this.dexterity + 0.3*this.speed) + item_def_points ; 
		DEF = DEF *(XP/6);
		return (int)DEF;
	}
	
	protected int getAttackPoints(){
		recalculateItems();
		double ATK;
		ATK = (0.6*this.strenght + 0.1*this.dexterity) + item_att_points; 
		ATK = ATK *(XP/2);
		return (int)ATK;
	}
	
	public String getName(){
		return alias;
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
	v.tookDMG(dmg);
	return dmg;
	}
	
	public int tookDMG(int v){
		HP = HP-v;
		System.out.println("HP" + HP);
		if(HP<1)
			morto=true;
		return HP;
	}
	
	public int getHP(){
		return HP;
	}
	
	public void addXP(int v){
		XP = XP + v;
		System.out.println("XP " + XP);
	}
	
	public int releaseXp(){
		int exp;
		exp = XP/10;
		if(exp<1)
			exp=1;
		
		return exp;
	}
	
	public void addHP(int v){
		HP = HP + v;
	
	}
	
	public boolean isDead(){
		return morto;
	}
	
	public void addMP(int v){
		MP = MP + v;
	}
	
	public void setStrenght(int v){
		strenght = v;
		checkSkills();
		System.out.println("STR " + strenght);
	}
	
	public void setSpeed(int v){
		speed = v;
		checkSkills();
		System.out.println("SPEED " + speed);
	}
	
	public void setDexterity(int v){
		dexterity= v;
		checkSkills();
		System.out.println("DXT " + dexterity);
	}
	
	public void setConstitution(int v){
		constitution = v;
		checkSkills();
		System.out.println("CONST " + constitution);
	}
	
	public void earnGold(double v){
		myitems.earnGold(v);
	}
	
	public void setSpaces(int v){
		myitems.setSpaces(v);
	}
	
	//INSERTS
	
	public void insertItem(Item v){
		System.out.println("Adicionando item: " + v.getName());
		if(myitems.insertItem(v)!=null){
			//CALCULA O NOVO SPEED
			double w = myitems.searchItem(v.getName()).getWeight();
			w = Math.sqrt(w)/10;
			w = speed * w;
			speed = (int)w;
		}
		recalculateItems();
	}
	
	public Item searchItem(String v){
		return myitems.searchItem(v);
	}
	
	public Item searchItem(int v){
		return myitems.searchItem(v);
	}
	
	public String removeItem(String v){
		String r = myitems.removeItem(v);
		
		//CALCULA O NOVO SPEED
        double w = myitems.searchItem(v).getWeight();
		double e = speed*10;
		e = e/Math.sqrt(w);
		speed = (int)e;
		
		recalculateItems();
		return r;
	}
		
	public int removeItem(int v){
		int r =  myitems.removeItem(v);
		
		//CALCULA O NOVO SPEED
        double w = myitems.searchItem(v).getWeight();
		double e = speed*10;
		e = e/Math.sqrt(w);
		speed = (int)e;
		
		recalculateItems();
		return r;
	}

	//(UN)EQUIPS//
		//Toda arma precisa ser equipada ou desequipada para ser somado (ou deixar de ser) aos itens de dano ou armadura
		//Nao eh possivel equipar mais de 2 armas ou 1 armadura
	
	public void equipArmor(String name){
		myitems.equipArmor(name);
		recalculateItems();
	}
	
	public void equipWeapon(String name){
		myitems.equipWeapon(name);
		recalculateItems();
	}
	
	public void unequipArmor(String name){
		myitems.unequipArmor(name);
		recalculateItems();
	}
	
	public void unequipWeapon(String name){
		myitems.unequipWeapon(name);
		recalculateItems();

	}
	
	public void usePotion(String name){
		if(myitems.searchItem(name) != null){
			System.out.println("Usando Pocao");
			int heal = myitems.searchItem(name).use(); //Se o valor retornado pelo use for positivo, é uma poscao de vida, se negativo, de mana;
			if(heal>0)
				addHP(heal);
			if(heal<0)
				addMP(-1*heal);
			myitems.removeItem(name);
			System.out.println("Vida adicionado com sucesso");
		}else 
		System.out.println("Pocao inexistente no inventario");
	}
}
	
	