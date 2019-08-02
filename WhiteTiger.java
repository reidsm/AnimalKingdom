import java.awt.*;
public class WhiteTiger extends Tiger {

    public String hasInfected = "tgr";

    public WhiteTiger() {
        super();
    }

    public Color getColor() {
        return Color.WHITE;
    }

    public String toString() {
        return this.hasInfected;
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER){
            this.hasInfected = "TGR";
        }
        return super.getMove(info);
    }
}
