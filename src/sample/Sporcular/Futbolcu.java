package sample.Sporcular;

import javafx.scene.control.Alert;

public class Futbolcu extends Sporcu{

    int penalty,freekick,finishing;

    public Futbolcu(){
        penalty = 80;
        freekick = 75;
        finishing = 95;
    }

    public Futbolcu(String futbolcuAdi,String futbolcuTakimi,int penalty,int freekick,int finishing){
        super(futbolcuAdi,futbolcuTakimi);
        this.penalty = penalty;
        this.freekick = freekick;
        this.finishing = finishing;
    }

    public int getPenalty(){
        return this.penalty;
    }

    public int getFreekick(){
        return this.freekick;
    }

    public int getFinishing(){
        return this.finishing;
    }

    public void setFinishing(int finishing) {
        this.finishing = finishing;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public void setFreekick(int freekick) {
        this.freekick = freekick;
    }

    @Override
    public void sporcuPuaniGoster() {
        //Alert kullan
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Futbolcu Bilgisi");
        alert.setHeaderText(null);
        alert.setContentText(this.name + " "+this.teamName+"\n"+"Penaltı : "+this.penalty+" \nSerbest Vuruş : "+this.freekick+" \nBitiricilik : "+this.finishing);

        alert.showAndWait();
    }

}
