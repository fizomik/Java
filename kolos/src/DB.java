package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import static sample.Main.search;

public class DB {
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    public static boolean connect(){
        try{Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl:3306/dkozyra","dkozyra","0PcT1RLPd8kaMBif");
        }catch(SQLException ex) {
            // handle any errors
            System.out.println("SQLException: "+ex.getMessage());
            System.out.println("SQLState: "+ex.getSQLState());
            System.out.println("VendorError: "+ex.getErrorCode());
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static ObservableList addBook() {
        ObservableList books = null;
        String search1=search.getText();
        try {
            books = FXCollections.observableArrayList();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                String isbn = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String year = rs.getString(4);
                if(search1.isEmpty()||search1==null)
                    books.add(new Book(isbn, title, author, year));
                else if(search1.equals(isbn))
                    books.add(new Book(isbn, title, author, year));
                else{
                    String parts[]=author.split(" ");
                    if(search1.equals(parts[1]))
                        books.add(new Book(isbn, title, author, year));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // handle any errors

        } finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
        return books;
    }


    public static void addBook2(String isbn1, String author1, String title1, String year1){
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "INSERT INTO books(isbn,author,title,year) VALUES(\"" +isbn1  + "\", \"" +author1+ "\", \"" +title1+"\", \"" +year1+ "\");");
        } catch (SQLException ex) {
            // handle any errors
            ex.printStackTrace();

        } finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
    }


}
