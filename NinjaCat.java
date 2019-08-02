import java.awt.*;
public class NinjaCat extends Critter {

    private Color currentColor;

    public NinjaCat(){
        super();
        this.currentColor = Color.CYAN;
    }

    public String toString(){
        return "N";
    }

    public Color getColor(){
        return currentColor;
    }

    public Action getMove(CritterInfo info){
        if(info.getFront() == Neighbor.OTHER){
            this.currentColor = Color.BLACK;
            return Action.INFECT;
        }else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            this.currentColor = Color.CYAN;
            return Action.LEFT;
        }else if(info.getFront() == Neighbor.SAME){
            this.currentColor = Color.CYAN;
            return Action.RIGHT;
        }else{
            this.currentColor = Color.CYAN;
            return Action.HOP;
        }
    }

}
