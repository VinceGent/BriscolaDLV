package jdlv;

public class BancoJDLV {
	private int id;
	private String seme;
	
	public BancoJDLV() {
	}
	public BancoJDLV(int id, String seme){
		this.setId(id);
		this.setSeme(seme);
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
