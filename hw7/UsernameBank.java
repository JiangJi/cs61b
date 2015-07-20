import java.util.HashMap;
import java.util.Map;
public class UsernameBank {

    // Instance variables (remember, they should be private!)
    // YOUR CODE HERE
    HashMap<String,String> Users = new HashMap<String,String>();
    HashMap<String,String> Emails = new HashMap<String,String>();
    HashMap<String,Integer> BadUsers = new HashMap<String,Integer>();
    HashMap<String,Integer> BadEmails = new HashMap<String,Integer>();
    public UsernameBank() {
        
    }

    public void generateUsername(String username, String email) {
        if(username == null || email == null)
        {
            throw new NullPointerException("illegal username or email");
        }
        if(!checkUsername(username) || !checkEmail(email))
        {
            throw new IllegalArgumentException("barformated username or email");
        }
        if(Users.get(username) == null)
        {
            throw new IllegalArgumentException("invalid username ");
        }
        {
            Users.put(username, email);
            Users.put(email, username);
        }
    }
    boolean checkUsername(String username)
    {
        if(username.length()<2 || username.length() >3)
        {
            return false;
        }
        String tmp = username.toLowerCase();
        for(char ch : tmp.toCharArray())
        {
            if(ch<'a' || ch > 'z')
            {
                return false;
            }
        }
        return true;
    }
    boolean checkEmail(String email)
    {
        for(char ch : email.toCharArray())
        {
            if(ch == '@')
            {
                return true;
            }
        }
        return false;
    }
    public String getEmail(String username) {
        // YOUR CODE HERE
        if(username == null)
        {
            throw new NullPointerException("username is null");
        }
        if(checkUsername(username))
        {
            Integer n = BadUsers.get(username);
            if(n==null)
            {
                BadUsers.put(username,1);
            }
            else
            {
                BadUsers.put(username, n++);
            }
            return null;
        }
        else
        {
            String email = Users.get(username);
            return email;
        }
    }

    public String getUsername(String email)  {
        if(email == null)
        {
            throw new NullPointerException("userEmail is null");
        }
        if(checkEmail(email))
        {
            Integer n = BadUsers.get(email);
            if(n==null)
            {
                BadUsers.put(email,1);
            }
            else
            {
                BadUsers.put(email, n++);
            }
            return null;
        }
        else
        {
            String user = Users.get(email);
            return user;
        }
    }

    public Map<String, Integer> getBadEmails() {
        // YOUR CODE HERE
        return BadEmails;
    }

    public Map<String, Integer> getBadUsernames() {
        // YOUR CODE HERE
        return BadUsers;
    }

    public String suggestUsername() {
        // YOUR CODE HERE
        return null;
    }

    // The answer is somewhere in between 3 and 1000.
    public static final int followUp() {
        // YOUR CODE HERE
        return 0;
    }

    // Optional, suggested method. Use or delete as you prefer.
    private void recordBadUsername(String username) {
        // YOUR CODE HERE
    }

    // Optional, suggested method. Use or delete as you prefer.
    private void recordBadEmail(String email) {
        // YOUR CODE HERE
    }
}