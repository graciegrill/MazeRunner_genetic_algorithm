import java.util.ArrayList;
//import java.util.List;
import java.util.Random;
public class Solver {

    private Random r = new Random();

    public int proximity(Maze m1, myNode n1){
        int row0 = n1.getState()[0][0];
        int col0 = n1.getState()[0][1];
        int row1 = m1.getGoal()[0][0];
        int col1 = m1.getGoal()[0][1];
        int rowDistance = Math.abs(row1 - row0);
        int colDistance = Math.abs(col1 - col0);
        return rowDistance+colDistance;
    }
    

    public int fitness (Maze m1, myNode n1){
        int row = n1.getState()[0][0];
        int col = n1.getState()[0][1];
        if(m1.getGrid()[row][col]== 0){
            return 0;
        }
        else if(m1.getGrid()[row][col]== 1 && n1.getState() == m1.getGoal()){ //double-check comparison here
            return Integer.MAX_VALUE;
        }
        else{
            return proximity(m1, n1);
        }
    }

    public myNode mutate(myNode n1){

    }

    public myNode reproduce(myNode p1, myNode p2){
        int n  = p1.getNumMoves();
        int c = r.nextInt(4);
        myNode p0 = new myNode

    }


    public ArrayList<myNode> geneticAlgorithm(int pop, int fitness){
        while(fitness!=Integer.MAX_VALUE){
            ArrayList<Integer> weights = weightedby (pop, fitness);
            ArrayList<myNode> pop2 = new ArrayList<myNode>();

            for (int i=1; i<pop; i++){
                parent1, parent2 = weightedRandomChoices(pop, weights,2);
                child = reproduce(parent1, parent2);
                if(small random prob){
                    child = mutate(child);
                    pop2.add(child);
                }
                pop = pop2;
            }
        }
        return best in pop;

    }
    
}
