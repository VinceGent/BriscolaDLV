package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.scene.image.Image;

public class Mazzo {

	private List<Carta> mazzo;
	private List<String> semi;
	private List<Integer> valori;
	
	public Mazzo(){
		this.setMazzo(new ArrayList<Carta>());
		this.semi = new ArrayList<String>();
		this.valori = new ArrayList<Integer>();
		inizializzaSemi();
		inizializzaValori();
		creaCarte();

	}
	
	private void creaCarte(){
		
		for (int i = 0; i < semi.size(); i++) {
			for (int j = 0; j < valori.size(); j++) {
				String immagine = "file:img/"+ Integer.toString(j+1)+ semi.get(i)+".png";
//				Image img = new Image(immagine);
				getMazzo().add(new Carta(j+1, semi.get(i), valori.get(j), immagine));
			}
		}
		

	}
	
	private void inizializzaValori(){
		valori.add(11);
		valori.add(0);
		valori.add(10);
		valori.add(0);
		valori.add(0);
		valori.add(0);
		valori.add(0);
		valori.add(2);
		valori.add(3);
		valori.add(4);
	}
	private void inizializzaSemi(){
		semi.add("denari");
		semi.add("bastoni");
		semi.add("coppe");
		semi.add("spade");
	}

	public void mischiaMazzo(){
		long seed = System.nanoTime();
        Collections.shuffle(mazzo, new Random(seed));
	}
	
	public static void main(String[] args) {
	/*	
		Mazzo mazzo = new Mazzo();
//		mazzo.mischiaMazzo();
		for (Carta c : mazzo.getMazzo()) {
			System.out.println(c.getId() + "  " + c.getSeme() + "  "+ c.getValore());
		}
		*/
	}

	public List<Carta> getMazzo() {
		return mazzo;
	}

	public void setMazzo(List<Carta> mazzo) {
		this.mazzo = mazzo;
	}
	
	
}
