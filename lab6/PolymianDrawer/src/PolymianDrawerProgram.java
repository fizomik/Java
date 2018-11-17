import java.awt.EventQueue;
public class PolymianDrawerProgram {
    private static void run()  {
        MyFrame frame = new MyFrame();
        frame.setSize(1000, 1000);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(PolymianDrawerProgram::run);

    }


}