package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Sporcular.Basketbolcu;
import sample.Sporcular.Futbolcu;
import sample.Sporcular.Sporcu;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("startPage.fxml"));
        primaryStage.setTitle("Sporcu Kart Oyunu");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

        /*ArrayList<Sporcu> cardList = new ArrayList<>(16);
        //Futbolcular
        cardList.add(new Futbolcu("Lionel Messi","Barcelona",90,92,95));
        cardList.add(new Futbolcu("Cristiano Ronaldo","Juventus",95,88,95));
        cardList.add(new Futbolcu("Heung Min Son","Tottenham",87,80,90));
        cardList.add(new Futbolcu("Robert Lewandowski","Bayern Münih",90,84,95));
        cardList.add(new Futbolcu("Mohamed Salah","Liverpool",79,80,93));
        cardList.add(new Futbolcu("Inaki Williams","Athletic Bilbao",37,40,54));
        cardList.add(new Futbolcu("Wissam Ben Yedder","Monaco",50,43,75));
        cardList.add(new Futbolcu("Richarlison","Everton",76,78,80));
        //Basketbolcular
        cardList.add(new Basketbolcu("LeBron James","LA Lakers",90,80,95));
        cardList.add(new Basketbolcu("Stephen Curry","Golden State Warriors",87,95,90));
        cardList.add(new Basketbolcu("Jimmy Butler","Miami Heats",73,70,76));
        cardList.add(new Basketbolcu("Anthony Davies","LA Lakers",83,77,84));
        cardList.add(new Basketbolcu("James Harden","Houston Rockets",88,93,88));
        cardList.add(new Basketbolcu("Luka Doncic","Dallas Mavericks",86,79,85));
        cardList.add(new Basketbolcu("Nikola Jokic","LA Lakers",75,75,75));
        cardList.add(new Basketbolcu("Kobe Bryant","LA Lakers",99,99,99));

        cardList.get(2).sporcuPuaniGoster();
        cardList.get(12).sporcuPuaniGoster();*/
        //System.out.println(cardList.get(2));

        //Test t = new Test();

    }
}
