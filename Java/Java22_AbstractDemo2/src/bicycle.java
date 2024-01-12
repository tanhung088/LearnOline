
public class bicycle extends transport{

	
	public bicycle(String transportType, Manufacturer manufacturer) {
		super(transportType, manufacturer);
	}

	@Override
	public void velocity() {
		System.out.println("Velocity of bicycle is 100");
		
	}

	@Override
	public String getName() {
		System.out.println("Excute in class bicycle");
		return super.getName();
	}
	
	
	
}
