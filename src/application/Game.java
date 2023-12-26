package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Game extends Canvas {
    private GraphicsContext gc;
    private Timeline tm;
    private BorderPane root;
    private int speed;
    private Color color;

    public Game(double x, double y, Color color, int speed, BorderPane root) {
        super(700, 700);
        this.setLayoutX(x);
        this.setLayoutY(y);
        gc = getGraphicsContext2D();
        this.speed = speed;
        this.root = root;
        this.color = color;
        work();
        add(this.color);
    }

    public void work() {
        tm = new Timeline(new KeyFrame(Duration.millis(16), e -> moveUp()));
        tm.setCycleCount(Animation.INDEFINITE);
        tm.play();
    }

    public void add(Color color) {
        gc.setFill(Color.BLACK);
        gc.setFill(color);
        gc.fillOval(20, 20, 50, 70);
        
    }

    public void moveUp() {
        if (this.getLayoutY() <= 1 || this.getLayoutX() >= root.getWidth() || this.getLayoutX() <= 1) {
            tm.stop();
            root.getChildren().remove(this);
        } else {
            this.setLayoutY(getLayoutY() - speed);
        }
    }
}
