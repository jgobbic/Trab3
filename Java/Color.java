public enum Color {
	
	blue("Blue",0,0,255),red("Red",255,0,0),green("Green",0,255,0),yellow("Yellow",255,255,0),white("White",255,255,255),black("Black",0,0,0);

	private String Name;
	private int R;
	private int G;
	private int B;
	
	Color(String n, int r,int g, int b) {
		Name = n;
		R = r;
		G = g;
		B = b;
	}
	
	public int getRed(){
		return R;
	}
	
	public int getBlue(){
		return B;
	}
	
	public int getGreen(){
		return G;
	}
	
	public String getName(){
		return Name;
	}
}