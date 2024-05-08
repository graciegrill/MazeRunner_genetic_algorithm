import java.util.ArrayList;
//import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;
public class Solver {

    public int fitness (ArrayList<Integer> path,Maze m1){ //ADD consideration for visited locations
        int[] loc = m1.getStart();
        ArrayList<int[]> moves = new ArrayList<int[]>();//change this to locations
        moves.add(loc);
        moveNode currentMove = new moveNode(loc);
        int total = 0;
        for(int i:path){
            if(i==0){
                int x = currentMove.getLoc()[0];
                int y = currentMove.getLoc()[1] + 1;
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
                if(m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total--;
                    continue;
                }
                if(moves.contains(currentMove.getLoc())){
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
                if(m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total--;
                    continue;
                }
                if(moves.contains(currentMove.getLoc())){
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
                if(m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total--;
                    continue;
                }
                if(moves.contains(currentMove.getLoc())){
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
                if(m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total--;
                    continue;
                }
                if(moves.contains(currentMove.getLoc())){
                    total = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        return total;
        
    }

    public static void mutate(int[] path){
        Random r = new Random();
        int rand = r.nextInt(100);
        int loc = r.nextInt(path.length);
        int choice = r.nextInt(4);
        if (rand<80){//CHANGE THIS BACK GRACE
            path[loc] = choice;
        }
        for (int i = 0; i<path.length; i++){
            System.out.println(path[i]);
        }
    }
//Crossover
    public static void reproduce(int[] path1, int[] path2){
        ArrayList<Integer> newList = new ArrayList<Integer>();
        Random rand = new Random();
        int n = path1.length;
        int c = rand.nextInt(n);
        for(int i = 0; i<c+1; i++){
            newList.add(path1[i]);
        }
        for(int i = c+1; i<n;i++){
            newList.add(path2[i]);
        }
        System.out.println(newList);
    }

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


    public ArrayList<myNode> geneticAlgorithm(ArrayList<myNode> pop, Maze m1){
        int fit = 0;
        ArrayList<ArrayList<Integer>> p = new ArrayList<ArrayList<Integer>>();
        while(fit!=Integer.MAX_VALUE){
            for (myNode ls : pop){
                int newFit = fitness(ls, m1);
                if(newFit>fit){
                    fit = newFit;
                }
            }
            ArrayList<myNode> pop2 = new ArrayList<myNode>();
            for (int i=1; i<pop.size(); i++){
                Random r = new Random();
                myNode parent1 = new myNode();
                myNode parent2 = new myNode();
                parent1 = pop.get((r.nextInt(pop.size())));
                parent2 = pop.get((r.nextInt(pop.size())));
                myNode child = reproduce(parent1, parent2);
                if(small random prob){//need to do this still.
                    child = mutate(child);
                    pop2.add(child);
                }
                pop = pop2; 
            }
        }
        return best in pop;

    } 
    public static void main(String[] args){
        int[] path1 = {1,2,3,4,5,6,7,8};
        int[] path2 = {11,12,13,14,15,16,17,18};
        mutate(path1);
    }
    
    
}

