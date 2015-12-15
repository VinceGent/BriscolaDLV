package gui;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import logic.BriscolaManager;
import logic.Carta;
import logic.Mazzo;


public class MainFrame extends Application {
	
	private CustomGridPane main;

	@Override
	public void start(Stage arg0) throws Exception {
		
		main = new CustomGridPane();

	    Rectangle2D screen = Screen.getPrimary().getVisualBounds();
	    arg0.setScene(new Scene(main, screen.getWidth() - 60.00, screen.getHeight() -60.00));
	    System.out.println(" screen width " + (screen.getWidth() - 60.00));
	    System.out.println(" screen width " + (screen.getHeight() -60.00));
	    
	    new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				main.aggiornaBanco();
			}
		}.start();
	    
	    
	    arg0.show();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
		

	}

}
