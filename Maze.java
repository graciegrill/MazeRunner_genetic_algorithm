public class Maze{

    private int xDim;//X dimension of the maze
    private int yDim;//Y dimension of the maze
    private int[] goal;//goal location
    private int[][] grid;//grid representing the maze. Made of 0s(impassable) and 1s(passable)
    private int size;//size of the maze

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Maze(int[] goal, int[][] grid, int[] start) {
        this.xDim = grid[0].length;
        this.yDim = grid.length;
        this.goal = goal;
        this.grid = grid;
        this.start = start;
        this.size = this.xDim*this.yDim;
    }

    public int[] getGoal() {
        return this.goal;
    }

    public void setGoal(int[] goal) {
        this.goal = goal;
    }

    
    
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
}
    
   
    