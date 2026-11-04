import java.math.BigDecimal;

class Main{
    public static void main(String[] args) {
        System.out.println("The main class");

        Account account1 = new Account(77575, "Aravind Swamy");
        System.out.println(account1.getBalance());
        account1.deposit(new BigDecimal("676.985"));
        System.out.println(account1.getBalance());
        System.out.println("Total accounts: " + Account.totalAccounts);
        System.out.println(account1.toString());

    }
}