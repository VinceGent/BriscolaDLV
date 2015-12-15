package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import logic.BriscolaManager;
import logic.Carta;
import logic.Giocatore;

public class GiocatoreGUI extends HBox{

	private BriscolaManager b;
	private Giocatore g;
	
	public GiocatoreGUI(Giocatore g) {
		this.g = g;
		this.setAlignment(Pos.CENTER);

	}

	public void disegnaCarte(){
		for (Carta c : g.getMieCarte()) {
			ImageView carta = new ImageView(c.getImg());
			carta.setOnMouseClicked(new EventHandler<Event>() {

				public void handle(Event arg0) {
			/*		Carta daGiocare = null;
					for (Carta c : g.getMieCarte()) {
						if(c.getImg().hashCode() == ((ImageView)arg0.getTarget()).getImage().hashCode()  ){
							System.out.println(c.getId() + "  " + c.getSeme());
							daGiocare = c;
						}
					}
					if(daGiocare != null)
						b.gioca(daGiocare);
					
					*/
				}
			});
			this.getChildren().add(carta);
		}
	}

}
