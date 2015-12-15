package logic;

import java.util.ArrayList;
import java.util.List;

public class Giocatore {

	private int punteggio = 0;
	private List<Carta> mieCarte;
	private List<Carta> cartePrese;
	
	
	public Giocatore() {
		
		this.setCartePrese(new ArrayList<Carta>());
		this.setMieCarte(new ArrayList<Carta>());
		
	}


	public int getPunteggio() {
		return punteggio;
	}


	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}


	public List<Carta> getMieCarte() {
		return mieCarte;
	}


	public void aggiungiCartaInMano(Carta c){
		if(!mieCarte.contains(c))
			mieCarte.add(c);
	}
	public void aggiungiCartaPresa(Carta c){
		if(!cartePrese.contains(c)){
			cartePrese.add(c);
			punteggio+= c.getValore();
		}
	}
	
	public void setMieCarte(List<Carta> mieCarte) {
		this.mieCarte = mieCarte;
	}


	public List<Carta> getCartePrese() {
		return cartePrese;
	}


	public void setCartePrese(List<Carta> cartePrese) {
		this.cartePrese = cartePrese;
	}
}
