
public abstract class transport {
	protected String transportType;
	protected Manufacturer manufacturer;
	
	public transport() {
		// TODO Auto-generated constructor stub
	}
	public transport(String transportType, Manufacturer manufacturer) {
		this.transportType = transportType;
		this.manufacturer = manufacturer;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public Manufacturer getManufacturer() {
		return this.getManufacturer();
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	//ham lay len hang san xuat
	public String getName() {
		return manufacturer.getManuName();
	}
	//ham bat dau
	public void start() {
		System.out.println("Begin to move");
	}
	//ham tang toc start to accelerate
	public void acceleration() {
		System.out.println("Begin to accelerating");
	}
	//ham dung lai
	public void stop() {
		System.out.println("Stop!!!");
	}
	//ham abstract van toc
	public abstract void velocity();
}
