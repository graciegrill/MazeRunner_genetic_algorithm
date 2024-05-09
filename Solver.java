import java.util.ArrayList;
//import java.util.List;
import java.util.Random;
public class Solver {
    /*
     * Returns an int fitness score of a move sequence in a node. It is set lowest as possible if the path ever
     * backtracks or makes an impossible move, and set highest when the goal is reached. It is incremented by one if
     * a legal and non-goal move is made.
     */
    public int fitness (moveNode n1,Maze m1){
        int[] loc = n1.getLoc();
        moveNode currentMove = n1;
        ArrayList<int[]> moves = new ArrayList<int[]>();
        moves.add(loc);
        int total = 0;
        for(int i:currentMove.getPreMoves()){
            if(i==0 && currentMove.getLoc()[1] != 0){//moving up
                int x = currentMove.getLoc()[0];
                int y = currentMove.getLoc()[1] - 1;
                
                //System.out.println("*****");
                //System.out.print(i+"\n");
                //System.out.print(x+"\n");
                //System.out.print(y+"\n");
                int[] loc1 = {x, y};
                currentMove.setLoc(loc1);
                if(currentMove.getLoc() == m1.getGoal()){
                    total = Integer.MAX_VALUE;
                    break;
                }
                else if(currentMove.getLoc()[0] < 0 || currentMove.getLoc()[1] < 0){
                    total = Integer.MIN_VALUE;
                    break;
                }
                else if(moves.contains(currentMove.getLoc()) || m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total = Integer.MIN_VALUE;
                    break;
                }
                else if (m1.getGrid()[currentMove.getLoc()[1]][currentMove.getLoc()[0]] == 1){
                    total++;
                    continue;
                }
            }
            else if(i==1 && currentMove.getLoc()[0] != m1.getYDim() - 1){//moving right
                int x = currentMove.getLoc()[0]+1;
                int y = currentMove.getLoc()[1];
                int[] loc1 = {x, y};

                //System.out.println("*****");
                //System.out.print(i+"\n");
                //System.out.print(x+"\n");
                //System.out.print(y+"\n");

                moves.add(loc1);
                currentMove.setLoc(loc1);
                if(currentMove.getLoc() == m1.getGoal()){
                    total = Integer.MAX_VALUE;
                    break;
                }
                else if(currentMove.getLoc()[0] < 0 || currentMove.getLoc()[1] < 0){
                    total = Integer.MIN_VALUE;
                    break;
                }
                else if(moves.contains(currentMove.getLoc()) || m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total = Integer.MIN_VALUE;
                    break;
                }
                else if (m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 1){
                    total++;
                    continue;
                }   
            }
            else if(i==2 && currentMove.getLoc()[1] != m1.getXDim()-1){//moving down
                int x = currentMove.getLoc()[0];
                int y = currentMove.getLoc()[1]+1;
                int[] loc1 = {x, y};
                
                //System.out.println("*****");
                //System.out.print(i+"\n");
                //System.out.print(x+"\n");
                //System.out.print(y+"\n");

                moves.add(loc1);
                currentMove.setLoc(loc1);
                if(currentMove.getLoc() == m1.getGoal()){
                    total = Integer.MAX_VALUE;
                    break;
                }
                else if(currentMove.getLoc()[0] < 0 || currentMove.getLoc()[1] < 0){
                    total = Integer.MIN_VALUE;
                    break;
                }
                else if(moves.contains(currentMove.getLoc()) || m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total = Integer.MIN_VALUE;
                    break;
                }
                else if (m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 1){
                    total++;
                    continue;
                } 
            }
            else if(i == 3 && currentMove.getLoc()[0] != 0){//moving left
                int x = currentMove.getLoc()[0]-1;
                int y = currentMove.getLoc()[1];
                
                //System.out.println("*****");
                //System.out.print(i+"\n");
                //System.out.print(x+"\n");
                //System.out.print(y+"\n");

                int[] loc1 = {x, y};
                moves.add(loc1);
                currentMove.setLoc(loc1);
                if(currentMove.getLoc() == m1.getGoal()){
                    total = Integer.MAX_VALUE;
                    break;
                }
                else if(currentMove.getLoc()[0] < 0 || currentMove.getLoc()[1] < 0){
                    total = Integer.MIN_VALUE;
                    break;
                }
                else if(moves.contains(currentMove.getLoc()) || m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 0){
                    total = Integer.MIN_VALUE;
                    break;
                }
                else if (m1.getGrid()[currentMove.getLoc()[0]][currentMove.getLoc()[1]] == 1){
                    total++;
                    continue;
                }
            }
            else {//backtracking
                total = Integer.MIN_VALUE;
                break;
            }
        }
        return total;
        
    }
    /*This mutates the path of moves based on a random chance of mutation, and returns a new path. */
    public ArrayList<Integer> mutate(ArrayList<Integer> path){
        Random r = new Random();
        int rand = r.nextInt(100);
        int loc = r.nextInt(path.size());
        int choice = r.nextInt(4);
        if (rand<50){
            path.set(loc, choice);
        }
        return path;
    }
    /*
     * This does parental crossover between paths, making a new path for the maze.
     */
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
    /*
     * This randomly generates an initial population of moveNodes for the intital run of the program.
     */
    public ArrayList<moveNode> generatePopulation(Maze m1){
        Random r = new Random();
        ArrayList<moveNode> paths = new ArrayList<moveNode>();
        for (int i = 0; i<10;i++){
        ArrayList<Integer> newPath = new ArrayList<Integer>();
            for (int j = 0; j<m1.getSize(); j++){
                newPath.add(r.nextInt(4));
        }
        paths.add(new moveNode(m1.getStart(), newPath));
    }
        return paths;
    }
    /*
     * This is the genetic algorithm itself, wherein the previous methods are called and used. I used ChatGPT really
     * minutely here to add the time condition.
     */
    public moveNode geneticAlgorithm(ArrayList<moveNode> pop, Maze m1, long maxTimeMillis){
        long startTime = System.currentTimeMillis(); // Start timing
        int fit = 0;
        moveNode winner = new moveNode();
        while(fit != Integer.MAX_VALUE){
            // Check if the maximum allowed time has been exceeded
            if (System.currentTimeMillis() - startTime > maxTimeMillis) {
                System.out.println("Maximum time exceeded.");
                break;
            }
    
            for (moveNode ls : pop){
                winner = ls;
                int newFit = fitness(ls, m1);
                if(newFit > fit){
                    fit = newFit;
                }
            }
    
            ArrayList<moveNode> pop2 = new ArrayList<moveNode>();
            for (int i = 1; i < pop.size(); i++){
                Random r = new Random();
                moveNode parent1 = pop.get(r.nextInt(pop.size()));
                moveNode parent2 = pop.get(r.nextInt(pop.size()));
                moveNode child = new moveNode(m1.getStart(), reproduce(parent1.getPreMoves(), parent2.getPreMoves())); // Ensure parent location is always the start
                Random r2 = new Random();
                int r1 = r2.nextInt(10);
                if (r1 < 9){
                    child = new moveNode(child.getLoc(), mutate(child.getPreMoves()));
                    pop2.add(child);
                }
            } 
            pop = pop2;
        }
        return winner;
    }
}