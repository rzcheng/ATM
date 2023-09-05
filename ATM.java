import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * ATM
 */
public class ATM {

    HashMap <String, Double> accountMap;

    public ATM () {
        accountMap = new HashMap<String, Double> ();
    }

    public void openAccount(String userId, double amount) throws Exception {
        if (accountMap.containsKey(userId))
            throw new Exception("Error: Account already exists.");

            accountMap.put(userId, amount);
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

    public double checkBalance (String userId) throws Exception {
        
        if (!accountMap.containsKey(userId))
            throw new Exception("Error: User ID does not exist.");

        return accountMap.get(userId);
    }

    public double depositMoney (String userId, double amount) throws Exception {
        
        if (!accountMap.containsKey(userId))
            throw new Exception("Error: You're broke AF.");

        accountMap.put(userId, accountMap.get(userId) + amount);
        return amount;
    }

    public double withdrawMoney (String userId, double amount) throws Exception {

        if (!accountMap.containsKey(userId) || accountMap.get(userId) < amount)
            throw new Exception("Error: You're broke AF.");

        accountMap.put(userId, accountMap.get(userId) - amount);
        return amount;
    }

    public boolean transferMoney (String fromAccount, String toAccount, double amount) throws Exception{

        if (!accountMap.containsKey(fromAccount) || !accountMap.containsKey(toAccount))
            throw new Exception("Error: An inputted account does not exist.");

        withdrawMoney(fromAccount, amount);
        depositMoney(toAccount, amount);

        return true;

    }

    public void audit () throws IOException {

        PrintWriter printWriter = new PrintWriter(new FileWriter("AccountAudit.txt"));

        for (Entry<String, Double> acc: accountMap.entrySet()) {
            printWriter.println("AccountEmail: " + acc.getKey() + ", AccountValue: " + acc.getValue());
        }

        printWriter.close();
    }

}