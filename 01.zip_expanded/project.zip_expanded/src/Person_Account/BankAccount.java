package Person_Account;
public class BankAccount {
    int balance;
    Person owner;
    
    public BankAccount(int balance) {
		super();
		this.balance = balance;
		if (balance < 0) {
			this.balance = 0;
		}
	}
    
	public BankAccount(Person owner) {
		super();
		this.owner = owner;
		this.balance = 0;
	}
	
	public BankAccount(int balance, Person owner) {
		super();
		this.balance = balance;
		this.owner = owner;
		if (balance < 0) {
			this.balance = 0;
		}
	}

	// 파라미터 : 입금할 액수(정수)
    // 리턴 : 성공여부(불린)
    boolean deposit(int amount) {
    	if (amount < 0 || owner.cashAmount < amount){
            System.out.printf("입금 실패입니다. 잔고: %d원, 현금: %d원\n",this.balance,owner.cashAmount);
            return false;
        }
        else{
        	this.balance += amount;
        	owner.cashAmount -= amount;
            System.out.printf("%d원 입금하였습니다. 잔고: %d원, 현금: %d원\n",amount,this.balance,owner.cashAmount);
            return true;
        }
    }

    // 파라미터 : 출금할 액수(정수)
    // 리턴 : 성공여부(불린)
    boolean withdraw(int amount) {
    	if (amount < 0 || this.balance < amount){
            System.out.printf("출금 실패입니다. 잔고: %d원, 현금: %d원\n",this.balance,owner.cashAmount);
            return false;
        }
        else{
        	this.balance -= amount;
        	owner.cashAmount += amount;
            System.out.printf("%d원 출금하였습니다. 잔고: %d원, 현금: %d원\n",amount,this.balance,owner.cashAmount);
            return true;
        }
    }

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
    
	public boolean transfer(Person to, int amount) {
		return transfer(to.getAccount(),amount);
    }

    // 첫 번째 파라미터: 받는 사람의 계정 (BankAccount)
    // 두 번째 파라미터: 이체할 금액 (정수)
    // 리턴 : 성공여부 (불린)
    public boolean transfer(BankAccount to, int amount) {
    	if (amount < 0 || this.balance < amount) {
    		System.out.printf("false - from: %s, to: %s, amount: %d, balance: %d\n",owner.getName(),to.getOwner().getName(),amount,this.balance);
    		return false;
    	}else {
    		to.setBalance(to.getBalance()+amount);
    		this.balance -= amount;
    		System.out.printf("true - from: %s, to: %s, amount: %d, balance: %d\n",owner.getName(),to.getOwner().getName(),amount,this.balance);
    		return true;
    	}
    }
    

    // 첫 번째 파라미터 : 받는 사람(Person)
    // 두 번째 파라미터 : 이체할 금액(정수)
    // 리턴 : 성공여부(불린)
    // boolean transfer(Person to, int amount) {
    // (다음 과제에서 사용하므로, 우선 skip합니다.)
    // }
}