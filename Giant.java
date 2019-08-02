import java.awt.*;

public class Giant extends Critter {

    int fourCycle = 0;
    private int moveCounter;

    public Giant(){
        super();
    }

    public Color getColor(){
        return Color.GRAY;
    }

    public String toString(){
        cycleTrigger();
        if(fourCycle == 1){
            return "fee";
        }else if(fourCycle == 2){
            return "fie";
        }else if(fourCycle == 3){
            return "foe";
        }else if(fourCycle == 4){
            return "fum";
        }else{
            return "fee";
        }
    }

    public void cycleTrigger(){
        int n = this.moveCounter;
        if(n%6 == 0){
            cycleCounter();
        }
    }

    public void cycleCounter(){
        if(this.fourCycle > 3){
            this.fourCycle = 1;
        }else{
            this.fourCycle++;
        }
    }

    public Action getMove(CritterInfo info){
        moveCounter++;
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }else{
            return Action.RIGHT;
        }
    }

}
