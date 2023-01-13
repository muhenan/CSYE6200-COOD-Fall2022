package view;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.InfoLabel;
import model.PACMAN;
import model.ShipPicker;
import model.SmallInfoLabel;
import model.PacmanInSpaceButton;
import model.PacmanInSpaceSubScene;
import model.UserScore;
import model.UserScoreLabel;


public class ViewManager {
	
	//scene dimensions
	private static final int HEIGHT = 768;
	private static final int WIDTH = 1024;
	
	public final static String FONT_PATH = "/resources/kenvector_future.ttf";
	
	//declare our layout - AnchorPane, our scene and our stage
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	//X and Y coordinates for the first button
	private final static int MENU_BUTTON_START_X = 100;
	private final static int MENU_BUTTON_START_Y = 150;

	//subscene for each button
	private PacmanInSpaceSubScene createUserSubscene;
	private PacmanInSpaceSubScene creditsSubscene;
	private PacmanInSpaceSubScene helpSubscene;
	private PacmanInSpaceSubScene scoreSubscene;
//	private PacmanInSpaceSubScene shipChooserSubscene;
	
	private PacmanInSpaceSubScene sceneToHide;

	List<PacmanInSpaceButton> menuButtons;
	
	List<ShipPicker> shipsList;
//	private PACMAN choosenShip;
	
	private String userName;
	private static UserScore userScore;
	private GameViewManager gameManager;
	private static boolean savedUserScoreToFile = false;
		
	public ViewManager() {
		
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		
		menuButtons = new ArrayList<>();
		createSubScenes();
		CreateButtons(); //to create the buttons on the main scene
		createBackground();
		//createLogo();
	}

	public Stage getMainStage() {
		return mainStage;
	}
	
	private void CreateButtons() {
		createUserButton();
		createStartButton();
		createScoresButton();
		createHelpButton();
		createCreditsButton();
		createExitButton();
	}

	private void showSubScene(PacmanInSpaceSubScene subScene) {
		if (sceneToHide != null) {
			sceneToHide.moveSubScene();
		}
		
		subScene.moveSubScene();
		sceneToHide = subScene;
	}
	
	
	
	
	private void createSubScenes() {
		
		createCreditsSubScene();
		createHelpSubScene();
		createAddUserSubScene();
		createScoreSubScene();
//		createShipChooserSubScene();
	}
	
	private void createHelpSubScene() {
		
		   final String FONT_PATH = "/resources/kenvector_future.ttf";
		
			
			helpSubscene = new PacmanInSpaceSubScene();
			mainPane.getChildren().add(helpSubscene);
			
			InfoLabel helpLabel = new InfoLabel("Keys to use");
			helpLabel.setLayoutX(110);
			helpLabel.setLayoutY(25);
			
			//left arrow
			ImageView aImage = new ImageView("/resources/leftArrow.png");
			aImage.setLayoutX(50);
			aImage.setLayoutY(85);
			
			Text text = new Text();
			text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
			String leftArrowText = "Move your pacman to left" ;
			text.setText(leftArrowText);
			text.setLayoutX(90);
			text.setLayoutY(110);
			
			//right arrow
			ImageView bImage = new ImageView("/resources/rightArrow.png");
			bImage.setLayoutX(50);
			bImage.setLayoutY(115);
			
			Text text2 = new Text();
			text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
			String rightArrowText = "Move your pacman to right" ;
			text2.setText(rightArrowText);
			text2.setLayoutX(90);
			text2.setLayoutY(140);

			//Create 
			ImageView cImage = new ImageView("/resources/greyCircle.png");
			cImage.setLayoutX(50);
			cImage.setLayoutY(145);
			
			Text text3 = new Text();
			text3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
			String creatPlayer = "Create: Give player name for dashboard" ;
			text3.setText(creatPlayer);
			text3.setLayoutX(90);
			text3.setLayoutY(170);
			
			//Scores 
			ImageView dImage = new ImageView("/resources/greyCircle.png");
			dImage.setLayoutX(50);
			dImage.setLayoutY(175);
			
			Text text4 = new Text();
			text4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
			String creatScore = "Scores: See scores of all players" ;
			text4.setText(creatScore);
			text4.setLayoutX(90);
			text4.setLayoutY(200);
			
			//Exit 
			ImageView eImage = new ImageView("/resources/greyCircle.png");
			eImage.setLayoutX(50);
			eImage.setLayoutY(205);
			
			Text text5 = new Text();
			text5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
			String exit = "Exit: Exit from the game" ;
			text5.setText(exit);
			text5.setLayoutX(90);
			text5.setLayoutY(230);

			helpSubscene.getPane().getChildren().add(helpLabel);
			helpSubscene.getPane().getChildren().add(aImage);
			helpSubscene.getPane().getChildren().add(text);
			helpSubscene.getPane().getChildren().add(bImage);
			helpSubscene.getPane().getChildren().add(text2);
			helpSubscene.getPane().getChildren().add(cImage);
			helpSubscene.getPane().getChildren().add(text3);
			helpSubscene.getPane().getChildren().add(dImage);
			helpSubscene.getPane().getChildren().add(text4);
			helpSubscene.getPane().getChildren().add(eImage);
			helpSubscene.getPane().getChildren().add(text5);
			
		}
	
