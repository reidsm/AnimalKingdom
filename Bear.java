import java.awt.*;
import java.util.*;

public class Bear extends Critter {

    private boolean polar;
    private int moveCounter;

    public Bear(boolean Polar){
        super();
        this.polar = randomBoolean();
    }

    public Color getColor(){
        if (this.polar == true){
            return Color.WHITE;
        }else{
            return Color.BLACK;
        }
    }

    public boolean randomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }

    public String toString(){
        if(this.moveCounter%2 == 0){
            return "/";
        }else{
            return"\\";
        }
    }

    public Action getMove(CritterInfo info){
        moveCounter++;
        if(info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }else {
            return Action.LEFT;
        }
    }

}
