package general;

public abstract class Computer {
	public String manufacturer;
	public int price;
	public abstract void input();
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}
	
	public Computer(String manufacturer, int price) {
		super();
		this.manufacturer = manufacturer;
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
