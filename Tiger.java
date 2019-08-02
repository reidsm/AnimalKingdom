import java.awt.*;
import java.util.*;
public class Tiger extends Critter {

    private Color newColor;
    private int moveCounter;

    public Tiger(){
        super();
    }

    public Color getColor(){
        int n = this.moveCounter;
        if(n%3 == 0){
            Color aColor = getRandomColor();
            this.newColor = aColor;
            return aColor;
        }else{
            return this.newColor;
        }
    }

    public int getRandomInt(){
        Random rand = new Random();
        int randomNum = rand.nextInt(3);
        return randomNum;
    }

    public Color getRandomColor(){
        int n = getRandomInt();
        if(n == 0){
            return Color.RED;
        }else if(n == 1){
            return Color.BLUE;
        }else{
            return Color.GREEN;
        }
    }

    public String toString(){
        return "TGR";
    }

    public Action getMove(CritterInfo info){
        moveCounter++;
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Action.LEFT;
        }else if(info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        }else{
            return Action.HOP;
        }
    }

}
