import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


class MyFrame extends JFrame {

    private final JTextField polymian;
    private final JTextField range;
    private final JTextField step;

    MyFrame(){
        setTitle("Wykresy");
        this.setLayout(new FlowLayout());

        polymian = new JTextField(11);
        range = new JTextField("",5);
        step = new JTextField("1",4);

        add(new JLabel("Wspolczynniki: "));
        add(polymian);
        add(new JLabel("Przedzial (po przecinku) : "));
        add(range);
        add(new JLabel("Krok: "));
        add(step);

        ButtonListener bl = new ButtonListener();
        JButton button = new JButton("Rysuj");
        button.addActionListener(bl);
        add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        pack();
    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0){

            revalidate();

                String factors[];
                factors = polymian.getText().split(",");
                String z[];

                z = range.getText().split(",");
                String k;

                k = step.getText();


                double k1;
                double start;
                double end;
                double []w = new double[factors.length];


                try{
                    for(int i=0; i < factors.length; i++) {
                        if(factors[i].startsWith("-")){
                            w[i] = -Double.parseDouble(factors[i]);
                            w[i] = -w[i];
                        }
                        else
                            w[i] = Double.parseDouble(factors[i]);
                    }

                    k1 = Double.parseDouble(k);


                    start = Double.parseDouble(z[0]);

                    end = Double.parseDouble(z[1]);
                }catch(Exception e) {
                    throw new NumberFormatException("Wrong format of args");

                }

                if(start>end)
                    throw new NumberFormatException ("Wrong range");

                int n = (int)((end-start)/k1);
                if(n<0)
                    n = -n;
                n+=1;


                double []x = new double[n];
                double []y = new double[n];

                while(start<=end) {
                    for(int i=0;i<n;i++) {
                        x[i]=start;
                        for(int j=0; j<factors.length; j++) {
                            y[i]+= w[j]*Math.pow(x[i],w.length-j-1);
                        }

                        start+=k1;

                    }
                }

                MyPanel panel = new MyPanel(x, y, n);

                panel.setSize(1000,1000);
                add(panel);

            repaint();

        }

    }

}