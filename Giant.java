import java.awt.*;

public class Giant extends Critter {

    int fourCycle = 0; //store the current state of the four step cycle "fee" "fie" "foe" "fum"
    private int moveCounter;

    public Giant(){
        super();
    }

    public Color getColor(){
        return Color.GRAY;
    }

    public String toString(){ //return a string that corresponds to which step of the cycle we're on
        cycleTrigger(); //at the start of every turn, perform a set of functions to update the cycle counter starting with cycleTrigger()
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
        if(n%6 == 0){ //if the movecounter is cleanly divisible by 6, then increase the cycle counter
            cycleCounter();
        }
    }

    public void cycleCounter(){
        if(this.fourCycle > 3){ //as soon as the cycle counter goes above 3, reset it to 1 so the counter goes back to "fee"
            this.fourCycle = 1; //it's 1 because cycleTrigger is at the top of the toString() method
        }else{
            this.fourCycle++; //if fourcycle is less than 3, just add 1 to the cycle counter
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
