package sample.Oyuncular;


import sample.Sporcular.Sporcu;

public class Kullanici extends Oyuncu{


    public Kullanici(){
        playerID = 22;
        playerName = "MK";
        score = 0;
    }

    public Kullanici(int playerID,String playerName,int score){
        super(playerID,playerName,score);
    }


    @Override
    public Sporcu kartSec(int index, boolean turnFlag) {
        Sporcu temp=null;
        if(turnFlag){
            this.handF.get(index).setUsed(false);
            temp = this.handF.get(index);
            this.handF.remove(index);

        } else {
            this.handB.get(index).setUsed(false);
            temp = this.handB.get(index);
            this.handB.remove(index);
        }

        return temp;
    }

}
