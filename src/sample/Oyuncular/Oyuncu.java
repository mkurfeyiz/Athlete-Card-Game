package sample.Oyuncular;


import sample.Sporcular.*;

import java.util.ArrayList;

public abstract class Oyuncu {

    String playerName;
    int playerID,score;
    ArrayList<Futbolcu> handF = new ArrayList<>(4);
    ArrayList<Basketbolcu> handB = new ArrayList<>(4);

    Oyuncu(){

    }

    Oyuncu(int playerID,String playerName,int score){
        this.playerID = playerID;
        this.playerName = playerName;
        this.score = score;
    }

    public abstract Sporcu kartSec(int index,boolean turnFlag);
    public int getScore() {
        return this.score;
    }
    public void setScore(int score) {
         this.score = score;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHandSizeF(){
        return this.handF.size();
    }

    public int getHandSizeB(){
        return this.handB.size();
    }

    public ArrayList<Futbolcu> getHandF() {
        return handF;
    }

    public ArrayList<Basketbolcu> getHandB() {
        return handB;
    }
}
