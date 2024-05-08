import java.util.ArrayList;
public class moveNode {

    private int[] loc;
    private ArrayList<Integer> preMoves;

    public moveNode(int[] loc, ArrayList<Integer> preMoves) {
        this.loc = loc;
        this.preMoves = preMoves;
    }

    public moveNode() {
    }
    public ArrayList<Integer> getPreMoves() {
        return this.preMoves;
    }

    public void setPreMoves(ArrayList<Integer> preMoves) {
        this.preMoves = preMoves;
    }

    public int[] getLoc() {
        return this.loc;
    }

    public void setLoc(int[] loc) {
        this.loc = loc;
    }
    
}
