package logic;

import java.util.HashMap;

public class BriscolaManager {

	private Mazzo mazzo;
	private Giocatore g1;
	private Giocatore g2;
	private Carta briscola;
	private int turno = 0;
	private int punteggioG1 = 0;
	private int punteggioG2 = 0;
	private HashMap<Integer, Carta> banco;
	
	public BriscolaManager() {
		
		this.setMazzo(new Mazzo());
		this.setG1(new Giocatore());
		this.setG2(new Giocatore());
		this.setBanco(new HashMap<Integer, Carta>());
		
	}
	
	public void nuovaPartita(){
		
		this.mazzo = new Mazzo();
		this.mazzo.mischiaMazzo();
		g1.setPunteggio(0);
		g2.setPunteggio(0);
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
			System.out.println("else");
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
	}
	
	public void gioca(Carta c){
		System.out.println("Gioco !!");
		if(turno == 0){
			if(g1.getMieCarte().contains(c)){
					getBanco().put(0, c);
					g1.getMieCarte().remove(c);
					cambiaTurno();
			}
		}else{
			if (g2.getMieCarte().contains(c)) {
					getBanco().put(1, c);
					g2.getMieCarte().remove(c);
					cambiaTurno();
			}
		}
		
		if (controllaGiocata()) {
			System.out.println("seh giustoh");
		}
	}
	
	public boolean controllaGiocata(){
		if(getBanco().size() == 2){
			Carta cartaG1 = getBanco().get(0);
			Carta cartaG2 = getBanco().get(1);
			
			if(cartaG1.getSeme() == briscola.getSeme()){
				if(cartaG2.getSeme() != briscola.getSeme()){
					//prende g1
					g1.aggiungiCartaPresa(cartaG1);
					g1.aggiungiCartaPresa(cartaG2);
				}else{
					//controllo 2 carte briscola
					if(cartaG1.getValore() > cartaG2.getValore()){
						g1.aggiungiCartaPresa(cartaG1);
						g1.aggiungiCartaPresa(cartaG2);
					}else if(cartaG1.getValore() == 0 && cartaG1.getId() > cartaG2.getId()){
						g1.aggiungiCartaPresa(cartaG1);
						g1.aggiungiCartaPresa(cartaG2);
					}else{
						g2.aggiungiCartaPresa(cartaG1);
						g2.aggiungiCartaPresa(cartaG2);
					}
				}
			}else{
				if(cartaG2.getSeme() == briscola.getSeme()){
					//piglie g2
					g2.aggiungiCartaPresa(cartaG1);
					g2.aggiungiCartaPresa(cartaG2);
					
				}else if (turno == 0){
					
					if(cartaG1.getSeme() != cartaG2.getSeme()){
						// piglie g1
						g1.aggiungiCartaPresa(cartaG1);
						g1.aggiungiCartaPresa(cartaG2);
					}else{
						if(cartaG1.getValore() > cartaG2.getValore()){
							// piglie g1
							g1.aggiungiCartaPresa(cartaG1);
							g1.aggiungiCartaPresa(cartaG2);
						}else if(cartaG1.getValore() == 0 && cartaG1.getId() > cartaG2.getId()){
							//pigli g1
							g1.aggiungiCartaPresa(cartaG1);
							g1.aggiungiCartaPresa(cartaG2);
						}
						else{
							//piglie g2
							g2.aggiungiCartaPresa(cartaG1);
							g2.aggiungiCartaPresa(cartaG2);
						}
					}
				}else{
					//turno == 1
					if (cartaG2.getValore() > cartaG1.getValore()) {
						g2.aggiungiCartaPresa(cartaG1);
						g2.aggiungiCartaPresa(cartaG2);
					}else if(cartaG2.getValore() == 0 && cartaG2.getId() > cartaG1.getId()){
						g2.aggiungiCartaPresa(cartaG1);
						g2.aggiungiCartaPresa(cartaG2);
					}else{
						//piglie g2
						g1.aggiungiCartaPresa(cartaG1);
						g1.aggiungiCartaPresa(cartaG2);
					}
				}
			}
			getBanco().clear();
			return true;
			// fine if del banco == 2
		}
		return false;
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
	
	
	
}
