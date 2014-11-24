import java.util.*;
import Item.*;

public abstract class Creature implements Entity{
	private String nome;
	private int HP;
	private int gold;
	private boolean morto;
	private AttackType A;
	private AttackType Weakness;
	
	protected int defense;
	protected int attack;	
	
	
	protected Vector<ChanceToGet> Drops;

	protected Creature(String name, int HpMax, int def, int atk, int gld){
		nome = name;
		HP = HpMax;
		defense = def;
		attack = atk;
		morto = false;
		gold = gld;
		Drops = new Vector<ChanceToGet>(); //Lista de itens que podem ser dropados;
		A = AttackType.Physical; //por padrao, attacktype fisico
		Weakness = AttackType.Fire;
	}
	
	//**Métodos Getters**//
	public String getNome(){return nome;}
	public int getGold(){return gold;}
	public int getHP(){return HP;}
	public boolean isDead(){return morto;}
	
	//Não há Setters e nem um popDropItem pois as criaturas devem ser feitas, e nunca mais modificadas se não batalhadas
	
	//**Métodos Implementados**//
	public void pushDropItem(Item v, Double c){ 
			if(c<0.01) c= 0.01;//minimo de 1% de chance de drop;
			if(c>1.0) c= 1.0;	//maximo de 100% de chance de drop;
			ChanceToGet A = new ChanceToGet(c,v);
			Drops.add(A);
			System.out.println("Item " + v.getName() + " adicionado com sucesso aos drops");
	}	
	
	public int tookDMG(int v){
		HP = HP-v;
		System.out.println("HP" + HP);
		if(HP<1){
			morto=true;
			//FAZER DROPS
			}
		return HP;
	}
	
	public Item Drop(){return null;}//IMPLEMENTAR
	
	//**Métodos abstratos**//
	public abstract int releaseXp();
	public abstract int attack(Entity a);
	public abstract int getDefensePoints();
	public abstract AttackType getWeakness();
}