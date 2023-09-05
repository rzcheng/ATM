import java.util.HashMap;

/**
 * ATM
 */
public class ATM {

    HashMap <String, Double> accountMap;

    public ATM () {
        accountMap = new HashMap<String, Double> ();
    }

    public void openAccount(String userId, double amount) throws Exception {
        if (accountMap.containsKey(userId)){
            throw new Exception("Error: Account already exists.");
        }
        else {
            accountMap.put(userId, amount);
        }
    }

    public void closeAccount (String userId) throws Exception{

        if (!accountMap.containsKey(userId))
            throw new Exception("Error: User ID does not exist.");

        if (accountMap.get(userId) <= 0) {
            accountMap.remove(userId);
        } else {
            throw new Exception("Error: Must withdraw money before closing.");
        }
    }

    
}