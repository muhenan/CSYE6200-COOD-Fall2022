package view;

import java.io.IOException;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.PACMAN;
import model.SmallInfoLabel;

//class for handling a game
public class GameViewManager {
	
	private AnchorPane gamePane;
	private Scene gameScene;
	//new stage for the game
	private Stage gameStage;
	
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	
	private Stage menuStage;
	private ImageView ship;
	
	private boolean isLeftKeyPressed;
	private boolean isRightKeyPressed;
	private int angle;
	
	private AnimationTimer gameTimer;
	
	//for the background
	private GridPane gridPane1;
	private GridPane gridPane2;
	private final static String BACKGROUND_IMAGE = "/resources/deep_blue.png"; 
	
	
	private final static String METEOR_BROWN_IMAGE = "/resources/blueghost.gif";
	private final static String METEOR_GREY_IMAGE = "/resources/redghost.gif";
	
	
	private ImageView[] brownGhosts;
	private ImageView[] greyGhosts;
	Random randomPositionGenerator;
	
	
	private ImageView star;
	private SmallInfoLabel pointsLabel;
	private ImageView[] playerLifes;
	private int playerLife;
	
	private int points;
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	private final static String GOLD_STAR_IMAGE = "/resources/star_gold.png";
	
	private final static int STAR_RADIUS = 12;
	private final static int SHIP_RADIUS = 27;
	private final static int METEOR_RADIUS = 20;
	
	public GameViewManager() {
		initializeStage();
		createKeyListeners();
		randomPositionGenerator = new Random();
		
	}
	
