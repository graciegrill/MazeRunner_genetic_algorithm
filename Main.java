import java.util.ArrayList;
public class Main {

    public static void main(String[] args){
        Maze m  = new Maze(new int[]{8, 0}, 
        new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 0, 0, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
        }, new int[]{1,9});
        Solver s = new Solver();
        ArrayList<moveNode> pop = s.generatePopulation(m);
        System.out.print(pop.get(5).getPreMoves().toString());
        System.out.println(s.geneticAlgorithm(pop, m).getPreMoves().toString());
    }
    
}
