import java.util.Set; /* java.util.Set needed only for challenge problem. */
import java.util.Iterator;
/** A data structure that uses a linked list to store pairs of keys and values.
 *  Any key must appear at most once in the dictionary, but values may appear multiple
 *  times. Supports get(key), put(key, value), and contains(key) methods. The value
 *  associated to a key is the value in the last call to put with that key. 
 *
 *  For simplicity, you may assume that nobody ever inserts a null key or value
 *  into your map.
 */ 
public class ULLMap <K,V> implements Map61B<K,V>, Iterable{ //FIX ME
    /** Keys and values are stored in a linked list of Entry objects.
      * This variable stores the first pair in this linked list. You may
      * point this at a sentinel node, or use it as a the actual front item
      * of the linked list. 
      */
    private Entry front;
    public ULLMap()
    {
       front = null;
    }
    public static ULLMap<V,K> invert()
    {
        
    }
    @Override
    public V get(K key) { //FIX ME
        if(front == null) return null;
       Entry entry = front.get(key);
       if(entry == null) return null;
       return entry.val;
    }

    @Override
    public void put(K key, V val) { //FIX ME
        if(front == null)
        {
            front = new Entry(key,val,null);
        }
        else
        {
            front = new Entry(key,val,front);
        }
    }

    @Override
    public boolean containsKey(K key) { //FIX ME
        if(front == null) return false;
        return front.get(key) !=null;
    }

    @Override
    public int size() {
        int sum = 0;
        Entry itr = front;
        while(itr != null)
        {
            itr = front.next;
            sum++;
        }
        return sum; // FIX ME (you can add extra instance variables if you want)
    }

    @Override
    public void clear() {
        front = null;
    }


    /** Represents one node in the linked list that stores the key-value pairs
     *  in the dictionary. */
    private class Entry{
    
        /** Stores KEY as the key in this key-value pair, VAL as the value, and
         *  NEXT as the next node in the linked list. */
        public Entry(K k, V v, Entry n) { //FIX ME
            key = k;
            val = v;
            next = n;
        }

        /** Returns the Entry in this linked list of key-value pairs whose key
         *  is equal to KEY, or null if no such Entry exists. */
        public Entry get(K k) { //FIX ME
            //FILL ME IN (using equals, not ==)
            if(k.equals(key)) return this;
            if(next == null) return null;
            return next.get(k);
        }

        /** Stores the key of the key-value pair of this node in the list. */
        private K key; //FIX ME
        /** Stores the value of the key-value pair of this node in the list. */
        private V val; //FIX ME
        /** Stores the next Entry in the linked list. */
        private Entry next;
    
    }

    /* Methods below are all challenge problems. Will not be graded in any way. 
     * Autograder will not test these. */
    @Override
    public V remove(K key) { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }
    public class ULLMapIter implements Iterator
    {
        private Entry iter;
        public ULLMapIter()
        {
            iter = front;
        }
        public boolean hasNext()
        {
            return iter!=null;
        }
        public K next(){
            K tmp = iter.key;
            iter = iter.next;
            return tmp;
        }
    }
    public ULLMapIter iterator()
    {
        return new ULLMapIter();
    }

}