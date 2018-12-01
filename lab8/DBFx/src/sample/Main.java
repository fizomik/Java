package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



import static sample.Btn0Controller.Controller0;
import static sample.Btn1Controller.Controller1;

public class Main extends Application {

    public static TableView table;
    public static TextField search;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        for (int i=1; i<4; i++){
            if(DB.connect()==true){
                System.out.println("udało się połączyć z bazą za "+i+" razem");
                break;
            }
            else if(i==3 && DB.connect()==false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Nie udało się połączyć z bazą!");
                alert.showAndWait();
                System.exit(1);
            }
        }

        TableColumn<Book,String> isbnColumn = new TableColumn<>("IBSN");
        isbnColumn.setMinWidth(150);
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));

        TableColumn<Book,String> authorColumn = new TableColumn<>("Author");
        authorColumn.setMinWidth(250);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));


        TableColumn<Book,String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(350);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));


        TableColumn<Book,String> yearColumn = new TableColumn<>("Year");
        yearColumn.setMinWidth(50);
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));


        primaryStage.setTitle("MyDataViewer");

        Pane root = new Pane();
        root.setStyle("-fx-background-color: #D2D2D2;");

        search = new TextField();
        search.setLayoutX(100);
        search.setLayoutY(40);
        search.setPrefColumnCount(20);
        search.setPromptText("Podaj ISBN lub nazwisko: ");
        root.getChildren().add(search);

        final Button btn0 = new Button();
        btn0.setLayoutX(500);
        btn0.setLayoutY(40);
        btn0.setText("Pokaż wyniki");
        root.getChildren().add(btn0);


        final Button btn1 = new Button();
        btn1.setLayoutX(700);
        btn1.setLayoutY(40);
        btn1.setText("Dodaj książkę");
        root.getChildren().add(btn1);

        table=new TableView();
        table.setLayoutX(100);
        table.setLayoutY(200);


        table.getColumns().addAll(isbnColumn, authorColumn, titleColumn, yearColumn);

        root.getChildren().add(table);


        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.setResizable(false);
        primaryStage.show();


        btn0.setOnAction(Controller0);
        btn1.setOnAction(Controller1);


    }
}