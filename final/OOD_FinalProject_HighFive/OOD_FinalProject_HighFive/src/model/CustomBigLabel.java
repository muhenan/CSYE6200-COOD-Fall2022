package model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

public class CustomBigLabel extends Label{
	
	private final static String FONT_PATH = "/resources/kenvector_future.ttf";
	
	private final static String BACKGROUND_IMAGE = "/resources/panelInset_brown.png";
	
	
	public CustomBigLabel(String text) {
		
		setPrefWidth(380);
		setPrefHeight(49);
		setText(text);
		setWrapText(true);
		setLabelFont();
		setAlignment(Pos.CENTER);
		
		BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE, 380, 49, false, true), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		setBackground(new Background(backgroundImage));
	}
	
	private void setLabelFont() {	
		setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
	}	

}
