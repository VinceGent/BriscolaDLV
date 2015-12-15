package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import logic.BriscolaManager;

public class CustomBorderPane extends GridPane {

	private BriscolaManager b;
	private GridPane banco;
	private Label punteggioG1;
	private Label punteggioG2;
	private HBox carteSulBanco;
	
	public CustomBorderPane() {
		
		this.setGridLinesVisible(true);
		this.setVgap(20);
//		this.setHgap(20);
//		this.setPadding(new Insets(10,10,10,10));
		setCostraints();
		this.carteSulBanco = new HBox();
		banco = new GridPane();
		this.b = new BriscolaManager();
		this.b.nuovaPartita();
		GiocatoreGUI g1 = new GiocatoreGUI(b.getG1());
		g1.disegnaCarte();
		GiocatoreGUI g2 = new GiocatoreGUI(b.getG2());
		g2.disegnaCarte();
//		punteggioG1 = new Label(Integer.toString(b.getG1().getPunteggio()));
//		punteggioG2 = new Label(Integer.toString(b.getG2().getPunteggio()));
//		this.setBackground(new Background(new BackgroundFill(Color.web("#31b82c"), CornerRadii.EMPTY, Insets.EMPTY)));
		this.add(g1, 0, 0);
		this.setColumnSpan(g1, 4);
		this.setColumnSpan(g2, 4);
		this.setHalignment(g1, HPos.CENTER);
		this.add(g2, 0, 2);
	/*	if(b.getMazzo().getMazzo().size() > 0 ){
			banco.add(new Label(Integer.toString(b.getMazzo().getMazzo().size())), 0, 0);
			Image i = new Image("file:img/retro.png", 170, 200, false, false);
			banco.add(new ImageView(i), 0, 1);
			banco.add(new ImageView(b.getBriscola().getImg()), 1,1);
		}
		
		banco.add(carteSulBanco, 2, 0);*/
//		this.setCenter(banco);
//		this.getCenter().
//		this.setTop(g1);
//		this.setBottom(g2);
		Pane p = new Pane();
		p.setPrefSize(400, 400);
		p.setBackground(new Background(new BackgroundFill(Color.web("#31b82c"), CornerRadii.EMPTY, Insets.EMPTY)));
		this.add(p, 0, 1);
		
		Pane p1 = new Pane();
		p1.setPrefSize(400, 400);
		p1.setBackground(new Background(new BackgroundFill(Color.web("#ea1515"), CornerRadii.EMPTY, Insets.EMPTY)));
		this.add(p1, 1, 1);
		
		Pane p3 = new Pane();
		p3.setPrefSize(400, 400);
		
		p3.setBackground(new Background(new BackgroundFill(Color.web("#1518ea"), CornerRadii.EMPTY, Insets.EMPTY)));
		this.add(p3, 2, 1);
//		
//		p.getChildren().add(punteggioG1);
//		Pane p2 = new Pane();
//		p2.setPrefSize(600, 800);
//		p2.getChildren().add(punteggioG2);

	
	}
	
	public void aggiornaBanco(){
		carteSulBanco.getChildren().clear();
		for (int i : b.getBanco().keySet()) {
			carteSulBanco.getChildren().add(new ImageView(b.getBanco().get(i).getImg()));
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
