public class Maze{

    private int [][] grid;
    private int[][] goal;

    public Maze(int[][] grid, int[][] goal) {
        this.grid = grid;
        this.goal = goal;
    }

    public int[][] getGoal() {
        return this.goal;
    }

    public void setGoal(int[][] goal) {
        this.goal = goal;
    }

    
   
    public int[][] getGrid() {
        return this.grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}