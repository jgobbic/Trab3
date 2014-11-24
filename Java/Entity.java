public interface Entity{
//	public abstract void attack();
	public abstract int getHP();
	public abstract int tookDMG(int v);
	public abstract int releaseXp();
	public abstract boolean isDead();
	public abstract int getDefensePoints();
	public abstract AttackType getWeakness();

}