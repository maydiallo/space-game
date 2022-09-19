package csc2a.game.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//References for fonts used 
/*
 * Date:JAN 4, 2021
 * Title:Wim Crouwel 68 Font
 * URL:https:https://www.fontspace.com/wim-crouwel-68-font-f54664
*/

/*
 * Date:AUG 16, 2018
 * Title:Batman Future Font
 * URL:https://www.fontspace.com/batman-future-font-f30266
*/

/**
 * @author Maimouna Diallo
 * Version Prac X
 * Class that places all the UI elements together so it can be used seamlessly i the main
 */
public class StartPage extends StackPane {
	//Variables
	private STATE currentState;
	private Font fontbtn = Font.loadFont("file:data/fonts/WimCrouwel68Regular-d9vPE.ttf", 30);
	private static final int WIDTH = 540;
	private static final int HEIGHT= 540;
	
	
	
	/**
	 * @param help
	 * @param main
	 * @param game
	 * creates the main page for the game with use of the Main Page function
	 */
	public StartPage(Stage help, Stage main, Stage game)
	{
		//Creation of Main page
		this.setPrefSize(WIDTH, HEIGHT);
		currentState = currentState.START;
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		MainPage(help,main, game);
	}
	
	/**
	 * @param help
	 * @param main
	 * @param game
	 * Places all components formatted onto the main page
	 */
	public void MainPage(Stage help, Stage main, Stage game)
	{
		//Title that will be displayed
		Text Title = new Text();
		Title.setText("abyss");
		Title.setFill(Color.WHITE);
		this.setAlignment(Title, Pos.TOP_CENTER);
		Title.setFont(Font.loadFont("file:data/fonts/BatmanFuture-8VZA.ttf", 120));

		//All the buttons and functionalities are made
		Button btnStart = new Button("Start");
		btnStart.setTranslateX(0);
		btnStart.setStyle("-fx-text-fill: white");
		btnStart.setTranslateY(0);
		btnStart.setFont(fontbtn);
		btnStart.setStyle("-fx-background-color: black; -fx-text-fill: white");
		start(btnStart, main, game);
		
		Button btnHelp = new Button("Help");
		btnHelp.setStyle("-fx-text-fill: white");
		btnHelp.setFont(fontbtn);
		btnHelp.setTranslateX(0);
		btnHelp.setTranslateY(50);
		btnHelp.setStyle("-fx-background-color: black; -fx-text-fill: white");
		help(btnHelp,help,main);
		
		Button btnExit = new Button("Exit");
		btnExit.setStyle("-fx-background-color: black; -fx-text-fill: white");
		btnExit.setFont(fontbtn);
		btnExit.setTranslateX(0);
		btnExit.setTranslateY(100);
		exit(btnExit);
		
		//Added to the pane
		this.getChildren().add(Title);
		this.getChildren().add(btnStart);
		this.getChildren().add(btnHelp);
		this.getChildren().add(btnExit);
	}
	
	
	/**
	 * @param btnExit
	 * exits the game when clicked
	 */
	private void exit(Button btnExit)
	{
		currentState = currentState.EXIT;
		EventHandler<ActionEvent> exitGame = new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e)
		    	{
		            System.exit(0);
		    	}
			 };
			 btnExit.setOnAction(exitGame);
	}
	
	/**
	 * @param btnHelp
	 * @param open
	 * @param close
	 * sends you to help page when clicked
	 */
	private void help(Button btnHelp, Stage open, Stage close)
	{	
		EventHandler<ActionEvent> helpPage = new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e)
		    	{
		    			HelpPage.back(close,open);
		    			close.close();
		    			open.show();
		    			
		    		}
			 };
			 btnHelp.setOnAction(helpPage);
	}
	
	/**
	 * @param btnStart
	 * @param close
	 * @param open
	 * begins the game
	 */
	private void start(Button btnStart, Stage close, Stage open)
	{	
		
		EventHandler<ActionEvent> gamePage = new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e)
		    	{
		    		
		    			close.close();
		    			open.show();
		   
		    		
		    	}
			 };
			 btnStart.setOnAction(gamePage);
	}
	
	
	
	
	
	
	 
}
