
public class Piece {
    boolean isFire;
    String type;
    public int x;
    public int y;
    String getImage()
    {
        return "img/"+type+(isFire() ? "-fire" : "-water")+ (isKing() ? "-crowned" : "")+".png";
    }
    public Piece(boolean isFire,Board b,int x,int y,String type)
    {
        this.x = x;
        this.y = y;
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
