package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import sample.Oyuncular.*;
import sample.Sporcular.*;

import java.util.ArrayList;


public class GamePage {

    @FXML
    Label _nameBot;
    @FXML
    Label _namePlayer;

    @FXML
    Label _playerNameBot;
    @FXML
    Label _playerNamePlayer;

    @FXML
    Label _teamNameBot;
    @FXML
    Label _teamNamePlayer;

    @FXML
    Label _abilityBot;
    @FXML
    Label _abilityPlayer;

    @FXML
    Label _abilityValueBot;
    @FXML
    Label _abilityValuePlayer;

    @FXML
    Label _scoreBot;
    @FXML
    Label _scorePlayer;


    Bilgisayar bot;
    Kullanici player;

    String pName;
    int pID;
    int _turnCounter = 0;
    int _index;

    Test _test;
    boolean flag;

    ArrayList<Sporcu> _board = new ArrayList<>(2);

    public void getSettings(String pName, int pID,Kullanici player) {

        this.pName = pName;
        this.pID = pID;

        this.player = player;
        bot = new Bilgisayar();

        setStartingLabels();

        setGame();

    }

    public void setStartingLabels() {
        //Player Names
        _namePlayer.setText(player.getPlayerName());
        _nameBot.setText(bot.getPlayerName());
        //Choosen card infos
        //Athlete Names
        _playerNamePlayer.setText("");
        _playerNameBot.setText("");
        //Team names
        _teamNamePlayer.setText("");
        _teamNameBot.setText("");
        //Abilities
        //This will be displayed later on in the game
        _abilityPlayer.setText("");
        _abilityBot.setText("");

        _abilityValuePlayer.setText("");
        _abilityValueBot.setText("");
        //Score
        _scorePlayer.setText(Integer.toString(player.getScore()));
        _scoreBot.setText(Integer.toString(bot.getScore()));
    }

    public void updateScreen() {
        //Athlete Names
        _playerNamePlayer.setText(_board.get(0).getName());
        _playerNameBot.setText(_board.get(1).getName());
        //Team names
        _teamNamePlayer.setText(_board.get(0).getTeamName());
        _teamNameBot.setText(_board.get(1).getTeamName());
        //Abilities
        _abilityPlayer.setText(_test.getAbility() + " :");
        _abilityBot.setText(_test.getAbility() + " :");

        if (this.flag == true) {
            if (_test.getAbility().matches("Bitiricilik")) {

                _abilityValuePlayer.setText(Integer.toString(_board.get(0).getFinishing()));
                _abilityValueBot.setText(Integer.toString(_board.get(1).getFinishing()));
            } else if (_test.getAbility().matches("Serbest Vuruş")) {

                _abilityValuePlayer.setText(Integer.toString(_board.get(0).getFreekick()));
                _abilityValueBot.setText(Integer.toString(_board.get(1).getFreekick()));
            } else if (_test.getAbility().matches("Penaltı")) {

                _abilityValuePlayer.setText(Integer.toString(_board.get(0).getPenalty()));
                _abilityValueBot.setText(Integer.toString(_board.get(1).getPenalty()));
            }
        } else {
            if (_test.getAbility().matches("İkilik")) {

                _abilityValuePlayer.setText(Integer.toString(_board.get(0).getPoint()));
                _abilityValueBot.setText(Integer.toString(_board.get(1).getPoint()));
            } else if (_test.getAbility().matches("Üçlük")) {

                _abilityValuePlayer.setText(Integer.toString(_board.get(0).getThreePointer()));
                _abilityValueBot.setText(Integer.toString(_board.get(1).getThreePointer()));
            } else if (_test.getAbility().matches("Serbest Atış")) {

                _abilityValuePlayer.setText(Integer.toString(_board.get(0).getFreeThrow()));
                _abilityValueBot.setText(Integer.toString(_board.get(1).getFreeThrow()));
            }
        }
        //Score
        _scorePlayer.setText(Integer.toString(player.getScore()));
        _scoreBot.setText(Integer.toString(bot.getScore()));
    }

    public void setGame() {
        _test = new Test(bot, player);
        //_test.setHand(bot,player);
    }

    public void showPlayerHand(){
        System.out.println("Elinizde kalan futbolcu kartları :");
        System.out.println("------------");
        _test.showPlayersHandF(player);
        System.out.println("------------");

        System.out.println("Elinizde kalan basketbolcu kartları :");
        System.out.println("------------");
        _test.showPlayersHandB(player);
        System.out.println("------------");
    }

