import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;
public class BSTMap<K extends Comparable<K>,V> implements Map61B<K, V>{

    public static void main(String[] args)
    {
       BSTMap<String,String> M = new BSTMap<String,String>();
       M.put("hello", "Hello");
       M.put("dog", "dog");
       M.put("world", "world");
     //  M.remove("hello","Hello");
       for(String s : M.keySet())
       {
           System.out.println(s);
       }
    }
    class Node
    {
        public K key;
        public V val;
        public Node left;
        public Node right;
        public Node(K key,V val)
        {
            this.key = key;
            this.val = val;
        }
        public Node(K key,V val,Node left,Node right)
        {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private Node root;
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        root = null;
        
    }

    @Override
    public boolean containsKey(K key) {
        // TODO Auto-generated method stub
        Node r = findKey(root,key);
        if(r==null)
        {
            return false;
        }
        else{
            return true;
        }
    }
    private Node findKey(Node r,K key)
    {
        if(r == null)
        {
            return null;
        }
        int cmp = key.compareTo(r.key);
        if(cmp == 0)
        {
            return r;
        }
        if(cmp > 0)
        {
            return findKey(r.right,key);
        }
        else
        {
            return findKey(r.left,key);
        }
    }
    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
        Node r = findKey(root,key);
        if(r==null)
        {
            return null;
        }
        else
        {
            return r.val;
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size(root);
    }
    public int size(Node r)
    {
        return r == null ? 0 : size(r.left) + size(r.right)+1;
    }

    @Override
    public void put(K key, V value) {
        // TODO Auto-generated method stub
        root = put(root,key,value);
    }
    public Node put(Node r,K key,V value)
    {
        if( r == null)
        {
            return new Node(key,value);
        }
        int cmp = key.compareTo(r.key);
        if(cmp < 0)
        {
            r.left = put(r.left,key,value);
        }
        else
        {
            r.right = put(r.right,key,value);
        }
        return r;
    }

    @Override
    public V remove(K key) {
        // TODO Auto-generated method stub
        Node r = findKey(root,key);
        if(r == null)
        {
            return null;
        }
        else
        {
            V res = r.val;
            root = remove(root,key);
            return res;
        }
    }
    public Node remove(Node r,K key)
    {
        if(r == null)
        {
            return null;
        }
        int cmp = key.compareTo(r.key);
        if(cmp < 0)
        {
            r = remove(r.left,key);
        }
        else if(cmp > 0)
        {
            r = remove(r.right,key);
        }
        else
        {
            if(r.right == null)
            {
                r = r.left;
            }
            else if(r.right.left == null)
            {
                r.right.left = r.left;
                r = r.right;
            }
            else
            {
              Node prev = r.right;
              Node cur = prev.left;
              while(cur.left!=null)
              {
                  prev = cur;
                  cur = cur.left;
              }
              prev.left = cur.right;
              cur.left = r.left;
              cur.right = r.right;
              r =cur;
            }
        }
        return r;
    }
    @Override
    public V remove(K key, V value) {
        // TODO Auto-generated method stub
        Node r = findKey(root,key);
        if(r == null)
        {
            return null;
        }
        if(value!=r.val)
        {
            return null;
        }
        else
        {
            root = remove(root,key);
            return value;
        }
    }
    private void visit(Node r,Set<K> S)
    {
        if(r !=null)
        {
            visit(r.left,S);
            S.add(r.key);
            visit(r.right,S);
        }
    }
    @Override
    public Set<K> keySet() {
        // TODO Auto-generated method stub
        Set<K> S = new HashSet<K>();
        visit(root,S);
        return S;
    }

}
