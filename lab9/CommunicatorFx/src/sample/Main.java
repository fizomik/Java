package sample;

import sample.javaIn.JIn;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {


    private boolean isServer;  //true gdy tworzymy serwer, false gdy tworzymy klienta
    private TextArea messages = new TextArea();
    private NetworkConnection connection;

    public Main() {

        System.out.println("1. Utwórz server");
        System.out.println("2. Utwórz klienta");
        int choice = JIn.getInt();
        switch (choice) {
            case 1:
                isServer = true;     //true gdy tworzymy serwer, false gdy tworzymy klienta
                break;

            case 2:
                isServer = false;     //true gdy tworzymy serwer, false gdy tworzymy klienta
                break;
            default:{
                System.out.print("Podaj liczbę od 1-2: ");
                break;
            }

        }
        connection = isServer ? createServer() : createClient();
    }


    @Override
    public void init() throws Exception {
        connection.startConnection();
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        messages.setPrefHeight(550);
        TextField input = new TextField();
        input.setOnAction(actionEvent -> {
            String message = isServer ? "Serwer: " : "Client: ";
            message += input.getText();
            input.clear();

            messages.appendText(message + "\n");

            try {
                connection.send(message);
            }
            catch(Exception s){
                messages.appendText("Failed to send \n");
            }



        });

        VBox root = new VBox(20,messages, input);


        root.setPrefSize(600,600);
        primaryStage.setScene(new Scene(root));



        primaryStage.show();
    }
    @Override
    public void stop() throws Exception {
        connection.closeConnection();
    }

    private Server createServer(){
        return new Server(55555, data ->{
            Platform.runLater(() ->{
                messages.appendText(data.toString()+ "\n");

            });
        });
    }

    private Client createClient(){
        return new Client("127.0.0.1", 55555,data ->{
        Platform.runLater(() ->{
            messages.appendText(data.toString()+ "\n");

            });
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
