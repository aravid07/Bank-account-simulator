import java.math.BigDecimal;

public class Account {
    private int accountID;
    private String accountName;
    private BigDecimal balance;

    public Account(int accountID, String accountName){
        this(accountID,accountName,new BigDecimal("0.0"));
    }

    public Account(int accountID, String accountName, BigDecimal balance){
        this.accountID = accountID;
        this.accountName = accountName;
        this.balance = balance;
    }

    public BigDecimal getBalance(){
        return this.balance;
    }

    public void deposit(BigDecimal amount){
        if (amount.signum() <= 0) throw new IllegalArgumentException("Amount must be positive");
        System.out.println(amount.signum());
        this.balance = this.balance.add(amount);
    }
}
