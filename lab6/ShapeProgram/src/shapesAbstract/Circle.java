package shapesAbstract;
import java.util.Random;
import java.awt.*;

public class Circle extends Shape{

    public Circle(String _name, int x, int y){
        name=_name;
        this.x = x;
        this.y = y;
    }
    public void setXandY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics arg0) {
        Graphics g = arg0;
        g.setColor(Color.yellow);
        g.fillOval(x, y, 50, 50);
        //System.out.println("Your "+name);

    }

}
