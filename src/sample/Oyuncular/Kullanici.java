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
    public Sporcu kartSec(int index, int counter) {
        Sporcu temp=null;
        if(counter % 2 == 0){
            this.handF.get(index).setUsed(false);
            temp = this.handF.get(index);
            this.handF.remove(index);

        } else if(counter % 2 == 1){
            this.handB.get(index-1).setUsed(false);
            temp = this.handB.get(index);
            this.handB.remove(index);
        }

        return temp;
    }

}
