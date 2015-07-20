import java.util.Observable;
/** 
 *  @author Josh Hug
 */

public class MazeCycles extends MazeExplorer {
    /* Inherits public fields: 
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private Maze maze;
    private boolean[] inStack;
    private int cycle = -1;
    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        inStack = new boolean[m.V()];
        for( boolean x : inStack)
        {
            x = false;
        }
    }

    @Override
    public void solve() {
        announce();
        dfs(0);
//        for(int x=0;x<maze.V();x++)
//        {
//            if(!marked[x])
//            {
//                dfs(x);
//            }
//        }
//        for(int x=0;x<maze.V();x++)
//        {
//            if(!inStack[x])
//            {
//                marked[x] = false;
//                distTo[x] = Integer.MAX_VALUE;
//                edgeTo[x] = Integer.MAX_VALUE;
//            }
//        }
          for(int i=0;i<maze.V();i++)
          {
              marked[i] = false;
          }
          if(cycle==-1)
          {
              return;
          }
          for(int itr= edgeTo[cycle];itr!=cycle;itr=edgeTo[itr])
          {
              marked[itr] = true;
          }
          marked[cycle] =true;
        announce();
    }
    private void dfs(int s)
    {
        marked[s] = true;
        inStack[s] = true;
        for(int w : maze.adj(s))
        {
            if(inStack[w] && edgeTo[s]!=w)
            {
             //   announce();
                edgeTo[w] = s;
                cycle = w;
                return;
            }
            if(!marked[w])
            {
                edgeTo[w] = s;
                dfs(w);
            }
        }
        inStack[s] = false;
    }
} 

