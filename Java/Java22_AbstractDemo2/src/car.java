
public class car extends transport{
	private String fuelType;

	public car() {
		// TODO Auto-generated constructor stub
	}
	public car(String transportType, Manufacturer manufacturer, String fuelType) {
		super(transportType, manufacturer);
		this.fuelType = fuelType;
	}

	@Override
	public void velocity() {
		System.out.println("Velocity of car is 500");
		
	}
	
	
}
