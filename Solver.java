import java.util.ArrayList;
//import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;
public class Solver {

    public int fitness (moveNode n1,Maze m1){ //ADD consideration for visited locations
        int[] loc = n1.getLoc();
        moveNode currentMove = n1;
        ArrayList<int[]> moves = new ArrayList<int[]>();//change this to locations
        moves.add(loc);
        int total = 0;
        for(int i:currentMove.getPreMoves()){
            if(i==0){
                int x = currentMove.getLoc()[0];
                int y = currentMove.getLoc()[1] + 1;
                int[] loc1 = {x, y};
                //n1.getPreMoves().add(0);
                currentMove.setLoc(loc1);
                if (m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 1){
                    total++;
                    continue;
                }
                if(currentMove.getLoc() == m1.getGoal()){
                    total = Integer.MAX_VALUE;
                    break;
                }
                if(moves.contains(currentMove.getLoc()) || m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total = Integer.MIN_VALUE;
                    break;
                }
            }
            else if(i==1){
                int x = currentMove.getLoc()[0]+1;
                int y = currentMove.getLoc()[1];
                int[] loc1 = {x, y};
                moves.add(loc1);
                currentMove.setLoc(loc1);
                if (m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 1){
                    total++;
                    continue;
                }
                if(currentMove.getLoc() == m1.getGoal()){
                    total = Integer.MAX_VALUE;
                    break;
                }
                if(moves.contains(currentMove.getLoc()) || m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total = Integer.MIN_VALUE;
                    break;
                }
            }
            else if(i==2){
                int x = currentMove.getLoc()[0];
                int y = currentMove.getLoc()[1]-1;
                int[] loc1 = {x, y};
                moves.add(loc1);
                currentMove.setLoc(loc1);
                if (m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 1){
                    total++;
                    continue;
                }
                if(currentMove.getLoc() == m1.getGoal()){
                    total = Integer.MAX_VALUE;
                    break;
                }
                if(moves.contains(currentMove.getLoc()) || m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total = Integer.MIN_VALUE;
                    break;
                }
            }
            else{
                int x = currentMove.getLoc()[0]-1;
                int y = currentMove.getLoc()[1];
                int[] loc1 = {x, y};
                moves.add(loc1);
                currentMove.setLoc(loc1);
                if (m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 1){
                    total++;
                    continue;
                }
                if(currentMove.getLoc() == m1.getGoal()){
                    total = Integer.MAX_VALUE;
                    break;
                }
                if(moves.contains(currentMove.getLoc()) || m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        return total;
        
    }
//Mutate
    public ArrayList<Integer> mutate(ArrayList<Integer> path){
        Random r = new Random();
        int rand = r.nextInt(100);
        int loc = r.nextInt(path.size());
        int choice = r.nextInt(4);
        if (rand<80){//CHANGE THIS BACK GRACE
            path.set(loc, choice);
        }
        return path;
    }
//Crossover
    public ArrayList<Integer> reproduce(ArrayList<Integer> path1, ArrayList<Integer> path2){
        ArrayList<Integer> newList = new ArrayList<Integer>();
        Random rand = new Random();
        int n = path1.size();
        int c = rand.nextInt(n);
        for(int i = 0; i<c+1; i++){
            newList.add(path1.get(i));
        }
        for(int i = c+1; i<n;i++){
            newList.add(path2.get(i));
        }
        return newList;
    }
//NEED TO FIX
    public ArrayList<ArrayList<Integer>> generatePopulation(Maze m1){
        Random r = new Random();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i<10;i++){
        ArrayList<Integer> newPath = new ArrayList<Integer>();
            for (int j = 0; j<m1.getSize(); j++){
                newPath.add(r.nextInt(4));
        }
        paths.add(newPath);
    }
        return paths;
    }

//NEED TO FIX
    public moveNode geneticAlgorithm(ArrayList<moveNode> pop, Maze m1){
        int fit = 0;
        moveNode winner = new moveNode();
        while(fit!=Integer.MAX_VALUE){
            for (moveNode ls : pop){
                winner = ls;
                int newFit = fitness(ls, m1);
                if(newFit>fit){
                    fit = newFit;
                }
            }
            ArrayList<moveNode> pop2 = new ArrayList<moveNode>();
            for (int i=1; i<pop.size(); i++){
                Random r = new Random();
                moveNode parent1 = new moveNode();
                moveNode parent2 = new moveNode();
                parent1 = pop.get((r.nextInt(pop.size())));
                parent2 = pop.get((r.nextInt(pop.size())));
                int[] test = {0,1};//GET RID OF THIS WHEN YOU FIX IT
                moveNode child = new moveNode(test, reproduce(parent1.getPreMoves(), parent2.getPreMoves()));
                Random r2 = new Random();
                int r1 = r2.nextInt(10);
                if(r1<2){//need to do this still.
                    child = new moveNode(child.getLoc(), mutate(child.getPreMoves()));
                    pop2.add(child);
                }
                pop = pop2; 
            }
        }
        return winner;

    } 
}

