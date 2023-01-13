package model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

public class UserScoreLabel extends Label{
	
	private final static String FONT_PATH = "/resources/kenvector_future.ttf";
	
	private final static String BACKGROUND_IMAGE = "/resources/glassPanel_corners.png";
	
	public UserScoreLabel(String text) {
		
		setPrefWidth(330);
		setPrefHeight(50);
		setText(text);
		setWrapText(true);
		setLabelFont();
		setAlignment(Pos.CENTER);
		BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE, 330, 50, false, true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		setBackground(new Background(backgroundImage));
	
	}
	
	private void setLabelFont() {
		setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 15));
	}
}

