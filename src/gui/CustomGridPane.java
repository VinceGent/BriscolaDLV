package gui;

import java.awt.Cursor;

import com.sun.glass.events.MouseEvent;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import jdlv.CartaDaGiocareJDLV;
import logic.BriscolaManager;
import logic.Carta;

public class CustomGridPane extends GridPane {

	private static ManagerAggiornamento notifiche;
	private BriscolaManager b;
	private Text punteggioG1;
	private Text punteggioG2;
	private Text turno;
	private Text nomeG1;
	private Text nomeG2;
	private BancoGUI banco;
	private GiocatoreGUI g1;
	private GiocatoreGUI g2;
	private GridPane mypaneLeft;
	private GridPane mypaneRight;
	private Button bottone;
	
	public CustomGridPane(BriscolaManager b) {
		
		this.getStylesheets().add("file:css/style.css");
		
		this.mypaneLeft = new GridPane();
		this.mypaneRight = new GridPane();
		notifiche = new ManagerAggiornamento(this);
		this.setGridLinesVisible(false);
		this.nomeG1 = new Text(b.getG1().getNome());
		this.nomeG2 = new Text(b.getG2().getNome());
		this.nomeG1.getStyleClass().add("nomeG1");
		this.nomeG2.getStyleClass().add("nomeG2");
		setHalignment(nomeG1, HPos.CENTER);
		setHalignment(nomeG2, HPos.CENTER);
		this.setVgap(10);
		setCostraints();
		this.b = b;
		this.bottone = new Button("Controlla giocata");
		setHalignment(bottone, HPos.CENTER);
		this.bottone.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event arg0) {
				System.out.println("CIAO");
				aggiorna();
			}
		});
		this.bottone.setVisible(false);
//		this.b.nuovaPartita();
		banco = new BancoGUI(b);
		g1 = new GiocatoreGUI(b.getG1(), b);
		g2 = new GiocatoreGUI(b.getG2(), b);
		turno = new Text();
		turno.getStyleClass().add("turno");
		setHalignment(turno, HPos.CENTER);
		punteggioG1 = new Text();
		punteggioG2 = new Text();
		punteggioG1.getStyleClass().add("punteggiog1");
		punteggioG2.getStyleClass().add("punteggiog2");
		
		this.mypaneLeft.add(turno, 0, 0);
		this.mypaneLeft.add(bottone, 0, 1);
//		this.mypaneLeft.setGridLinesVisible(true);
		this.add(punteggioG1, 0, 0);
		this.add(mypaneLeft, 0, 1);
		this.add(nomeG1 , 2 , 0);
		this.add(nomeG2 , 0 , 2);
		setHalignment(punteggioG1, HPos.CENTER);
		
//		this.mypaneRight.setGridLinesVisible(true);
		this.add(punteggioG2, 2, 2);
		this.add(mypaneRight, 2, 1);
		
//		this.add(punteggioG2, 2, 1);
		setHalignment(punteggioG2, HPos.CENTER);
		
		this.setBackground(new Background(new BackgroundFill(Color.web("#048d04"), CornerRadii.EMPTY, Insets.EMPTY)));
		this.add(g1, 0, 0);
		setColumnSpan(g1, 4);
		setColumnSpan(g2, 4);
		setHalignment(g1, HPos.CENTER);
		setFillHeight(g1, true);
		setFillHeight(g2, true);
		this.add(g2, 0, 2);

		banco.disegnaBanco();
		this.add(banco, 1, 1);
		Pane p3 = new Pane();
		p3.setPrefSize(400, 400);
		
		this.add(p3, 2, 1);
		aggiorna();
	}
	
	public void aggiorna(){
		
		this.bottone.setVisible(false);
		banco.aggiorna();
		aggiornaTurno();
		g1.disegnaCarte();
		g2.disegnaCarte();
		punteggioG1.setText(b.getG1().getNome() + " ha : "+Integer.toString(b.getG1().getPunteggio()) + " punti");
		punteggioG2.setText(b.getG2().getNome()+ " ha : "+Integer.toString(b.getG2().getPunteggio()) + " punti");
		
		System.out.println(" banco " + b.getBanco().size());
		if(b.getBanco().size() == 2){
			banco.aggiorna();
			b.controllaGiocata();
			bottone.setVisible(true);
		}
		
		if(b.getTurno() == 0){
			System.out.println("chitemmu joca");
			b.getIntelligenza().gioca();
			if(b.getIntelligenza().getSoluzione().size() > 0){
				CartaDaGiocareJDLV sol = b.getIntelligenza().getSoluzione().get(0);
				for (Carta c : b.getG1().getMieCarte()) {
					if( c.getId() == sol.getId() && c.getSeme().equals(sol.getSeme())){
						if(b.gioca(c))
							aggiorna();
						
					}
				}
			}
		}
	}
	
	public void aggiornaTurno(){
		if(b.getTurno() == 0 ){
			turno.setText("Tocca a " + b.getG1().getNome() + " !!! ");
		}else
			turno.setText("Tocca a " + b.getG2().getNome() + " !!! ");
	}
	
	private void setCostraints(){
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(20);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(60);
		ColumnConstraints column3 = new ColumnConstraints();
		column3.setPercentWidth(20);
		this.getColumnConstraints().addAll(column1,column2,column3);
		
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(25);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(50);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(25);
		this.getRowConstraints().addAll(row1,row2,row3);
		
		ColumnConstraints columnMypane = new ColumnConstraints();
		columnMypane.setPercentWidth(100);
		RowConstraints rowmMypane1 = new RowConstraints();
		rowmMypane1.setPercentHeight(50);
		RowConstraints rowmMypane2 = new RowConstraints();
		rowmMypane2.setPercentHeight(50);
		
		this.mypaneLeft.getColumnConstraints().add(columnMypane);
		this.mypaneLeft.getRowConstraints().addAll(rowmMypane1,rowmMypane2);
		this.mypaneRight.getColumnConstraints().add(columnMypane);
		this.mypaneRight.getRowConstraints().addAll(rowmMypane1,rowmMypane2);
	}
	
	
	
	
}
