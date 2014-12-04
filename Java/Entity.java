import Item.*;
//Entity são os personagens atacaveis e que podem atacar do jogo. (ps: diferenciar de Team, que apesar de atacar e ser atacavel, não é uma entity e sim uma colecao de entities)
public interface Entity{
	public abstract int attack(Entity v);
	public abstract String getName();
	public abstract int getHP();
	public abstract int tookDMG(int v);
	public abstract int releaseXp();
	public abstract boolean isDead();
	public abstract int getDefensePoints();
	public abstract AttackType getWeakness();
	public abstract Item Drop();

}