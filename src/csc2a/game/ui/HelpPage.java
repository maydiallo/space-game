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
/**
 * @author Maimouna Diallo
 * Version Prac X
 * Creates the Help Page
 */
public class HelpPage extends StackPane {
	private static final int WIDTH = 540;
	private static final int HEIGHT= 540;
	private static Button btnBack = new Button("back");
	private Font fontbtn = Font.loadFont("file:data/fonts/WimCrouwel68Regular-d9vPE.ttf", 30);
	private STATE currentState;
	
	public HelpPage() {
		//Setting the defaults for how the page should look
		this.setPrefSize(WIDTH, HEIGHT);
		currentState = STATE.HELP;
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		
		//Creation of title 
		Text Title = new Text();
		Title.setText("help");
		Title.setFill(Color.WHITE);
		this.setAlignment(Title, Pos.TOP_CENTER);
		Title.setFont(Font.loadFont("file:data/fonts/BatmanFuture-8VZA.ttf", 120));
		
		//Creation of back button
		btnBack.setStyle("-fx-background-color: black; -fx-text-fill: white");
		btnBack.setFont(fontbtn);
		btnBack.setTranslateX(0);
		btnBack.setTranslateY(200);
		
		//Creatio of Text instructions
		Text Instruct = new Text();
		Instruct.setText("1. Moving Keys: A and D or Arrow Keys < and >"+ System.lineSeparator()+
				"2. Avoid Enemy ships, if you come in contact with one Game Over"+ System.lineSeparator()+
				"3. If you avoid it till the end of the line you win");
		Instruct.setFill(Color.WHITE);
		this.setAlignment(Instruct, Pos.CENTER_LEFT);
		Font Arial = new Font("Arial", 18);
		Instruct.setFont(Arial);
		
		//Adding all the components to the pane
		this.getChildren().add(Instruct);
		this.getChildren().add(btnBack);
		this.getChildren().add(Title);
	}
	
	public static void back(Stage open, Stage close)
	{
		EventHandler<ActionEvent> backToMain = new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e)
		    	{
		    		open.show();
		    		close.close();
		    	}
			 };
			 btnBack.setOnAction(backToMain);
	}
	
	
	
	

}
