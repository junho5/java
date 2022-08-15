package Person_Account;
public class Person {
    String name;
    int age;
    int cashAmount;
    BankAccount account;
    
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		if (age < 0) {
			this.age = 12;
		}
	}

	public Person(String name, int age, int cashAmount) {
		super();
		this.name = name;
		this.age = age;
		this.cashAmount = cashAmount;
		if (age < 0) {
			this.age = 12;
		}
		if (cashAmount < 0) {
			this.cashAmount = 0;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(int cashAmount) {
		this.cashAmount = cashAmount;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	public boolean transfer(Person to, int amount) {
		return account.transfer(to.getAccount(), amount);
    }

    // 첫 번째 파라미터: 받는 사람의 계정 (BankAccount)
    // 두 번째 파라미터: 이체할 금액 (정수)
    // 리턴 : 성공여부 (불린)
    public boolean transfer(BankAccount to, int amount) {
    	return account.transfer(to.getOwner().getAccount(), amount);
    }
	
	
	
}