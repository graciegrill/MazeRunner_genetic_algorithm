import java.util.ArrayList;
public class Main { 
    public static void main(String[] args){
        Maze m  = new Maze(new int[]{0, 2}, 
        new int[][]{
            {0,1},
            {0,1}
        }, new int[]{1,2});
        Solver s = new Solver();
        ArrayList<moveNode> pop = s.generatePopulation(m);
        System.out.println(s.geneticAlgorithm(pop, m, 10000).getPreMoves().toString());
        //System.out.println(s.geneticAlgorithm(pop, m, 30000));
    }
}

/*
 * Sample output
 * 
 * Maximum time exceeded.
[0, 1, 1, 2]
 */