    public void startTurn() {

        if (_test.checkGame()) {

            int index = 0;
            this.flag = _test.checkPlayerType(_turnCounter);

            if (flag == true) {
                System.out.println("\nFutbolcu Sırası\n");
                //Choosing a card then adding it to board
                _board.add(0, player.kartSec(_index, flag));
                _board.add(1, bot.kartSec(index, flag));


                System.out.println(player.getPlayerName() + " oyuncusunun oynadığı kart ");
                _board.get(0).sporcuPuaniGoster();
                System.out.println();
                System.out.println(bot.getPlayerName() + " oyuncusunun oynadığı kart ");
                _board.get(1).sporcuPuaniGoster();
                System.out.println();

                //Choosing and comparing abilities
                _test.setAbility();
                updateScreen();
                if (_test.getAbility().matches("Bitiricilik")) {
                    System.out.println("Bitiricilik özelliği karşılaştırılacak\n");
                    //Comparing players finishing ability
                    if (_board.get(0).getFinishing() > _board.get(1).getFinishing()) {
                        System.out.println(_board.get(0).getName() + ", " + _board.get(1).getName() + " futbolcusundan daha bitirici");
                        System.out.println("Bu turu kazanan " + player.getPlayerName());
                        player.setScore(player.getScore() + 15);
                    } else if (_board.get(0).getFinishing() < _board.get(1).getFinishing()) {
                        System.out.println(_board.get(1).getName() + ", " + _board.get(0).getName() + " futbolcusundan daha bitirici");
                        System.out.println("Bu turu kazanan " + bot.getPlayerName());
                        bot.setScore(bot.getScore() + 15);
                    } else if (_board.get(0).getFinishing() == _board.get(1).getFinishing()) {
                        System.out.println(_board.get(0).getName() + " ve " + _board.get(1).getName() + " futbolcularının bitiricilikleri eşit");
                        System.out.println("Bu turun kazananı olmuyor!");
                        System.out.println("Yeni bir özellik seçiliyor..");
                        //Tie situation
                        tieHandler(_test.getAbility());
                    }

                } else if (_test.getAbility().matches("Serbest Vuruş")) {
                    System.out.println("Serbest Vuruş özelliği karşılaştırılacak\n");
                    //Comparing players freekick ability
                    if (_board.get(0).getFreekick() > _board.get(1).getFreekick()) {
                        System.out.println(_board.get(0).getName() + ", " + _board.get(1).getName() + " futbolcusundan daha iyi serbest vuruşlara sahip");
                        System.out.println("Bu turu kazanan " + player.getPlayerName());
                        player.setScore(player.getScore() + 15);
                    } else if (_board.get(0).getFreekick() < _board.get(1).getFreekick()) {
                        System.out.println(_board.get(1).getName() + ", " + _board.get(0).getName() + " futbolcusundan daha iyi serbest vuruşlara sahip");
                        System.out.println("Bu turu kazanan " + bot.getPlayerName());
                        bot.setScore(bot.getScore() + 15);
                    } else if (_board.get(0).getFreekick() == _board.get(1).getFreekick()) {
                        System.out.println(_board.get(0).getName() + " ve " + _board.get(1).getName() + " futbolcularının serbest vuruşları eşit");
                        System.out.println("Bu turun kazananı olmuyor!");
                        System.out.println("Yeni bir özellik seçiliyor..");
                        //Tie situation
                        tieHandler(_test.getAbility());
                    }

                } else if (_test.getAbility().matches("Penaltı")) {
                    System.out.println("Penaltı özelliği karşılaştırılacak\n");
                    //Comparing players penalty ability
                    if (_board.get(0).getPenalty() > _board.get(1).getPenalty()) {
                        System.out.println(_board.get(0).getName() + ", " + _board.get(1).getName() + " futbolcusundan daha iyi penaltı atıyor");
                        System.out.println("Bu turu kazanan " + player.getPlayerName());
                        player.setScore(player.getScore() + 15);
                    } else if (_board.get(0).getPenalty() < _board.get(1).getPenalty()) {
                        System.out.println(_board.get(1).getName() + ", " + _board.get(0).getName() + " futbolcusundan daha iyi penaltı atıyor");
                        System.out.println("Bu turu kazanan " + bot.getPlayerName());
                        bot.setScore(bot.getScore() + 15);
                    } else if (_board.get(0).getPenalty() == _board.get(1).getPenalty()) {
                        System.out.println(_board.get(0).getName() + " ve " + _board.get(1).getName() + " futbolcularının penaltıları eşit");
                        System.out.println("Bu turun kazananı olmuyor!");
                        System.out.println("Yeni bir özellik seçiliyor..");
                        //Tie situation
                        tieHandler(_test.getAbility());
                    }
                }
                updateScreen();
                _board.removeAll(_board);

            } else {
                System.out.println("\nBasketbolcu Sırası \n");

                //Choosing a card then adding it to board
                _board.add(0, player.kartSec(_index, flag));
                _board.add(1, bot.kartSec(index, flag));


                System.out.println(player.getPlayerName() + " oyuncusunun oynadığı kart ");
                _board.get(0).sporcuPuaniGoster();
                System.out.println();
                System.out.println(bot.getPlayerName() + " oyuncusunun oynadığı kart ");
                _board.get(1).sporcuPuaniGoster();
                System.out.println();

                //Choosing and comparing abilities
                _test.setAbility();
                updateScreen();
                if (_test.getAbility().matches("İkilik")) {
                    System.out.println("İkilik özelliği karşılaştırılacak\n");
                    //Comparing players finishing ability
                    if (_board.get(0).getPoint() > _board.get(1).getPoint()) {
                        System.out.println(_board.get(0).getName() + ", " + _board.get(1).getName() + " oyuncusundan daha iyi ikilik atıyor");
                        System.out.println("Bu turu kazanan " + player.getPlayerName());
                        player.setScore(player.getScore() + 15);
                    } else if (_board.get(0).getPoint() < _board.get(1).getPoint()) {
                        System.out.println(_board.get(1).getName() + ", " + _board.get(0).getName() + " oyuncusundan daha iyi ikilik atıyor");
                        System.out.println("Bu turu kazanan " + bot.getPlayerName());
                        bot.setScore(bot.getScore() + 15);
                    } else if (_board.get(0).getPoint() == _board.get(1).getPoint()) {
                        System.out.println(_board.get(0).getName() + " ve " + _board.get(1).getName() + " oyuncuların ikilikleri eşit");
                        System.out.println("Bu turun kazananı olmuyor!");
                        System.out.println("Yeni bir özellik seçiliyor..");
                        //Tie situation
                        tieHandler(_test.getAbility());
                    }

                } else if (_test.getAbility().matches("Serbest Atış")) {
                    System.out.println("Serbest Atış özelliği karşılaştırılacak\n");
                    //Comparing players freekick ability
                    if (_board.get(0).getFreeThrow() > _board.get(1).getFreeThrow()) {
                        System.out.println(_board.get(0).getName() + ", " + _board.get(1).getName() + " oyuncusundan daha iyi serbest atışlara sahip");
                        System.out.println("Bu turu kazanan " + player.getPlayerName());
                        player.setScore(player.getScore() + 15);
                    } else if (_board.get(0).getFreeThrow() < _board.get(1).getFreeThrow()) {
                        System.out.println(_board.get(1).getName() + ", " + _board.get(0).getName() + " oyuncusundan daha iyi serbest atışlara sahip");
                        System.out.println("Bu turu kazanan " + bot.getPlayerName());
                        bot.setScore(bot.getScore() + 15);
                    } else if (_board.get(0).getFreeThrow() == _board.get(1).getFreeThrow()) {
                        System.out.println(_board.get(0).getName() + " ve " + _board.get(1).getName() + " oyuncularının serbest atışları eşit");
                        System.out.println("Bu turun kazananı olmuyor!");
                        System.out.println("Yeni bir özellik seçiliyor..");
                        //Tie situation
                        tieHandler(_test.getAbility());
                    }

                } else if (_test.getAbility().matches("Üçlük")) {
                    System.out.println("Üçlük özelliği karşılaştırılacak\n");
                    //Comparing players penalty ability
                    if (_board.get(0).getThreePointer() > _board.get(1).getThreePointer()) {
                        System.out.println(_board.get(0).getName() + ", " + _board.get(1).getName() + " oyuncusundan daha iyi üçlük atıyor");
                        System.out.println("Bu turu kazanan " + player.getPlayerName());
                        player.setScore(player.getScore() + 15);
                    } else if (_board.get(0).getThreePointer() < _board.get(1).getThreePointer()) {
                        System.out.println(_board.get(1).getName() + ", " + _board.get(0).getName() + " oyuncusundan daha iyi üçlük atıyor");
                        System.out.println("Bu turu kazanan " + bot.getPlayerName());
                        bot.setScore(bot.getScore() + 15);
                    } else if (_board.get(0).getThreePointer() == _board.get(1).getThreePointer()) {
                        System.out.println(_board.get(0).getName() + " ve " + _board.get(1).getName() + " oyuncularının üçlükleri eşit");
                        System.out.println("Bu turun kazananı olmuyor!");
                        System.out.println("Yeni bir özellik seçiliyor..");
                        //Tie situation
                        tieHandler(_test.getAbility());
                    }
                }
                updateScreen();
                _board.removeAll(_board);
            }


            _turnCounter++;

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Oyun Hakkında");
            alert.setHeaderText(null);
            alert.setContentText("Oyuncuların kartları bittiği için oyun sona erdi!");

            alert.showAndWait();

            //Check the winner
            System.out.println();
            if(player.getScore() > bot.getScore()){
                System.out.println(player.getPlayerName()+", "+player.getScore()+" puan ile oyunun galibi oluyor.");
            } else if(player.getScore() < bot.getScore()){
                System.out.println(bot.getPlayerName()+", "+bot.getScore()+" puan ile oyunun galibi oluyor.");
            } else if(player.getScore() == bot.getScore()){
                System.out.println(bot.getPlayerName()+" ve "+player.getPlayerName()+", "+bot.getScore()
                        +" ile berabere kalıyor.");
            }

        }

    }

