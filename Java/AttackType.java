public enum AttackType { //Tipos de atacks
	
	Fire("Fire",0),Poison("Poison",1),Physical("Physical",2),Piercing("Piercing",3); // Nome e id para facilitar identificacao

	private String Type;
	private int id;
	
	AttackType(String n, int ident) {
		Type = n;
		id = ident;
	}
	
	public int getId(){
		return id;
	}
	
	public String getType(){
		return Type;
	}
}