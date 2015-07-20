public class Username {

    // Potentially useless note: (int) '0' == 48, (int) 'a' == 97

    // Instance Variables (remember, they should be private!)
    // YOUR CODE HERE
    private String userName;
    public Username() {
        // YOUR CODE HERE
        int c1 = (int)(Math.random()*26);
        int c2 = (int)(Math.random()*26);
        userName = ""+(char)(c1+97)+(char)(c2+97);
        if(Math.random()<0.5)
        {
            userName +=(char)(int)((Math.random()*26)+97);
        }
    }

    public Username(String reqName) {
        if(reqName == null)
        {
            throw new NullPointerException("arguments is null");
        }
        if(reqName.length()==3 || reqName.length() == 2)
        {
            userName = reqName;
        }else
        {
            throw new IllegalArgumentException(reqName +"lenth is not 2 or 3");
        }
    }

    @Override
    public boolean equals(Object o) {
        // YOUR CODE HERE
        return userName.equals(((Username)o).userName);
    }

    @Override
    public int hashCode() { 
        // YOUR CODE HERE
        int sum = 0;
        String tmp = userName.toLowerCase();
        for(int i=0;i<tmp.length();i++)
        {
            sum+=26*(tmp.charAt(i)-'a');
        }
        return sum;
    }

    public static void main(String[] args) {
        // You can put some simple testing here.
        Username u1 = new Username("hel");
        Username u2 = new Username("hel");
    }
}