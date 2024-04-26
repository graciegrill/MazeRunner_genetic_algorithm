import java.util.ArrayList;
//import java.util.List;
import java.util.Random;
public class Solver {

    public int fitness (int[] path,Maze m1, myNode n1){ //ADD consideration for visited locations
        int[] loc = m1.getStart();
        ArrayList<moveNode> moves = new ArrayList<moveNode>();//change this to locations
        moveNode currentMove = new moveNode(loc, moves);
        int total = 0;
        for(int i:path){
            if(i==0){
                int x = currentMove.getLoc()[0];
                int y = currentMove.getLoc()[1] + 1;
                int[] loc1 = {x, y};
                currentMove.setLoc(loc1);
                if (m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 1){
                    total++;
                }
                else if(currentMove.getLoc() == m1.getGoal()){
                    total = Integer.MAX_VALUE;
                }
                else if(m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total--;
                }
            }
            else if(i==1){
                int x = currentMove.getLoc()[0]+1;
                int y = currentMove.getLoc()[1];
                int[] loc1 = {x, y};
                currentMove.setLoc(loc1);
                if (m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 1){
                    total++;
                }
                else if(currentMove.getLoc() == m1.getGoal()){
                    total = Integer.MAX_VALUE;
                }
                else if(m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total--;
                }

            }
            else if(i==2){
                int x = currentMove.getLoc()[0];
                int y = currentMove.getLoc()[1]-1;
                int[] loc1 = {x, y};
                currentMove.setLoc(loc1);
                if (m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 1){
                    total++;
                }
                else if(currentMove.getLoc() == m1.getGoal()){
                    total = Integer.MAX_VALUE;
                }
                else if(m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total--;
                }

            }
            else{
                int x = currentMove.getLoc()[0]-1;
                int y = currentMove.getLoc()[1];
                int[] loc1 = {x, y};
                currentMove.setLoc(loc1);
                if (m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 1){
                    total++;
                }
                if(currentMove.getLoc() == m1.getGoal()){
                    total = Integer.MAX_VALUE;
                }
                if(m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total--;
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


    /* public ArrayList<myNode> geneticAlgorithm(int pop, int fitness){
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

    } */

    public static void main(String[] args){
        int[] path1 = {1,2,3,4,5,6,7,8};
        int[] path2 = {11,12,13,14,15,16,17,18};
        mutate(path1);
    }
    
    
}

