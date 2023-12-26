package application;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Gener extends Canvas{
	private double height;
	private BorderPane root;
	private Random random ;
	private int speed;
	
	
	public Gener(BorderPane root,double height) {
		this.height = height;
		this.root = root;
		this.random = new Random();
		this.speed = 15;
		generate();
	}
	private void generate() {
		Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                	Game bloon = new Game(random.nextInt((int)Math.round(root.getHeight()-100) - 40 + 1) + 40,this.height,
                			Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)),  
                			random.nextInt(this.speed), root);
                	bloon.setOnMouseClicked((evt)->{
                		root.getChildren().remove(bloon);
                		});
                	root.getChildren().add(bloon);
                }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
	}
	
	
	
}
