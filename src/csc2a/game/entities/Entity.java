package csc2a.game.entities;

import javafx.animation.AnimationTimer;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;




/**
 * @author Maimouna Diallo
 * Version Prac X
 * Class that creates and places entities
 */

public class Entity extends Canvas{
	private double playX;
	private double playY;
	private double[] enemX;
	private double[] enemY;
	private Image PlImage;
	private Image EnImage;
	private Player player;
	private static final int SIZE=60;
	private GraphicsContext gc;
	private static final int DIMENSION = 540;
	private static int ARRAYLEN = 7;
	private static final double upperboundY = 270;
	private static final double upperboundX = 421;
	private Rectangle[] boxEnem = new Rectangle[ARRAYLEN];
	private Enemy enemy;
	

	/**
	 * @param playX
	 * @param playY
	 * @param PlImage
	 * @param EnImage
	 * constructor initializes all variables
	 */
	public Entity(double playX,double playY,Image PlImage, Image EnImage) {
		
		this.setHeight(540);
		this.setWidth(540);
		gc = getGraphicsContext2D();
		player = new Player(playX,playY,PlImage);
		enemX = new double[ARRAYLEN];
		enemY = new double[ARRAYLEN];
		this.playX= playX;
		this.playY=playY;
		this.PlImage = PlImage;
		this.EnImage = EnImage;
		
		//Loop to instantiate all enemies as well as check if they intersect 
		for(int i = 0 ; i<enemX.length;i++)
		{
			enemX[i]= (double)(Math.random() * upperboundX) + 60;
			enemY[i]=(double)(Math.random() * upperboundY);
			boxEnem[i] = new Rectangle(enemX[i],enemY[i], SIZE, SIZE);
			
				if (boxEnem[i].intersects(enemX[i]+1,enemY[i]+1, SIZE, SIZE)) {
					enemX[i]= (double)(Math.random() * upperboundX) + 60;
					enemY[i]=(double)(Math.random() * upperboundY);
			
		}
				
		
			enemy = new Enemy (enemX[i], enemY[i], EnImage);
		}
		
		
	}
	
	/**
	 * Begins timer for objects to move based on the Move entities class
	 */
	public void move()
	{	
		AnimationTimer timer = new MoveEntities();
		timer.start();
	}
	
	
	/**
	 * Draws the player incrementing the Y value so it's constantly in motion
	 */
	private void drawPlayer() {
		playY-=0.25;
		gc.drawImage(PlImage, playX,playY, SIZE, SIZE);	
	}
	
	/**
	 * Draws the enemies incrementing the Y value so it's constantly in motion
	 */
	public void drawEnemy() {
		
		for(int i = 0; i<enemX.length; i++)
		{
			enemY[i]+=0.25;
			 gc.drawImage(EnImage,enemX[i], enemY[i], SIZE, SIZE);
		}
	    	 
	         
	}
	
	/**
	 * Relocates values based on keyboard input using AnimationTimer
	 */
	public void rel(double xPl) {
		 AnimationTimer mytimer = new AnimationTimer() {
	            @Override
	            public void handle(long now) {
	            	//Always begin by clearing and then move the objects
	            	gc.clearRect(0, 0, DIMENSION, DIMENSION);
	            	for(int i = 0; i<enemX.length; i++)
	        		{
	        			 gc.drawImage(EnImage,enemX[i], enemY[i], SIZE, SIZE);
	        			
	        		}	
	            	gc.drawImage(PlImage, xPl,playY, SIZE, SIZE);
	            	
	            	if (playY==0)
	            	{
	            		stop();
	            		Win();
	            	}else if(xPl==540)
	            	{
	            		stop();
 					     GameOver();
	            	}else if(xPl==540)
	            	{
	            		stop();
 					     GameOver();
	            	}
	            	
	            	for(int i = 0 ; i<enemX.length;i++)
	    			{
	    				if (boxEnem[i].intersects(playX,playY,SIZE, SIZE)) {
	      					     stop();
	      					     GameOver();
	      					}
	    				
	    			}
	            
	            }
	           
	        
	        };
		
	        mytimer.start();
	}

	
	
	
	/**
	 * Game Over printed by gc
	 */
	private void GameOver() {
		gc.setFont(Font.loadFont("file:data/fonts/BatmanFuture-8VZA.ttf", 120));
		gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFill(Color.WHITE);
        gc.fillText(
            "Game Over", 
            Math.round(this.getWidth()  / 2), 
            Math.round(this.getHeight() / 2)
        );
        
       
		
	}
	
	/**
	 * Win printed by gc
	 */
	private void Win() {
		gc.setFont(Font.loadFont("file:data/fonts/BatmanFuture-8VZA.ttf", 120));
		gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFill(Color.WHITE);
        gc.fillText(
            "Win", 
            Math.round(this.getWidth()  / 2), 
            Math.round(this.getHeight() / 2)
        );
        
		
	}
	
	
	private class MoveEntities extends AnimationTimer{
		
		@Override
		public void handle(long now) {
			gc.clearRect(0, 0, DIMENSION, DIMENSION);
			
			
			drawPlayer();
			drawEnemy();
			if (playY==0)
        	{
        		stop();
        		Win();
        	}
			for(int i = 0 ; i<enemX.length;i++)
			{
				if (boxEnem[i].intersects(playX,playY,SIZE, SIZE)) {
  					     stop();
  					     GameOver();
  					}
				
			}
			
			 
			
		
		}

	}
	
}


