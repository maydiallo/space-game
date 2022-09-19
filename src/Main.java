import csc2a.game.entities.Entity;
import csc2a.game.ui.GamePage;
import csc2a.game.ui.HelpPage;
import csc2a.game.ui.StartPage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//References for images used 
/*
* Date:March 7, 2021
* Title:Pixel Space Ship
* URL:https:https://opengameart.org/content/pixel-space-ship
*/

/*
* Date: November 7, 2020
* Title: Shiper_remix_h_hover_0
* URL:https://opengameart.org/content/ship-sprites-0
*/

/**
 * @author Maimouna Diallo
 * Version Prac X
 * Initializes and sets all JavaFX components so it can run through the application
 */
public class Main extends Application implements EventHandler<KeyEvent>{
	
	//variables
	private static double leftRight =240;
	private static double movePl =480;
	private static Image ENEMY_IMG = new Image("file:data/enemy.png");
	private static Image PLAYER_IMG = new Image("file:data/player.png");
	Entity entity = new Entity(leftRight,movePl,PLAYER_IMG, ENEMY_IMG);
	
	private HelpPage helpPane = null;
	private StartPage startPane = null;
	private GamePage gamePane= null;
	private Stage helpStage = new Stage();
	private Stage gameStage = new Stage();
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	
		//showing of the main page
		Text text = new Text();
		startPane = new StartPage(helpStage,primaryStage,gameStage);
		try {
			Scene scene = new Scene(startPane); // Placing the pane in the Scene.
			primaryStage.setTitle("Abyss");
			primaryStage.setScene(scene); // Adding the Scene to the Stage.
			primaryStage.show(); // Displaying the Stage.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//showing of the help page
		helpPane = new HelpPage();
		try {
			Scene helpScene = new Scene(helpPane); // Placing the pane in the Scene.
			helpStage.setTitle("Help");
			helpStage.setScene(helpScene); // Adding the Scene to the Stage.
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
		//showing of the game page
		gamePane = new GamePage(entity);
		gamePane.getChildren().add(text);
		try {
			
			Scene GameScene = new Scene(gamePane);  // Placing the pane in the Scene.
			gameStage.setTitle("Game");
			gameStage.setScene(GameScene); // Displaying the Stage.
			//Accepts Input from here 
			entity.move();
			GameScene.setOnKeyPressed(this);
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
		
	}
	
	
	/**
	 *Changes the X value of the player based on user input
	 */
	@Override
	public void handle(KeyEvent event) {
		//Use of switch statement to get and interpret code
				switch(event.getCode())
				{
				case LEFT: 
				case A:
					leftRight-=1;
					entity.rel(leftRight);
				    break;
				case RIGHT:
				case D:
					leftRight+=1;
					entity.rel(leftRight);
					  break;
				default:
					break;
				}
				
	}


}
