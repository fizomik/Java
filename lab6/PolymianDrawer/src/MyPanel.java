import java.awt.*;
import javax.swing.JPanel;



public class MyPanel extends JPanel  {

    private double []x;
    private double []y;

    private int n;

    public MyPanel(double []x, double []y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(4));

        double max = 0;

        for (int i=0; i<n; ++i)
            if(modul(y[i])> max)
                max = modul(y[i]);

        double sky = 400 / max;

        double skx;
        if(modul(x[n-1])> modul(x[0]))
            skx = 400/x[n-1];
        else
            skx = 400/x[0];
        if(skx <0)
            skx = -skx;


        g2.setColor(Color.RED);

        int sx = 500;
        int sy = 500;
        for (int i = 0; i<n-1; ++i)
            g2.drawLine(sx +(int)(x[i]* skx), sy -(int)(y[i]* sky), sx +(int)(x[i+1]* skx), sy -(int)(y[i+1]* sky));


        g2.setColor(Color.blue);
        g2.drawLine(sx -420, sy, sx +420, sy); //os x

        g2.drawLine(sx +420, sy, sx +415, sy +5);
        g2.drawLine(sx +420, sy, sx +415, sy -5); //strzalka x

        g2.drawLine(sx, sy +420, sx, sy -420); //os y

        g2.drawLine(sx, sy -420, sx -5, sy -415);
        g2.drawLine(sx, sy -420, sx +5, sy -415); //strzalka y



            g2.drawLine(sx +20*20, sy -5, sx +20*20, sy +5);
            g2.drawLine(sx -20*20, sy -5, sx -20*20, sy +5);
        for(int i=0;i<21;i++){
            g2.drawLine(sx -5, sy -20*i, sx +5, sy -20*i);
            g2.drawLine(sx -5, sy +20*i, sx +5, sy +20*i);
        }

        //wartosci na osiach
        g2.drawString(Double.toString((int)((250/ sky)*100)/100), sx +6, sy -395);
        g2.drawString(Double.toString((int)(-(250/ sky)*100)/100), sx +6, sy +405);
        g2.drawString(Double.toString((int)((x[0])*100)/100), sx +(int)(skx *x[0])-10, sy +15);
        g2.drawString(Double.toString((int)((x[n-1])*100)/100), sx +(int)(skx *x[n-1])-10, sy +15);

    }


    private double modul(double x) {
        if(x<0)
            x=-x;
        return x;
    }
}
