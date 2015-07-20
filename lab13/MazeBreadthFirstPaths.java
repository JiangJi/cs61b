import java.util.Observable;
/** 
 *  @author Josh Hug
 */

public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields: 
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private Queue<Integer> visited;
    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        visited = new Queue<Integer>();
        
    }

    /** Conducts a breadth first search of the maze starting at vertex x. */
    private void bfs(int s) {
        /* Your code here. */
        announce();
        if(s == t)
        {
            return;
        }
        visited.enqueue(s);
        while(!visited.isEmpty())
        {
            Integer v = visited.dequeue();
            marked[v] = true;
            announce();
            if(v == t) return;
            for (int w : maze.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    announce();
                    visited.enqueue(w);
                }
                distTo[w] = distTo[v] + 1;
            }
        }
    }
    


    @Override
    public void solve() {
        bfs(s);
    }
} 

