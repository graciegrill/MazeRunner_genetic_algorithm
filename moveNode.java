import java.util.ArrayList;
import java.util.Objects;
public class moveNode {

    private int[] loc;
    private int[] preMoves;

    public moveNode() {
    }
    public int[] getPreMoves() {
        return this.preMoves;
    }

    public void setPreMoves(int[] preMoves) {
        this.preMoves = preMoves;
    }

    public int[] getLoc() {
        return this.loc;
    }

    public void setLoc(int[] loc) {
        this.loc = loc;
    }
    
}
