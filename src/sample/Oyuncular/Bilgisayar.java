package sample.Oyuncular;


import sample.Sporcular.Sporcu;

import java.util.Random;

public class Bilgisayar extends Oyuncu{

    Random _random = new Random();

    public Bilgisayar(){

        this.playerID = _random.nextInt(500);
        this.playerName = "Mr.Bot";
        this.score = 0;
    }

    public Bilgisayar(int playerID,String playerName,int score){
        super(playerID,playerName,score);
    }

    @Override
    public Sporcu kartSec(int index,boolean turnFlag) {
        Sporcu temp = null;
        if(turnFlag){
            index = _random.nextInt(this.handF.size());
            this.handF.get(index).setUsed(false);
            temp = this.handF.get(index);
            this.handF.remove(index);

        } else {
            index = _random.nextInt(this.handB.size());
            this.handB.get(index).setUsed(false);
            temp = this.handB.get(index);
            this.handB.remove(index);
        }

        return  temp;
    }

}
