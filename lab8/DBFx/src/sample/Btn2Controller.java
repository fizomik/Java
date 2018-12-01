package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import static sample.Btn1Controller.author;
import static sample.Btn1Controller.isbn;
import static sample.Btn1Controller.title;
import static sample.Btn1Controller.year;

public class Btn2Controller {
    static EventHandler<ActionEvent> Controller2=new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String isbn1=isbn.getText();
            String author1=author.getText();
            String title1=title.getText();
            String year1=year.getText();
            DB.addBook2(isbn1,author1,title1,year1);
        }
    };
}
