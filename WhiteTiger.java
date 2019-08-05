import java.awt.*;
public class WhiteTiger extends Tiger { //extends tiger so I didn't have to redo the whole getMove method

    public String hasInfected = "tgr"; //default string value is tgr

    public WhiteTiger() {
        super();
    }

    public Color getColor() {
        return Color.WHITE;
    }

    public String toString() {
        return this.hasInfected; //return whatever is in the tgr field
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER){
            this.hasInfected = "TGR"; //if it has performed the action infect, then change the field hasInfected to TGR
        }
        return super.getMove(info);//then go everything the tiger does
    }
}
