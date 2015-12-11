package logic;

public class BriscolaManager {

	private Mazzo mazzo;
	private Giocatore g1;
	private Giocatore g2;
	private Carta briscola;
	private int turno = 0;
	
	public BriscolaManager() {
		
		this.mazzo = new Mazzo();
		this.g1 = new Giocatore();
		this.g2 = new Giocatore();
		
	}
	
	
	
}
