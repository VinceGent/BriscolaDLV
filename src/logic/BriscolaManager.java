package logic;

import gui.CustomGridPane;

import java.util.HashMap;

import jdlv.BancoVuotoAI;
import jdlv.BriscolaAI;

public class BriscolaManager {

	private Mazzo mazzo;
	private Giocatore g1;
	private Giocatore g2;
	private Carta briscola;
	private int turno = 1;
	private int giocoMano = 1;
	private int punteggioG1 = 0;
	private int punteggioG2 = 0;
	private HashMap<Integer, Carta> banco;
	private BriscolaAI intelligenza;
	private BancoVuotoAI intelligenzaBancoVuoto;
	
	public BriscolaManager() {
		
		this.setMazzo(new Mazzo());
//		this.setG1(new Giocatore());
//		this.setG2(new Giocatore());
		this.setBanco(new HashMap<Integer, Carta>());
		
	}
	
	public void nuovaPartita(String g1, String g2){
		
		this.mazzo = new Mazzo();
		this.mazzo.mischiaMazzo();
		this.setG1(new Giocatore(g1));
		System.out.println("g1 è : " + this.g1.getNome());
		this.setG2(new Giocatore(g2));
		System.out.println("g2 è : "+ this.g2.getNome());
		this.g1.setPunteggio(0);
		this.g2.setPunteggio(0);
		if(turno == 0){
			for (int i = 0; i < 3; i++) {
				this.g1.aggiungiCartaInMano(mazzo.getMazzo().get(0));
				this.mazzo.getMazzo().remove(0);
			}
			for (int i = 0; i < 3; i++) {
				this.g2.aggiungiCartaInMano(mazzo.getMazzo().get(0));
				this.mazzo.getMazzo().remove(0);
			}
		}
		else{
			for (int i = 0; i < 3; i++) {
				this.g2.aggiungiCartaInMano(mazzo.getMazzo().get(0));
				this.mazzo.getMazzo().remove(0);
			}
			for (int i = 0; i < 3; i++) {
				this.g1.aggiungiCartaInMano(mazzo.getMazzo().get(0));
				this.mazzo.getMazzo().remove(0);
			}
		}
		
		this.briscola = mazzo.getMazzo().get(0);
		this.mazzo.getMazzo().remove(0);
		
		this.intelligenza = new BriscolaAI(this);
		this.intelligenzaBancoVuoto = new BancoVuotoAI(this);
		
	}
	
	public boolean gioca(Carta c){
		if(turno == 0){
			if(g1.getMieCarte().contains(c)){
					getBanco().put(0, c);
					g1.getMieCarte().remove(c);
					cambiaTurno();
					return true;
			}
		}else{
			if (g2.getMieCarte().contains(c)) {
					getBanco().put(1, c);
					g2.getMieCarte().remove(c);
					cambiaTurno();
					return true;
			}
		}
		return false;
	/*	if (controllaGiocata()) {
			//System.out.println("seh giustoh");
			return true;
		}else 
			return false; */ 
	}
	
