package sample.Sporcular;

public abstract class Sporcu {

    String name,teamName;
    boolean isUsed; // true == unused / false == used
    Sporcu(){
        name = "Muhammed Kurfeyiz";
        teamName = "Beşiktaş JK";
    }

    Sporcu(String name,String teamName){
        this.name = name;
        this.teamName = teamName;
    }

    public abstract void sporcuPuaniGoster();
    //Futbolcu methods
    public abstract int getPenalty();
    public abstract int getFreekick();
    public abstract int getFinishing();
    //Basketbolcu methods
    public abstract int getPoint();
    public abstract int getThreePointer();
    public abstract int getFreeThrow();

    public String getName(){
        return this.name;
    }

    public String getTeamName(){
        return  this.teamName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public boolean getIsUsed(){
        return this.isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public boolean isCardUsed(){
        return getIsUsed();
    }
}
