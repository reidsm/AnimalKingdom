import java.awt.*;
import java.util.*;
public class Tiger extends Critter {

    private Color newColor; //holds the current color on turns where the color doesn't change
    private int moveCounter;

    public Tiger(){
        super();
    }

    public Color getColor(){
        int n = this.moveCounter;
        if(n%3 == 0){ //if n is cleanly divisible by 3 then change colors to a random color
            Color aColor = getRandomColor(); //decides which random color to change to
            this.newColor = aColor; //stores the color it changed to keep things stable on turns that are not cleanly divisible by 3
            return aColor; //return the new color
        }else{
            return this.newColor; //otherwise, return the color it is right now
        }
    }

    public int getRandomInt(){ //returns a random integer between 0 and 2 basically
        Random rand = new Random();
        int randomNum = rand.nextInt(3);
        return randomNum;
    }

    public Color getRandomColor(){ //associates colors with integers
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
        moveCounter++; //every move, increaes the turn counter
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