	private void createCreditsSubScene() {
		creditsSubscene = new PacmanInSpaceSubScene();
		mainPane.getChildren().add(creditsSubscene);
		
		InfoLabel chooseShipLabel = new InfoLabel("HIGH FIVE");
		chooseShipLabel.setLayoutX(110);
		chooseShipLabel.setLayoutY(25);
		ArrayList<String> teamMembers = new ArrayList<String>();
		//read all the lines from the file
		try {
			teamMembers = ReadFromFile("src/view/Team.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		creditsSubscene.getPane().getChildren().add(chooseShipLabel);
		creditsSubscene.getPane().getChildren().add(ShowUserScores(teamMembers));
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public UserScore getUserScore() {
		return userScore;
	}

	public void setUserScore(UserScore userScore) {
		this.userScore = userScore;
	}

	private void createAddUserSubScene() {
		
		createUserSubscene = new PacmanInSpaceSubScene();
		mainPane.getChildren().add(createUserSubscene);
		userScore = new UserScore();
		setUserName(userScore.getName());
		InfoLabel chooseShipLabel = new InfoLabel("ADD YOUR NAME HERE");
		chooseShipLabel.setLayoutX(110);
		chooseShipLabel.setLayoutY(25);
		createUserSubscene.getPane().getChildren().add(chooseShipLabel);
		TextField userName = new TextField();
		userName.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		userName.setLayoutX(150);
		userName.setLayoutY(150);
		userName.setPrefWidth(300);
		userName.setPrefHeight(50);
		userName.setAlignment(Pos.CENTER);
	
		EventHandler<KeyEvent> event = new EventHandler<KeyEvent>() {
            @Override
			public void handle(KeyEvent e)
            {
            	setUserName(userName.getText());
            }
        };
        userName.addEventHandler(KeyEvent.KEY_TYPED, event);
        createUserSubscene.getPane().getChildren().add(userName);
        createUserSubscene.getPane().getChildren().add(createSubmitButton());
	}
	
	private PacmanInSpaceButton createSubmitButton() {
		
		PacmanInSpaceButton submitButton = new PacmanInSpaceButton("SUBMIT");
		//to fix the X and Y coordinates of the button
		submitButton.setLayoutX(350);
		submitButton.setLayoutY(300);
		
    	//System.out.print(getUserName());
		//action handler method for that button
    	submitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				userScore.setName(getUserName());
				System.out.print(userScore.getName());
			}
		});
		
		return submitButton;
	}

	
//	private void createShipChooserSubScene() {
//		
//		shipChooserSubscene = new SpaceRunnerSubScene();
//		mainPane.getChildren().add(shipChooserSubscene);
//		
//		InfoLabel chooseShipLabel = new InfoLabel("CHOOSE YOUR SHIP");
//		chooseShipLabel.setLayoutX(110);
//		chooseShipLabel.setLayoutY(25);
//		shipChooserSubscene.getPane().getChildren().add(chooseShipLabel);
//		shipChooserSubscene.getPane().getChildren().add(createShipsToChoose());
//		shipChooserSubscene.getPane().getChildren().add(createButtonToStart());
//
//	}
	
