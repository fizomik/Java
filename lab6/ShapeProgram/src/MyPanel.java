import shapesAbstract.Shape;
import shapesAbstract.Square;
import shapesAbstract.Rectangle;
import shapesAbstract.Circle;
import shapesAbstract.Triangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

    public int x1,y1,x2,y2,x3,y3;
    private Point movingPoint;
    static ArrayList<Point> points = new ArrayList<Point>();
    private static List<shapesAbstract.Shape> listofshapes = new LinkedList<>();


    MyPanel(){
        super();
        setPreferredSize(new Dimension(1920, 1080));
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        System.out.println("mouseMoved");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        int index = 0;
        int size = points.size();
        Point p;

        while (movingPoint == null && index < size) {
            p = points.get(index);
            x2 = (int) p.getX();
            y2 = (int) p.getY();
            if (x1 >= x2 && y1 >= y2 && x1 <= x2 + 50 && y1 <= y2 + 50) {
                movingPoint = p;
            }
            index++;
        }

        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (movingPoint != null) {
            movingPoint.x = e.getX();
            movingPoint.y = e.getY();
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        System.out.println("mouseEntered");
    }
    public void mouseClicked(MouseEvent e) {

        System.out.println("mouseClicked");
    }

    @Override
    public void mouseExited(MouseEvent e) {

        System.out.println("mouseExited");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        movingPoint = null;
    }

    static void addCircle(){
        Random r = new Random();
        int x=r.nextInt(1920-100);
        int y=r.nextInt(1080-100);
        points.add(new Point(x, y));
        Shape kolo = new Circle("Circle", x, y);
        listofshapes.add(kolo);

    }
    static void addTriangle(){
        Random r = new Random();
        int x=r.nextInt(1920-100)+50;
        int y=r.nextInt(1080-100)+50;
        points.add(new Point(x, y));
        Shape trojkat = new Triangle("Triangle",x ,y);
        listofshapes.add(trojkat);
    }
    static void addSquare(){
        Random r = new Random();
        int x=r.nextInt(1920-100);
        int y=r.nextInt(1080-100);
        points.add(new Point(x, y));
        Shape kwadrat = new Square("Square",x, y);
        listofshapes.add(kwadrat);

    }

    static void addRectangle(){
        Random r = new Random();
        int x=r.nextInt(1920-100);
        int y=r.nextInt(1080-100);
        points.add(new Point(x, y));
        Shape prostokat = new Rectangle("Rectangle",x, y);
        listofshapes.add(prostokat);
    }

    public void paint(Graphics arg0) {
        super.paint(arg0);
        Graphics2D g2 = (Graphics2D) arg0;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 1920, 1080);

        for (int i = 0; i < listofshapes.size(); i++) {
            listofshapes.get(i).setXandY(points.get(i).x, points.get(i).y);
            listofshapes.get(i).draw(arg0);
        }

    }



}
