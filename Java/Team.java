import java.util.*;
import Item.*;

public class Team{
	private String name;
	private Color color;
	private int win;
	private int lose;
	private int draw;
	private Vector<Character> characters;
	
	private int index;
	private int size;
	
	public Team(String nome, Color cor){
		name = nome;
		color = cor;
		win = 0;
		lose = 0;
		draw = 0;
		
		characters = new Vector<Character>();
		index = 0;
		
	}
	
	public String getName(){
		return name;
	}
	
	public String getResults(){
		String xtring = new String("Win: " + win + " Lose: " + lose + " Draw: " + draw);
		
		return xtring;
	}
	
	public String toString(){
		return name + " " +color.getName() ;
	}
	
	public int getPoints(){
		int i;
		int media = 0;
		for(i=0;i<characters.size();i++){
			media = media + characters.elementAt(i).getHP();
		}
		media = media/characters.size();
		
		return media;
	
	}
	
	public void addChar(Character c){
		size++;
		characters.add(c);
	
	}
	
	public void removeChar(Character c){
		size--;
		characters.remove(c);
	}
	
	public void removeChar(int c){
		size--;
		characters.remove(c);
	}
	
	public Character searchChar(String c){
		int i;
		
		for(i=0;i<characters.size();i++){
		if (characters.elementAt(i).getName() == c)
			return characters.elementAt(i);
		}
		return null;
	}
	
	Vector<Character> getList(){
	
		return characters;
	}
	
	public void resolveBattle(Team B){
	
		if(this.getPoints()>B.getPoints()){
			win++;
			
			System.out.println(this.getName() + " ganhou de " + B.getName());
		}
		
		if(this.getPoints()<B.getPoints()){
			lose++;
			
			System.out.println(this.getName() + " perdeu de " + B.getName());
		}
		
		if(this.getPoints()==B.getPoints()){
			draw++;
			
			System.out.println(this.getName() + " empatou com " + B.getName());
		}
	
	}
	
	
	private void receiveXp(int v){ //divide uma xp recebida pelo time pelos personagens do time
		
		
		int w = v/(characters.size() + 1);	
		
		System.out.println("Personagens do time " + this.getName() + " receberam " + v + " de xp, que divido pelo time foi " + w + " por pesonagem");
		
		Iterator<Character> itr = characters.iterator();
		while( itr.hasNext() ){
			itr.next().addXP(w);
		}
		
	}
	
	
	private void receiveDrop(Item d){ //da um item recebido para alguem aleatorio do time
	
		int chance = (int)( Math.random() * (size+1)); //sorteia um dos player para receber
		characters.elementAt(chance).insertItem(d);
		System.out.println("Character " + characters.elementAt(chance).getName() + " recebeu o item dropado " + d.getName() );
	}
	
	
	
	public int letsBattle(Team L){//time atacando outro time
	
		Vector<Character> lista = this.getList();
		Iterator<Character> itr = lista.iterator();
		Iterator<Character> itr2 = L.getList().iterator();
		
		while(itr2.hasNext()){//O time(todos os personagens, vide o outro letsBattle) ataca todos os personagens do outro time
			letsBattle(itr2.next()); //chama o metodo letsBattle(Entity) que eh diferente deste.
		}
		return 0;
	}
	
	
	public int letsBattle(Entity L){//ataca uma criatura ou outro char
		Vector<Character> lista = this.getList();
		Iterator<Character> itr = lista.iterator();
		Item drop;	
		
		while( itr.hasNext() ){ //todos os personagens desse time atacam
			itr.next().attack(L);
			if(L.isDead()){ //so continuará atacando se a criatura estiver viva, e caso ela tenha morrido, algumas coisa acontecem
				System.out.println("Time " + this.getName() + " derrotou " + L.getName() );//avisa que a criatura ou player foi morta pelo time
				if(L instanceof Creature){ //teste se eh uma criatura, para assim dropar xp e dropar itens
					this.receiveXp( L.releaseXp() ); //Divide e insere a xp para o time
					drop = L.Drop();//recebe o item dropado
					if(drop!=null){//e apenas se o item nao for null (caso a ChanceToGet nao tenha dropado o item, ou a criatura nao tenha itens)
						this.receiveDrop(drop);
					}else{System.out.println("Nenhum item dropado");}
					
				}
				
			return 1;//matou o inimigo
			}
		}
	return 0;//nao matou
	}
	


}