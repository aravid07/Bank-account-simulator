import java.math.BigDecimal;

public class Account {
    private int accountID;
    private String accountName;
    private BigDecimal balance;
    public  static int totalAccounts;

    public Account(int accountID, String accountName){
        this(accountID,accountName,new BigDecimal("0.0"));
        totalAccounts += 1;
    }

    public Account(int accountID, String accountName, BigDecimal balance){
        this.setAccountId(accountID);
        this.setAccountName(accountName);
        this.balance = balance;
    }

    public void setAccountName(String name){
        if(name == null || name == "") throw new IllegalArgumentException("Name cannot be empty");
        this.accountName = name;
    }

    public void setAccountId(int id){
        if(id <= 0) throw new IllegalArgumentException("Invalid account id");
        this.accountID = id;
    }

    public BigDecimal getBalance(){
        return this.balance;
    }

    public void deposit(BigDecimal amount){
        if (amount.signum() <= 0) throw new IllegalArgumentException("Amount must be positive");
        System.out.println(amount.signum());
        this.balance = this.balance.add(amount);
    }


    @Override 
    public String toString(){
        return this.accountID + " | " + this.accountName + " | " + this.getBalance();
    }
}
