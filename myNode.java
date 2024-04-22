public class myNode {

    private myNode parent;//parent node (prev pointer)
    private int[][] state; //whether the runner is at a 0 or a 1 (wall or path)
    private int numMoves;

    public myNode(myNode parent, int[][] state, int numMoves) {
        this.parent = parent;
        this.state = state;
        this.numMoves = numMoves;
    }

    public int getNumMoves() {
        return this.numMoves;
    }

    public void setNumMoves(int numMoves) {
        this.numMoves = numMoves;
    }

    

    public int[][] getState() {
        return this.state;
    }

    public void setState(int[][] state) {
        this.state = state;
    }

    

    
    public myNode getParent() {
        return this.parent;
    }

    public void setParent(myNode parent) {
        this.parent = parent;
    }
}
