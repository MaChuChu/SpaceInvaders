
package spaceinvaders;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends Sprite{
    
    private double dx;
    
    private boolean left,right;
    private KeyCode leftKey,rightKey,upKey;
    private double SpeedMulti = 10;
    
    Player(double x, double y, double width, double height,Color colour, KeyCode leftKey, KeyCode rightKey, KeyCode upKey){
        super(x, y, width, height, colour);
        
        rect.setArcHeight(20);
        rect.setArcWidth(20);
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.upKey = upKey;
    }  

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDx() {
        return dx;
    }

    void keyPressed(KeyEvent code) {
        KeyCode kc = code.getCode();
        if(kc==leftKey){
            right = false; left = true;
        }
        else if(kc==rightKey){
            right = true; left = false;
        }
        
    }
    
    void keyReleased(KeyEvent code) {
        KeyCode kc = code.getCode();
        if(kc==leftKey){
            left = false;
        }
        else if(kc==rightKey){
            right = false;
        }
        
    }

    public void move(){
        if(left){
            if(x>0){
                dx = -SpeedMulti;
            }else{
                left=false; dx=0;       
            }
        }
        else if (right){
            if (x<800-20) {
                dx = SpeedMulti;
            }else{
                right=false; dx=0; 
            }
        }
        
        x+=getDx();
        rect.setX(x);
    }
    
}
