import java.util.HashMap; // Import Java's HashMap so we can use it

public class FibonacciMemo {

    /**
     * The classic recursive implementation with no memoization. Don't care
     * about graceful error catching, we're only interested in performance.
     * 
     * @param n
     * @return The nth fibonacci number
     */
    private static HashMap<Integer,Integer> memo = new HashMap<Integer,Integer>();
    public static int fibNoMemo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibNoMemo(n - 2) + fibNoMemo(n - 1);
    }

    /**
     * Your optimized recursive implementation with memoization. 
     * You may assume that n is non-negative.
     * 
     * @param n
     * @return The nth fibonacci number
     */
    public static int fibMemo(int n) {
        // YOUR CODE HERE
        if(n<=1)
        {
            return n;
        }
        else
        {
            if(memo.get(n)!=null)
            {
                return memo.get(n);
            }
            else
            {
                int res = fibMemo(n-1)+fibMemo(n-2);
                memo.put(n,res);
                return res;
            }
        }
    }

    /**
     * Answer the following question as a returned String in this method:
     * Why does even a correctly implemented fibMemo not return 2,971,215,073
     * as the 47th Fibonacci number?
     */
    public static String why47() {
        String answer = "potatoes";
        answer += ", " + answer + " and tapioca";
        return answer;
    }

    public static void main(String[] args) {
        // Optional testing here        
        String m = "Fibonacci's real name was Leonardo Pisano Bigollo.";
        m += "\n" + "He was the son of a wealthy merchant.\n";
        System.out.println(m);
        System.out.println("0: " + FibonacciMemo.fibMemo(0));
        System.out.println("1: " + FibonacciMemo.fibNoMemo(1));
        System.out.println("2: " + FibonacciMemo.fibNoMemo(2));
        System.out.println("3: " + FibonacciMemo.fibNoMemo(3));
        System.out.println("4: " + FibonacciMemo.fibNoMemo(4));
        System.out.println(fibMemo(47));
        // 46th Fibonacci = 1,836,311,903
        // 47th Fibonacci = 2,971,215,073
    }
}
