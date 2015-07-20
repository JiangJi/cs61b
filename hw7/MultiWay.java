import java.util.PriorityQueue;
class Stream implements Comparable
{
    private In in;
    private String cur;
    public Stream(In in)
    {
        this.in = in;
        if(in.hasNextChar()) cur = in.readString();
    }
    boolean isEmpty()
    {
        return in.hasNextChar();
    }
    String next()
    {
        assert(!isEmpty());
        String res = cur;
        cur = in.readString();
        return res;
    }
   
    String current()
    {
        return cur;
    }
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
       return current().compareTo(((Stream)o).current());
    }
}
public class MultiWay {
  
   public static void mergeN(In[] inFiles)
   {
       PriorityQueue<Stream> pq = new PriorityQueue<Stream>();
       for(int i=0;i<inFiles.length;i++)
       {
           Stream s = new Stream(inFiles[i]);
           if(s.isEmpty())
           {
               pq.add(s);
           }
       }
       
       while(!pq.isEmpty())
       {
           Stream top = pq.remove();
           System.out.println(top.next());
           if(top.isEmpty())
           {
               pq.add(top);
           }
       }
   }
    public static void main(String[] args)
    {
        String files[] = {"input1","input2","input3"};
        int N = files.length;
        In[] streams  = new In[N];
        for(int i=0;i<N;i++)
        {
            streams[i] = new In(files[i]);
        }
        mergeN(streams);

    }
}
