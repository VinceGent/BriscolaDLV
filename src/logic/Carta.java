package logic;

import javafx.scene.image.Image;

public class Carta {
	
	private int id;
	private String seme;
	private int valore;
	private Image img;
	
	public Carta(int id, String seme, int valore, Image img){
		this.setId(id);
		this.setSeme(seme);
		this.setValore(valore);
		this.setImg(img);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeme() {
		return seme;
	}

	public void setSeme(String seme) {
		this.seme = seme;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	

}
