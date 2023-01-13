package edu.northeastern.csye6200;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LAB8P3 extends Application {
	
	@Override 
	public void start(Stage primaryStage) {
		// TODO: write your code here
		try {
	        Pane pane = new Pane();
			Random rnd = new Random();
			int seed = 1331; // Optional: set seed to create repeatable results
			rnd.setSeed(seed);
	        for (int r = 0; r < 10; r++) {
	        	for (int c = 0; c < 10; c++) {
	        		TextField textField = new TextField();
	        		textField.setLayoutX(50 * c);
	        		textField.setLayoutY(50 * r);
	        		textField.setText(String.valueOf(rnd.nextInt(2)));
	        		textField.setPrefSize(50, 50);
	        		textField.setAlignment(Pos.CENTER);
	        		pane.getChildren().add(textField);
	        	}
	        }
			Scene scene = new Scene(pane, 500, 500); // width height
			primaryStage.setTitle("Lab8_Problem3 - Extra Credit");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support.
	 * Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		// TODO: write your code here
		launch(args);
	}
	
}