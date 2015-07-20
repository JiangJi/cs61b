import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** ULLMapTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ULLMapTest {
    @Test
    public static void testBasic() {
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
       // System.out.println(um.get("Gracias"));
      //  assertEquals(um.get("Gracias"), "Dios Basado");
    }

    
    @Test
    public static void testIterator() {
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");
        Iterator<Integer> umi = um.iterator();
        while(umi.hasNext())
        {
            System.out.println(umi.next());
        }
       
    }
    

    /** Runs tests. */
    public static void main(String[] args) {
        //jh61b.junit.textui.runClasses(ULLMapTest.class);
        testBasic();
        testIterator();
    }
} 