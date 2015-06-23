
public class Test {
    public static void main(String[] args)
    {
        double xmin =0;
        double xmax =10;
        double ymin = 0;
        double ymax =10;
        double midx = (xmax+xmin)/2;
        double midy = (ymax+ymin)/2;
        StdDraw.setXscale(xmin,xmax);
        StdDraw.setYscale(ymin,ymax);
        Planet planet = new Planet(midx,midy,0,0,0,"starfield.jpg");
        Planet planet2 = new Planet(midx,midy,0,0,0,"earth.gif");
        planet.Draw();
        planet2.Draw();
    }
}
