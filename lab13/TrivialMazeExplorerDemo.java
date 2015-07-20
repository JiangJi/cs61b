/** 
 *  @author Josh Hug
 */

public class TrivialMazeExplorerDemo {
    public static void main(String[] args) {
        Maze maze = new Maze("maze.config");
        TrivialMazeExplorer tme = new TrivialMazeExplorer(maze);
        //MazeDepthFirstPaths tme = new MazeDepthFirstPaths(maze,0,0,1,1);
        tme.solve();
    }
} 