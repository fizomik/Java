package shapesAbstract;

import java.awt.*;
import java.util.Random;

public class Rectangle extends Shape{


    public Rectangle(String _name,int x, int y){
        name=_name;
        this.x = x;
        this.y = y;
    }


    @Override
    public void draw(Graphics arg0) {
        Graphics g = arg0;
        g.setColor(Color.green);
        g.fillRect(x, y, 25, 50);
        //System.out.println("Your "+name);

    }

}

