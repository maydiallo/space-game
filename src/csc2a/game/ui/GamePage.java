package csc2a.game.ui;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import csc2a.game.entities.Entity;


/**
 * @author Maimouna Diallo
 * Version Prac X
 * Creates the Game page
 */
public class GamePage extends StackPane {
	private static final int WIDTH = 540;
	private static final int HEIGHT= 540;
	
	public GamePage(Entity e) {
		//Setting the defaults for how the page should look
		this.setPrefSize(WIDTH, HEIGHT);
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
	
		//adding components to pane
		this.getChildren().add(e);
	
	}
	
	
	
}

