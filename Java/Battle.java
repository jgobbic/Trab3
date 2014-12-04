//Thread battle eh um thread de batalhar de time contra time

class Battle extends Thread {
	Team A;
	Team B;
	public Battle(Team A, Team B) {
	this.A= A;
	this.B=B;
	}

	public void run() {
	System.out.println("Starting");

	A.letsBattle(B);
	B.letsBattle(A);
	}
	
	public Team getA(){
		return A;
	}
	public Team getB(){
		return B;
	}

}
