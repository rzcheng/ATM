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
            throw new Exception("Account already exists.");
        }
        else {
            accountMap.put(userId, amount);
        }
    }
}