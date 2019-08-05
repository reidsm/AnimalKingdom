import java.awt.*;
import java.util.*;

public class Bear extends Critter {

    private boolean polar; //holds a random boolean
    private int moveCounter; //holds the number of moves made so we can use division to figure out if it's supposed to be a / or \

    public Bear(boolean Polar){
        super();
        this.polar = randomBoolean(); //calls a function that returns a random boolean
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
        return random.nextBoolean(); //returns a random boolean with the Random object type
    }

    public String toString(){
        if(this.moveCounter%2 == 0){ //if the mouvecount is even, return /
            return "/";
        }else{
            return"\\"; //otherwise use the escape sequence for \
        }
    }

    public Action getMove(CritterInfo info){
        moveCounter++; //every move, increase the turn counter
        if(info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }else {
            return Action.LEFT;
        }
    }

}
