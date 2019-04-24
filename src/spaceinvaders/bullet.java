
package spaceinvaders;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class bullet extends Sprite{
    
    public bullet(double x, double y, double width, double height, Color colour) {
        super(x, y, width, height, colour);
        rect.setArcHeight(20);
        rect.setArcWidth(20);
        
    }
    void move(){
        y-=10;
        rect.setY(y);
    }
}