	private void createScoreSubScene() {
		
		scoreSubscene = new PacmanInSpaceSubScene();
		mainPane.getChildren().add(scoreSubscene);
		
		InfoLabel chooseShipLabel = new InfoLabel("SCORE BOARD");
		chooseShipLabel.setLayoutX(110);
		chooseShipLabel.setLayoutY(25);
		ArrayList<String> usersScores = new ArrayList<String>();
		//read all the lines from the file
		try {
			//src/view/LeaderBoard.txt
			//usersScores = ReadFromFile("C:\\Users\\siddh\\OneDrive\\Desktop\\OOD\\space-runner-game-javafx-main\\space-runner-game-javafx-main\\src\\view\\LeaderBoard.txt");
			usersScores = ReadFromFile("src/view/LeaderBoard.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scoreSubscene.getPane().getChildren().add(chooseShipLabel);
		//create SmallInfoLabels for each of the lines and add them to the scene
		scoreSubscene.getPane().getChildren().add(ShowUserScores(usersScores));
		
	}
	
	private VBox ShowUserScores(ArrayList<String> Scores) {
		VBox box = new VBox();
		box.setSpacing(10);
		List<String> list = new ArrayList<>();
		for (String userScore : Scores) {
			UserScoreLabel scoreLabel = new UserScoreLabel(userScore);
			box.getChildren().add(scoreLabel);	
		}
		
		box.setLayoutX(140);
		box.setLayoutY(100);
		return box;
	}
	
	public static ArrayList<String> ReadFromFile(String fileName) throws FileNotFoundException{
		
		File file1 = new File(fileName);
		Scanner s = new Scanner(file1);
		ArrayList<String> usersList = new ArrayList<String>();
		while(s.hasNextLine()) {
			String line = s.nextLine();
			usersList.add(line);
		}
		return usersList;
	}
	
//	private HBox createShipsToChoose() {
//		HBox box = new HBox();
//		box.setSpacing(60);
//		shipsList = new ArrayList<>();
//		for (PACMAN ship : PACMAN.values()) {
//			ShipPicker shipToPick = new ShipPicker(ship);
//			shipsList.add(shipToPick);
//			box.getChildren().add(shipToPick);
//			shipToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//				@Override
//				public void handle(MouseEvent event) {
//					for (ShipPicker ship : shipsList) {
//						ship.setIsCircleChoosen(false);
//					}
//					shipToPick.setIsCircleChoosen(true);
//					choosenShip = shipToPick.getShip();
//					
//				}
//			});
//		}
//		
//		box.setLayoutX(300 - (118*2));
//		box.setLayoutY(100);
//		return box;
//	}
	
	
	
//	private PacmanInSpaceButton createButtonToStart() {
//		
//		PacmanInSpaceButton startButton = new PacmanInSpaceButton("START");
//		//to fix the X and Y coordinates of the button
//		startButton.setLayoutX(350);
//		startButton.setLayoutY(300);
//		//action handler method for that button
//		startButton.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				if (choosenShip != null) {
//					//if the user has chosen a ship and clicked on the start button
//					//we then create a new game
//				    gameManager = new GameViewManager();
//					gameManager.createNewGame(mainStage, choosenShip);
//				}
//				
//			}
//		});
//		
//		return startButton;
//	}
	
	private void AddMenuButtons(PacmanInSpaceButton button) {
		button.setLayoutX(MENU_BUTTON_START_X);
		button.setLayoutY(MENU_BUTTON_START_Y + menuButtons.size() * 100);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}
	
	private void createUserButton() {
		
		PacmanInSpaceButton createUserButton = new PacmanInSpaceButton("CREATE USER");
		AddMenuButtons(createUserButton);
		
		createUserButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(createUserSubscene);
			}
		});
	}
	
	private void createStartButton() {
		PacmanInSpaceButton startButton = new PacmanInSpaceButton("PLAY");
		AddMenuButtons(startButton);
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//showSubScene(shipChooserSubscene);
				
				//if (choosenShip != null) {
					//if the user has chosen a ship and clicked on the start button
					//we then create a new game
				    gameManager = new GameViewManager();
					gameManager.createNewGame(mainStage, PACMAN.YELLOW);
				//}
			}
		});
	}
	
	private void createScoresButton() {
		PacmanInSpaceButton scoresButton = new PacmanInSpaceButton("SCORES");
		AddMenuButtons(scoresButton);
		
		scoresButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(scoreSubscene);
				
			}
		});
	}
	
	private void createHelpButton() {
		PacmanInSpaceButton helpButton = new PacmanInSpaceButton("HELP");
		AddMenuButtons(helpButton);
		
		helpButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(helpSubscene);
				
			}
		});
	}
	
	private void createCreditsButton() {
		
		PacmanInSpaceButton creditsButton = new PacmanInSpaceButton("CREDITS");
		AddMenuButtons(creditsButton);
		
		creditsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(creditsSubscene);
				
			}
		});
	}
	
	private void createExitButton() {
		PacmanInSpaceButton exitButton = new PacmanInSpaceButton("EXIT");
		AddMenuButtons(exitButton);
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				//System.out.println("your score ---"+ gameManager.getPoints());
				try {
					SaveToFile("src/view/LeaderBoard.txt",String.valueOf(userScore.getScore()), true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
//				userScore.setScore(gameManager.getPoints());
//				System.out.print(userScore.getName());
//				System.out.print(userScore.getScore());
				mainStage.close();
				
			}
		});
		
	}
	
	public static void SaveToFile(String fileName, String score, boolean append) throws IOException {
		
		System.out.println("saving details to file"+score);
		System.out.println("file name ---"+fileName);
		File file1 = new File(fileName);
		FileWriter fw = new FileWriter(file1, append);
		PrintWriter pw = new PrintWriter(fw);
		
		if(!savedUserScoreToFile) {
			
			try {
				pw.println(userScore.getName()+" - "+score);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			savedUserScoreToFile = true;
		}
		
		pw.close();
		
	}

	//to create the logo
	private void createLogo() {
		ImageView logo = new ImageView("/resources/title.jpg");
		logo.setLayoutX(380);
		logo.setLayoutY(50);
		
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(new DropShadow());
				
			}
		});
		
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(null);
				
			}
		});
		
		mainPane.getChildren().add(logo);	
	}
	
	//for the background
	private void createBackground() {
		/*Image backgroundImage = new Image("/resources/space_background.gif", 256, 256, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);*/
		//Image backgroundImage = new Image("/resources/space_background.gif",  1024, 768,false, false);
		Image backgroundImage = new Image("/resources/pacman_bg.jpg",  1024, 768,false,false);
		ImageView imageView = new ImageView(backgroundImage);
		
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	
	
	
	

}
