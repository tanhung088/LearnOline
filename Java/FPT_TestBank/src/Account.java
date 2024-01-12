import java.lang.reflect.Constructor;
import java.util.Scanner;
import javax.management.ConstructorParameters;
public class Account {
	private long Account;
	private String AccountName;
	private double Balance = 50f;
	private long AccountId;
	final float profit = 0.035f;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(long Account, String AccountName, double Balance, long AccountId) {
        this.Account = Account;
        this.AccountName = AccountName;
        this.Balance = Balance;
        this.AccountId = AccountId;
    }
	
	public long getAccount() {
		return Account;
	}
	public String getAccountName() {
		return AccountName;
	}
	public double getBalance() {
		return Balance;
	}
	public void setAccount(long account) {
		Account = account;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public long getAccountId() {
		return AccountId;
	}
	public void setAccountId(long accountId) {
		AccountId = accountId;
	}
	
	@Override
	public String toString() {
		return "AccountID: " + this.AccountId + "AccountName: " + this.AccountName + "Balance: " + this.Balance; 
	}
	
	//ham dat balace default la 50
	public void DefaultBalace() {
		
	}
	
	// ham gui tien
    public void deposit(){
        System.out.println("Enter number of money you wann to deposit: ");
        double MoneyDeposit;
        do {
        	Scanner sc = new Scanner(System.in); 
            MoneyDeposit = sc.nextDouble();
			if(MoneyDeposit > 0) {
				this.Balance = this.Balance + MoneyDeposit;
		        System.out.println("Balance currency: " + this.Balance);
			}else {
				System.out.println("Wrong! The deposit can not <= 0!!!");
				System.out.println("Enter agian!!!");
			}
		} while (MoneyDeposit <= 0f);
    }
    
    // ham rut tien
    public void withdraw() {
    	System.out.println("Enter number of money you wann to withdraw: ");
    	double MoneyWithdraw;
    	final double Phi = 1;
        do {
        	Scanner sc = new Scanner(System.in); 
        	MoneyWithdraw = sc.nextDouble();
			if(MoneyWithdraw <= this.Balance) {
				this.Balance = this.Balance - (MoneyWithdraw + Phi);
		        System.out.println("Balance currency: " + this.Balance);
			}else {
				System.out.println("Wrong! The withdraw can not > balance currentcy!!!");
				System.out.println("Enter agian!!!");
			}
		} while ((MoneyWithdraw + MoneyWithdraw + Phi) <= this.Balance);
    }
    
    //Ham dao hang account maturity
    public void maturity() {
    	this.Balance = this.Balance + this.Balance*profit;
    	//System.out.println("Account maturity = " + this.Balance);
    }
    
    // Ham chuyen khoan tu tk nay sang tk khac
    /*
    public void Transfer() {
    	
    }
    */
}
