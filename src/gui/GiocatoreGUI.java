package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
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
		
		disegnaCarte();
		Timer timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {
	            Platform.runLater(new Runnable() {
					
					public void run() {
						disegnaCarte();
					}
				});
//	            System.out.println("RIDISEGNO CARTEEEE");
	        }
	    }, 0, 2000);

	}
	
	private void initListener(){
		
		for (CartaGUI carta : carteDisegnate) {
			
			carta.setOnMouseClicked(new EventHandler<Event>() {

				public void handle(Event arg0) {
				
					CartaGUI tmp = (CartaGUI) arg0.getTarget();
					if(b.gioca(tmp.getC())){
						tmp.setUsata(true);
						return;
					}
					
				}
			});
		}
	}
	
	private void initCarte(){
		this.getChildren().clear();
		for (Carta c : g.getMieCarte()){
			CartaGUI carta = new CartaGUI(c);
			Rectangle2D screen = Screen.getPrimary().getVisualBounds();
			carta.setFitHeight(screen.getHeight()*0.2);
			carta.setFitWidth((screen.getHeight()*0.2) - 15.0);
			carteDisegnate.add(carta);
			this.getChildren().add(carta);
		}
	}
	

	public void disegnaCarte(){
		initCarte();
		initListener();
	}
	
	
	public void aggiornaCarte(){
		for (Node c : this.getChildren()) {
			CartaGUI carta = (CartaGUI) c;
			if(carta.isUsata()){
				System.out.println(carta.getC().getId() + "   " + carta.getC().getSeme());
				carta.cambiaCarta(g.getMieCarte().get(2));
			}
		}	
		
	}

}
