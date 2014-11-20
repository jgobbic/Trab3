package Item;

public abstract class Item{
	private String name;
	private double price;
	private boolean equipado; //Bolean que diz se item esta equipado ou nao.
	
	public Item(String nome, double valor){
	name=nome;
	price = valor;
	equipado = false;
	}
	
	public Item(Item i){
		name = i.getName();
		price = i.getPrice();
		equipado = false;
	}
	
	public String getName(){
				//System.out.println("Item Acessado em getName:" + name + "/" + price + "/" + attackpts + "/" + defensepts);
		return name;
	}
	
	public double getPrice(){
		//System.out.println("Item Acessado em getPrice:" + name + "/" + price+ "/" + attackpts+ "/" + defensepts);
		return price;
	}
	
	public boolean isEquiped(){
		return equipado;
	}
	public void equip(){
		equipado = true;
	}
	public void unequip(){
		equipado = false;
	}
	
	public abstract int getPts(); //É um getPts mais geral, retorna o pontos de qualquer item (inclusive pocao)
	public int getAttackPts(){return 0;}; //soh funciona pra armor
	public int getDefensePts(){return 0;}; //soh funciona para weapon
	
	public int use(){
	return 1;}
	
	public double getWeight(){
		return 1;
	}
	
}