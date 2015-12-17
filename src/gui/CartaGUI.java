package gui;

import javafx.scene.image.ImageView;
import logic.Carta;

public class CartaGUI extends ImageView {
	
	private Carta c;
	private boolean usata;
	
	public CartaGUI(Carta c) {
		super();
		this.cambiaCarta(c);
	}
	
	public void cambiaCarta(Carta c){
		this.c = c;
		this.setImage(c.getImg());
		this.usata = false;
		this.setVisible(true);
	}
	
	public Carta getC() {
		return c;
	}
	public void setC(Carta c) {
		this.c = c;
	}
	public boolean isUsata() {
		return usata;
	}
	public void setUsata(boolean usata) {
		this.usata = usata;
		this.setVisible(!usata);
	}

}