    public void tieHandler(String ability){

        _test.setAbility();
        while (_test.getAbility().matches(ability)){
            _test.setAbility();
        }

        if (_test.getAbility().matches("Bitiricilik")) {
            System.out.println("Bitiricilik özelliği karşılaştırılacak\n");
            //Comparing players finishing ability
            if (_board.get(0).getFinishing() > _board.get(1).getFinishing()) {
                System.out.println(_board.get(0).getName() + ", " + _board.get(1).getName() + " futbolcusundan daha bitirici");
                System.out.println("Bu turu kazanan " + player.getPlayerName());
                player.setScore(player.getScore() + 15);
            } else if (_board.get(0).getFinishing() < _board.get(1).getFinishing()) {
                System.out.println(_board.get(1).getName() + ", " + _board.get(0).getName() + " futbolcusundan daha bitirici");
                System.out.println("Bu turu kazanan " + bot.getPlayerName());
                bot.setScore(bot.getScore() + 15);
            } else if (_board.get(0).getFinishing() == _board.get(1).getFinishing()) {
                System.out.println(_board.get(0).getName() + " ve " + _board.get(1).getName() + " futbolcularının bitiricilikleri eşit");
                System.out.println("Bu turun kazananı olmuyor!");
                System.out.println("Yeni bir özellik seçiliyor..");
                //Tie situation
                tieHandler(_test.getAbility());
            }

        } else if (_test.getAbility().matches("Serbest Vuruş")) {
            System.out.println("Serbest Vuruş özelliği karşılaştırılacak\n");
            //Comparing players freekick ability
            if (_board.get(0).getFreekick() > _board.get(1).getFreekick()) {
                System.out.println(_board.get(0).getName() + ", " + _board.get(1).getName() + " futbolcusundan daha iyi serbest vuruşlara sahip");
                System.out.println("Bu turu kazanan " + player.getPlayerName());
                player.setScore(player.getScore() + 15);
            } else if (_board.get(0).getFreekick() < _board.get(1).getFreekick()) {
                System.out.println(_board.get(1).getName() + ", " + _board.get(0).getName() + " futbolcusundan daha iyi serbest vuruşlara sahip");
                System.out.println("Bu turu kazanan " + bot.getPlayerName());
                bot.setScore(bot.getScore() + 15);
            } else if (_board.get(0).getFreekick() == _board.get(1).getFreekick()) {
                System.out.println(_board.get(0).getName() + " ve " + _board.get(1).getName() + " futbolcularının serbest vuruşları eşit");
                System.out.println("Bu turun kazananı olmuyor!");
                System.out.println("Yeni bir özellik seçiliyor..");
                //Tie situation
                tieHandler(_test.getAbility());
            }

        } else if (_test.getAbility().matches("Penaltı")) {
            System.out.println("Penaltı özelliği karşılaştırılacak\n");
            //Comparing players penalty ability
            if (_board.get(0).getPenalty() > _board.get(1).getPenalty()) {
                System.out.println(_board.get(0).getName() + ", " + _board.get(1).getName() + " futbolcusundan daha iyi penaltı atıyor");
                System.out.println("Bu turu kazanan " + player.getPlayerName());
                player.setScore(player.getScore() + 15);
            } else if (_board.get(0).getPenalty() < _board.get(1).getPenalty()) {
                System.out.println(_board.get(1).getName() + ", " + _board.get(0).getName() + " futbolcusundan daha iyi penaltı atıyor");
                System.out.println("Bu turu kazanan " + bot.getPlayerName());
                bot.setScore(bot.getScore() + 15);
            } else if (_board.get(0).getPenalty() == _board.get(1).getPenalty()) {
                System.out.println(_board.get(0).getName() + " ve " + _board.get(1).getName() + " futbolcularının penaltıları eşit");
                System.out.println("Bu turun kazananı olmuyor!");
                System.out.println("Yeni bir özellik seçiliyor..");
                //Tie situation
                tieHandler(_test.getAbility());
            }
        } else if (_test.getAbility().matches("İkilik")) {
            System.out.println("İkilik özelliği karşılaştırılacak\n");
            //Comparing players finishing ability
            if (_board.get(0).getPoint() > _board.get(1).getPoint()) {
                System.out.println(_board.get(0).getName() + ", " + _board.get(1).getName() + " oyuncusundan daha iyi ikilik atıyor");
                System.out.println("Bu turu kazanan " + player.getPlayerName());
                player.setScore(player.getScore() + 15);
            } else if (_board.get(0).getPoint() < _board.get(1).getPoint()) {
                System.out.println(_board.get(1).getName() + ", " + _board.get(0).getName() + " oyuncusundan daha iyi ikilik atıyor");
                System.out.println("Bu turu kazanan " + bot.getPlayerName());
                bot.setScore(bot.getScore() + 15);
            } else if (_board.get(0).getPoint() == _board.get(1).getPoint()) {
                System.out.println(_board.get(0).getName() + " ve " + _board.get(1).getName() + " oyuncuların ikilikleri eşit");
                System.out.println("Bu turun kazananı olmuyor!");
                System.out.println("Yeni bir özellik seçiliyor..");
                //Tie situation
                tieHandler(_test.getAbility());
            }

        } else if (_test.getAbility().matches("Serbest Atış")) {
            System.out.println("Serbest Atış özelliği karşılaştırılacak\n");
            //Comparing players freekick ability
            if (_board.get(0).getFreeThrow() > _board.get(1).getFreeThrow()) {
                System.out.println(_board.get(0).getName() + ", " + _board.get(1).getName() + " oyuncusundan daha iyi serbest atışlara sahip");
                System.out.println("Bu turu kazanan " + player.getPlayerName());
                player.setScore(player.getScore() + 15);
            } else if (_board.get(0).getFreeThrow() < _board.get(1).getFreeThrow()) {
                System.out.println(_board.get(1).getName() + ", " + _board.get(0).getName() + " oyuncusundan daha iyi serbest atışlara sahip");
                System.out.println("Bu turu kazanan " + bot.getPlayerName());
                bot.setScore(bot.getScore() + 15);
            } else if (_board.get(0).getFreeThrow() == _board.get(1).getFreeThrow()) {
                System.out.println(_board.get(0).getName() + " ve " + _board.get(1).getName() + " oyuncularının serbest atışları eşit");
                System.out.println("Bu turun kazananı olmuyor!");
                System.out.println("Yeni bir özellik seçiliyor..");
                //Tie situation
                tieHandler(_test.getAbility());
            }

        } else if (_test.getAbility().matches("Üçlük")) {
            System.out.println("Üçlük özelliği karşılaştırılacak\n");
            //Comparing players penalty ability
            if (_board.get(0).getThreePointer() > _board.get(1).getThreePointer()) {
                System.out.println(_board.get(0).getName() + ", " + _board.get(1).getName() + " oyuncusundan daha iyi üçlük atıyor");
                System.out.println("Bu turu kazanan " + player.getPlayerName());
                player.setScore(player.getScore() + 15);
            } else if (_board.get(0).getThreePointer() < _board.get(1).getThreePointer()) {
                System.out.println(_board.get(1).getName() + ", " + _board.get(0).getName() + " oyuncusundan daha iyi üçlük atıyor");
                System.out.println("Bu turu kazanan " + bot.getPlayerName());
                bot.setScore(bot.getScore() + 15);
            } else if (_board.get(0).getThreePointer() == _board.get(1).getThreePointer()) {
                System.out.println(_board.get(0).getName() + " ve " + _board.get(1).getName() + " oyuncularının üçlükleri eşit");
                System.out.println("Bu turun kazananı olmuyor!");
                System.out.println("Yeni bir özellik seçiliyor..");
                //Tie situation
                tieHandler(_test.getAbility());
            }
        }

        updateScreen();

    }

    public void setIndexOne() {
        _index = 0;
    }

    public void setIndexTwo() {
        _index = 1;
    }

    public void setIndexThree() {
        _index = 2;
    }

    public void setIndexFour() {
        _index = 3;
    }
}
