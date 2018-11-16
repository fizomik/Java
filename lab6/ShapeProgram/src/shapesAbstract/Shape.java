package shapesAbstract;

import java.awt.*;

public abstract class Shape {

    public int x,y;
    public String name;
    public abstract void draw(Graphics arg0);
    public abstract void setBounds(int xIn, int yIn);

}

