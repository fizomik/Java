package shapesAbstract;

import java.awt.*;
import java.util.Random;

public class Square extends Shape{

    public Square(String _name,int x, int y){
        name=_name;
        this.x = x;
        this.y = y;
    }
    public void setBounds(int xIn, int yIn) {
        x = xIn;
        y = yIn;
    }

    public Square(String _name){ this.name=_name; }

    @Override
    public void draw(Graphics arg0) {
        Graphics g =arg0;
        g.setColor(Color.blue);
        g.fillRect(x, y, 50, 50);
        //System.out.println("Your "+name);

    }

}
