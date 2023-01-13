package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.GameDashboard;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	//firstly, we need to override the start method
	//for every stage object...there must be only one scene
	@Override
	public void start(Stage primaryStage) {
		try {
			GameDashboard dashboard = new GameDashboard();
			primaryStage = dashboard.getMainStage();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
