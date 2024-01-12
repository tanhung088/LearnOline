
public class plane extends transport {
	private String fuelType;

	public plane(String transportType, Manufacturer manufacturer, String fuelType) {
		super(transportType, manufacturer);
		this.fuelType = fuelType;
	}
	public plane() {
		// TODO Auto-generated constructor stub
	}
	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	//ham cat canh
	public void planeTakingOff() {
		System.out.println("Plane taking off");
	}
	//ham ha canh
	public void planeLand() {
		System.out.println("Plane landed");
	}
	
	
	@Override
	public void velocity() {
		System.out.print("Celocity of plane is 1500");
	}
	
	
	
}
