package shapesAbstract;
import java.awt.*;
import java.util.Random;

public class Triangle extends Shape{


    public Triangle(String _name, int x, int y){
        name=_name;
        this.x = x;
        this.y = y;
    }


    @Override
    public void draw(Graphics arg0){
        Graphics g = arg0;
        Polygon triangle;
        triangle = new Polygon();
        triangle.addPoint(x, y);
        triangle.addPoint(x+50, y);
        triangle.addPoint((2*x+50)/2, y-50);
        g.setColor(Color.red);
        g.fillPolygon(new int[]{x, x+50, (2*x+50)/2}, new int[]{y, y, y-50},3);
    }
}

