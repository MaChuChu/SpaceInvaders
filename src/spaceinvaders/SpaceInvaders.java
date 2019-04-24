
package spaceinvaders;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SpaceInvaders extends Application {
    Group g = new Group();
    Scene scene = new Scene(g, 800, 800);
    
    Player player;
    Alien[] alien = new Alien[8];
    bullet bullet;
    
    @Override
    public void start(Stage primaryStage) {
        
        player = new Player(400,700,20,20,Color.WHITE, KeyCode.A, KeyCode.D,KeyCode.W);
        bullet = new bullet(player.getX(),player.getY(),5,5,Color.YELLOW);
        for (int i = 0; i < alien.length; i++) {
            alien[i] = new Alien(20+(i*101),20,50,50,Color.RED);
            g.getChildren().add(alien[i].getRect()); 
        }
        g.getChildren().add(player.getRect());
        
        
        scene.setFill(Color.BLACK);
        
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                    player.keyPressed(event);
                    if (event.getCode() == KeyCode.W) {
                           shoot();
                           
                    }
                }
                 
            });          
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
              player.move();  
              bullet.move();
              hit();
            }
         }.start();
        
        primaryStage.setTitle("Space Invaders!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private void shoot(){
        System.out.println("BANG");
        bullet = new bullet(player.getX(),player.getY(),5,5,Color.YELLOW);
        g.getChildren().add(bullet.getRect());
        
    }

    private void hit() {
        for (Alien A:alien) {
            if (bullet.getRect().getBoundsInParent().intersects(A.getRect().getBoundsInParent())) {
                System.out.println("hit");
                Random random = new Random();

                A.setX(random.nextInt(255));
                A.setY(random.nextInt(255));
                A.setRect();
             } 
        }
        
    }
    
}
