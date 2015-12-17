package gui;

public class ManagerAggiornamento {
	
	private static CustomGridPane principale;
	
	public ManagerAggiornamento(CustomGridPane p) {

		ManagerAggiornamento.principale = p;
	}
	
	public static void notifica(){
		principale.aggiorna();
		
		System.out.println("Aggiorno!!");
	}
	

}
