import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Prefix-Trie. Supports linear time find() and insert(). 
 * Should support determining whether a word is a full word in the 
 * Trie or a prefix.
 * @author 
 */
public class Trie {
    private static final int R = 256;
    private Node root = null;
    private class Node
    {
        public boolean exists = false;
        public Node links[] = new Node[R];
    }
    private Node put(Node r,String s,int k)
    {
        if(r == null)
        {
            r = new Node();
        }
        if(k == s.length())
        {
            r.exists = true;
            return r;
        }
        char ch = s.charAt(k);
        r.links[ch] = put(r.links[ch],s,k+1);
        return r;
    }
    public static void main(String[] args)
    {
        Trie t  = new Trie();
        t.insert("hello");
        t.insert("hey");
        t.insert("goodbye");
        System.out.println(t.find("hell", false));
        System.out.println(t.find("hello", true));
        System.out.println(t.find("good", false));
        System.out.println(t.find("bye", false));
        System.out.println(t.find("heyy", false));
        System.out.println(t.find("hell", true));
        ArrayList<String> queue = t.keySets();
        for(String s : queue)
        {
            System.out.println(s);
        }
    }
    public boolean find(String s, boolean isFullWord) {
        if(s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("s is null or empty");
        }
        int i=0;
        Node itr = root;
        while(i<s.length() && itr!=null)
        {
           char ch = s.charAt(i);
           i++;
           itr = itr.links[ch];
        }
        if(itr == null) return false;
        return !isFullWord || itr.exists;
    }

    public void insert(String s) {
        if(s == null || s.length() ==0)
        {
            throw new IllegalArgumentException("s is null or empty");
        }
        root = put(root,s,0);
    } 
    void visit(Node r,ArrayList<String> que,String str,String order)
    {
        if(r!=null)
        {
            if(r.exists)
            {
                que.add(str);
            }
//            for(int i=0;i<R;i++)
//            {
//                if(r.links[i]!=null)
//                {
//                    visit(r.links[i],que,str+(char)i,order);
//                }
//            }
            for(char ch : order.toCharArray())
            {
                if(r.links[ch]!=null)
                {
                    visit(r.links[ch],que,str+ch,order);
                }
            }
        }
    }
    void visit(Node r,ArrayList<String> que,String str)
    {
        if(r!=null)
        {
            if(r.exists)
            {
                que.add(str);
            }
            for(int i=0;i<R;i++)
            {
                if(r.links[i]!=null)
                {
                    visit(r.links[i],que,str+(char)i);
                }

            }
        }
    }
    public ArrayList<String> keySets(String order)
    {
        ArrayList<String> que = new ArrayList<String>();
        visit(root,que,"",order);
        return que;
    }
    public ArrayList<String> keySets()
    {
        ArrayList<String> que = new ArrayList<String>();
        visit(root,que,"");
        return que;
    }
    public ArrayList<String> prefixOf(String prefix)
    {
        Node itr = root;
        int i =0;
        while(i!= prefix.length() && itr!=null)
        {
            itr = itr.links[prefix.charAt(i)];
            i++;
        }
        String word = prefix;
        ArrayList<String> que =new  ArrayList<String>();
        visit(itr,que,word);
        return que;
    }
}
