package gui;

import javafx.application.Platform;
import jdlv.CartaDaGiocareJDLV;
import logic.BriscolaManager;
import logic.Carta;

public class AIThread extends Thread {
	
	private static CustomGridPane principale;
	private BriscolaManager manager;
	
	public AIThread(CustomGridPane p , BriscolaManager b) {

		AIThread.principale = p;
		manager = b;
		
	}
	
	@Override
	public void run() {
		
		System.out.println("inizio la partita");
		while(manager.finePartita() == -1){
			System.out.println("nel while il turno è " + manager.getTurno());
			if(manager.getTurno() == 0 && manager.getBanco().size() < 2){
				System.out.println("tocca a tia joca");
				 if(manager.getBanco().size() >0){
					System.out.println("AI risponde alla giocata");
//					rispondiAllaGiocata();
					
				}else if(manager.getBanco().isEmpty()){ //banco == 0
					System.out.println("tocca ad AI e gioca");
//					giocaBancoVuoto();
				}
			}
			

			if(manager.getBanco().size() == 2){
				try {
					sleep(7000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				manager.controllaGiocata();
				
			}
			
			try {
				sleep(5000);
//				Platform.runLater(this);
//				notifica();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	} 
	
	public static void notifica(){
		System.out.println("notifico");
		System.out.println("Aggiorno!!");
		principale.aggiorna();
	}
	
	private void rispondiAllaGiocata(){
		manager.getIntelligenza().gioca();
		if(manager.getIntelligenza().getSoluzione().size() > 0){
			CartaDaGiocareJDLV sol = manager.getIntelligenza().getSoluzione().get(0);
			Carta cartaLogic = null;
			for (Carta c : manager.getG1().getMieCarte()) {
				if( c.getId() == sol.getId() && c.getSeme().equals(sol.getSeme())){
				/*	if(manager.gioca(c)){
						//aggiorna();
						System.out.println("Turno di: "+manager.getTurno());
					} */
					cartaLogic = c;
				}
			}
			if(cartaLogic != null && manager.gioca(cartaLogic))
				System.out.println("ho giocato");
		}
	}
	
	private void giocaBancoVuoto(){
		manager.getIntelligenzaBancoVuoto().gioca();
		if(manager.getIntelligenzaBancoVuoto().getSoluzione().size() > 0){
			CartaDaGiocareJDLV sol = manager.getIntelligenzaBancoVuoto().getSoluzione().get(0);
			Carta cartaLogic = null;
			for (Carta c : manager.getG1().getMieCarte()) {
				if( c.getId() == sol.getId() && c.getSeme().equals(sol.getSeme())){
				/*	if(manager.gioca(c)){
						//aggiorna();
						System.out.println("Turno di: "+manager.getTurno());
					} */
					cartaLogic = c;
				}
			}
			if(cartaLogic != null && manager.gioca(cartaLogic))
				System.out.println("ho giocato");
		}
	}
	

}
