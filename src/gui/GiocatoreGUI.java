package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import logic.Carta;
import logic.Giocatore;

public class GiocatoreGUI extends HBox{

	private Giocatore g;
	
	public GiocatoreGUI(Giocatore g) {
		this.g = g;
		this.setAlignment(Pos.CENTER);
	}

	public void disegnaCarte(){
		this.getChildren().clear();
		for (Carta c : g.getMieCarte()) {
			ImageView carta = new ImageView(c.getImg());
//			System.out.println("scene height " + getScene().getHeight());
			Rectangle2D screen = Screen.getPrimary().getVisualBounds();
			carta.setFitHeight(screen.getHeight()*0.18);
			carta.setFitWidth(170);
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
