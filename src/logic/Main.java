package logic;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BriscolaManager briscola = new BriscolaManager();
		briscola.nuovaPartita();
		
		System.out.println("la briscola è : "+ briscola.getBriscola().getId() + "  " + briscola.getBriscola().getSeme());
		
		Giocatore eliana = briscola.getG1();
		Giocatore carlo = briscola.getG2();
		
		for (Carta c : eliana.getMieCarte()) {
			System.out.println("Eliana ha in mano " + c.getId() + "  " + c.getSeme());
		}
		for (Carta c : carlo.getMieCarte()) {
			System.out.println("Carlo ha in mano " + c.getId() + "  " + c.getSeme());
		}
		
		
		
		
	}

}
