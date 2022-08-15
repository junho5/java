package Market;

public class MarketGood {
    private String name;
    private int retailPrice;
    private int discountRate;
    
    


	public MarketGood(String name, int retaulPrice) {
		super();
		this.name = name;
		this.retailPrice = retaulPrice;
		this.discountRate = 0;
	}

	public MarketGood(String name, int retaulPrice, int discountRate) {
		super();
		this.name = name;
		this.retailPrice = retaulPrice;
		this.discountRate = discountRate;
		if (discountRate < 0 || discountRate > 100) {
			this.discountRate = 0;
		}
	}

	public String getName() {
		return name;
	}


	public int getRetailPrice() {
		return retailPrice;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	
	public int getDiscountedPrice() {
		int goods = this.getRetailPrice();
		goods -= (int)(this.retailPrice * (this.getDiscountRate()/100.0));
		return goods;
	}

	
	
    
    
}
