package sample;

import sample.Oyuncular.*;
import sample.Sporcular.*;

import java.security.SecureRandom;
import java.util.ArrayList;


public class Test {

    //Oyunun ilerleyişi buradan takip edilmelidir.
    Bilgisayar _bot;
    Kullanici _player;
    boolean flag,flagF,flagB;

    ArrayList<Futbolcu> cardListF = new ArrayList<>(8);
    ArrayList<Basketbolcu> cardListB = new ArrayList<>(8);

    Test(Bilgisayar bot,Kullanici player){

        _bot = bot;
        _player = player;

        setDeck(this.cardListF,this.cardListB);

        /*for (Futbolcu kart : cardListF) {//javada foreach
            System.out.println(kart.getName()+" "+kart.getTeamName());
        }
        System.out.println("\n------------\n");
        for (Basketbolcu kart : cardListB) {//javada foreach
            System.out.println(kart.getName()+" "+kart.getTeamName());
        }*/

    }

    public void setHand(Bilgisayar bot,Kullanici player){

        for(int i=0;i<this.cardListF.size();i++){
            if(i<4){
                player.getHandF().add(cardListF.get(i));
                player.getHandB().add(cardListB.get(i));
            } else {
                bot.getHandF().add(cardListF.get(i));
                bot.getHandB().add(cardListB.get(i));
            }

        }

        /*for(int i=0;i<4;i++){
            System.out.println("player : "+player.getHandF().get(i).getName() + " bot : "+bot.getHandF().get(i).getName());
            System.out.println("player : "+player.getHandB().get(i).getName() + " bot : "+bot.getHandB().get(i).getName());
        }*/

    }

    public void setDeck(ArrayList<Futbolcu> cardListF,ArrayList<Basketbolcu> cardListB){

        //Adding players to list
        //Futbolcular
        cardListF.add(new Futbolcu("Lionel Messi","Barcelona",90,92,95));
        cardListF.add(new Futbolcu("Cristiano Ronaldo","Juventus",95,88,95));
        cardListF.add(new Futbolcu("Heung Min Son","Tottenham",87,80,90));
        cardListF.add(new Futbolcu("Robert Lewandowski","Bayern Münih",90,84,95));
        cardListF.add(new Futbolcu("Mohamed Salah","Liverpool",79,80,93));
        cardListF.add(new Futbolcu("Inaki Williams","Athletic Bilbao",37,40,54));
        cardListF.add(new Futbolcu("Wissam Ben Yedder","Monaco",50,43,75));
        cardListF.add(new Futbolcu("Richarlison","Everton",76,78,80));
        //Basketbolcular
        cardListB.add(new Basketbolcu("LeBron James","LA Lakers",90,80,95));
        cardListB.add(new Basketbolcu("Stephen Curry","Golden State Warriors",87,95,90));
        cardListB.add(new Basketbolcu("Jimmy Butler","Miami Heats",73,70,76));
        cardListB.add(new Basketbolcu("Anthony Davies","LA Lakers",83,77,84));
        cardListB.add(new Basketbolcu("James Harden","Houston Rockets",88,93,88));
        cardListB.add(new Basketbolcu("Luka Doncic","Dallas Mavericks",86,79,85));
        cardListB.add(new Basketbolcu("Nikola Jokic","LA Lakers",75,75,75));
        cardListB.add(new Basketbolcu("Kobe Bryant","LA Lakers",99,99,99));

        int newPos;
        Futbolcu temp;
        SecureRandom random=new SecureRandom();
        //Randomizing F
        for (int ilkKart = 0; ilkKart < cardListF.size(); ilkKart++) {
            newPos=random.nextInt(8);

            temp=cardListF.get(ilkKart);
            cardListF.set(ilkKart, cardListF.get(newPos));
            cardListF.set(newPos,temp);
        }
        Basketbolcu tempB;
        //Randomizing B
        for (int ilkKart = 0; ilkKart < cardListB.size(); ilkKart++) {
            newPos=random.nextInt(8);

            tempB=cardListB.get(ilkKart);
            cardListB.set(ilkKart, cardListB.get(newPos));
            cardListB.set(newPos,tempB);
        }
    }

    public void getFutbolcuOz(Futbolcu f){

        System.out.println("Adı : "+f.getName());
        System.out.println("Oynadığı Kulüp : "+f.getTeamName());
        System.out.println("Penaltı : "+f.getPenalty());
        System.out.println("Serbest Vuruş : "+f.getFreekick());
        System.out.println("Bitiricilik : "+f.getFinishing());

    }

    public void getBasketbolcuOz(Basketbolcu b){

        System.out.println("Adı : "+b.getName());
        System.out.println("Oynadığı Kulüp : "+b.getTeamName());
        System.out.println("İkilik : "+b.getPoint());
        System.out.println("Üçlük : "+b.getThreePointer());
        System.out.println("Serbest Atış : "+b.getFreeThrow());
        
    }

    public void setPlayerType(int counter){
        if(counter % 2 == 0){
            System.out.println("Futbolcu Sırası");
            flagF = true;
            flagB = false;
        } else {
            System.out.println("Basketbolcu Sırası");
            flagF = false;
            flagB = true;
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag(){
        return this.flag;
    }

    public boolean checkGame(){

        if(_player.getHandSizeB() == 0 && _player.getHandSizeB() == 0 ){

            if(_bot.getHandSizeF() == 0 && _bot.getHandSizeB() == 0){
                setFlag(false);
            }
        } else {
            setFlag(true);
        }

        return this.flag;
    }
}
