import java.util.Set;
import java.util.HashSet;

public class MyHashMap<K,V> implements Map61B<K,V>{
    
    private static final int BUCKETNUM = 100;
    private HashSet<?>[] buckets = new HashSet<?>[BUCKETNUM];
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        for(HashSet<?> S : buckets)
        {
           S.clear();
        }
    }
    int hash(Object key)
    {
        return ((K)key).hashCode() % BUCKETNUM;
    }
    @Override
    public boolean containsKey(Object key) {
        // TODO Auto-generated method stub
        int idx = hash(key);
        return buckets[idx].get(key);
    }

    @Override
    public Object get(Object key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void put(Object key, Object value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Object remove(Object key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object remove(Object key, Object value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set keySet() {
        // TODO Auto-generated method stub
        return null;
    }

}
