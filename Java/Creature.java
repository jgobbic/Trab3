import java.util.*;
import Item.*;
//classe criatura eh uma Entity a qual possuem item, dropam items e soltam experienciam.
public abstract class Creature implements Entity{
	private String nome;
	private int HP;
	private int gold;
	private boolean morto;
	private AttackType A;
	private AttackType Weakness;
	
	protected int defense;
	protected int attack;	
	
	
	protected Vector<ChanceToGet> Drops;//Lista de itens que podem ser dropados;

	protected Creature(String name, int HpMax, int def, int atk, int gld){
		nome = name;
		HP = HpMax;
		defense = def;
		attack = atk;
		morto = false;
		gold = gld;
		Drops = new Vector<ChanceToGet>(); 
		A = AttackType.Physical; //por padrao, attacktype fisico
		Weakness = AttackType.Fire; //Fraqueza padrao
	}
	
	//**Métodos Getters**//
	public String getName(){return nome;}
	public int getGold(){return gold;}
	public int getHP(){return HP;}
	public boolean isDead(){return morto;}
	
	//Não há Setters e nem um popDropItem pois as criaturas devem ser feitas, e nunca mais modificadas se não batalhadas
	
	//**Métodos Implementados**//
	
	
	public void pushDropItem(Item v, double c){ //adiciona um item aos que podem ser possivelmente dropados, dada chance
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
			}
		return HP;
	}
	
	public Item Drop(){	//dropa item
		if(Drops.size()==0){return null;} //se nao houverem itens para ser dropado, retorna nulo
		
		int chance =(int)( Math.random() * ((Drops.size()))); //calcula um item aleatorio para ser dropado
		Item droped = (Item)Drops.elementAt(chance).amIGetting(); //tenta dropar o item calculado
		return( droped ); //retorna o item dropado ou nulo.
		
	}
	
	public int attack(Team L){ //metodo de uma criatura atacando outro Time
		
		Iterator<Character> itr2 = L.getList().iterator();
		
		while(itr2.hasNext()){
			attack(itr2.next()); //criatura ataca TODOS os adiversarios
		}
		return 0;
	}
	
	
	
	//**Métodos abstratos**//
	
	public abstract int releaseXp(); //retorna um numero que eh a experiencia que o personagem ou time que o matou ganha
	public abstract int attack(Entity a);//faz atacar alguma outra entity
	public abstract int getDefensePoints();//retorna a defesa, calculada difrente para os tipos de criaturas
	public abstract AttackType getWeakness();//retorna a fraqueza.
}