import java.util.ArrayList;
public class moveNode {

    private int[] loc;
    private ArrayList<moveNode> visited;

    public moveNode(int[] loc, ArrayList<moveNode> visited) {
        this.loc = loc;
        this.visited = visited;
    }

    public int[] getLoc() {
        return this.loc;
    }

    public void setLoc(int[] loc) {
        this.loc = loc;
    }

    

    
    public ArrayList<moveNode> getVisited() {
        return this.visited;
    }

    public void setVisited(ArrayList<moveNode> visited) {
        this.visited = visited;
    }
    
    
}