	public boolean controllaGiocata(){
		System.out.println("È il turno di "+ turno);
		System.out.println("ha iniziato la mano " + giocoMano);
	
		if(getBanco().size() == 2){
			
			Carta cartaG1 = getBanco().get(0);
			Carta cartaG2 = getBanco().get(1);
			System.out.println("g1 ha giocato: "+cartaG1.getId() + "  " + cartaG1.getSeme());
			System.out.println("G2 ha giocato: "+cartaG2.getId() + "  " + cartaG2.getSeme());
			
			if(cartaG1.getSeme() == briscola.getSeme()){
				if(cartaG2.getSeme() != briscola.getSeme()){
					//prende g1
					System.out.println(" prende G1 con una briscola ");
					g1.aggiungiCartaPresa(cartaG1);
					g1.aggiungiCartaPresa(cartaG2);
					turno = 0;
					giocoMano = 0;
				}else{
					System.out.println("controllo 2 briscole a terra");
					//controllo 2 carte briscola
					if(cartaG1.getValore() > cartaG2.getValore()){
						System.out.println("prende g1 con briscola piu alta");
						g1.aggiungiCartaPresa(cartaG1);
						g1.aggiungiCartaPresa(cartaG2);
						turno = 0;
						giocoMano = 0;
					}else if(cartaG1.getValore() == 0 && cartaG2.getValore() == 0 && cartaG1.getId() > cartaG2.getId()){
						System.out.println("prende g1 con briscola piu alta parte 2");
						g1.aggiungiCartaPresa(cartaG1);
						g1.aggiungiCartaPresa(cartaG2);
						turno = 0;
						giocoMano = 0;
					}else{
						System.out.println("prende g2 con briscola migliore");
						g2.aggiungiCartaPresa(cartaG1);
						g2.aggiungiCartaPresa(cartaG2);
						turno = 1;
						giocoMano = 1;
					}
				}
			}else{
				if(cartaG2.getSeme() == briscola.getSeme()){
					//prende g2
					System.out.println("prende G2 con briscola");
					g2.aggiungiCartaPresa(cartaG1);
					g2.aggiungiCartaPresa(cartaG2);
					turno = 1;
				}else if (giocoMano == 0){
					
					if(cartaG1.getSeme() != cartaG2.getSeme()){
						System.out.println("prende g1 con il turno a favore e carte diverse");
						// prende g1
						g1.aggiungiCartaPresa(cartaG1);
						g1.aggiungiCartaPresa(cartaG2);
						turno = 0;
						giocoMano = 0;
					}else{
						System.out.println("carte sul banco stesso seme non briscola");
						if(cartaG1.getValore() > cartaG2.getValore()){
							// prende g1
							System.out.println("prende G1 con carta migliore");
							g1.aggiungiCartaPresa(cartaG1);
							g1.aggiungiCartaPresa(cartaG2);
							turno = 0;
							giocoMano = 0;
						}else if(cartaG1.getValore() == 0 && cartaG2.getValore() == 0 && cartaG1.getId() > cartaG2.getId()){
							//prende g1
							System.out.println("prende G1 con carta migliore parte 2");
							g1.aggiungiCartaPresa(cartaG1);
							g1.aggiungiCartaPresa(cartaG2);
							turno = 0;
							giocoMano = 0;
						}
						else{
							//prende g2
							System.out.println("prende G2");
							g2.aggiungiCartaPresa(cartaG1);
							g2.aggiungiCartaPresa(cartaG2);
							turno = 1;
							giocoMano = 1;
						}
					}
				}else if(giocoMano == 1){
					//turno == 1
					System.out.println("inizia la mano " + giocoMano);
					if(cartaG1.getSeme() != cartaG2.getSeme()){
						System.out.println("prende g2 con il turno a favore e carte diverse");
						// prende g1
						g2.aggiungiCartaPresa(cartaG1);
						g2.aggiungiCartaPresa(cartaG2);
						turno = 1;
						giocoMano = 1;
					}
					else if (cartaG2.getValore() > cartaG1.getValore()) {
						System.out.println(" prende G2 con valore Migliore");
						g2.aggiungiCartaPresa(cartaG1);
						g2.aggiungiCartaPresa(cartaG2);
						turno = 1;
						giocoMano = 1;
					}else if(cartaG2.getValore() == 0 && cartaG1.getValore() == 0 && cartaG2.getId() > cartaG1.getId()){
						//prende g2
						System.out.println(" prende G2 con valore Migliore di liscio");
						g2.aggiungiCartaPresa(cartaG1);
						g2.aggiungiCartaPresa(cartaG2);
						turno = 1;
						giocoMano = 1;
					}else{
						//prende g1
						System.out.println("prende G1 con carta migliore credo");
						g1.aggiungiCartaPresa(cartaG1);
						g1.aggiungiCartaPresa(cartaG2);
						turno = 0;
						giocoMano = 0;
					}
				}
			}
			getBanco().clear();
			System.out.println("svuoto il banco");
			pesca();
			if(finePartita() != -1){
				System.out.println("Partita Finita");
			}
			return true;
			// fine if del banco == 2
		}else if(getBanco().size() == 1){
			cambiaTurno();
			return true;
		}
		return false;
	}
	
