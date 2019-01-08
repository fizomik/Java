package server;

import javax.swing.*;


public class executeServer {
    public static void main(String[] args) {
        TicTacToeServer application = new TicTacToeServer();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.execute();    }
}
