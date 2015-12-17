package gui;

import java.util.List;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import logic.BriscolaManager;

public class CustomGridPane extends GridPane {

	private static ManagerAggiornamento notifiche;
	private BriscolaManager b;
	private Label punteggioG1;
	private Label punteggioG2;
	private Label turno;
	private BancoGUI banco;
	private GiocatoreGUI g1;
	private GiocatoreGUI g2;
	
	public CustomGridPane(BriscolaManager b) {
		
		notifiche = new ManagerAggiornamento(this);
		this.setGridLinesVisible(false);
		this.setVgap(10);
		setCostraints();
		this.b = b;
//		this.b.nuovaPartita();
		banco = new BancoGUI(b);
		g1 = new GiocatoreGUI(b.getG1(), b);
		g2 = new GiocatoreGUI(b.getG2(), b);
		turno = new Label();
		punteggioG1 = new Label();
		punteggioG2 = new Label();
		this.add(punteggioG1, 0, 1);
		setHalignment(punteggioG1, HPos.CENTER);
		
		this.add(punteggioG2, 2, 1);
		setHalignment(punteggioG2, HPos.CENTER);
		
		this.setBackground(new Background(new BackgroundFill(Color.web("#048d04"), CornerRadii.EMPTY, Insets.EMPTY)));
		this.add(g1, 0, 0);
		setColumnSpan(g1, 4);
		setColumnSpan(g2, 4);
		setHalignment(g1, HPos.CENTER);
		setFillHeight(g1, true);
		setFillHeight(g2, true);
		this.add(g2, 0, 2);
		
		Pane p = new Pane();
		p.setPrefSize(400, 400);
//		p.setBackground(new Background(new BackgroundFill(Color.web("#31b82c"), CornerRadii.EMPTY, Insets.EMPTY)));
		this.add(p, 0, 1);
		
//		Pane p1 = new Pane();
//		p1.setPrefSize(400, 400);
//		p1.setBackground(new Background(new BackgroundFill(Color.web("#ea1515"), CornerRadii.EMPTY, Insets.EMPTY)));
		banco.disegnaBanco();
		this.add(banco, 1, 1);
//		notifiche.appendi(banco);
		
		Pane p3 = new Pane();
		p3.setPrefSize(400, 400);
		
		this.add(p3, 2, 1);
//		
//		p.getChildren().add(punteggioG1);
//		Pane p2 = new Pane();
//		p2.setPrefSize(600, 800);
//		p2.getChildren().add(punteggioG2);
		aggiorna();
	}
	
	
	
	public void aggiorna(){
	/*	carteSulBanco.getChildren().clear();
		for (int i : b.getBanco().keySet()) {
			carteSulBanco.getChildren().add(new ImageView(b.getBanco().get(i).getImg()));
		}*/
		banco.aggiorna();
		g1.disegnaCarte();
		g2.disegnaCarte();
		punteggioG1.setText(b.getG1().getNome() + " ha : "+Integer.toString(b.getG1().getPunteggio()) + " punti");
		punteggioG2.setText(b.getG2().getNome()+ " ha : "+Integer.toString(b.getG2().getPunteggio()) + " punti");
	}
	
	public void aggiornaTurno(){
		if(b.getTurno() == 0 ){
//			turno.setText();
		}
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
		row1.setPercentHeight(20);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(60);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(20);
		this.getRowConstraints().addAll(row1,row2,row3);
	}
	
	
	
	
}
