package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import static sample.Main.table;
import static sample.Main.search;

public class Btn0Controller {
    static String search1;
    static EventHandler<ActionEvent> Controller0=new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String search1=search.getText();
            table.setItems(DB.addBook());
        }
    };
}
