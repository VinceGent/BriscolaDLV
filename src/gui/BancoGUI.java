package gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import logic.BriscolaManager;

public class BancoGUI extends GridPane {
	
	private BriscolaManager b;
	Rectangle2D screen = Screen.getPrimary().getVisualBounds();
	private HBox banco;
	private StackPane mazzo;
	private ImageView briscola;
	private Text numero;
	
	public BancoGUI(BriscolaManager b) {
		this.b = b;
		numero = new Text();

		this.mazzo = new StackPane();
		mazzo.getStylesheets().add("file:css/style.css");
		mazzo.setAlignment(Pos.CENTER);
		setCostraints();
		this.setHgap(5);
		this.setVgap(5);
		Pane p1 = new Pane();
//		p1.setBackground(new Background(new BackgroundFill(Color.web("#ea1515"), CornerRadii.EMPTY, Insets.EMPTY)));
		//this.add(p1, 0, 0);
		
		banco = new HBox();
//		banco.getStylesheets().add("file:css/style.css");
		banco.setBackground(new Background(new BackgroundFill(Color.web("#219621"), CornerRadii.EMPTY, Insets.EMPTY)));
		setRowSpan(banco, 2);
		this.add(banco, 1, 0);
		
		Pane p3 = new Pane();
//		p3.setBackground(new Background(new BackgroundFill(Color.web("#8b81ff"), CornerRadii.EMPTY, Insets.EMPTY)));
		this.add(p3, 0, 1);
		
		Pane p4 = new Pane();
//		p4.setBackground(new Background(new BackgroundFill(Color.web("#ffdd33"), CornerRadii.EMPTY, Insets.EMPTY)));
		this.add(p4, 1, 1);
		
		
	}
	
	private void setCostraints(){
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(15);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(85);

		this.getColumnConstraints().addAll(column1,column2);
		
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(50);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(50);
		this.getRowConstraints().addAll(row1,row2);
	}
	
	public void disegnaBanco(){
		
		briscola = new ImageView(b.getBriscola().getImg());
		briscola.setFitHeight(screen.getHeight()*0.18);
		briscola.setFitWidth((screen.getHeight()*0.18) - 10.0);
		this.add(briscola , 0 , 0 );
		setHalignment(briscola, HPos.CENTER);
		
		if(b.getMazzo().getMazzo().size() > 1){
			
			ImageView cartaMazzo = new ImageView("file:img/retro.png");
			cartaMazzo.setFitHeight(screen.getHeight()*0.18);
			cartaMazzo.setFitWidth((screen.getHeight()*0.18) - 10.0);
			mazzo.getChildren().add(cartaMazzo);
			numero = new Text(Integer.toString(b.getMazzo().getMazzo().size()));
			numero.getStyleClass().add("numeromazzo");
			//numero.setStyle("-fx-font: 100px Tahoma; -fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%); -fx-stroke: black; -fx-stroke-width: 1;");
			
			mazzo.getChildren().add(numero);
			this.add(mazzo, 0, 1);
			setHalignment(mazzo, HPos.CENTER);
		}
		
		if(b.getBanco().size() > 0){
			for (int i : b.getBanco().keySet()) {
				ImageView suBanco  = new ImageView(b.getBanco().get(i).getImg());
				suBanco.setFitHeight(screen.getHeight()*0.18);
				suBanco.setFitWidth((screen.getHeight()*0.18) - 10.0);
				banco.getChildren().add(suBanco);
				
			}
		}
		
	}
	
	public void aggiorna(){
		if(b.getMazzo().getMazzo().size() > 1){
			Text tmp = (Text) mazzo.getChildren().get(1);
			mazzo.getChildren().remove(1);
			tmp.setText(Integer.toString(b.getMazzo().getMazzo().size()));
			mazzo.getChildren().add(tmp);
		}
		if(b.getBanco().size() > 0){
			System.out.println("size di banco " + b.getBanco().keySet().size());
			for (int i : b.getBanco().keySet()) {
				System.out.println("int i  " + i);
				ImageView suBanco  = new ImageView(b.getBanco().get(i).getImg());
				suBanco.setFitHeight(screen.getHeight()*0.18);
				suBanco.setFitWidth((screen.getHeight()*0.18) - 10.0);
				banco.getChildren().add(suBanco);
			}
		}
		if(b.getBanco().size() == 0 )
			banco.getChildren().clear();
		
		if(b.getMazzo().getMazzo().size() == 0){
			mazzo.getChildren().clear();
			this.briscola.setVisible(false);
			
		}
		
	}

	

}
