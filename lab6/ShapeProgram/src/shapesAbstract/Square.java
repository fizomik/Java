package shapesAbstract;

import java.awt.*;

public class Square extends Shape{

    public Square(String _name,int x, int y){
        name=_name;
        this.x = x;
        this.y = y;
    }
    public void setXandY(int x, int y) {
        this.x = x;
        this.y = y;
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
