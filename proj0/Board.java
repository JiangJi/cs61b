import java.awt.Color;
public class Board {
    public Board()
    {}
    private boolean shouldBeEmpty = false;
    private static final boolean WATER = true;
    private static final boolean FIRE = false;
    private boolean turn = WATER;
    public static final int N = 8;
    private  Piece[][] pieces = new Piece[N][N];
    private Piece selected = null;
    public static void filledSquare(double x,double y,Color color,double size)
    {
        StdDrawPlus.setPenColor(color);
        StdDrawPlus.filledSquare(x+0.5, y+0.5, size);
        StdDrawPlus.setPenColor(Color.WHITE);
    }
    private static void showPiece(int x,int y,Piece piece)
    {
        if(piece!=null)
        {
            String img = piece.getImage();
            StdDrawPlus.picture(x+0.5, y+0.5, img,1,1);
        }
    }
    public  void drawBoard()
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               if(selected!=null && i==selected.x && j ==selected.y){}
               else if((i+j)%2==0) filledSquare(i,j,Color.GRAY,0.5);
               else filledSquare(i,j,Color.RED,0.5);
               showPiece(i,j,pieces[i][j]);
            }
        }
    }
    public  void init()
    {
       for(int i=0;i<N;i+=2)
       {
         place(new Piece(true,this,i,0,"pawn"),i,0);
         place(new Piece(true,this,i+1,1,"shield"),i+1,1);
         place(new Piece(true,this,i,2,"bomb"),i,2);
         place(new Piece(false,this,i+1,N-1,"pawn"),i+1,N-1);
         place(new Piece(false,this,i,N-2,"shield"),i,N-2);
         place(new Piece(false,this,i+1,N-3,"bomb"),i+1,N-3);
       }
    }
    public static void main(String[] args)
    {
        Board board =new Board();
        board.init();
        StdDrawPlus.setXscale(0,N);
        StdDrawPlus.setYscale(0,N);
        while(true)
        {
            if(StdDrawPlus.mousePressed())
            {
                int x = (int)StdDrawPlus.mouseX();
                int y = (int)StdDrawPlus.mouseY();
                board.select(x, y);
            }
            else if(StdDrawPlus.isSpacePressed())
            {
                board.endTurn();
            }
            board.drawBoard();
            StdDrawPlus.show(100);
        }
    }
    public Board(boolean shouldBeEmpty)
    {
        this.shouldBeEmpty =shouldBeEmpty;
    }
    Piece pieceAt(int x,int y)
    {
        if(inBounds(x,y))
        {
            return pieces[x][y];
        }
        else return null;
    }
    boolean canSelect(int x, int y)
    {
        if(pieceAt(x,y)!=null)
        {
          if(selected==null)
              return true;
        }
        else
        {
            return true;
        }
        return false;
    }
    private boolean validMove(int xi,int yi,int xf,int yf)
    {
        return true;
    }
    void select(int x,int y)
    {
        if(!canSelect(x,y)) return;
        filledSquare(x,y,Color.WHITE,0.5);
        if(selected == null)
        {
            selected = pieceAt(x,y);
            return;
        }
        Piece fromPiece = selected;
        int x1 = fromPiece.x;
        int y1 = fromPiece.y;
        place(fromPiece,x,y);
        remove(x1,y1);
        selected = pieceAt(x,y);
    }
    
    void place(Piece p,int x,int y)
    {
        if(inBounds(x,y))
        {
            pieces[x][y] = p;
            p.x = x;
            p.y = y;
        }
    }
    Piece remove(int x,int y)
    {
        Piece orig = pieces[x][y];
        pieces[x][y] = null;
        return orig;
        
    }
    boolean canEndTurn()
    {
        return false;
    }
    void endTurn()
    {
      selected = null;
      turn =!turn;
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
