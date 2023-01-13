package view;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;

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
import model.CustomBigLabel;
import model.PacMan;
import model.CustomSmallLabel;
import model.CustomButton;
import model.CustomSubScene;
import model.UserScore;
import model.UserScoreLabel;


public class GameDashboard {
	
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
	private CustomSubScene createUserSubscene;
	private CustomSubScene creditsSubscene;
	private CustomSubScene helpSubscene;
	private CustomSubScene scoreSubscene;
	private CustomSubScene sceneToHide;
	
	//
	List<CustomButton> menuButtons;
	
	//for storing user name and scores
	private String userName;
	private static UserScore userScore;
	
	//instance of the actual Game Screen
	private PacManScreen pacManScreen;
	
	private static boolean savedUserScoreToFile = false;
		
	public GameDashboard() {
		
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		
		menuButtons = new ArrayList<>();
		createSubScenes();//to create the subscenes of each button on the main scene
		CreateButtons(); //to create the buttons on the main scene
		createBackground();//to create the backgrounf to the game dashboard
	}

	public Stage getMainStage() {
		return mainStage;
	}
	
	//method to create buttons on the dashboardScreen
	private void CreateButtons() {
		createUserButton();
		createStartButton();
		createScoresButton();
		createHelpButton();
		createCreditsButton();
		createExitButton();
	}
	
	//method to show and hide subscenes
	private void showSubScene(CustomSubScene subScene) {
		if (sceneToHide != null) {
			sceneToHide.moveSubScene();
		}
		
		subScene.moveSubScene();
		sceneToHide = subScene;
	}
	
	//method to create subscenes
	private void createSubScenes() {
		createAddUserSubScene();
		createScoreSubScene();
		createHelpSubScene();
		createCreditsSubScene();
		//createShipChooserSubScene();
	}
	
	private void createHelpSubScene() {
		
		   final String FONT_PATH = "/resources/kenvector_future.ttf";
			
			helpSubscene = new CustomSubScene();
			mainPane.getChildren().add(helpSubscene);
			
			CustomBigLabel helpLabel = new CustomBigLabel("Keys to use");
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
		
		creditsSubscene = new CustomSubScene();
		mainPane.getChildren().add(creditsSubscene);
		
		CustomBigLabel teamLabel = new CustomBigLabel("HIGH FIVE");
		teamLabel.setLayoutX(110);
		teamLabel.setLayoutY(25);
		HashSet<String> teamMembers = new HashSet<String>();
		//read all the lines from the file
		try {
			teamMembers = new HashSet<String>(ReadFromFile("src/view/Team.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		creditsSubscene.getPane().getChildren().add(teamLabel);
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
		
		createUserSubscene = new CustomSubScene();
		mainPane.getChildren().add(createUserSubscene);
		userScore = new UserScore();
		setUserName(userScore.getName());
		CustomBigLabel addUserNameLabel = new CustomBigLabel("ADD YOUR NAME HERE");
		addUserNameLabel.setLayoutX(110);
		addUserNameLabel.setLayoutY(25);
		createUserSubscene.getPane().getChildren().add(addUserNameLabel);
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
	
	private CustomButton createSubmitButton() {
		
		CustomButton submitButton = new CustomButton("SUBMIT");
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
	
	private void createScoreSubScene() {
		
		scoreSubscene = new CustomSubScene();
		mainPane.getChildren().add(scoreSubscene);
		
		CustomBigLabel scoreLabel = new CustomBigLabel("SCORE BOARD");
		scoreLabel.setLayoutX(110);
		scoreLabel.setLayoutY(25);
		HashSet<String> usersScores = new HashSet<>();
		//read all the lines from the file
		try {
			usersScores = new HashSet<String>(ReadFromFile("src/view/LeaderBoard.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scoreSubscene.getPane().getChildren().add(scoreLabel);
		//create SmallInfoLabels for each of the lines and add them to the scene
		scoreSubscene.getPane().getChildren().add(ShowUserScores(usersScores));
		
	}
	
	private VBox ShowUserScores(HashSet<String> Scores) {
		VBox box = new VBox();
		box.setSpacing(10);
		List<String> list = new ArrayList<String>();
		Iterator<String> userScores = Scores.iterator();
		while(userScores.hasNext()) {
			UserScoreLabel scoreLabel = new UserScoreLabel(userScores.next());
			box.getChildren().add(scoreLabel);
		}
		box.setLayoutX(140);
		box.setLayoutY(100);
		return box;
	}
	
	public static List<String> ReadFromFile(String fileName) throws FileNotFoundException{
		
		File file1 = new File(fileName);
		Scanner s = new Scanner(file1);
		ArrayList<String> usersList = new ArrayList<String>();
		while(s.hasNextLine()) {
			String line = s.nextLine();
			usersList.add(line);
		}
		return usersList;
	}
	
	private void AddMenuButtons(CustomButton button) {
		button.setLayoutX(MENU_BUTTON_START_X);
		button.setLayoutY(MENU_BUTTON_START_Y + menuButtons.size() * 100);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}
	
	private void createUserButton() {
		
		CustomButton createUserButton = new CustomButton("PLAYER");
		AddMenuButtons(createUserButton);
		
		createUserButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showSubScene(createUserSubscene);
			}
		});
	}
	
	private void createStartButton() {
		CustomButton startButton = new CustomButton("PLAY");
		AddMenuButtons(startButton);
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				    pacManScreen = new PacManScreen();
					pacManScreen.createNewGame(mainStage, PacMan.YELLOW); 
				
			}
		});
	}
	
	private void createScoresButton() {
		CustomButton scoresButton = new CustomButton("SCORES");
		AddMenuButtons(scoresButton);
		
		scoresButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(scoreSubscene);
				
			}
		});
	}
	
	private void createHelpButton() {
		CustomButton helpButton = new CustomButton("HELP");
		AddMenuButtons(helpButton);
		
		helpButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(helpSubscene);
				
			}
		});
	}
	
	private void createCreditsButton() {
		
		CustomButton creditsButton = new CustomButton("CREDITS");
		AddMenuButtons(creditsButton);
		
		creditsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(creditsSubscene);
				
			}
		});
	}
	
	private void createExitButton() {
		CustomButton exitButton = new CustomButton("EXIT");
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
		
		Image backgroundImage = new Image("/resources/pacman_bg.jpg",  1024, 768,false,false);
		ImageView imageView = new ImageView(backgroundImage);
		
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
}
