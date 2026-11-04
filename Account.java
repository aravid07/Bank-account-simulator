import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account {
    private int accountID;
    private String accountName;
    private BigDecimal balance;
    public  static int totalAccounts;

    public Account(int accountID, String accountName){
        this(accountID,accountName,new BigDecimal("0.0"));
        totalAccounts += 1;
    }

    private Account(int accountID, String accountName, BigDecimal balance){
        this.setAccountId(accountID);
        this.setAccountName(accountName);
        this.balance = balance;
    }

    public void setAccountName(String name){
        if(name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty");
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
        this.balance = this.balance.add(amount).setScale(2,RoundingMode.HALF_UP);
    }

    public void withdraw(BigDecimal amount){
        if(amount.compareTo(this.balance) > 0 || amount.signum() <=0 ) throw new IllegalArgumentException("Insufficient funds or amount is Invalid");
        this.balance = this.balance.subtract(amount);
    }


    @Override 
    public String toString(){
        return this.accountID + " | " + this.accountName + " | " + this.getBalance();
    }
}
