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
import model.PacMan;
import model.CustomSmallLabel;

//class for handling a game
public class PacManScreen {
	
	private AnchorPane gamePane;
	private Scene gameScene;
	//new stage for the game
	private Stage gameStage;
	
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;
	
	private Stage menuStage;
	private ImageView pac;
	
	private boolean isLeftKeyPressed;
	private boolean isRightKeyPressed;
	private int angle;
	
	private AnimationTimer gameTimer;
	
	//for the background
	private GridPane gridPane1;
	private GridPane gridPane2;
	private final static String GAME_BACKGROUND = "/resources/deep_blue.png"; 
	
	
	private final static String BLUE_GHOST = "/resources/blueghost.gif";
	private final static String RED_GHOST = "/resources/redghost.gif";
	
	//array of blue and red ghosts
	private ImageView[] blueGhosts;
	private ImageView[] redGhosts;
	Random randomPositionGenerator;
	
	//for the start image
	private ImageView star;
	
	//for tracking the points that the user scores
	private CustomSmallLabel pointsLabel;
	
	//for tracking the player's life
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
	
	public PacManScreen() {
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
	 * 2. the chosenPacMan
	 * */
	public void createNewGame(Stage menuStage, PacMan pacMan) {
	
		this.menuStage = menuStage;
		this.menuStage.hide();
		createGameBackground();
		createPacMan(pacMan);
		createGameElements(pacMan);
		createGameLoop();
		gameStage.show();
	}
	
	private void createGameElements(PacMan pacMan) {
		
		playerLife = 2;
		star = new ImageView(GOLD_STAR_IMAGE);
		setNewElementPosition(star);
		gamePane.getChildren().add(star);
		pointsLabel = new CustomSmallLabel("POINTS : 00");
		pointsLabel.setLayoutX(460);
		pointsLabel.setLayoutY(20);
		gamePane.getChildren().add(pointsLabel);
		playerLifes = new ImageView[3];
		
		for(int i = 0; i < playerLifes.length; i++) {
			playerLifes[i] = new ImageView(pacMan.getPacManLife());
			playerLifes[i].setFitHeight(26);
			playerLifes[i].setFitWidth(26);
			playerLifes[i].setPreserveRatio(true);
			playerLifes[i].setLayoutX(455 + (i * 50));
			playerLifes[i].setLayoutY(80);
			gamePane.getChildren().add(playerLifes[i]);
			
		}
		
		blueGhosts = new ImageView[3];
		for(int i = 0; i < blueGhosts.length; i++) {
			blueGhosts[i] = new ImageView(BLUE_GHOST);
			blueGhosts[i].setFitHeight(45);
			blueGhosts[i].setFitWidth(40);
			blueGhosts[i].setPreserveRatio(true);
			setNewElementPosition(blueGhosts[i]);
			gamePane.getChildren().add(blueGhosts[i]);
		}
		
		redGhosts = new ImageView[3];
		for(int i = 0; i < redGhosts.length; i++) {
			redGhosts[i] = new ImageView(RED_GHOST);
			redGhosts[i].setFitHeight(45);
			redGhosts[i].setFitWidth(40);
			redGhosts[i].setPreserveRatio(true);
			setNewElementPosition(redGhosts[i]);
			gamePane.getChildren().add(redGhosts[i]);
		}
	}
	
	
	private void moveGameElements() {
	
		star.setLayoutY(star.getLayoutY() + 5);
		
		for(int i = 0; i < blueGhosts.length; i++) {
			blueGhosts[i].setLayoutY(blueGhosts[i].getLayoutY()+5);
		}
		
		for(int i = 0; i < redGhosts.length; i++) {
			redGhosts[i].setLayoutY(redGhosts[i].getLayoutY()+5);
		}
	}
	
	private void checkIfElementAreBehindThePacManAndRelocated() {
		
		if(star.getLayoutY() > 1200) {
			setNewElementPosition(star);
		}
		
		for(int i = 0; i< blueGhosts.length; i++) {
			if(blueGhosts[i].getLayoutY() > 900) {
				setNewElementPosition(blueGhosts[i]);
			}
		}
		
		
		for(int i = 0; i< redGhosts.length; i++) {
			if(redGhosts[i].getLayoutY() > 900) {
				setNewElementPosition(redGhosts[i]);
			}
		}
	}
	
	private void setNewElementPosition(ImageView image) {
		
		image.setLayoutX(randomPositionGenerator.nextInt(GAME_WIDTH));
		image.setLayoutY(-randomPositionGenerator.nextInt(3200)+600);
		
	}
	
	private void createPacMan(PacMan pacMan) {
		pac = new ImageView(pacMan.getPacManUrl());
		pac.setFitHeight(60);
		pac.setFitWidth(60);
		pac.setPreserveRatio(true);
		//set the starting coordinates of the pacMan
		pac.setLayoutX(GAME_WIDTH/2);
		pac.setLayoutY(GAME_HEIGHT - 70);
		//add the pacMan to the pane
		gamePane.getChildren().add(pac);
	}
	
	
	private void createGameLoop() {
		
		gameTimer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				moveBackground();
				moveGameElements();
				checkIfElementAreBehindThePacManAndRelocated();
				checkIfElementsCollide();
				movePacMan();
			}
		};
		gameTimer.start();
	}
	
	//to move and rotate our pacMan
	private void movePacMan() {
		
		//when left key is pressed and right key is not pressed
		if (isLeftKeyPressed && !isRightKeyPressed) {
			//to rotate and move pacMan left
			if(angle > -30) {
				angle -= 5;
			}
			pac.setRotate(angle);
			//set a border for rotating and moving
			if(pac.getLayoutX() > -20) {
				pac.setLayoutX(pac.getLayoutX() - 3);
			}
		}
		
		//when left key is not pressed and right key is pressed
		//do the opposite to what happens when we click left key
		if (isRightKeyPressed && !isLeftKeyPressed) {
			if(angle < 30) {
				angle += 5;
			}
			pac.setRotate(angle);
			if(pac.getLayoutX() < 522) {
				pac.setLayoutX(pac.getLayoutX() + 3);
			}
		}
		
		//when left key and right key are not pressed
		//or when left key and right key are pressed
		//we don't want to move the pacMan
		if ((!isLeftKeyPressed && !isRightKeyPressed) || (isLeftKeyPressed &&  isRightKeyPressed)) {
			if(angle < 0) {
				angle += 5;
			} else if (angle > 0) {
				angle -= 5;
			}
			pac.setRotate(angle);
		}
				
	}
	
	private void createGameBackground() {
		
		gridPane1 = new GridPane();
		gridPane2 = new GridPane();
		
		for (int i = 0 ; i < 12; i++) {
			ImageView backgroundImage1 = new ImageView(GAME_BACKGROUND);
			ImageView backgroundImage2 = new ImageView(GAME_BACKGROUND);
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
		
		if(SHIP_RADIUS + STAR_RADIUS > calculateDistance(pac.getLayoutX() + 49, star.getLayoutX() + 15,
				pac.getLayoutY() + 37, star.getLayoutY() + 15)) {
			setNewElementPosition(star);
			
			points++;
		
			String textToSet = "POINTS : ";
			if (points < 10) {
				textToSet = textToSet + "0";
			}
			pointsLabel.setText(textToSet + points);
		}
		
		for (int i = 0; i < blueGhosts.length; i++) {
			
			if (METEOR_RADIUS + SHIP_RADIUS > calculateDistance(pac.getLayoutX() + 49, blueGhosts[i].getLayoutX() + 20,
					pac.getLayoutY() + 37, blueGhosts[i].getLayoutY() + 20)) {
				
				removeLife();
				setNewElementPosition(blueGhosts[i]);
			}
			
		}
		
		for (int i = 0; i < redGhosts.length; i++) {
			
			if (METEOR_RADIUS + SHIP_RADIUS > calculateDistance(pac.getLayoutX() + 49, redGhosts[i].getLayoutX() + 20,
					pac.getLayoutY() + 37, redGhosts[i].getLayoutY() + 20)) {
				
				removeLife();
				setNewElementPosition(redGhosts[i]);
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
				GameDashboard.SaveToFile("src/view/LeaderBoard.txt",String.valueOf(getPoints()), true);
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
