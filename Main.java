import java.util.ArrayList;
public class Main {

    public static void main(String[] args){
        Maze m  = new Maze(new int[]{0, 0}, 
        new int[][]{
            {1,1}

        }, new int[]{0,0});
        Solver s = new Solver();
        ArrayList<moveNode> pop = s.generatePopulation(m);
        System.out.println(s.geneticAlgorithm(pop, m, 300000).getPreMoves().toString());
    }
    
}
