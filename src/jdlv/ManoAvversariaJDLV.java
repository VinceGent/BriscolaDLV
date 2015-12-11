package jdlv;

public class ManoAvversariaJDLV {
private int id;
private String seme;

	public ManoAvversariaJDLV() {
	}
	
	public ManoAvversariaJDLV(int id, String seme){
		this.setId(id);
		this.setSeme(seme);
	}

	public String getSeme() {
		return seme;
	}

	public void setSeme(String seme) {
		this.seme = seme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