	public void pesca(){
				
		if(turno == 0){
			if(mazzo.getMazzo().size() > 0){
				g1.aggiungiCartaInMano(mazzo.getMazzo().get(0));
				mazzo.getMazzo().remove(mazzo.getMazzo().get(0));
				g2.aggiungiCartaInMano(mazzo.getMazzo().get(0));
				mazzo.getMazzo().remove(mazzo.getMazzo().get(0));
			}
			else{
				g1.aggiungiCartaInMano(mazzo.getMazzo().get(0));
				mazzo.getMazzo().remove(mazzo.getMazzo().get(0));
				g2.aggiungiCartaInMano(briscola);
				
			}
		}else{
			if(mazzo.getMazzo().size() > 0){
				g2.aggiungiCartaInMano(mazzo.getMazzo().get(0));
				mazzo.getMazzo().remove(mazzo.getMazzo().get(0));
				g1.aggiungiCartaInMano(mazzo.getMazzo().get(0));
				mazzo.getMazzo().remove(mazzo.getMazzo().get(0));
			}else{
				g2.aggiungiCartaInMano(mazzo.getMazzo().get(0));
				mazzo.getMazzo().remove(mazzo.getMazzo().get(0));
				g1.aggiungiCartaInMano(briscola);
			}
		}
		System.out.println("Pescato!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
	public int finePartita(){
		
		if(g1.getMieCarte().isEmpty() && g2.getMieCarte().isEmpty()){
			
			if(g1.getPunteggio() == g2.getPunteggio())
				return 0;
			
			if(g1.getPunteggio() > g2.getPunteggio())
				return 1;
			else
				return 2;
			
		}
		return -1;
		
	}
	
	public Mazzo getMazzo() {
		return mazzo;
	}

	public void setMazzo(Mazzo mazzo) {
		this.mazzo = mazzo;
	}

	public Giocatore getG1() {
		return g1;
	}

	public void setG1(Giocatore g1) {
		this.g1 = g1;
	}

	public Giocatore getG2() {
		return g2;
	}

	public void setG2(Giocatore g2) {
		this.g2 = g2;
	}

	public Carta getBriscola() {
		return briscola;
	}

	public void setBriscola(Carta briscola) {
		this.briscola = briscola;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getPunteggioG1() {
		return punteggioG1;
	}

	public void setPunteggioG1(int punteggioG1) {
		this.punteggioG1 = punteggioG1;
	}

	public int getPunteggioG2() {
		return punteggioG2;
	}

	public void setPunteggioG2(int punteggioG2) {
		this.punteggioG2 = punteggioG2;
	}

	public HashMap<Integer, Carta> getBanco() {
		return banco;
	}

	public void setBanco(HashMap<Integer, Carta> banco) {
		this.banco = banco;
	}
	
	private void cambiaTurno(){
		if(turno == 0) turno = 1;
		else turno = 0;
	}

	public BriscolaAI getIntelligenza() {
		return intelligenza;
	}

	public void setIntelligenza(BriscolaAI intelligenza) {
		this.intelligenza = intelligenza;
	}

	public BancoVuotoAI getIntelligenzaBancoVuoto() {
		return intelligenzaBancoVuoto;
	}

	public void setIntelligenzaBancoVuoto(BancoVuotoAI intelligenzaBancoVuoto) {
		this.intelligenzaBancoVuoto = intelligenzaBancoVuoto;
	}
	
	
	
}
