package sample;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage mainStage) throws Exception {
        stage = mainStage;
        ScrollPane root = new ScrollPane();
        TilePane tile = new TilePane();
        tile.setStyle("-fx-background-color: LIGHTGRAY");

        final TextField path1 = new TextField();
        path1.setPromptText("Enter your path");
        tile.getChildren().add(path1);

        final Button btn = new Button();
        btn.setText("Załaduj");
        tile.getChildren().add(btn);

        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        root.setFitToWidth(true);

        root.setContent(tile);

        mainStage.setWidth(1080);
        mainStage.setHeight(720);

        mainStage.setScene(new Scene(root));
        mainStage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String path = path1.getText();


                    File folder = new File(path);
                    File[] listOfFiles = folder.listFiles();
                    tile.getChildren().clear();
                    tile.getChildren().add(path1);
                    tile.getChildren().add(btn);
                    for (final File file : listOfFiles) {
                        ImageView imageView = newImageView(file);
                        tile.getChildren().add(imageView);
                    }

                    mainStage.show();
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("Check your path");
                }
            }



        });
    }



    private ImageView newImageView(final File imageFile) {

        ImageView imageView = null;
        try {
            final Image image = new Image(new FileInputStream(imageFile), 120, 0, true, true);

            imageView = new ImageView(image);
            imageView.setFitWidth(120);

            imageView.setOnMouseClicked(mouseEvent -> {

                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){

                        try {

                            BorderPane borderPane = new BorderPane();
                            ImageView imageView1 = new ImageView();
                            Image image1 = new Image(new FileInputStream(imageFile));
                            imageView1.setImage(image1);
                            imageView1.setFitHeight(stage.getHeight());
                            imageView1.setPreserveRatio(true);

                            borderPane.setCenter(imageView1);
                            borderPane.setStyle("-fx-background-color: BLACK");


                            Stage newStage = new Stage();
                            newStage.setWidth(stage.getWidth());
                            newStage.setHeight(stage.getHeight());
                            newStage.setTitle(imageFile.getName());
                            Scene scene = new Scene(borderPane);

                            newStage.setScene(scene);
                            newStage.show();

                        } catch (FileNotFoundException e) {
                            System.out.println("Problem with img");
                            e.printStackTrace();
                        }

                }
            });
        } catch (FileNotFoundException ex) {
            System.out.println("Problem with img");
            ex.printStackTrace();
        }
        return imageView;
    }

    public static void main(String[] args) {
        launch(args);
    }

}