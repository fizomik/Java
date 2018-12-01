package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



import static sample.Btn2Controller.Controller2;

public class Btn1Controller {

    static TextField isbn;
    static TextField title;
    static TextField author;
    static TextField year;

    static EventHandler<ActionEvent> Controller1=new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Stage newStage = new Stage();
            newStage.setWidth(500);
            newStage.setHeight(500);
            newStage.setTitle("ksiażka");

            Pane root1 = new Pane();

            isbn = new TextField();
            isbn.setLayoutX(50);
            isbn.setLayoutY(40);
            isbn.setPrefColumnCount(30);
            isbn.setPromptText("Podaj ISBN");

            title = new TextField();
            title.setLayoutX(50);
            title.setLayoutY(120);
            title.setPrefColumnCount(30);
            title.setPromptText("Podaj tytuł:");

            author = new TextField();
            author.setLayoutX(50);
            author.setLayoutY(200);
            author.setPrefColumnCount(30);
            author.setPromptText("Podaj autora:");

            year = new TextField();
            year.setLayoutX(50);
            year.setLayoutY(280);
            year.setPrefColumnCount(20);
            year.setPromptText("Podaj rok:");


            final Button btn2 = new Button();
            btn2.setLayoutX(100);
            btn2.setLayoutY(360);
            btn2.setText("Zapisz");

            root1.getChildren().addAll(btn2,isbn, title, author, year);
            newStage.setScene(new Scene(root1, 500, 500));
            newStage.show();
            btn2.setOnAction(Controller2);



        }
    };
}
