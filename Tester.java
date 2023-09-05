public class Tester {
    public static void main(String[] args) {
        ATM atm = new ATM();

        try {
            atm.openAccount("acc1", 100);
            atm.openAccount("acc2", 1000);
            atm.openAccount("elon", 100000000);


            System.out.println(atm.transferMoney("acc2", "acc1", 200));
            atm.depositMoney("elon", 10000);
            atm.withdrawMoney("acc1", 150);

            System.out.println("acc1 balance: " + atm.checkBalance("acc1"));
            System.out.println("acc2 balance: " + atm.checkBalance("acc2"));
            System.out.println("elon balance: " + atm.checkBalance("elon"));

            atm.withdrawMoney("acc1", 150);
            atm.closeAccount("acc1");

            atm.audit();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
