
public class Piece {
    boolean isFire;
    String type;
    public Piece(boolean isFire,Board b,int x,int y,String type)
    {
        this.isFire = isFire;
        b.place(this, x, y);
        this.type = type;
    }
    boolean isFire()
    {
        return isFire;
    }
    int side()
    {
        return 0;
    }
    boolean isKing()
    {
        return type.equals("King");
    }
    boolean isBomb()
    {
        return type.equals("Bomb");
    }
    boolean isShield()
    {
        return type.equals("Shield");
    }
    void move(int x,int y)
    {
        
    }
    boolean hasCaptured()
    {
        return false;
    }
    void doneCapturing()
    {
        
    }
}
