package sample;
        import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Node;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.Pane;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Line;
        import javafx.stage.Stage;
        import javafx.stage.StageStyle;
        import java.util.ArrayList;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {



        primaryStage.setTitle("Polymians");

        Pane root = new Pane();
        root.setStyle("-fx-background-color: #D2D2D2;");


        final TextField factors = new TextField();
        factors.setLayoutX(100);
        factors.setLayoutY(40);
        factors.setPrefColumnCount(10);
        factors.setPromptText("Enter your factors.");
        root.getChildren().add(factors);

        final TextField range = new TextField();
        range.setLayoutX(300);
        range.setLayoutY(40);
        range.setPrefColumnCount(10);
        range.setPromptText("Enter your range.");
        root.getChildren().add(range);

        final TextField step = new TextField();
        step.setLayoutX(500);
        step.setLayoutY(40);
        step.setPrefColumnCount(10);
        step.setPromptText("Enter your step.");

        root.getChildren().add(step);


        final Button btn = new Button();
        btn.setLayoutX(900);
        btn.setLayoutY(40);
        btn.setText("Rysuj");
        root.getChildren().add(btn);

        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.setResizable(false);
        primaryStage.show();


        btn.setOnAction(new EventHandler<ActionEvent>() {
            private double modul(double x) {
                if(x<0)
                    x=-x;
                return x;
            }
            @Override
            public void handle(ActionEvent event) {
                String factors1[];
                String range1[];
                String step1;
                ArrayList<Line> particles1 = new ArrayList<Line>();
                ArrayList<Line> particles2 = new ArrayList<Line>();
                factors1=factors.getText().split(",");
                range1=range.getText().split(",");
                step1=step.getText();

                double k1;
                double start;
                double end;
                double []w = new double[factors1.length];


                try{
                    for(int i=0; i < factors1.length; i++) {
                        if(factors1[i].startsWith("-")){
                            w[i] = -Double.parseDouble(factors1[i]);
                            w[i] = -w[i];
                        }
                        else
                            w[i] = Double.parseDouble(factors1[i]);
                    }

                    k1 = Double.parseDouble(step1);


                    start = Double.parseDouble(range1[0]);

                    end = Double.parseDouble(range1[1]);
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
                        for(int j=0; j<factors1.length; j++) {
                            y[i]+= w[j]*Math.pow(x[i],w.length-j-1);
                        }

                        start+=k1;
                    }
                }

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


                int sx = 500;
                int sy = 500;
                for (int i = 0; i<n-1; ++i)
                    particles1.add(new Line(sx +(int)(x[i]* skx), sy -(int)(y[i]* sky), sx +(int)(x[i+1]* skx), sy -(int)(y[i+1]* sky)));


                particles2.add(new Line(sx -420, sy, sx +420, sy)); //os x

                particles2.add(new Line(sx +420, sy, sx +415, sy +5));
                particles2.add(new Line(sx +420, sy, sx +415, sy -5)); //strzalka x

                particles2.add(new Line(sx, sy +420, sx, sy -420)); //os y

                particles2.add(new Line(sx, sy -420, sx -5, sy -415));
                particles2.add(new Line(sx, sy -420, sx +5, sy -415)); //strzalka y

                //przedzialkia

                for(int i=0;i<21;i++){
                    particles2.add(new Line(sx +20*i, sy -5, sx +20*i, sy +5));
                    particles2.add(new Line(sx -20*i, sy -5, sx -20*i, sy +5));
                    particles2.add(new Line(sx -5, sy -20*i, sx +5, sy -20*i));
                    particles2.add(new Line(sx -5, sy +20*i, sx +5, sy +20*i));
                }


                Label label1 = new Label(Double.toString((int)((250/ sky)*100)/100));
                Label label2 = new Label(Double.toString((int)(-(250/ sky)*100)/100));
                Label label3 = new Label(Double.toString((int)((x[0])*100)/100));
                Label label4 = new Label(Double.toString((int)((x[n-1])*100)/100));

                label1.setTranslateX(sx +6);
                label1.setTranslateY(sy -395);

                label2.setTranslateX(sx +6);
                label2.setTranslateY(sy +405);

                label3.setTranslateX(sx +(int)(skx *x[0])-10);
                label3.setTranslateY(sy +15);

                label4.setTranslateX(sx +(int)(skx *x[n-1])-10);
                label4.setTranslateY(sy +15);


                root.getChildren().clear();

                root.getChildren().addAll(label1,label2,label3,label4);
                root.getChildren().add(factors);
                root.getChildren().add(range);
                root.getChildren().add(step);
                root.getChildren().add(btn);

                for (Node node : particles1) {
                    root.getChildren().addAll(node);
                }
                for (Node node : particles2) {
                    root.getChildren().addAll(node);
                }
                for (int i = 0; i<particles1.size(); i++){
                    particles1.get(i).setStrokeWidth(3);
                    particles1.get(i).setStroke(Color.RED);
                }
                for (int i = 0; i<particles2.size(); i++){
                    particles2.get(i).setStrokeWidth(3);
                    particles2.get(i).setStroke(Color.BLUE);
                }


                primaryStage.show();
            }
        });


    }
}