	private void initializeStage() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
	}
	
	private void createKeyListeners() {
		
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.LEFT) {
					isLeftKeyPressed = true;
					
				} else if (event.getCode() == KeyCode.RIGHT) {
					isRightKeyPressed = true;
				}
				
			}
		});
		
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.LEFT) {
					isLeftKeyPressed = false;
					
				} else if (event.getCode() == KeyCode.RIGHT) {
					isRightKeyPressed = false;
					
				}
				
			}
		});
	}
	
	

	
	/*
	 * for the new game
	 * it takes two params
	 * 1. the menustage ? to hide it
	 * 2. the chosenship
	 * */
	public void createNewGame(Stage menuStage, PACMAN choosenShip) {
	
		this.menuStage = menuStage;
		this.menuStage.hide();
		createBackground();
		createShip(choosenShip);
		createGameElements(choosenShip);
		createGameLoop();
		gameStage.show();
	}
	
	private void createGameElements(PACMAN choosenShip) {
		
		playerLife = 2;
		star = new ImageView(GOLD_STAR_IMAGE);
		setNewElementPosition(star);
		gamePane.getChildren().add(star);
		pointsLabel = new SmallInfoLabel("POINTS : 00");
		pointsLabel.setLayoutX(460);
		pointsLabel.setLayoutY(20);
		gamePane.getChildren().add(pointsLabel);
		playerLifes = new ImageView[3];
		
		for(int i = 0; i < playerLifes.length; i++) {
			playerLifes[i] = new ImageView(choosenShip.getUrlLife());
			playerLifes[i].setFitHeight(26);
			playerLifes[i].setFitWidth(26);
			playerLifes[i].setPreserveRatio(true);
			playerLifes[i].setLayoutX(455 + (i * 50));
			playerLifes[i].setLayoutY(80);
			gamePane.getChildren().add(playerLifes[i]);
			
		}
		
		
		brownGhosts = new ImageView[3];
		for(int i = 0; i < brownGhosts.length; i++) {
			brownGhosts[i] = new ImageView(METEOR_BROWN_IMAGE);
			brownGhosts[i].setFitHeight(45);
			brownGhosts[i].setFitWidth(40);
			brownGhosts[i].setPreserveRatio(true);
			setNewElementPosition(brownGhosts[i]);
			gamePane.getChildren().add(brownGhosts[i]);
		}
		greyGhosts = new ImageView[3];
		for(int i = 0; i < greyGhosts.length; i++) {
			greyGhosts[i] = new ImageView(METEOR_GREY_IMAGE);
			greyGhosts[i].setFitHeight(45);
			greyGhosts[i].setFitWidth(40);
			greyGhosts[i].setPreserveRatio(true);
			setNewElementPosition(greyGhosts[i]);
			gamePane.getChildren().add(greyGhosts[i]);
		}
	}
	
	
	private void moveGameElements() {
	
		star.setLayoutY(star.getLayoutY() + 5);
		
		for(int i = 0; i < brownGhosts.length; i++) {
			brownGhosts[i].setLayoutY(brownGhosts[i].getLayoutY()+5);
			//brownMeteors[i].setRotate(brownMeteors[i].getRotate()+4);
		}
		
		for(int i = 0; i < greyGhosts.length; i++) {
			greyGhosts[i].setLayoutY(greyGhosts[i].getLayoutY()+5);
//			greyMeteors[i].setRotate(greyMeteors[i].getRotate()+4);
		}
	}
	
	private void checkIfElementAreBehindTheShipAndRelocated() {
		
		if(star.getLayoutY() > 1200) {
			setNewElementPosition(star);
		}
		
		for(int i = 0; i< brownGhosts.length; i++) {
			if(brownGhosts[i].getLayoutY() > 900) {
				setNewElementPosition(brownGhosts[i]);
			}
		}
		
		
		for(int i = 0; i< greyGhosts.length; i++) {
			if(greyGhosts[i].getLayoutY() > 900) {
				setNewElementPosition(greyGhosts[i]);
			}
		}
	}
	
	
	
	
	
	private void setNewElementPosition(ImageView image) {
		
		image.setLayoutX(randomPositionGenerator.nextInt(GAME_WIDTH));
		image.setLayoutY(-randomPositionGenerator.nextInt(3200)+600);
		
	}
	

	
	
	private void createShip(PACMAN choosenShip) {
		ship = new ImageView(choosenShip.getUrl());
		ship.setFitHeight(60);
		ship.setFitWidth(60);
		ship.setPreserveRatio(true);
		//set the starting coordinates of the ship
		ship.setLayoutX(GAME_WIDTH/2);
		ship.setLayoutY(GAME_HEIGHT - 70);
		//add the ship to the pane
		gamePane.getChildren().add(ship);
	}
	
	
	private void createGameLoop() {
		
		gameTimer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				moveBackground();
				moveGameElements();
				checkIfElementAreBehindTheShipAndRelocated();
				checkIfElementsCollide();
				moveShip();
			}
		};
		gameTimer.start();
	}
	
	//to move and rotate our ship
	private void moveShip() {
		
		//when left key is pressed and right key is not pressed
		if (isLeftKeyPressed && !isRightKeyPressed) {
			//to rotate and move ship left
			if(angle > -30) {
				angle -= 5;
			}
			ship.setRotate(angle);
			//set a border for rotating and moving
			if(ship.getLayoutX() > -20) {
				ship.setLayoutX(ship.getLayoutX() - 3);
			}
		}
		
		//when left key is not pressed and right key is pressed
		//do the opposite to what happens when we click left key
		if (isRightKeyPressed && !isLeftKeyPressed) {
			if(angle < 30) {
				angle += 5;
			}
			ship.setRotate(angle);
			if(ship.getLayoutX() < 522) {
				ship.setLayoutX(ship.getLayoutX() + 3);
			}
		}
		
		//when left key and right key are not pressed
		//or when left key and right key are pressed
		//we don't want to move the ship
		if ((!isLeftKeyPressed && !isRightKeyPressed) || (isLeftKeyPressed &&  isRightKeyPressed)) {
			if(angle < 0) {
				angle += 5;
			} else if (angle > 0) {
				angle -= 5;
			}
			ship.setRotate(angle);
		}
		
		//when left key and right key are pressed
//		if (isLeftKeyPressed &&  isRightKeyPressed) {
//			if(angle < 0) {
//				angle += 5;
//			} else if (angle > 0) {
//				angle -= 5;
//			}
//			ship.setRotate(angle);
//		}
		
	}
	
	private void createBackground() {
		
		gridPane1 = new GridPane();
		gridPane2 = new GridPane();
		
		for (int i = 0 ; i < 12; i++) {
			ImageView backgroundImage1 = new ImageView(BACKGROUND_IMAGE);
			ImageView backgroundImage2 = new ImageView(BACKGROUND_IMAGE);
			GridPane.setConstraints(backgroundImage1, i% 3, i / 3 );
			GridPane.setConstraints(backgroundImage2, i% 3, i / 3 );
			gridPane1.getChildren().add(backgroundImage1);
			gridPane2.getChildren().add(backgroundImage2);
		}
		
		gridPane2.setLayoutY(- 1024);
		gamePane.getChildren().addAll(gridPane1, gridPane2);
	}
	
	private void moveBackground() {
		gridPane1.setLayoutY(gridPane1.getLayoutY() + 0.5);
		gridPane2.setLayoutY(gridPane2.getLayoutY() + 0.5);
		
		if (gridPane1.getLayoutY() >= 1024) {
			gridPane1.setLayoutY(-1024);
		}
		
		if (gridPane2.getLayoutY() >= 1024) {
			gridPane2.setLayoutY(-1024);
		}
	}
	
	
	private void checkIfElementsCollide() {
		
		if(SHIP_RADIUS + STAR_RADIUS > calculateDistance(ship.getLayoutX() + 49, star.getLayoutX() + 15,
				ship.getLayoutY() + 37, star.getLayoutY() + 15)) {
			setNewElementPosition(star);
			
			points++;
		
			String textToSet = "POINTS : ";
			if (points < 10) {
				textToSet = textToSet + "0";
			}
			pointsLabel.setText(textToSet + points);
		}
		
		for (int i = 0; i < brownGhosts.length; i++) {
			
			if (METEOR_RADIUS + SHIP_RADIUS > calculateDistance(ship.getLayoutX() + 49, brownGhosts[i].getLayoutX() + 20,
					ship.getLayoutY() + 37, brownGhosts[i].getLayoutY() + 20)) {
				
				removeLife();
				setNewElementPosition(brownGhosts[i]);
			}
			
		}
		
		for (int i = 0; i < greyGhosts.length; i++) {
			
			if (METEOR_RADIUS + SHIP_RADIUS > calculateDistance(ship.getLayoutX() + 49, greyGhosts[i].getLayoutX() + 20,
					ship.getLayoutY() + 37, greyGhosts[i].getLayoutY() + 20)) {
				
				removeLife();
				setNewElementPosition(greyGhosts[i]);
			}
			
		}
	}
	
	
	private void removeLife() {
		
		gamePane.getChildren().remove(playerLifes[playerLife]);
		playerLife--;
		if(playerLife < 0) {
			
			System.out.println("your score ---"+getPoints());
			//call a method in the view manager and pass points to it 
			try {
				ViewManager.SaveToFile("src/view/LeaderBoard.txt",String.valueOf(getPoints()), true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gameStage.close();
			gameTimer.stop();
			menuStage.show();
		}
	}
	
	private double calculateDistance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
	
	
	
	
	
	
	
	
	

	
	
	

}
