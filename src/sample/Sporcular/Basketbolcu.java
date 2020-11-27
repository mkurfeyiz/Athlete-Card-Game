package sample.Sporcular;

import javafx.scene.control.Alert;

public class Basketbolcu extends Sporcu {

    int point,threePointer,freeThrow;

    public Basketbolcu(){
        point = 75;
        threePointer = 65;
        freeThrow = 70;
    }

    public Basketbolcu(String basketbolcuAdi,String basketbolcuTakim,int point,int threePointer,int freeThrow){
        super(basketbolcuAdi,basketbolcuTakim);
        this.point = point;
        this.threePointer = threePointer;
        this.freeThrow = freeThrow;
    }

    public int getPoint(){
        return this.point;
    }

    public int getThreePointer(){
        return this.threePointer;
    }

    public int getFreeThrow(){
        return this.freeThrow;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setThreePointer(int threePointer) {
        this.threePointer = threePointer;
    }

    public void setFreeThrow(int freeThrow) {
        this.freeThrow = freeThrow;
    }

    //Buralari alert ile gösterebilirim.
    @Override
    public void sporcuPuaniGoster() {

        System.out.println("Oyuncunun Adı : "+this.name + "\nTakımı : "+this.teamName+"\n"+"İkilik : "+this.point+" \nÜçlük : "+this.threePointer+" \nSerbest Atış : "+this.freeThrow);

    }

    @Override
    public int getPenalty() {
        int i = 0;
        return i;
    }

    @Override
    public int getFreekick() {
        int i = 0;
        return i;
    }

    @Override
    public int getFinishing() {
        int i = 0;
        return i;
    }

}
