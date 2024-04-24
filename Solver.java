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
    

    public int fitness (int[] path,Maze m1, myNode n1){
        int[] loc = m1.getStart();
        ArrayList<moveNode> moves = new ArrayList<moveNode>();
        moveNode currentMove = new moveNode(loc, moves);
        for(int i:path){
            if(i==0){

            }
            else if(i==1){

            }
            else if(i==2){

            }
            else{

            }
        }
        
    }

    public myNode mutate(myNode n1){


    }
//Crossover
    public myNode reproduce(myNode p1, myNode p2){
        int n  = p1.getNumMoves();
        int c = r.nextInt(n);
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
