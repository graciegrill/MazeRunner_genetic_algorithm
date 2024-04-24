public class Maze{

    private int xDim;
    private int yDim;
    private int[]    goal;
    private int[][] grid;
    private int[] start;

    public int[] getStart() {
        return this.start;
    }

    public void setStart(int[] start) {
        this.start = start;
    }



    public int[][] getGrid() {
        return this.grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int getXDim() {
        return this.xDim;
    }

    public void setXDim(int xDim) {
        this.xDim = xDim;
    }

    public int getYDim() {
        return this.yDim;
    }

    public void setYDim(int yDim) {
        this.yDim = yDim;
    }

    public Maze(int xDim, int yDim, int[][] goal) {
        this.xDim = xDim;
        this.yDim = yDim;
        this.goal = goal;
        this.grid = new int[yDim][xDim];
    }

   
    public int[][] getGoal() {
        return this.goal;
    }

    public void setGoal(int[][] goal) {
        this.goal = goal;
    }
}