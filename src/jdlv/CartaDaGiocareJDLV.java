package jdlv;

public class CartaDaGiocareJDLV {
	
	private int id;
	private String seme;
	
	public CartaDaGiocareJDLV() {
	}
	
	public CartaDaGiocareJDLV(int id , String seme) {
		this.id = id;
		this.seme = seme;
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

}
