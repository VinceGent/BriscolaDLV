package jdlv;

public class CartaJDLV {
	private int id;
	private String seme;
	private int valore;
	
	public CartaJDLV() {
	}
	
	public CartaJDLV(int id, String seme, int valore){
		this.setId(id);
		this.setSeme(seme);
		this.setValore(valore);
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

}
