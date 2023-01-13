package model;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
//it'll contain two images...ship and circle(will be filled after choosing one of the ships)
public class ShipPicker extends VBox {
//
//	private ImageView circleImage;
//	private ImageView shipImage;
//	
//	private String circleNotChoosen = "/resources/grey_circle.png";
//	private String circleChoosen = "/resources/red_choosen.png";
//	
//	private PACMAN ship;
//	
//	private boolean isCircleChoosen;
//	
//	
//	public ShipPicker(PACMAN ship) {
//		circleImage = new ImageView(circleNotChoosen);
//		shipImage = new ImageView(ship.getUrl());
//		shipImage.setFitHeight(75);
//		shipImage.setFitWidth(75);
//		shipImage.setPreserveRatio(true);
//		this.ship = ship;
//		isCircleChoosen = false;
//		this.setAlignment(Pos.CENTER);
//		this.setSpacing(20);
//		this.getChildren().add(circleImage);
//		this.getChildren().add(shipImage);
//		
//	}
//	
//	public PACMAN getShip() {
//		return ship;
//	}
//	
//	public boolean getCircleChoosen() {
//		return isCircleChoosen;
//	}
//	
//	public void setIsCircleChoosen(boolean isCircleChoosen) {
//		this.isCircleChoosen = isCircleChoosen;
//		String imageToSet = this.isCircleChoosen ? circleChoosen : circleNotChoosen;
//		circleImage.setImage(new Image(imageToSet));
//	}
}
