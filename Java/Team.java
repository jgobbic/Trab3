import java.util.*;

public class Team{
	private String name;
	private Color color;
	private int win;
	private int lose;
	private int draw;
	private Vector<Character> characters;
	
	public Team(String nome, Color cor){
		name = nome;
		color = cor;
		win = 0;
		lose = 0;
		draw = 0;
		
		characters = new Vector<Character>();
		
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
	


}