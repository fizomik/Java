import javax.swing.JFrame;

class MyFrame extends JFrame {
    MyFrame() {
        super("Twoje figury");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        add(panel);
        pack();
        setVisible(true);
        setResizable(false);
    }
}