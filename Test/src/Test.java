import java.io.IOException;

public class Test {
    public static void main(String[] args)
    {
        try
        {
            dangerMethod();
        }catch(Exception e)
        {
            System.out.println("aha");
        }
    }
    public static void dangerMethod() throws IOException
    {
        throw new IOException();
    }
}
