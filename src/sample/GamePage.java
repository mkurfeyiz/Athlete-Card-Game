package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.Oyuncular.Bilgisayar;
import sample.Oyuncular.Kullanici;


public class GamePage {

    @FXML Label _nameBot;
    @FXML Label _namePlayer;

    @FXML Label _playerNameBot;
    @FXML Label _playerNamePlayer;

    @FXML Label _teamNameBot;
    @FXML Label _teamNamePlayer;

    @FXML Label _abilityBot;
    @FXML Label _abilityPlayer;

    @FXML Label _abilityValueBot;
    @FXML Label _abilityValuePlayer;

    @FXML Label _scoreBot;
    @FXML Label _scorePlayer;


    Bilgisayar bot;
    Kullanici player;

    String pName;
    int pID;

    Test _test;

    public void getSettings(String pName, int pID){

        this.pName = pName;
        this.pID = pID;

        if(pName.matches("")){
            player = new Kullanici();
        } else {
            player = new Kullanici(this.pID,this.pName,0);
        }
        bot = new Bilgisayar();

        setStartingLabels();



        setGame();
        startTurn();

    }

    public void setStartingLabels(){
        //Choosen card infos
        _namePlayer.setText(player.getPlayerName());
        _nameBot.setText(bot.getPlayerName());
        //Player Names
        _playerNamePlayer.setText("");
        _playerNameBot.setText("");
        //Team names
        _teamNamePlayer.setText("");
        _teamNameBot.setText("");
        //Abilities
        //This will be displayed later on in the game
        _abilityPlayer.setText("");
        _abilityBot.setText("");

        _abilityValuePlayer.setText("0");
        _abilityValueBot.setText("0");
        //Score
        _scorePlayer.setText(Integer.toString(player.getScore()));
        _scoreBot.setText(Integer.toString(bot.getScore()));
    }

    public void setGame(){
        _test = new Test(bot,player);
        _test.setHand(bot,player);
    }

    public void startTurn(){

        //System.out.println(_test.cardListF.get(0).getName()+" player hand :"+bot.getHandB().get(0).getName());
    }
}
