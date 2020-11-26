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


    //Buralari alert ile gösterebilirim.
    @Override
    public void sporcuPuaniGoster() {
        //Alert kullan
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Basketbolcu Bilgisi");
        alert.setHeaderText(null);
        alert.setContentText(this.name + " "+this.teamName+"\n"+"İkilik : "+this.point+" \nÜçlük : "+this.threePointer+" \nSerbest Atış : "+this.freeThrow);

        alert.showAndWait();
    }

}
