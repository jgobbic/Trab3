import java.util.*;

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
		characters.add(c);
	
	}
	
	public void removeChar(Character c){
		characters.remove(c);
	}
	
	public void removeChar(int c){
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
	
	/*
	//Metodos para serem iteraveis//
	public Iterator<Character> iterator(){
		private int currentIndex = 0;
		
		public boolean hasNext(){
			return characters.elementAt(0).hasNext();
		}
		
		public Character next(){
			currentIndex++;
			return characters.elementAt(0);
		
		}
	
		public void remove(){}
	};
	return it;
	**/
	
	
	
	public int letsBattle(Team L){
	
		Vector<Character> lista = this.getList();
		Iterator<Character> itr = lista.iterator();
		
		Iterator<Character> itr2 = L.getList().iterator();
		while(itr2.hasNext()){
			letsBattle(itr2.next());
		}
		return 0;
	
	}
	
	public int letsBattle(Entity L){
		Vector<Character> lista = this.getList();
		Iterator<Character> itr = lista.iterator();
		
		while( itr.hasNext() ){
			itr.next().attack(L);
			if(L.isDead()){
				//OQUE ACONTECE QUANDO TA MORTO
			return 1;
			}
		}
	return 0;
	}
	


}