package Item;

import java.util.*;

public class Inventory{
	
	private int posicao_encontrado;
	private int spaces;
	private Vector<Item> Items; //Inventorio ainda possui uma lista de ITENS, entretanto cada item possui um status booleano se esta equipado ou nao, para implementar como foi pedido, um sistema de "itens equipados para contar nos atk e def"
	private double gold;
	
	private int Nr_armors_equiped; //faz o controle de numero de armaduras equipadas
	private int Nr_weapons_equiped;//faz o controle de numero de armas equipadas

	public Inventory(){
		spaces = 0;
		gold = 0.0;
		Items = new Vector<Item>(); 
		posicao_encontrado = -1;
		
		Nr_armors_equiped = 0;
		Nr_weapons_equiped = 0;
		
		}	
	public double getTotalGold(){
		return gold;
	}
	
	public void setSpaces(int v){
		spaces = v;
	}
	
	public int getAvailableSpaces(){
		return (spaces - Items.size());
	}
	
	public double spendGold(double v){
		gold=gold-v;
		return gold;
	}
	
	public double earnGold(double v){
		gold = gold+v;
		return gold;
	}

	public Item searchItem(String v){
		int i;
		String aux;
		boolean FOUND = false;
	
		for(i=0;i<Items.size();i++){
			aux = Items.elementAt(i).getName();
			if(aux.equals(v)){
				FOUND = true;
				break;
			}
		}
		if(FOUND){
			posicao_encontrado=i;
			//System.out.println("Posicao Encontrado:" + posicao_encontrado);
			return Items.elementAt(i);
		}
		else{
			posicao_encontrado=-1;
			//System.out.println("Item nao Encontrado, portanto " + posicao_encontrado);
			return null;
		}
	}
	
	
	public Item searchItem(int v){
		posicao_encontrado = v;
		if(v<0)
			v = 0;
		if(v>Items.size()-1)
			v = (Items.size() - 1);
		return Items.elementAt(v);
	}
	
	public Item insertItem(Item v){
		if(getAvailableSpaces() < 1){
			System.out.println("Nao ha espacos livres");
			return null;
		
		}
		Items.add(v);
		
		return v;
	}
	
	public String removeItem(String v){
		String aux;
		searchItem(v);
		
		if(Items.elementAt(posicao_encontrado).isEquiped()){
			System.out.println ( "Item equipado nao pode ser deletado");
			return "equipado";
		}
		
		if(posicao_encontrado>-1){
			aux = Items.elementAt(posicao_encontrado).getName();
			Items.removeElementAt(posicao_encontrado);
		
	//		System.out.println("Item "+ aux + " encontrado na posicao "+ posicao_encontrado);
	//		System.out.println("O Item " + v + " foi removido e agora na posicao dele existe:  " + Items.elementAt(posicao_encontrado).getName() );
		return v;
		}
		else{
			return "Nao Encontrado ";
		}
	}
	
	public int removeItem(int v){
		if(v<0)
			v = 0;
		if(v>Items.size()-1)
			v = (Items.size() - 1);
			
			if(Items.elementAt(posicao_encontrado).isEquiped()){
				System.out.println( "Item equipado nao pode ser deletado");
				return -1;
			}
			
		searchItem(v);
		Items.removeElementAt(posicao_encontrado);
		
		System.out.println("Item removido com Sucesso");
		
		return  posicao_encontrado;
	
	}

	
	public int calc_atk_points(){
		int i;
		int atk;
		atk = 0;
		
		for(i=0;i<Items.size();i++){
			if(Items.elementAt(i).isEquiped()){ //O item só é adicionado à conta se estiver equipado
			//System.out.println("ADICIONANDO ITEM A CONTA " + Items.elementAt(i).getName());
			atk = atk + Items.elementAt(i).getAttackPts();
			}
		}
		return atk;
	}
	
	
	public int calc_def_points(){
		int i;
		int def;
		def = 0;
		
		for(i=0;i<Items.size();i++){
			if(Items.elementAt(i).isEquiped()){ //O item só é adicionado à conta se estiver equipado
			//System.out.println("ADICIONANDO ITEM A CONTA " + Items.elementAt(i).getName());
				def = def + Items.elementAt(i).getDefensePts();
				}
		}
		return def;
	}
	
	public void equipArmor(String name){
		if(Nr_armors_equiped>0){
			System.out.println("Ja possui uma armor equipada");
			return;
		}
		
		searchItem(name);
		
		if(posicao_encontrado>=0){
			Items.elementAt(posicao_encontrado).equip();
			Nr_armors_equiped++;
		}
	}
	
	public void equipWeapon(String name){
		if(Nr_weapons_equiped>1){
			System.out.println("Ja possui o maximo de armas equipadas");
			return;
		}
		
		searchItem(name);
		
		if(posicao_encontrado>=0){
		Items.elementAt(posicao_encontrado).equip();
		Nr_weapons_equiped++;
		}
	}
	
	public void unequipArmor(String name){
		searchItem(name);
		System.out.println("Unequiping" + name);
		
		if(posicao_encontrado>=0){
			Items.elementAt(posicao_encontrado).unequip();
			Nr_armors_equiped--;
		}
	}
	
	public void unequipWeapon(String name){
		searchItem(name);
		System.out.println("Unequiping" + name);
		
		if(posicao_encontrado>=0){
			Items.elementAt(posicao_encontrado).unequip();
			Nr_weapons_equiped--;
		}
	}
	
	
	
	
}