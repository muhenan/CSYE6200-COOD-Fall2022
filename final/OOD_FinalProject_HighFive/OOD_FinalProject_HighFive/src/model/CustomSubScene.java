package model;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class CustomSubScene extends SubScene{
	
	private final static String FONT_PATH = "/resources/kenvector_future.ttf";
	private final static String BACKGROUND_IMAGE = "/resources/panelInset_brown.png";
	private  boolean isHidden;
	
	
	public CustomSubScene() {
		super(new AnchorPane(), 600, 425);
		prefWidth(600);
		prefHeight(425);
		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 600, 425, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		
		//get the anchor Pane created above and set it's backgroundImage
		AnchorPane root2 = (AnchorPane) this.getRoot();
		root2.setBackground(new Background(image));
		
		isHidden = true ;
		
		setLayoutX(1024);
		setLayoutY(180);
		
	}
	
	//logic to move our subscenes
	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		
		if (isHidden) {
			transition.setToX(-676);
			isHidden = false;
			
		} else {
			transition.setToX(0);
			isHidden = true ;
		}
		
		transition.play();
	}
	
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}

}
