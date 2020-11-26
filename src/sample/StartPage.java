package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Oyuncular.Kullanici;


import java.io.IOException;

public class StartPage {

    @FXML TextField playerName;
    @FXML TextField playerID;

    String pName;
    int pID;


    public void setPlayerInfos() {

        try{

            this.pName = playerName.getText();
            this.pID = Integer.parseInt(playerID.getText());

        } catch (Exception e){
            pName = "";
            pID = 1;
        }

    }

    public void startTheGame(ActionEvent event)throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("gamePage.fxml"));
        Parent game = loader.load();
        Scene gameScene = new Scene(game);
        //Asagida gecis yapmak istedigimiz sayfanin controllerinin methodunu kullanarak bilgileri aktardik.
        GamePage controller = loader.getController();
        controller.getSettings(pName,pID);
        //
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(gameScene);
        window.show();

    }

}
