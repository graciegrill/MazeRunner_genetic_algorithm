public class Maze{

    private int [][] grid;
    private int goalX, goalY;

    public int getGoalX() {
        return this.goalX;
    }

    public void setGoalX(int goalX) {
        this.goalX = goalX;
    }

    public int getGoalY() {
        return this.goalY;
    }

    public void setGoalY(int goalY) {
        this.goalY = goalY;
    }

    public Maze(int[][] grid) {
        this.grid = grid;
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}