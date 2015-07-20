import java.io.File;
import java.util.*;
public class AlphabetSort {
    public static void main(String[] args) throws Exception
    {
        Trie t = new Trie();
        Scanner in = new Scanner(new File("testAlphabetLong"));
        String order = in.next();
        while(in.hasNext())
        {
            String word = in.next();
            t.insert(word);
        }
        ArrayList<String> que  = t.keySets(order);
        for(String s : que)
        {
            System.out.println(s);
        }
    }
}
