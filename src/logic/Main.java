package logic;

import gui.CustomGridPane;
import javafx.animation.AnimationTimer;
import jdlv.CartaDaGiocareJDLV;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final BriscolaManager  b = new BriscolaManager();
		//b.nuovaPartita(g1, g2);
		System.out.println("la briscola è : "+ b.getBriscola().getId() + "  " + b.getBriscola().getSeme());
		
		Giocatore eliana = b.getG1();
		Giocatore carlo = b.getG2();
		

		
		for (Carta c : eliana.getMieCarte()) {
			System.out.println("Eliana ha in mano " + c.getId() + "  " + c.getSeme());
		}
		for (Carta c : carlo.getMieCarte()) {
			System.out.println("Carlo ha in mano " + c.getId() + "  " + c.getSeme());
		}
		
		new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				if(b.getTurno() == 0){
					if(b.getBanco().isEmpty()){
						System.out.println("entro nel vuoto");
						b.getIntelligenzaBancoVuoto().gioca();
						if(b.getIntelligenzaBancoVuoto().getSoluzione().size() >0){
							CartaDaGiocareJDLV sol = b.getIntelligenzaBancoVuoto().getSoluzione().get(0);
							for(Carta c : b.getG1().getMieCarte()){
								if(c.getId() == sol.getId() && c.getSeme().equals(sol.getSeme())){
									if(b.gioca(c))
										CustomGridPane.aggiorna();
								}
							}
						}
					}
				}
				
			}
		}.start();
	}
}
