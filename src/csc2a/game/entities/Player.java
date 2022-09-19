package csc2a.game.entities;

import javafx.scene.image.Image;

/**
 * @author Maimouna Diallo
 * Version Prac X
 * Player class 
 */
public class Player {
	private double playerX;
	private double playerY;
	private Image PlImage;
	
	public Player(double playerX,double playerY,Image PlImage) {
		this.playerX= playerX;
		this.playerY= playerY;
		this.PlImage=PlImage;
	
	}

}
