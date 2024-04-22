import java.util.ArrayList;
//import java.util.List;
public class Solver {
    

    public int fitness (Node n1){
        if
    }

    public Node mutate(Node n1){

    }

    public Node reproduce(Node p1, Node p2){

    }


    public ArrayList<Node> geneticAlgorithm(int pop, int fitness){
        while(fitness!=1 /*|| runtime condition*/){
            ArrayList<Integer> weights = weightedby (pop, fitness);
            ArrayList<Node> pop2 = new ArrayList<Node>();

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
