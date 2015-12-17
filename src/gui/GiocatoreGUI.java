package gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import logic.BriscolaManager;
import logic.Carta;
import logic.Giocatore;

public class GiocatoreGUI extends HBox{

	private Giocatore g;
	private BriscolaManager b;
	private List<CartaGUI> carteDisegnate;
	
	public GiocatoreGUI(Giocatore g , BriscolaManager b) {
		this.g = g;
		this.b = b;
		this.carteDisegnate = new ArrayList<CartaGUI>();
		this.setAlignment(Pos.CENTER);
	}
	
	private void initListener(){
		
		for (CartaGUI carta : carteDisegnate) {
			
			carta.setOnMouseClicked(new EventHandler<Event>() {

				public void handle(Event arg0) {
				
					CartaGUI tmp = (CartaGUI) arg0.getTarget();
					if(b.gioca(tmp.getC())){
						System.out.println(arg0.getTarget().getClass());
						tmp.setUsata(true);
						ManagerAggiornamento.notifica();
					}
					
				}
			});
		}
	}
	
	private void initCarte(){
		this.getChildren().clear();
		for (Carta c : g.getMieCarte()){
//			ImageView carta = new ImageView(c.getImg());
//			System.out.println("scene height " + getScene().getHeight());
			CartaGUI carta = new CartaGUI(c);
			Rectangle2D screen = Screen.getPrimary().getVisualBounds();
			carta.setFitHeight(screen.getHeight()*0.18);
			carta.setFitWidth((screen.getHeight()*0.18) - 15.0);
//			this.carte.add(carta);
			carteDisegnate.add(carta);
			//this.disegna.add(true);
			this.getChildren().add(carta);
		}
	}

	public void disegnaCarte(){
		initCarte();
		initListener();
	}

}
