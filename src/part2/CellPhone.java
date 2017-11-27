package part2;

public class CellPhone {

	private long serialNum; // one system covering all brands (unique)
	private String brand; // always recorded as single word
	private int year; // manufacturing year
	private double price;
	
	// parameterized constructor
	public CellPhone(long sn, String b, int y, double p) {
		serialNum = sn;
		brand = b;
		year = y;
		price = p;
	}
	
	// copy constructor
	public CellPhone(CellPhone cp, long sn) { 
		serialNum = sn; // assumption: this sn will be unique
		setBrand(cp.getBrand());
		setYear(cp.getYear());
		setPrice(cp.getPrice());
	}
	
	// clone
	public CellPhone clone(long sn) {
		CellPhone cp = new CellPhone(sn, brand, year, price);
		return cp;
	}
	
	// getters and setters
	public long getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Serial Number: " + getSerialNum() + ", Brand: " + getBrand()
		+ ", Year: " + getYear() + ", Price: " + getPrice();
	}
	
	public boolean equals(CellPhone cp) { // except serialNum
		return (brand == cp.getBrand() && year == cp.getYear() && price == cp.getPrice());
	}
	
}
