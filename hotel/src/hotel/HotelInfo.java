package hotel;

public class HotelInfo {
	private String rName;
	private int rPrice;
	private int rLimitNumber;//인원
	private int rSpareCount;//남은방
	
	public HotelInfo(String rName,int rPrice,int rLimitNumber, int rSpareCount) {
		super();
		this.rName = rName;
		this.rPrice = rPrice;
		this.rLimitNumber = rLimitNumber;
		this.rSpareCount = rSpareCount;
		
	}
	
	public HotelInfo() {}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public int getrPrice() {
		return rPrice;
	}

	public void setrPrice(int rPrice) {
		this.rPrice = rPrice;
	}

	public int getrLimitNumber() {
		return rLimitNumber;
	}

	public void setrLimitNumber(int rLimitNumber) {
		this.rLimitNumber = rLimitNumber;
	}

	public int getrSpareCount() {
		return rSpareCount;
	}

	public void setrSpareCount(int rSpareCount) {
		this.rSpareCount = rSpareCount;
	}
	
	@Override
	public String toString() {
		return "HotelInfo[객실유형:" + rName +", 가격:" + rPrice +", 객실인원:" + rLimitNumber +", 남은방수:" + rSpareCount + "]\n";
	}

}
