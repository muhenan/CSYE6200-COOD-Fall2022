package edu.northeastern.csye6200;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LAB8P2 extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO: write your code here
		try {
	        int widthOfStage = 800;
	        int hightOfStage = 200;
	        int widthOfRectangle = widthOfStage / 5;
	        int hightOfRectangle = 3;
	        int gap = (int) (widthOfRectangle * 0.2);
	        int[] percents = new int[]{35, 30, 30, 5};
	        Paint[] colors = new Paint[]{Color.BLUE, Color.GREEN, Color.RED, Color.ORANGE};
	        String[] texts = new String[]{"Project", "Exams", "Assignments", "Attendance"};
	        Pane pane = new Pane();
	        for (int i = 0; i < 4; i++) {
	        	Rectangle rectangle = new Rectangle();
	        	rectangle.setLayoutX(gap * (i + 1) + i * widthOfRectangle);
	        	rectangle.setLayoutY(hightOfStage - hightOfRectangle * percents[i]);
	        	rectangle.setWidth(widthOfRectangle);
	        	rectangle.setHeight(hightOfRectangle * percents[i]);
	        	rectangle.setFill(colors[i]);
	        	pane.getChildren().add(rectangle);
	        	Label lable = new Label(texts[i] + " -- " + String.valueOf(percents[i]) + '%');
	        	lable.setLayoutX(gap * (i + 1) + i * widthOfRectangle);
	        	lable.setLayoutY(hightOfStage - hightOfRectangle * percents[i] - 20);
	        	pane.getChildren().add(lable);
	        }
			Scene scene = new Scene(pane, widthOfStage, hightOfStage); // width height
			primaryStage.setTitle("Lab8_Problem2");
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