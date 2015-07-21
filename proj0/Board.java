
public class Board {
    private boolean shouldBeEmpty = false;
    public static final int N = 8;
    private Piece[][] boards = new Piece[N][N];
    public static void main(String[] args)
    {
       
    }
    public Board(boolean shouldBeEmpty)
    {
        this.shouldBeEmpty =shouldBeEmpty;
    }
    Piece pieceAt(int x,int y)
    {
        if(inBounds(x,y))
        {
            return boards[x][y];
        }
        else return null;
    }
    boolean canSelect(int x, int y)
    {
        return true;
    }
    void select(int x,int y)
    {
      
    }
    void place(Piece p,int x,int y)
    {
        if(inBounds(x,y))
        {
            boards[x][y] = p;
        }
    }
    Piece remove(int x,int y)
    {
        return null;
        
    }
    boolean canEndTurn()
    {
        return false;
    }
    void endTurn()
    {
        
    }
    String winner()
    {
        return null;
    }
    boolean inBounds(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<N;
    }
}
