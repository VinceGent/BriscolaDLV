package gui;


import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import logic.BriscolaManager;


public class MainFrame extends Application {
	
	private CustomGridPane main;
	private BriscolaManager b;

	@Override
	public void start(Stage arg0) throws Exception {
		b = new BriscolaManager();
		b.nuovaPartita("Mario", "Piera");
		main = new CustomGridPane(b);
		arg0.setTitle("BriscolaDLV");
	    Rectangle2D screen = Screen.getPrimary().getVisualBounds();
	    arg0.setScene(new Scene(main, screen.getWidth() - 25.00, screen.getHeight() -50.00));
//	    arg0.setFullScreen(true);
	    System.out.println(" screen width " + (screen.getWidth() - 50.00));
	    System.out.println(" screen width " + (screen.getHeight() - 50.00));
	    
	    
	    
	    arg0.show();
	/*    new AnimationTimer() {
	    	
	    	@Override
	    	public void handle(long arg0) {
//	    		main.aggiorna();
	    		try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    }.start();*/
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
		

	}

}
